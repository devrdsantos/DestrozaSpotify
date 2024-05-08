package model;

import javax.swing.ImageIcon;

public class Episodio extends Audio {

	private String colaboradores;
	private boolean reproduciendo;
	
	public Episodio() {
		
	}
	
	public Episodio(String nombre, int duracion, ImageIcon imagen, String colaboradores) {
		super(duracion, nombre, duracion, imagen, colaboradores);
		this.colaboradores = colaboradores;
	}

	public String getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(String colaboradores) {
		this.colaboradores = colaboradores;
	}
	
	public boolean sonando() {
		if (!reproduciendo) {
			return true;
		} else {
			return false;
		}
	}

}