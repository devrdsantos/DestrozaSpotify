package model;

import javax.swing.ImageIcon;

public abstract class Audio {

	private int IDAudio;
	private String nombre;
	private int duracion;
	private ImageIcon imagen;
	private String tipo;
	private boolean reproduciendo;
	
	public Audio() {

	}

	public Audio(int iDAudio, String nombre, int duracion, ImageIcon imagen, String tipo) {
		IDAudio = iDAudio;
		this.nombre = nombre;
		this.duracion = duracion;
		this.imagen = imagen;
		this.tipo = tipo;
		this.reproduciendo = false;
	}



	public int getIDAudio() {
		return IDAudio;
	}

	public void setIDAudio(int iDAudio) {
		IDAudio = iDAudio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean sonando() {
		if (!reproduciendo) {
			return true;
		} else {
			return false;
		}
	}
	
}
