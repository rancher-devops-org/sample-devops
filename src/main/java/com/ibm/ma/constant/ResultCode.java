package com.ibm.ma.constant;

public enum ResultCode {
	
    SUCCESS("200", "SUCCESS"),
    FAIL("205", "FAILED");
	
	
	private ResultCode(String value, String msg){
        this.val = value;
        this.msg = msg;
    }

    public String val() {
        return val;
    }

    public String msg() {
        return msg;
    }

    private String val;
    private String msg;
}
