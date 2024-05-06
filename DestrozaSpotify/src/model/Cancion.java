package model;

import javax.swing.ImageIcon;

public class Cancion extends Audio {

	private String colaboradores;
	private boolean reproduciendo;

	public Cancion() {

	}

	public Cancion(int iDAudio, String nombre, int duracion, ImageIcon imagen, String tipo, boolean reproduciendo,
			String colaboradores, boolean reproduciendo2) {
		super(iDAudio, nombre, duracion, imagen, tipo, reproduciendo);
		this.colaboradores = colaboradores;
		reproduciendo = reproduciendo2;
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
