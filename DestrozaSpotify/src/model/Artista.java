package model;

import javax.swing.ImageIcon;

public abstract class Artista {

	private String nombre;
	private ImageIcon imagen;
	private String descripcion;

	public Artista() {

	}

	public Artista(String nombre, ImageIcon imagen, String descripcion) {
		this.nombre = nombre;
		this.imagen = imagen;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
