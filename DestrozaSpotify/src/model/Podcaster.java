package model;

import javax.swing.ImageIcon;

public class Podcaster {

	private int idPodcaster;
	private String nombreArtistico;
	private ImageIcon imagen;
	private String descripcion;
	private String genero;

	public Podcaster() {

	}

	public Podcaster(int iDPodcaster, String nombreArtistico, ImageIcon imagen, String descripcion, String genero) {
		this.idPodcaster = iDPodcaster;
		this.nombreArtistico = nombreArtistico;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.genero = genero;
	}

	public int getIdPodcaster() {
		return idPodcaster;
	}

	public void setIdPodcaster(int idPodcaster) {
		this.idPodcaster = idPodcaster;
	}

	public String getNombreArtistico() {
		return nombreArtistico;
	}

	public void setNombreArtistico(String nombreArtistico) {
		this.nombreArtistico = nombreArtistico;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
