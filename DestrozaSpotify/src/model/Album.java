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
	private String nombreArtista;

	public Album() {

	}

	public Album(int idAlbum, String nombre, String fechaPublicacion, String genero, ImageIcon imagen, String nombreArtista) {
		this.idAlbum = idAlbum;
		this.nombre = nombre;
		this.fechaPublicacion = fechaPublicacion;
//		this.canciones = canciones;
		this.genero = genero;
		this.imagen = imagen;
		this.nombreArtista = nombreArtista;
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

	public String getNombreArtista() {
		return nombreArtista;
	}

	public void setNombreArtista(String nombreArtista) {
		this.nombreArtista = nombreArtista;
	}
	
}
