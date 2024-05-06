package model;

import java.util.ArrayList;
import java.util.Date;

public class Playlist {

	private int IDPlaylist;
	private String nombre;
	private ArrayList<Cancion> canciones;
	private Date fechaCreacion;

	public Playlist() {

	}

	public Playlist(int IDPlaylist, String nombre, ArrayList<Cancion> canciones, Date fechaCreacion) {
		this.IDPlaylist = IDPlaylist;
		this.nombre = nombre;
		this.canciones = canciones;
		this.fechaCreacion = fechaCreacion;
	}
	
	public int getIDPlaylist() {
		return IDPlaylist;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(ArrayList<Cancion> canciones) {
		this.canciones = canciones;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
