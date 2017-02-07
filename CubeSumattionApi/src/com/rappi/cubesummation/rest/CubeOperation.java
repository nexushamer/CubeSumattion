package com.rappi.cubesummation.rest;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jettison.json.JSONException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.rappi.cubesummation.dto.CoordinateDTO;
import com.rappi.cubesummation.dto.ResponseStandardDTO;
import com.rappi.cubesummation.ejb.CubeManagerRemote;
import com.rappi.cubesummation.managers.MessagesManager;
import com.rappi.cubesummation.models.RequestCreate;
import com.rappi.cubesummation.models.RequestUpdate;
import com.rappi.cubesummation.models.StandardMessage;
import com.rappi.cubesummation.utilidades.Utilidades;

@Path("/Cube")
public class CubeOperation 
{
	private final MessagesManager messages = MessagesManager.getInstance();
	private final Utilidades utilidades = new Utilidades();
	
	private CubeManagerRemote cubeManager;
	
	public CubeOperation(){
		InitialContext initialContext;
		try 
		{
			initialContext = new InitialContext();
			cubeManager = (CubeManagerRemote)initialContext.lookup("java:jboss/exported/CubeSumattionEAR/CubeSumattionEJB/CubeManager!com.rappi.cubesummation.ejb.CubeManagerRemote");
		}
		catch (NamingException e) 
		{
			System.out.println(utilidades.generarString(messages.getSpecificMessage("ERR001")," ",e.getMessage()));
		}
	}
	
	@PUT @Path("/create")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes({"application/xml", "application/json"})
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public Response create(@Context HttpHeaders headers,RequestCreate request) throws JSONException  
	{
		Status status = null;
		StandardMessage response = new StandardMessage();
		String headerAccept = getFormatAccept(headers);
		String producer = null;
		
		if(headerAccept != null)
			producer = getProducer(headerAccept);
		else
			return generateResponse(true, Status.INTERNAL_SERVER_ERROR, null, null);
		
		if(producer == null)
			return generateResponse(true, Status.INTERNAL_SERVER_ERROR, null, null);
		
		try
		{	
			
			/*
			ResponseStandardDTO responseEjb = cubeManager.update(coordinates);
			response.setMessage(responseEjb.getMessageResponse().getCode(), 
					messages.getSpecificMessage(responseEjb.getMessageResponse().getCode()));
			*/
			status = Response.Status.OK;
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			status = Response.Status.INTERNAL_SERVER_ERROR;
			response.setMessage("100", messages.getSpecificMessage("APP_100"));
		}
		
		return generateResponse(false, status, response, producer); 
	}
	
	@PUT @Path("/update")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes({"application/xml", "application/json"})
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public Response update(@Context HttpHeaders headers,RequestUpdate request) throws JSONException  
	{
		Status status = null;
		StandardMessage response = new StandardMessage();
		String headerAccept = getFormatAccept(headers);
		String producer = null;
		
		if(headerAccept != null)
			producer = getProducer(headerAccept);
		else
			return generateResponse(true, Status.INTERNAL_SERVER_ERROR, null, null);
		
		if(producer == null)
			return generateResponse(true, Status.INTERNAL_SERVER_ERROR, null, null);
		
		try
		{
			
			CoordinateDTO coordinates = new CoordinateDTO.CoordinateDTOBuilder(
					request.getCoordinate().getX(), 
					request.getCoordinate().getY(), 
					request.getCoordinate().getZ()).value(
							request.getCoordinate().getValue()
							).createCoordinateDTO();
			
			ResponseStandardDTO responseEjb = cubeManager.update(coordinates);
			response.setMessage(responseEjb.getMessageResponse().getCode(), 
					messages.getSpecificMessage(responseEjb.getMessageResponse().getCode()));
			status = Response.Status.OK;
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			status = Response.Status.INTERNAL_SERVER_ERROR;
			response.setMessage("100", messages.getSpecificMessage("APP_100"));
		}
		
		return generateResponse(false, status, response, producer); 
	}
	
	private String getProducer(String headerAccept)
	{
		if(headerAccept.equals("application/json"))
			return MediaType.APPLICATION_JSON;
		else
			if(headerAccept.equals("application/xml"))
				return MediaType.APPLICATION_XML;
		
		return null;
	}
	
	private String getFormatAccept(HttpHeaders headers)
	{
		String formatAcept = "";
		if(headers != null)
		{
			formatAcept = headers.getRequestHeader("Accept").get(0);
			if(formatAcept == null)
				formatAcept = headers.getRequestHeader("accept").get(0);
		}
		
		if(formatAcept.equals(""))
			return null;
		else
			return formatAcept;
	}
	
	private Response generateResponse(boolean isError,Status status,Object entity,String type)
	{
		if(isError)
			return Response.serverError().status(Response.Status.INTERNAL_SERVER_ERROR).build();
		else
			return Response.ok(entity,type).status(status).build();
	}
	
}
