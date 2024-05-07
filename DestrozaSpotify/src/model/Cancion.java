package model;

import javax.swing.ImageIcon;

public class Cancion extends Audio {

	private String artistasInvitados;
	private boolean reproduciendo;

	public Cancion() {

	}

	public Cancion(int iDAudio, String nombre, int duracion, ImageIcon imagen, String tipo, boolean reproduciendo,
			String artistasInvitados, boolean reproduciendo2) {
		super(iDAudio, nombre, duracion, imagen, tipo, reproduciendo);
		this.artistasInvitados = artistasInvitados;
		reproduciendo = reproduciendo2;
	}

	public String getColaboradores() {
		return artistasInvitados;
	}

	public void setColaboradores(String colaboradores) {
		this.artistasInvitados = colaboradores;
	}

	public boolean sonando() {
		if (!reproduciendo) {
			return true;
		} else {
			return false;
		}
	}

}
