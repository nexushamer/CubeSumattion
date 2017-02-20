package com.rappi.cubesummation.dto;

import java.io.Serializable;

public class CoordinateDTO implements Serializable 
{
	private static final long serialVersionUID = -1221939649933270059L;
	private float x;
	private float y;
	private float z;
	private float value;
	
	private CoordinateDTO(float x, float y, float z, float value) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.value = value;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
	
	public static class CoordinateDTOBuilder
	{
		private float x;
		private float y;
		private float z;
		private float value;
		
		public CoordinateDTOBuilder(float x,float y, float z)
		{
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		public CoordinateDTOBuilder(CoordinateDTO cordinate)
		{
			this.x = cordinate.x;
			this.y = cordinate.y;
			this.z = cordinate.z;
		}
		
		public CoordinateDTOBuilder value(float value)
		{
			this.value = value;
			
			return this;
		}
		
		public CoordinateDTOBuilder cordinates(float x,float y, float z)
		{
			this.x = x;
			this.y = y;
			this.z = z;
			
			return this;
		}
		
		public CoordinateDTOBuilder cordinatesAndValues(float x,float y, float z,float value)
		{
			this.x = x;
			this.y = y;
			this.z = z;
			this.value = value;
			
			return this;
		}
		
		public CoordinateDTO createCoordinateDTO()
		{
			return new CoordinateDTO(x, y, z, value);
		}
	}
}
