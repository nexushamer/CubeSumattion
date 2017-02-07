package com.rappi.cubesummation.dto;

import java.io.Serializable;

public class MessageDTO implements Serializable 
{
	private static final long serialVersionUID = -966107216686481727L;
	private String code;
	private String message;
	
	public MessageDTO(){}

	public MessageDTO(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
