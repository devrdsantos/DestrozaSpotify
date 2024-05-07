package model;

import javax.swing.ImageIcon;

public class Podcast extends Audio {

	private int IDPodcast;
	private String descripcion;
	private boolean reproduciendo;

	public Podcast() {

	}

	public Podcast(int iDAudio, String nombre, int duracion, ImageIcon imagen, String tipo, boolean reproduciendo,
			int iDPodcast, String descripcion, boolean reproduciendo2) {
		super(iDAudio, nombre, duracion, imagen, tipo, reproduciendo);
		IDPodcast = iDPodcast;
		this.descripcion = descripcion;
		reproduciendo = reproduciendo2;
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
