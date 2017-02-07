package com.rappi.cubesummation.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;

@XmlRootElement(name = "RequestCreate",namespace="http://www.wfmc.org/2008/XPDL2.1")
@XmlAccessorType(XmlAccessType.PROPERTY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestCreate implements Serializable
{
	private static final long serialVersionUID = 5047345701833134902L;
	private int depth;
	private int operationsLength;
	
	public RequestCreate()
	{	
	}

	public RequestCreate(int depth, int operationsLength) {
		super();
		this.depth = depth;
		this.operationsLength = operationsLength;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getOperationsLength() {
		return operationsLength;
	}

	public void setOperationsLength(int operationsLength) {
		this.operationsLength = operationsLength;
	}
}
