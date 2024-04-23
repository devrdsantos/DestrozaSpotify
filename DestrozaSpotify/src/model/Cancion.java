package model;

import javax.swing.ImageIcon;

public class Cancion extends Audio {

	private String colaboradores;

	public Cancion() {
		
	}
	
	public Cancion(String nombre, int duracion, ImageIcon imagen, String colaboradores) {
		super(nombre, duracion, imagen);
		this.colaboradores = colaboradores;
	}

	public String getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(String colaboradores) {
		this.colaboradores = colaboradores;
	}

}
