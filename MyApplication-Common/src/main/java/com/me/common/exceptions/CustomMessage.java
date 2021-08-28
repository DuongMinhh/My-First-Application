package com.me.common.exceptions;

public interface CustomMessage {

	String BAD_REQUEST = "Bad request";
	
	String RESOURCE_NOT_FOUND = "Resource not found";
	
	String ACTION_SUCCESS = "Action success";
	
	String ACTION_FAIL = "Action faild";
	
	String IMAGE_TYPE_FAIL = "Type of image is illogical";
	
	String EMAIL_REGEX = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
	
	String PHONE_REGEX = "^[+][0-9]{9,15}+$";
	
	String EMAIL_INVALID = "The email is invalid";
	
	String PHONE_INVALID = "The phone number is invalid";
	
	String FIELD_LEN_INVALID = "This field length is invalid";
	
	String FIELD_NOT_BLANK = "This field is not blank";
	
	String FIELD_NOT_NULL = "This field is not null";
	
	String UNAUTHORIZED = "Unauthorized";
	
	String LOGIN_INFO_INVALID = "Login information or password is invalid";
	
}
