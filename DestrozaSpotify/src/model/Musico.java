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
		super();
		this.idMusico = idMusico;
		this.nombreArtistico = nombreArtistico;
		this.imagen = imagen;
		this.caracteristicas = caracteristicas;
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

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Musico [idMusico=" + idMusico + ", nombreArtistico=" + nombreArtistico + ", imagen=" + imagen
				+ ", caracteristicas=" + caracteristicas + ", descripcion=" + descripcion + "]";
	}

}