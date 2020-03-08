package com.ibm.ma.dto.model;

import java.util.Date;

import lombok.Data;

@Data
public class UserDTO {

	/* MSI: sometimes that you don't need to return the whole User entity from DB to
	the FE(mobile or browser) directly, need to remove some fields */
	private String id;
	private String username;
	private Date createTime;
	private String mail;

}