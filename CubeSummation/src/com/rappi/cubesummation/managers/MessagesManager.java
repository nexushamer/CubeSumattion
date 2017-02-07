package com.rappi.cubesummation.managers;

import java.util.HashMap;

public class MessagesManager 
{
	private static MessagesManager instance = null;
	private HashMap<String, String> messageParameters;
	
	protected MessagesManager()
	{
		messageParameters = new HashMap<>();
	}
	
	public static MessagesManager getInstance()
	{
		if(instance == null)
			instance = new MessagesManager();
		
		return instance;
	}

	public HashMap<String, String> getMessageParameters() 
	{
		return messageParameters;
	}

	public String getSpecificMessage(String code) 
	{
		if(this.messageParameters != null)
			return this.messageParameters.get(code);
			
		return null;
	}
	
	public void setMessageParameters(HashMap<String, String> messageParameters) 
	{
		this.messageParameters = messageParameters;
	}

	public void setMessageParameters(String key,String value) 
	{
		if(this.messageParameters != null)
			this.messageParameters.put(key, value);
	} 
}
