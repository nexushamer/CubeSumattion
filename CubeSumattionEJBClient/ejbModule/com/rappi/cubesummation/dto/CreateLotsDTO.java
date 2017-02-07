package com.rappi.cubesummation.dto;

public class CreateLotsDTO 
{
	private int depth;
	private int length;
	
	public CreateLotsDTO(){}

	public CreateLotsDTO(int depth, int length) 
	{
		super();
		this.depth = depth;
		this.length = length;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
