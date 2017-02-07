package com.rappi.cubesummation.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;

@XmlRootElement(name = "RequestUpdate",namespace="http://www.wfmc.org/2008/XPDL2.1")
@XmlAccessorType(XmlAccessType.PROPERTY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestUpdate implements Serializable
{
	private static final long serialVersionUID = 5047345701833134902L;
	private Coordinate coordinate; 
	
	public RequestUpdate()
	{	
		coordinate = new Coordinate();
	}

	public RequestUpdate(Coordinate coordinate) {
		super();
		this.coordinate = coordinate;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
}
