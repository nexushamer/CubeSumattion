package com.rappi.cubesummation.math;

import java.io.Serializable;

/**
 * Clase que se usa para realizar las operaciones sobre la sumatoria de cubos
 * @author sergioalexandermendietaarias
 *
 */
public class Matrix3D implements Serializable
{
	private static final long serialVersionUID = 323897683169943286L;
	private float[][][] points;
	private int depth;
	
	public Matrix3D(int depth) throws NegativeArraySizeException
	{
		this.depth = depth;
		points = new float[this.depth][this.depth][this.depth];
		zero();
	}
	
	public void zero()
	{
		for(int i = 0; i < this.depth ; i++)
			for(int j = 0; j < this.depth ; j++)
				for(int k = 0; k < this.depth ; k++)
					points[i][j][k] = 0;
	}
	
	public void update(int x,int y,int z,float w)
	{
		if(x > 0)
			x -= 1;
		
		if(y > 0)
			y -= 1;
		
		if(z > 0)
			z -= 1;
		points[x][y][z] = w;
	}
	
	public float sum(int x1,int y1,int z1,int x2,int y2,int z2)
	{
		if(x1 > 0)
			x1 -= 1;
		
		if(y1 > 0)
			y1 -= 1;
		
		if(z1 > 0)
			z1 -= 1;
		
		if(x2 > 0)
			x2 -= 1;
		
		if(y2 > 0)
			y2 -= 1;
		
		if(z2 > 0)
			z2 -= 1;
		
		float sum = 0;
		
		for(int i = x1; i <= x2 ; i++)
			for(int j = y1; j <= y2 ; j++)
				for(int k = z1; k <= z2 ; k++)
					sum += points[i][j][k];
		
		return sum;
	}
	
	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		final String LINESEPARATOR = System.getProperty("line.separator");
		
		for(int i = 0; i < this.depth ; i++)
			for(int j = 0; j < this.depth ; j++)
				for(int k = 0; k < this.depth ; k++)
				{
					stringBuilder.append(i);
					stringBuilder.append(" ");
					stringBuilder.append(j);
					stringBuilder.append(" ");
					stringBuilder.append(k);
					stringBuilder.append(" -> ");
					stringBuilder.append(points[i][j][k]);
					stringBuilder.append(LINESEPARATOR);
				}
		
		return stringBuilder.toString();
	}
	
}
