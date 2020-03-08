package com.ibm.ma.exception;

import org.springframework.http.HttpStatus;

public class MSIException extends Exception {

	private static final long serialVersionUID = 1L;
	private HttpStatus code;
	
	public MSIException(HttpStatus code,String message) {
        super(message);
        this.code = code;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}
}

