package com.ibm.ma.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ma.api.UsersApi;
import com.ibm.ma.dto.mapper.UserDtoMapper;
import com.ibm.ma.dto.model.UserDTO;
import com.ibm.ma.entity.User;
import com.ibm.ma.exception.MSIException;
import com.ibm.ma.service.UserService;
import com.ibm.ma.util.HttpResponseBuilder;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController implements UsersApi {

	@Autowired
	private UserService mUserServie;

	@Autowired
	private UserDtoMapper mUserDtoMapper;

	// @Value("${eureka.client}")
	// private String samplevalue;

	@Override
	public ResponseEntity<Object> getUserById(@Valid String id, String authorization) {
		try {
			log.info("the value is: {}", "get user API");
			// TODO: do your own service magic here
			User user = mUserServie.getUserByUserId(id);
			UserDTO dto = mUserDtoMapper.from(user);
			return HttpResponseBuilder.success(HttpStatus.OK, "success", dto);
		} catch (MSIException e) {
			return HttpResponseBuilder.fail(e.getCode(), "failed", e.getMessage());
		} catch (Exception e) {
			return HttpResponseBuilder.fail(HttpStatus.BAD_REQUEST, "failed", e.getMessage());
		}
	}
}
