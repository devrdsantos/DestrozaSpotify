package model;

import javax.swing.ImageIcon;

public class Podcast {


	private int idPodcast;
	private String titulo;
	private ImageIcon imagen;
	private int idPodcaster;


	public Podcast() {

	}
	



	public Podcast(int idPodcast, String titulo, ImageIcon imagen, int idPodcaster) {
		this.idPodcast = idPodcast;
		this.titulo = titulo;
		this.imagen = imagen;
		this.idPodcaster = idPodcaster;

	}




	public int getIdPodcast() {
		return idPodcast;
	}




	public void setIdPodcast(int idPodcast) {
		this.idPodcast = idPodcast;
	}




	public String getTitulo() {
		return titulo;
	}




	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}




	public ImageIcon getImagen() {
		return imagen;
	}




	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}




	public int getIdPodcaster() {
		return idPodcaster;
	}




	public void setIdPodcaster(int idPodcaster) {
		this.idPodcaster = idPodcaster;
	}


	

	

}
