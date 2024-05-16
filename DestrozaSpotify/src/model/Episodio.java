package model;

import javax.swing.ImageIcon;

public class Episodio extends Audio {

	private int idPodcast;
	private String colaboradores;
	private boolean reproduciendo;

	public Episodio() {

	}

	public Episodio(int iDAudio, String nombre, int duracion, ImageIcon imagen, String tipo, int idPodcast,
			String colaboradores) {
		super(iDAudio, nombre, duracion, imagen, tipo);
		this.idPodcast = idPodcast;
		this.colaboradores = colaboradores;
	}

	public String getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(String colaboradores) {
		this.colaboradores = colaboradores;
	}

	public int getIdAlbum() {
		return idPodcast;
	}

	public void setIdAlbum(int idAlbum) {
		this.idPodcast = idAlbum;
	}

	public boolean sonando() {
		if (!reproduciendo) {
			return true;
		} else {
			return false;
		}
	}

}