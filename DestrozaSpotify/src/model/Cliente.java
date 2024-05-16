package model;

import java.util.ArrayList;

public class Cliente {

	private int IDCliente;
	private String usuario;
	private String contraseña;
	private String nombre;
	private String apellido;
	private String fechaRegistro;
	private String tipo;
	private String idioma;
	private String fechaNacimiento;
	private String fechaPreiumBaja;
	private ArrayList<Cancion> favoritos;

	public Cliente() {

	}

	public Cliente(int iDCliente, String usuario, String contraseña, String nombre, String apellido,
			String fechaRegistro, String tipo, String idioma, String fechaNacimiento,
			String fechaPreiumBaja) {
		this.IDCliente = iDCliente;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaRegistro = fechaRegistro;
		this.tipo = tipo;
		this.idioma = idioma;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaPreiumBaja = fechaPreiumBaja;
		favoritos = new ArrayList<Cancion>();
	}

	public int getIDCliente() {
		return IDCliente;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setIDCliente(int iDCliente) {
		IDCliente = iDCliente;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaPreiumBaja() {
		return fechaPreiumBaja;
	}

	public void setFechaPreiumBaja(String fechaPreiumBaja) {
		this.fechaPreiumBaja = fechaPreiumBaja;
	}

	public ArrayList<Cancion> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(ArrayList<Cancion> favoritos) {
		this.favoritos = favoritos;
	}

}
