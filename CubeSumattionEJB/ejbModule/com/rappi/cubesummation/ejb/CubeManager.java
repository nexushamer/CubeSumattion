package com.rappi.cubesummation.ejb;

import java.util.LinkedList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.rappi.cubesummation.dto.CoordinateDTO;
import com.rappi.cubesummation.dto.CreateLotsDTO;
import com.rappi.cubesummation.dto.MessageDTO;
import com.rappi.cubesummation.dto.RequestCreateLotsDTO;
import com.rappi.cubesummation.dto.ResponseStandardDTO;
import com.rappi.cubesummation.exceptions.ApplicationException;
import com.rappi.cubesummation.managers.MessagesManager;
import com.rappi.cubesummation.math.Matrix3D;

/**
 * Session Bean implementation class CubeSummationManager
 */
@Stateless
@LocalBean
public class CubeManager implements CubeManagerRemote, CubeManagerLocal 
{
	private MessagesManager objectManager = MessagesManager.getInstance();
	private LinkedList<Matrix3D> list;
	
    public CubeManager() 
    {
    	list = new LinkedList<>();
    }

    @Override
	public ResponseStandardDTO createLots(RequestCreateLotsDTO request) throws ApplicationException 
    {
    	int sizeOkResponse = 0;
    	if(request.getLots() != null && request.getLots().size() > 0)
    		for(CreateLotsDTO create : request.getLots())
    		{
    			ResponseStandardDTO respuesta = create(create.getDepth(), create.getLength());
    			if(respuesta.getMessageResponse().getCode().equals("APP_002"))
    				sizeOkResponse += 1;
    		}
    	
    	if(sizeOkResponse == request.getLots().size())
    		return new ResponseStandardDTO(new MessageDTO("APP_003", objectManager.getSpecificMessage("APP_003")));
    	else
    		if(sizeOkResponse == request.getLots().size())
    			return new ResponseStandardDTO(new MessageDTO("APP_004", objectManager.getSpecificMessage("APP_004")));
    	
    	return new ResponseStandardDTO(new MessageDTO("APP_005", objectManager.getSpecificMessage("APP_005")));
	}
    
	@Override
	public ResponseStandardDTO create(int depth,int length) throws ApplicationException 
	{
		ResponseStandardDTO response = new ResponseStandardDTO();
		
		try
		{
			Matrix3D matrix = new Matrix3D(depth,length);
			list.add(matrix);
			
			response.setMessageResponse(new MessageDTO("APP_002", objectManager.getSpecificMessage("APP_002")));
		}
		catch (NegativeArraySizeException e) 
		{
			response.setMessageResponse(new MessageDTO("ERR_001", objectManager.getSpecificMessage("ERR_001")));
		}
		
		return response;
	}

	@Override
	public ResponseStandardDTO update(CoordinateDTO position) throws ApplicationException 
	{
		ResponseStandardDTO response = new ResponseStandardDTO();
		
		if(list != null && list.size() > 0)
		{
			Matrix3D cube = list.get(0);
			cube.update((int)position.getX(),
						(int)position.getY(),
						(int)position.getZ(),
						(int)position.getValue());
			
			response.setMessageResponse(new MessageDTO("APP_006", objectManager.getSpecificMessage("APP_006")));
		}
		else
			response.setMessageResponse(new MessageDTO("ERR_002", objectManager.getSpecificMessage("ERR_002")));
		
		return response;
	}

	@Override
	public ResponseStandardDTO query(CoordinateDTO initialRange, CoordinateDTO finalRange) throws ApplicationException 
	{
		ResponseStandardDTO response = new ResponseStandardDTO();
		
		try
		{
			Matrix3D cube = list.get(0);
			float result = cube.sum((int)initialRange.getX(), (int)initialRange.getY(), (int)initialRange.getZ(), 
					(int)finalRange.getX(), (int)finalRange.getY(), (int)finalRange.getZ());
		
			response.setValue(result);
			response.setMessageResponse(new MessageDTO("APP_006", objectManager.getSpecificMessage("APP_006")));
		}
		catch (Exception e) 
		{
			response.setMessageResponse(new MessageDTO("ERR_001", objectManager.getSpecificMessage("ERR_001")));
		}
		
		return response;
	}
}
