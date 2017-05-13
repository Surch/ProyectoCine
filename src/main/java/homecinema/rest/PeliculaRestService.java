package homecinema.rest;

import homecinema.model.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.googlecode.objectify.ObjectifyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Path("/films")
@Api(value="gestorPeliculas")
public class PeliculaRestService {

	UriInfo uriInfo;
	
	@POST
	@Path("/addfav")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML)
	@ApiOperation(value="Añade una pelicula a la lista de favoritas o seguidas por un usuario.")
	public String addFilmtoFav(Pelicula film) {
		String msg = "";
		String resultStr ="";
		try {
			resultStr = "201";
			msg = "<message>" + resultStr + "</message>";
			ObjectifyService.ofy().save().entity(film).now();
			System.out.println("Los datos de: " + film.getTitulo() + film.getAnyo() + film.getDirector() + film.getGenero() + " se han guardado correctamente en la lista del usuario: " + film.getId_user());
		} catch (Exception e) {
			resultStr = e.getMessage();
			msg = "<message>ERROR: " + resultStr + "</message>"; 
		} 
		return "<?xml version=\"1.0\"?>" + msg;
	}

	@DELETE
	@Path("/deletefav")
	@Produces(MediaType.APPLICATION_XML)
	@ApiOperation(value="Elimina de la lista de favoritos de un usuario una pelicula")
	public String deleteFilmtoFav(Pelicula film) {
		String msg = "";
		String resultStr ="";
		try {
			resultStr = "201";
			msg = "<message>" + resultStr + "</message>";
			ObjectifyService.ofy().delete().entity(film).now();
		} catch (Exception e) {
			resultStr = e.getMessage();
			msg = "<message>ERROR: " + resultStr + "</message>"; 
		} 
		return "<?xml version=\"1.0\"?>" + msg;
	}

	@GET
	@Path("/filmsofauser")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="Devuelve la lista de peliculas de un usuario")
	public List<Pelicula> films(Usuario user) {
		List<Pelicula> films = ObjectifyService.ofy()
				.load()
				.type(Pelicula.class) // We want only Conversions
				.order("-estreno")       // Most recent first - date is indexed.
				.limit(6)             // Only show 6 of them.
				.list();	
		return films;	
	}
}