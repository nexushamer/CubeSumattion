package com.rappi.cubesummation.test;

import static org.junit.Assert.*;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.JerseyClient;
import org.junit.Test;

import com.rappi.cubesummation.models.Coordinate;
import com.rappi.cubesummation.models.RequestUpdate;

public class ApiTest extends JerseyClient 
{
	@Test
    public void test() 
	{
		Coordinate coor = new Coordinate(0, 0, 0, 4);
		RequestUpdate request = new RequestUpdate(coor);
		
		Response response = target("http://localhost:8082/CubeSumattionApi/rest/Cube").path("update").request(MediaType.APPLICATION_JSON).post(Entity.entity(request, MediaType.APPLICATION_JSON));
        assertEquals(response.getStatus(), 200);
    }
}
