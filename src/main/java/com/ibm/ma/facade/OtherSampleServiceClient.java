package com.ibm.ma.facade;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import com.ibm.ma.entity.User;

@Service
@Slf4j
public class OtherSampleServiceClient {

	@Autowired
	private RestTemplate mRestTemplate;
	
	@Autowired
	private ObjectMapper mObjectMapper;
	
	public HttpEntity<String> buildEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		return entity;
	}
	
	//MSI: Sample method, usually it will be used to call other microservice
	public User getUserByUserId(String userId) {
		User user = new User();
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("id", userId);
			ResponseEntity<String> result = mRestTemplate.exchange("TODO: YOUR OWN CLIENT URL", HttpMethod.GET, buildEntity(), String.class, params);
		 	log.info("Get user info for user : {}", userId);
			JsonNode response = mObjectMapper.readTree(result.getBody());
			JsonNode userArray = response.get("data");
			user = mObjectMapper.treeToValue(userArray, User.class);
		} catch (Exception e) {
			return null;
		}
		return user;
	}
	
}
