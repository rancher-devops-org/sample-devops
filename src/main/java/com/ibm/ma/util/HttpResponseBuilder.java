package com.ibm.ma.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ibm.ma.model.StandardResponse;

public class HttpResponseBuilder {

	public static ResponseEntity<Object> success(HttpStatus code, String message, Object data) {
		StandardResponse response = new StandardResponse();
		response.setCode(code.value());
		response.setMessage(message);
		response.setData(data);
		return new ResponseEntity<Object>(response, code);
	}

	public static ResponseEntity<Object> fail(HttpStatus code, String message, Object data) {
		StandardResponse response = new StandardResponse();
		response.setCode(code.value());
		response.setMessage(message);
		response.setData(data);
		return new ResponseEntity<Object>(response, code);
	}

}
