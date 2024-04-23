package model;

import javax.swing.ImageIcon;

public class Podcaster extends Artista {

	private String genero;

	public Podcaster(String nombre, ImageIcon imagen, String descripcion, String genero) {
		super(nombre, imagen, descripcion);
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
