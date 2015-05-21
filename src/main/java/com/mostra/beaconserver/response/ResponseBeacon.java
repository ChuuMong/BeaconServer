package com.mostra.beaconserver.response;

import com.mostra.beaconserver.model.Beacon;
import com.mostra.beaconserver.model.vo.BeaconVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JongHunLee on 2015-05-21.
 */
public class ResponseBeacon extends ResponseDefault {
    List<BeaconVo> beaconList;
    BeaconVo beacon;

    public ResponseBeacon(int code) {
        // TODO Auto-generated constructor stub
        super.onCreate(code);
        beaconList = new ArrayList<>();
    }

    public ResponseBeacon(int code, String msg) {
        // TODO Auto-generated constructor stub
        super.onCreate(code, msg);
        beaconList = new ArrayList<>();
    }

    public BeaconVo getBeacon() {
        return beacon;
    }

    public void setBeacon(Beacon beacon) {
        this.beacon = new BeaconVo(beacon);
    }

    public void addBeacon(Beacon beacon) {
        beaconList.add(new BeaconVo(beacon));
    }

    public void addBeacon(List<Beacon> beaconList) {
        for (Beacon beacon : beaconList) {
            this.beaconList.add(new BeaconVo(beacon));
        }
    }

    public List<BeaconVo> getBeaconList() {
        return beaconList;
    }

    public void setBeaconList(List<BeaconVo> beaconList) {
        this.beaconList = beaconList;
    }

    public void setBeacon(BeaconVo beacon) {
        this.beacon = beacon;
    }
}
