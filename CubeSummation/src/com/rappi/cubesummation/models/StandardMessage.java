package com.rappi.cubesummation.models;

import java.io.Serializable;

public class StandardMessage implements Serializable 
{
	private static final long serialVersionUID = -9052363896966802862L;
	private String codigo;
	private String descripcion;
	
	public StandardMessage(){}

	public StandardMessage(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setMessage(String code,String descripcion) 
	{
		this.codigo = code;
		this.descripcion = descripcion;
	}
	
}
