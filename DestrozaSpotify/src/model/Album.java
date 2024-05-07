package model;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;

public class Album {

	private int idAlbum;
	private String nombre;
	private String fechaPublicacion;
//	private ArrayList<Cancion> canciones;
	private String genero;
	private ImageIcon imagen;
	private int idMusico;
	private int cantidadCanciones;
	
	public Album() {

	}

	public Album(int idAlbum, String nombre, String fechaPublicacion, String genero, ImageIcon imagen, int idMusico, int cantidadCanciones) {
		this.idAlbum = idAlbum;
		this.nombre = nombre;
		this.fechaPublicacion = fechaPublicacion;
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
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
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

	public int getIdMusico() {
		return idMusico;
	}

	public void setNombreArtista(int idMusico) {
		this.idMusico = idMusico;
	}

	public int getCantidadCanciones() {
		return cantidadCanciones;
	}

	public void setCantidadCanciones(int cantidadCanciones) {
		this.cantidadCanciones = cantidadCanciones;
	}
	
	
	
}
