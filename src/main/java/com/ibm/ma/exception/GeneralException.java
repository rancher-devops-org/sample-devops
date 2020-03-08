package com.ibm.ma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class GeneralException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6771494113273719957L;
	public GeneralException(String exception) {
	    super(exception);
	  }
}
