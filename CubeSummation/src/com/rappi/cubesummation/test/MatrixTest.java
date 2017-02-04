package com.rappi.cubesummation.test;

import org.junit.Test;

import com.rappi.cubesummation.math.Matrix3D;

import static org.junit.Assert.*;

/**
 * Clase de Junit test para realizar las pruebas unitarias del proyecto
 * @author sergioalexandermendietaarias
 *
 */
public class MatrixTest 
{
	@Test
	public void test()
	{
		Matrix3D matrix = new Matrix3D(4);
		
		matrix.update(2, 2, 2, 4.0f);
		float sum = matrix.sum(1, 1, 1, 3, 3, 3);
		assertEquals(0,Float.compare(4.0f, sum));
		
		matrix.update(1, 1, 1, 23.0f);
		sum = matrix.sum(2, 2, 2, 4, 4, 4);
		assertEquals(0,Float.compare(4.0f, sum));
		
		sum = matrix.sum(1, 1, 1, 3, 3, 3);
		assertEquals(0,Float.compare(27.0f, sum));
	}
}
