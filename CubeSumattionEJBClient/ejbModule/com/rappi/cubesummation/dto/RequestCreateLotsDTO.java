package com.rappi.cubesummation.dto;

import java.io.Serializable;
import java.util.LinkedList;

public class RequestCreateLotsDTO implements Serializable
{
	private static final long serialVersionUID = 5627163492209012420L;
	private LinkedList<CreateLotsDTO> lots;
	
	public RequestCreateLotsDTO()
	{
		lots = new LinkedList<>();
	}

	public RequestCreateLotsDTO(LinkedList<CreateLotsDTO> lots) 
	{
		super();
		this.lots = lots;
	}

	public LinkedList<CreateLotsDTO> getLots() 
	{
		return lots;
	}

	public void setLots(LinkedList<CreateLotsDTO> lots) 
	{
		this.lots = lots;
	}
	
	public void setLots(CreateLotsDTO create) 
	{
		if(this.lots != null)
			this.lots.add(create);
	}
}
