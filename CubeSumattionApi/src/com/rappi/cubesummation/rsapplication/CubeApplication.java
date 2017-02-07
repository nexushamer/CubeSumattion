package com.rappi.cubesummation.rsapplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.rappi.cubesummation.managers.MessagesManager;
import com.rappi.cubesummation.utilidades.Utilidades;

@ApplicationPath("/")
public class CubeApplication extends ResourceConfig
{
	private final String STANDARDERRORMESSAGE = "Hubo un error en el servidor, por favor verifique el log y vuelva a intentar instalar la aplicación";
	
	public CubeApplication()
	{
		packages("com.rappi.cubesummation.rsapplication.CubeApplication");
		packages("com.rappi.cubesummation.rest");
		
		register(JacksonFeature.class);
		register(MultiPartFeature.class);
		
		inicializarAplicativo();
	}
	
	private void inicializarAplicativo()
	{
		cargarMensajes();
	}
	
	private void cargarMensajes()
	{
		Properties properties = new Properties();
		Utilidades utilidades = new Utilidades();
		try
		{
			InputStream inputStream = MessagesManager.class.getClassLoader().getResourceAsStream("META-INF/messages.properties");
			properties.load(inputStream);
			
			MessagesManager manager = MessagesManager.getInstance();
			
			for (String key : properties.stringPropertyNames()) 
			{
				String value = properties.getProperty(key);
				manager.setMessageParameters(key, value);
			}
		}
		catch (IOException e) 
		{ 
			System.out.println(utilidades.generarString(STANDARDERRORMESSAGE,e.getMessage()));
		}
	}
	
}
