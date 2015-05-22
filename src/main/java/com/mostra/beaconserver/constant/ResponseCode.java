package com.mostra.beaconserver.constant;

/**
 * Created by JongHunLee on 2015-05-21.
 */
public class ResponseCode {
    public static final int SUCCESS = 200;
    public static final int ERROR_NOT_BEACON_UUID = 001;







    public static String getMessage(int code) {
        if(ERROR_NOT_BEACON_UUID == code) return "비콘을 찾을 수 없습니다.";
        return "";
    }
}
