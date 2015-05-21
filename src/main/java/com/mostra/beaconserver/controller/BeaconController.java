package com.mostra.beaconserver.controller;

import com.mostra.beaconserver.constant.ResponseCode;
import com.mostra.beaconserver.exception.CustomException;
import com.mostra.beaconserver.model.Beacon;
import com.mostra.beaconserver.response.ResponseBeacon;
import com.mostra.beaconserver.response.ResponseDefault;
import com.mostra.beaconserver.service.BeaconService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by JongHunLee on 2015-05-21.
 */

@RestController
public class BeaconController extends ObjectController {
    private static final Logger logger = LoggerFactory.getLogger(BeaconController.class);
    @Autowired
    protected BeaconService beaconService;

    @RequestMapping(value = "/get/data", method = RequestMethod.GET)
    public ResponseDefault getBeaconData(@RequestParam Map<String, String> params) {
        logger.info("/get/data >> " + params.toString());

        ResponseBeacon result = null;
        try {
            Beacon beacon = beaconService.getBeaconByUUID(params.get("uuid"));
            if (beacon == null) throw new CustomException(ResponseCode.ERROR_NOT_BEACON_UUID);
            result = new ResponseBeacon(ResponseCode.SUCCESS);
            result.setBeacon(beacon);
        } catch (CustomException e) {
            return new ResponseBeacon(e.getCode(), "/get/data >> " + e.getMessage() + ", params:" + params);
        }
        return result;
    }

    @RequestMapping(value = "/get/all/data", method = RequestMethod.GET)
    public ResponseDefault getBeaconAllData(@RequestParam Map<String, String> params) {
        logger.info("/get/all/data >> " + params.toString());

        ResponseBeacon result = null;
        try {
            List<Beacon> beaconList = beaconService.getBeacon();
            if (beaconList == null) throw new CustomException(ResponseCode.ERROR_NOT_BEACON_UUID);
            result = new ResponseBeacon(ResponseCode.SUCCESS);
            result.addBeacon(beaconList);
        } catch (CustomException e) {
            return new ResponseBeacon(e.getCode(), "/get/data >> " + e.getMessage() + ", params:" + params);
        }
        return result;
    }

    @RequestMapping(value = "/get/data", method = RequestMethod.POST)
    public ResponseDefault postBeaconData(@RequestParam Map<String, String> params) {
        logger.info("/get/data >> " + params.toString());

        ResponseBeacon result = null;
        try {
            Beacon beacon = beaconService.getBeaconByUUID(params.get("uuiid"));
            if (beacon == null) throw new CustomException(ResponseCode.ERROR_NOT_BEACON_UUID);
            result = new ResponseBeacon(ResponseCode.SUCCESS);
        } catch (CustomException e) {
            return new ResponseBeacon(e.getCode(), "/get/data >> " + e.getMessage() + ", params:" + params);
        }
        return result;
    }

    @RequestMapping(value = "/insert/data", method = RequestMethod.POST)
    public ResponseDefault inseartBeaconData(@RequestParam Map<String, String> params) {
        logger.info("/insert/data >> " + params.toString());

        ResponseBeacon result = null;
        try {
            beaconService.insertBeacon(params);
            result = new ResponseBeacon(ResponseCode.SUCCESS);
        } catch (CustomException e) {
            return new ResponseBeacon(e.getCode(), "/insert/data >> " + e.getMessage() + ", params:" + params);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}

