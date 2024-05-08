package model;

import javax.swing.ImageIcon;

public class Podcast {

	private int IDPodcast;
	private String titulo;
	private boolean reproduciendo;
	private ImageIcon imagen;
	private int IDPodcaster;
	
	
	public Podcast() {

	}
	
	


	public Podcast(int iDPodcast, String titulo, boolean reproduciendo, ImageIcon imagen, int iDPodcaster) {
		super();
		IDPodcast = iDPodcast;
		this.titulo = titulo;
		this.reproduciendo = reproduciendo;
		this.imagen = imagen;
		IDPodcaster = iDPodcaster;
	}




	public int getIDPodcast() {
		return IDPodcast;
	}


	public void setIDPodcast(int iDPodcast) {
		IDPodcast = iDPodcast;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public boolean isReproduciendo() {
		return reproduciendo;
	}


	public void setReproduciendo(boolean reproduciendo) {
		this.reproduciendo = reproduciendo;
	}


	public ImageIcon getImagen() {
		return imagen;
	}


	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}


	public int getIDPodcaster() {
		return IDPodcaster;
	}


	public void setIDPodcaster(int iDPodcaster) {
		IDPodcaster = iDPodcaster;
	}

	

}
