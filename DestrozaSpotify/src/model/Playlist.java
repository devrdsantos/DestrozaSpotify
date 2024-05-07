package model;

import java.util.ArrayList;
import java.util.Date;

public class Playlist {

	private int idPlaylist;
	private String nombre;
	private ArrayList<Cancion> canciones;
	private String fechaCreacion;
	private int idCliente;

	public Playlist() {

	}

	public Playlist(int idPlaylist, String nombre, String fechaCreacion, int idCliente ) {
		this.idPlaylist = idPlaylist;
		this.nombre = nombre;
		canciones = new ArrayList<Cancion>();
		this.fechaCreacion = fechaCreacion;
		this.idCliente = idCliente;
	}

	public int getIdPlaylist() {
		return idPlaylist;
	}

	public void setIdPlaylist(int idPlaylist) {
		this.idPlaylist = idPlaylist;
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

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	

}
