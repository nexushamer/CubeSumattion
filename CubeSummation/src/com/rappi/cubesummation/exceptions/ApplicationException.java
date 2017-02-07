package com.rappi.cubesummation.exceptions;

public class ApplicationException extends Exception 
{
	private static final long serialVersionUID = 5518568572892397520L;
	private String message;
	
	public ApplicationException(String message)
	{
		super(message);
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	}

	public void setMessage(String message) 
	{
		this.message = message;
	}
}
