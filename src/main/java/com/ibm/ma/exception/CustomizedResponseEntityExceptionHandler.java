package com.ibm.ma.exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.ibm.ma.constant.Constants;
import com.ibm.ma.util.HttpResponseBuilder;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<Object> handleException(Exception e){
		return HttpResponseBuilder.fail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
	}

	@ExceptionHandler(GeneralException.class)
	@ResponseBody
	public final ResponseEntity<Object> handleGeneralException(GeneralException ex, WebRequest request) {
		return HttpResponseBuilder.fail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
	}

	@ExceptionHandler(value = MSIException.class)
	@ResponseBody
	public ResponseEntity<Object> MSIExceptionHandler(HttpServletRequest req, MSIException e) throws Exception {
		System.out.println("MSIException Response:" + e.getMessage());
		return HttpResponseBuilder.fail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<Object> handleMethodArgumentNotValidException(HttpServletRequest req, MethodArgumentNotValidException e)
			throws MethodArgumentNotValidException {
		System.out.println("MSIException Response:" + e.getMessage());
		return HttpResponseBuilder.fail(HttpStatus.INTERNAL_SERVER_ERROR, Constants.ARGUMENT_INVALID, e.getMessage());
	}
}
