package com.rappi.cubesummation.ejb;

import javax.ejb.Local;

import com.rappi.cubesummation.dto.CoordinateDTO;
import com.rappi.cubesummation.dto.RequestCreateLotsDTO;
import com.rappi.cubesummation.dto.ResponseStandardDTO;
import com.rappi.cubesummation.exceptions.ApplicationException;

@Local
public interface CubeManagerLocal 
{
	public ResponseStandardDTO createLots(RequestCreateLotsDTO request) throws ApplicationException;
	public ResponseStandardDTO create(int depth,int length) throws ApplicationException;
	public ResponseStandardDTO update(CoordinateDTO position) throws ApplicationException;
	public ResponseStandardDTO query(CoordinateDTO initialRange,CoordinateDTO finalRange) throws ApplicationException;
}
