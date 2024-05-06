package model;

import javax.swing.ImageIcon;

public class Podcaster extends Artista {

	private int IDPodcaster;
	private String genero;

	public Podcaster() {
		
	}
	
	public Podcaster(int IDPodcaster, String nombre, ImageIcon imagen, String descripcion, String genero) {
		super(nombre, imagen, descripcion);
		this.IDPodcaster = IDPodcaster;
		this.genero = genero;
	}
	
	public int getIDPodcaster() {
		return IDPodcaster;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
