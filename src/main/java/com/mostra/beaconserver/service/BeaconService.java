package com.mostra.beaconserver.service;

import com.google.gson.Gson;
import com.mostra.beaconserver.constant.ResponseCode;
import com.mostra.beaconserver.exception.CustomException;
import com.mostra.beaconserver.model.Beacon;
import com.mostra.beaconserver.model.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mostra.beaconserver.repository.BeaconRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by JongHunLee on 2015-05-21.
 */

@Service
public class BeaconService {
    @Autowired
    private BeaconRepository beaconRepository;

    public Beacon insertBeacon(Map<String, String> params) throws Exception {
        if (params.get("uuid") == null)
            throw new CustomException(ResponseCode.ERROR_NOT_BEACON_UUID);

        Beacon existBeacon = getBeaconByUUID(params.get("uuid"));
        if (existBeacon != null) return existBeacon;

        Beacon beacon = new Beacon();

        if (params.get("uuid") != null)
            beacon.setUuid(params.get("uuid"));
        if (params.get("title") != null)
            beacon.setTitleText(params.get("title"));
        if (params.get("picture") != null) {
            Picture picture = new Gson().fromJson(params.get("picture"), Picture.class);
            beacon.setPictureURL(picture.getPictureList());
        }
        if (params.get("content") != null)
            beacon.setContentText(params.get("content"));
        beaconRepository.insert(beacon);
        if (beacon == null) throw new Exception();

        return beacon;
    }

    public Beacon insertBeacon(Beacon beacon) throws Exception {
        if (beacon == null)
            throw new CustomException(ResponseCode.ERROR_NOT_BEACON_UUID);

        Beacon existBeacon = getBeaconByUUID(beacon.getUuid());
        if (existBeacon != null) return existBeacon;

        beaconRepository.insert(beacon);
        if (beacon == null) throw new Exception();

        return beacon;
    }

    public List<Beacon> getBeacon() {
        return beaconRepository.getBeacons();
    }

    public Beacon getBeaconByUUID(String uuid) {
        return beaconRepository.getBeacon(uuid);
    }
}
