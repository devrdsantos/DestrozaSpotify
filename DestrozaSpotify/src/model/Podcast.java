package model;

import javax.swing.ImageIcon;

public class Podcast extends Audio {

	private int IDPodcast;
	private String descripcion;
	private boolean reproduciendo;
	
	public Podcast() {

	}

	public Podcast(int IDPodcast, String nombre, int duracion, ImageIcon imagen, String descripcion) {
		super(nombre, duracion, imagen);
		this.IDPodcast = IDPodcast;
		this.descripcion = descripcion;
	}
	
	public int getIDPodcast() {
		return IDPodcast;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public boolean sonando() {
		if (!reproduciendo) {
			return true;
		} else {
			return false;
		}
	}

}
