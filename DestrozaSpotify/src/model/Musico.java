package model;

import javax.swing.ImageIcon;

public class Musico {

	private int idMusico;
	private String nombreArtistico;
	private ImageIcon imagen;
	private String caracteristicas;
	private String descripcion;

	public Musico() {

	}

	public Musico(int idMusico, String nombreArtistico, ImageIcon imagen, String caracteristicas, String descripcion) {
		this.idMusico = idMusico;
		this.nombreArtistico = nombreArtistico;
		this.imagen = imagen;
		this.caracteristicas = caracteristicas;
	}

	public String getNombre() {
		return nombreArtistico;
	}

	public void setNombre(String nombre) {
		this.nombreArtistico = nombre;
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

	public int getIdMusico() {
		return idMusico;
	}

	public void setIdMusico(int idMusico) {
		this.idMusico = idMusico;
	}

	public String getNombreArtistico() {
		return nombreArtistico;
	}

	public void setNombreArtistico(String nombreArtistico) {
		this.nombreArtistico = nombreArtistico;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

}
