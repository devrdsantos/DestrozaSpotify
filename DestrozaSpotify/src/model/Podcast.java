package model;

import javax.swing.ImageIcon;

public class Podcast extends Audio {

	private String descripcion;
	private boolean reproduciendo;
	
	public Podcast() {

	}

	public Podcast(String nombre, int duracion, ImageIcon imagen, String descripcion) {
		super(nombre, duracion, imagen);
		this.descripcion = descripcion;
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
