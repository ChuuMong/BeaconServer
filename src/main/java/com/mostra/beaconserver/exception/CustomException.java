package com.mostra.beaconserver.exception;

import com.mostra.beaconserver.constant.ResponseCode;

public class CustomException extends Exception {

	private static final long serialVersionUID = 6516637121661728622L;
 
	private int code;
    private String msg;
	
	public CustomException(int code) {
		this.code = code; 
	}
    public CustomException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	@Override
	public String getMessage() {
        if(msg != null && msg.length() > 0) return msg;
        else return ResponseCode.getMessage(code);
    }
}
