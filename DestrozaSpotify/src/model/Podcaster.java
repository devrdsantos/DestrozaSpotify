package model;

import javax.swing.ImageIcon;

public class Podcaster {
	
	private int IDPodcaster;
	private String nombreArtistico;
	private ImageIcon imagen;
	private String descripcion;	
	private String genero;

	public Podcaster() {
		
	}

	public Podcaster(String nombreArtistico, ImageIcon imagen, String descripcion, int iDPodcaster, String genero) {
		super();
		this.nombreArtistico = nombreArtistico;
		this.imagen = imagen;
		this.descripcion = descripcion;
		IDPodcaster = iDPodcaster;
		this.genero = genero;
	}

	public String getNombre() {
		return nombreArtistico;
	}

	public void setNombre(String nombre) {
		this.nombreArtistico = nombre;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIDPodcaster() {
		return IDPodcaster;
	}

	public void setIDPodcaster(int iDPodcaster) {
		IDPodcaster = iDPodcaster;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	

}
