package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Cliente {

	private String usuario;
	private String contraseña;
	private String nombre;
	private String rol;
	private String apellido;
	private String fechaRegistro;
	private boolean isPremium = false;
	private String idioma;
	private String fechaNacimiento;
	private String fechaPremiumAlta;
	private String fechaPreiumBaja;
	private ArrayList<Playlist> favoritos;

	public Cliente() {

	}

	public Cliente(String usuario, String contraseña, String nombre, String rol, String apellido, String fechaRegistro,
			boolean isPremium, String idioma, String fechaNacimiento, ArrayList<Playlist> favoritos) {
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.rol = rol;
		this.apellido = apellido;
		this.fechaRegistro = fechaRegistro;
		this.isPremium = isPremium;
		this.idioma = idioma;
		this.fechaNacimiento = fechaNacimiento;
		this.favoritos = favoritos;

		if (!isPremium) {
			LocalDate fechaSinFormatoAlta = LocalDate.now();
			DateTimeFormatter formatoAlta = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String fechaAlta = formatoAlta.format(fechaSinFormatoAlta);
			this.fechaPremiumAlta = fechaAlta;

			LocalDate fechaSinFormatoBaja = LocalDate.now();
			DateTimeFormatter formatoBaja = DateTimeFormatter.ofPattern("2025-MM-yyyy");
			String fechaBaja = formatoBaja.format(fechaSinFormatoBaja);
			this.fechaPreiumBaja = fechaBaja;

		}

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

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
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

	public boolean isPremium() {
		return isPremium;
	}

	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
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

	public String getFechaPremiumAlta() {
		return fechaPremiumAlta;
	}

	public void setFechaPremiumAlta(String fechaPremiumAlta) {
		this.fechaPremiumAlta = fechaPremiumAlta;
	}

	public String getFechaPreiumBaja() {
		return fechaPreiumBaja;
	}

	public void setFechaPreiumBaja(String fechaPreiumBaja) {
		this.fechaPreiumBaja = fechaPreiumBaja;
	}

	public ArrayList<Playlist> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(ArrayList<Playlist> favoritos) {
		this.favoritos = favoritos;
	}

}
