package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import model.Cliente;
import view.VistaPrincipal;

public class ControladorDeEntrada {

	private ArrayList<String> datosUsuario;
	private ArrayList<Cliente> usuario;
	private GestionBD gestionBD;
	
	public ControladorDeEntrada() {
		datosUsuario = new ArrayList<String>();
		gestionBD = new GestionBD();
		usuario = new ArrayList<Cliente>();
	}
	
	public void validarInformacionFormulario(String usuarioFormulario, String passFormulario, String nombreFormulario,
			String apellidoFormulario, String idioma ,String fechaNacFormulario, VistaPrincipal v) {

		String usuarioDB, passDB, nombreDB, apellidoDB;
		
		String textoUsuario = usuarioFormulario;
		Pattern patron = Pattern.compile("^[a-z]+$", Pattern.CASE_INSENSITIVE);
		Matcher usuario = patron.matcher(textoUsuario);

		if (!usuario.find()) {
			JOptionPane.showMessageDialog(null, "DNI no valido");
		} else {
//			usuarioDB = usuario.group();
			datosUsuario.add(usuario.group());
		}

		String textoPass = passFormulario;
		Pattern patron1 = Pattern.compile("^[\\S]{6,14}+$", Pattern.CASE_INSENSITIVE);
		Matcher pass = patron1.matcher(textoPass);

		if (!pass.find()) {
			JOptionPane.showMessageDialog(null, "Contraseña no valida");
		} else {
//			passDB = pass.group();
			datosUsuario.add(pass.group());
		}

		String textoNombre = nombreFormulario;
		Pattern patron2 = Pattern.compile("^[a-z]+$", Pattern.CASE_INSENSITIVE);
		Matcher nombre = patron2.matcher(textoNombre);

		if (!nombre.find()) {
			JOptionPane.showMessageDialog(null, "Nombre no valido");
		} else {
//			nombreDB = nombre.group();
			datosUsuario.add(nombre.group());
		}

		String textoApellido = apellidoFormulario;
		Pattern patron3 = Pattern.compile("^[a-z]+$", Pattern.CASE_INSENSITIVE);
		Matcher apellido = patron3.matcher(textoApellido);

		if (!apellido.find()) {
			JOptionPane.showMessageDialog(null, "Apellido no valido");
		} else {
//			apellidoDB = apellido.group();
			datosUsuario.add(apellido.group());
		}
		
		
		
		datosUsuario.add(fechaNacFormulario);
		
		LocalDate fechaSinFormato = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String fechaRegistro = formato.format(fechaSinFormato);
		
		datosUsuario.add(fechaRegistro);
		
		String rol = "Cliente";
		datosUsuario.add(rol);
	
		datosUsuario.add("0");
		
		datosUsuario.add(idioma);
		
//		usuario.add(new Cliente(usuarioDB, passDB, nombreDB, rol, apellidoDB, fechaRegistro, false, idioma, fechaNacFormulario, null));
		
		gestionBD.insertUsuario(datosUsuario, v);
	}

	
}
