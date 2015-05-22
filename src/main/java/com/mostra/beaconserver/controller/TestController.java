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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by JongHunLee on 2015-05-21.
 */

@RestController
public class TestController extends ObjectController {
    private static final Logger logger = LoggerFactory.getLogger(BeaconController.class);
    @Autowired
    protected BeaconService beaconService;


    @RequestMapping(value = "/test/set/data", method = RequestMethod.GET)
    public ResponseDefault getBeaconData(@RequestParam Map<String, String> params) {
        logger.info("/test/set/dataa >> " + params.toString());
        ResponseBeacon result = null;
        try {
            Beacon beacon1 = new Beacon();
            beacon1.setUuid("c8c3e68d-2709-48f7-a5c3-d1e4c1ff851b");
            beacon1.setTitleText("아이유 이뻐요");
            beacon1.addPicureURL("http://www.gasengi.com/data/cheditor4/1210/6e96c27731d5986aa7a0283e1572f0c7_gl1as4qj8IxLAHT4CJESVN.jpg");
            beacon1.addPicureURL("http://cfile30.uf.tistory.com/image/195B2336503470B303D86F");
            beacon1.addPicureURL("http://cfile27.uf.tistory.com/original/254ABF4C53A2E1E51E668F");
            beacon1.addPicureURL("http://i1.ruliweb.daumcdn.net/uf/original/U01/ruliweb/54D0EA6F401D6C002F");
            beacon1.addPicureURL("http://www.gasengi.com/data/cheditor4/1210/6e96c27731d5986aa7a0283e1572f0c7_ulewK1s7mVe67wL.jpg");
            beacon1.setContentText("아이유 정말 정말 이뻐요");

            beaconService.insertBeacon(beacon1);

            Beacon beacon2 = new Beacon();
            beacon2.setUuid("3a8c58cf-dfd7-462b-9a27-ac2d9d226e1b");
            beacon2.setTitleText("아이유 짱짱 이뻐요");
            beacon2.addPicureURL("http://www.gasengi.com/data/cheditor4/1210/6e96c27731d5986aa7a0283e1572f0c7_gl1as4qj8IxLAHT4CJESVN.jpg");
            beacon2.addPicureURL("http://cfile30.uf.tistory.com/image/195B2336503470B303D86F");
            beacon2.addPicureURL("http://cfile27.uf.tistory.com/original/254ABF4C53A2E1E51E668F");
            beacon2.addPicureURL("http://i1.ruliweb.daumcdn.net/uf/original/U01/ruliweb/54D0EA6F401D6C002F");
            beacon2.addPicureURL("http://www.gasengi.com/data/cheditor4/1210/6e96c27731d5986aa7a0283e1572f0c7_ulewK1s7mVe67wL.jpg");
            beacon2.setContentText("아이유 크게 크게 이뻐요");

            beaconService.insertBeacon(beacon2);

            Beacon beacon3 = new Beacon();
            beacon3.setUuid("ddc7e89f-a8ef-4ddd-a839-98a9263f49a6");
            beacon3.setTitleText("아이유 소주 광고 해요");
            beacon3.addPicureURL("http://cfile27.uf.tistory.com/image/226ADB37546ECA6E2DA3C9");
            beacon3.addPicureURL("http://tmtj1.tvcps.com/images/20141220/20141220_1419040911_46967600_0.jpg");
            beacon3.addPicureURL("http://cfile23.uf.tistory.com/original/221F4C3C547D47C135478B");
            beacon3.addPicureURL("http://cfile6.uf.tistory.com/image/2353DB4D552A9DA3282048");
            beacon3.addPicureURL("http://www.datanews.co.kr/Articleimages/2014/12/26/20141226052559867.jpg");
            beacon3.setContentText("아이유랑 짠~ 술 마셔요");

            beaconService.insertBeacon(beacon3);
            List<Beacon> beaconList = new ArrayList<>();
            beaconList.add(beacon1);
            beaconList.add(beacon2);
            beaconList.add(beacon3);

            result = new ResponseBeacon(ResponseCode.SUCCESS);
            result.addBeacon(beaconList);
        } catch (Exception e) {
            return new ResponseBeacon(500, "/test/set/data >> " + e.getMessage() + ", params:" + params);
        }
        return result;
    }
}
