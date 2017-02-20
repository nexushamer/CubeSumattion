package com.rappi.cubesummation.test;

import com.rappi.cubesummation.exceptions.ApplicationException;
import com.rappi.cubesummation.math.Matrix3D;

public class Main 
{
	public static void main(String[] args)
	{
		Matrix3D matrix = new Matrix3D(4,4);
		
		try
		{
			matrix.update(2, 2, 2, 4.0f);
			System.out.println(matrix.toString());
			float sum = matrix.sum(1, 1, 1, 3, 3, 3);
			System.out.println("sum " + sum);
			matrix.update(1, 1, 1, 23.0f);
			System.out.println(matrix.toString());
			sum = matrix.sum(2, 2, 2, 4, 4, 4);
			System.out.println("sum " + sum);
			sum = matrix.sum(1, 1, 1, 3, 3, 3);
			System.out.println("sum " + sum);
		}
		catch (ApplicationException e) 
		{
			System.out.println(e.getMessage());
		}
	}
}
