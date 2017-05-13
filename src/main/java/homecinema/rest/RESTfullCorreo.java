package homecinema.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import homecinema.model.MailSender;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Path("/email")
public class RESTfullCorreo {

	Thread hilo;
	@GET
	@Path("/remind/{dato}")
	@Produces(MediaType.APPLICATION_XML)
	@ApiOperation(value="Env�a un email para confirmar la suscripci�n.")
	public void mailValidacion(@ApiParam(value="dato",required=true)@PathParam("dato") final String destinatario)
	{
		hilo = new Thread() 
		{  
			public void run() 
			{
				MailSender ms = new MailSender(destinatario);
				ms.sendMessageValidacion("Hola,\n\nUsted se ha suscrito al servicio de Homecinemapp" +
						"\n\nA partir de este momento podr� usar la aplicaci�n para buscar las peliculas pr�ximas a estrenarse, calificarlas y comentarlas." +
						"\nGracias por unirse a nuestra peque�a comunidad,"+
						"\n\n�Le deseamos una feliz experiencia\n" +
						"Su equipo de Homecinemapp");
			}
		};
		hilo.start();
	}
    
    }