package model;

import javax.swing.ImageIcon;

public class Musico extends Artista {

	private String caracteristicas;

	public Musico() {
		
	}
	
	public Musico(String nombre, ImageIcon imagen, String descripcion, String caracteristicas) {
		super(nombre, imagen, descripcion);
		this.caracteristicas = caracteristicas;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

}
