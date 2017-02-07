package com.rappi.cubesummation.utilidades;

public class Utilidades 
{
	public String generarString(String... valores)
	{
		StringBuilder stringBuilder = new StringBuilder();
		
		for(String string : valores){
			stringBuilder.append(string);
		}
		
		return stringBuilder.toString();
	}
}
