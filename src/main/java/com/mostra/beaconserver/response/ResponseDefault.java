package com.mostra.beaconserver.response;

import com.mostra.beaconserver.constant.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by JongHunLee on 2015-05-21.
 */
public class ResponseDefault {
    private static final Logger logger = LoggerFactory.getLogger(ResponseDefault.class);

    protected int code;
    protected String msg;
    protected String errorLog;

    public ResponseDefault() {
        // TODO Auto-generated constructor stub
    }

    public ResponseDefault(int code) {
        onCreate(code);
    }

    public ResponseDefault(int code, String msg) {
        onCreate(code, msg);
    }

    protected void onCreate(int code) {
        onCreate(code, ResponseCode.getMessage(code));
    }

    protected void onCreate(int code, String msg) {
        this.code = code;

        if(this.code != ResponseCode.SUCCESS) {
            this.msg = ResponseCode.getMessage(code);
            this.errorLog = msg;
            writeLog();
        }  else
            this.msg = msg;
    }

    private void writeLog() {
        logger.error(errorLog);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
