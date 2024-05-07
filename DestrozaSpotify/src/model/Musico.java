package model;

import javax.swing.ImageIcon;

public class Musico {
	
	private int IDMusico;
	private String nombreArtistico;
	private ImageIcon imagen;
	private String descripcion;
	private String caracteristica;

	public Musico() {
		
	}
	
	public Musico(String nombreArtistico, ImageIcon imagen, String descripcion, int iDMusico, String caracteristica) {
		super();
		this.nombreArtistico = nombreArtistico;
		this.imagen = imagen;
		this.descripcion = descripcion;
		IDMusico = iDMusico;
		this.caracteristica = caracteristica;
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

	public int getIDMusico() {
		return IDMusico;
	}

	public void setIDMusico(int iDMusico) {
		IDMusico = iDMusico;
	}

	public String getCaracteristicas() {
		return caracteristica;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristica = caracteristicas;
	}
	




}
