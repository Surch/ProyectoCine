package homecinema.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
@XmlRootElement
public class Pelicula {
	@Id public Long id_pelicula;
	private String id_user;
	private String titulo;
	private int anyo;
	@Index private String estreno;
	private String duracion;
	private String genero;
	private String director;
	private String sinopsis;
	private String portada;//alamacena una URL
	//private String[] aCines;
	//private double[] notas;
	
	public Pelicula(){}
	
	@JsonCreator
	public Pelicula(@JsonProperty("id_user")String id_user, @JsonProperty("titulo")String titulo, @JsonProperty("portada")String portada, @JsonProperty("anyo")int anyo, 
			@JsonProperty("estreno")String estreno, @JsonProperty("duracion")String duracion, @JsonProperty("genero")String genero,
			@JsonProperty("director")String director, @JsonProperty("sinopsis")String sinopsis) {
		this.id_user = id_user;
		this.titulo = titulo;
		this.anyo = anyo;
		this.estreno = estreno;
		this.duracion = duracion;
		this.genero = genero;
		this.director = director;
		this.sinopsis = sinopsis;
		this.portada = portada;

	}

	/*public Pelicula(Long id_user, String titulo, int anyo, String edad, 
			Date estreno, int duracion, String genero,
			String director, String sinopsis, String portada) {
		this.id_user = id_user;
		this.titulo = titulo;
		this.anyo = anyo;
		this.edad = edad;
		this.estreno = estreno;
		this.duracion = duracion;
		this.genero = genero;
		this.director = director;
		this.sinopsis = sinopsis;
		this.portada = portada;

	}*/


	public Long getId_pelicula() {
		return id_pelicula;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public String getEstreno() {
		return estreno;
	}
	public void setEstreno(String estreno) {
		this.estreno = estreno;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public String getportada() {
		return portada;
	}
	public void setportada(String portada) {
		this.portada = portada;
	}

	public String getId_user() {
		return id_user;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
}
