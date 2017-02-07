package com.rappi.cubesummation.dto;

public class ResponseStandardDTO 
{
	private MessageDTO messageResponse;
	private float value;
	
	public ResponseStandardDTO(){}
	
	public ResponseStandardDTO(MessageDTO messageResponse) 
	{
		super();
		this.messageResponse = messageResponse;
	}
	
	public ResponseStandardDTO(MessageDTO messageResponse, float value) 
	{
		super();
		this.messageResponse = messageResponse;
		this.value = value;
	}
	
	public MessageDTO getMessageResponse() {
		return messageResponse;
	}
	public void setMessageResponse(MessageDTO messageResponse) {
		this.messageResponse = messageResponse;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	
}
