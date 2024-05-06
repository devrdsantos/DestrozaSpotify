package model;

import javax.swing.ImageIcon;

public class Musico extends Artista {

	private int IDMusico;
	private String caracteristicas;

	public Musico() {
		
	}
	
	public Musico(int IDMusico, String nombre, ImageIcon imagen, String descripcion, String caracteristicas) {
		super(nombre, imagen, descripcion);
		this.IDMusico = IDMusico;
		this.caracteristicas = caracteristicas;
	}

	public int getIDMusico() {
		return IDMusico;
	}
	
	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

}
