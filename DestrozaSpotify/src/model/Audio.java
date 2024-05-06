package model;

import javax.swing.ImageIcon;

public abstract class Audio {

	private int IDAudio;
	private String nombre;
	private int duracion;
	private ImageIcon imagen;
	private boolean reproduciendo;
	
	public Audio() {

	}

	public Audio(String nombre, int duracion, ImageIcon imagen) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.imagen = imagen;
	}
	
	public int getIDAudio() {
		return IDAudio;
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

	public boolean sonando() {
		if (!reproduciendo) {
			return true;
		} else {
			return false;
		}
	}
	
}
