package homecinema.rest;

import homecinema.model.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.googlecode.objectify.ObjectifyService;

import java.util.List;

@Path("/users")
@Api(value="gestor")
public class UserRestService {

	UriInfo uriInfo;

	Thread hilo;
	public void mailValidacion(final String destinatario)
	{
		hilo = new Thread() 
		{  
			public void run() 
			{
				MailSender ms = new MailSender(destinatario);
				ms.sendMessageValidacion("Hola,\n\nUsted se ha suscrito al servicio de Homecinemapp" +
						"\n\nA partir de este momento podrá usar la aplicación para buscar las peliculas próximas a estrenarse, calificarlas y comentarlas." +
						"\nGracias por unirse a nuestra pequeña comunidad,"+
						"\n\n¡Le deseamos una feliz experiencia\n" +
						"Su equipo de Homecinemapp");
			}
		};
		hilo.start();
	}

	@POST
	@Path("/register")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value="Registra un nuevo usuario en la aplicación.")
	public String register(Usuario newUser) {
		String msg = "";
		String resultStr ="";
		try {
			resultStr = "201";
			msg = "<message>" + resultStr + "</message>";
			ObjectifyService.ofy().save().entity(newUser).now();
			System.out.println("Los datos de: " + newUser.getNickname() + " se han guardado correctamente.");
		} catch (Exception e) {
			resultStr = e.getMessage();
			msg = "<message>ERROR: " + resultStr + "</message>"; 
		} 
		return "<?xml version=\"1.0\"?>" + msg;
	}

	@POST
	@Path("/login")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML)
	@ApiOperation(value="Verifica los datos del usuario y le permite entrar en su cuenta si son correctos.")
	public String login(Usuario user) {
		String msg = "";
		Long resultStr;
		List<Usuario> users = ObjectifyService.ofy()
				.load()
				.type(Usuario.class) 
				.list();	
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getNickname().equals(user.getNickname())){
				if(users.get(i).getPassword().equals(user.getPassword())){
					System.out.println("ID del usuario: " + users.get(i).getId_user());
					resultStr = users.get(i).getId_user();
					msg = "<message>" + resultStr + "</message>";
				}
			}else{
				System.out.println("Error en el logueo.");
			}
		}
		return "<?xml version=\"1.0\"?>" + msg;

	}
}