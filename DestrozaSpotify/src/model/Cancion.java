package model;

import javax.swing.ImageIcon;

public class Cancion extends Audio {

	private int idAlbum;
	private String artistasInvitados;
	private boolean reproduciendo;

	public Cancion() {

	}

	public Cancion(int iDAudio, String nombre, int duracion, ImageIcon imagen, String tipo, int idAlbum,
			String artistasInvitados) {
		super(iDAudio, nombre, duracion, imagen, tipo);
		this.idAlbum = idAlbum;
		this.artistasInvitados = artistasInvitados;
		this.reproduciendo = false;
	}


	public int getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}

	public String getArtistasInvitados() {
		return artistasInvitados;
	}

	public void setArtistasInvitados(String artistasInvitados) {
		this.artistasInvitados = artistasInvitados;
	}

	public boolean sonando() {
		if (!reproduciendo) {
			return true;
		} else {
			return false;
		}
	}

}