package model;

import javax.swing.ImageIcon;

public class Episodio extends Audio {

	private int idAlbum;
	private String colaboradores;
	private boolean reproduciendo;

	public Episodio() {

	}

	public Episodio(int iDAudio, String nombre, int duracion, ImageIcon imagen, String tipo, int idAlbum,
			String colaboradores) {
		super(iDAudio, nombre, duracion, imagen, tipo);
		this.idAlbum = idAlbum;
		this.colaboradores = colaboradores;
	}

	public String getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(String colaboradores) {
		this.colaboradores = colaboradores;
	}

	public int getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}

	public boolean sonando() {
		if (!reproduciendo) {
			return true;
		} else {
			return false;
		}
	}

}