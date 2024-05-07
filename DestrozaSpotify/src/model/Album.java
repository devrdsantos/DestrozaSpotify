package model;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;

public class Album {

	private int idAlbum;
	private String titulo;
	private String año;
//	private ArrayList<Cancion> canciones;
	private String genero;
	private ImageIcon imagen;
	private int idMusico;
	private int cantidadCanciones;
	
	public Album() {

	}

	public Album(int idAlbum, String titulo, String año, String genero, ImageIcon imagen, int idMusico, int cantidadCanciones) {
		this.idAlbum = idAlbum;
		this.titulo = titulo;
		this.año = año;
//		this.canciones = canciones;
		this.genero = genero;
		this.imagen = imagen;
		this.idMusico = idMusico;
		this.cantidadCanciones = cantidadCanciones;
	}

	public int getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}

	public String getNombre() {
		return titulo;
	}

	public void setNombre(String nombre) {
		this.titulo = nombre;
	}

	public String getFechaPublicacion() {
		return año;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.año = fechaPublicacion;
	}

//	public ArrayList<Cancion> getCanciones() {
//		return canciones;
//	}
//
//	public void setCanciones(ArrayList<Cancion> canciones) {
//		this.canciones = canciones;
//	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public int getIDMusico() {
		return idMusico;
	}

	public void setIDMusico(int idMusico) {
		this.idMusico = idMusico;
	}

	public int getCantidadCanciones() {
		return cantidadCanciones;
	}

	public void setCantidadCanciones(int cantidadCanciones) {
		this.cantidadCanciones = cantidadCanciones;
	}
	
	
	
}
