package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import view.VistaPrincipal;

public class GestionBD {

	private Connection conexion;
	private GestionDeLaInformacion gestionINF;

	public GestionBD() {
		iniciarConexion();
	}

	public void iniciarConexion() {
		System.out.println("Conectando...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/spotify", "root", "");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado la librería");
		} catch (SQLException e) {
			System.out.println("Base de Datos no encontrada");
		}
		System.out.println("Conexion establecida");
	}

	public void cerrarConexion() {
		System.out.println("Cerrando...");
		try {
			if (!conexion.isClosed()) {
				conexion.close();
			}
		} catch (SQLException e) {
			System.out.println("No hay conexion con la Base de Datos");
		}
		System.out.println("Conexion cerrada");
	}
	
	public boolean verificarLogin(String usuario, String pass, VistaPrincipal v) throws Exception {

		boolean verificarLogin = false;

		try {
			// System.out.println("Iniciando consulta...");
			// QUERY para verificar el LOGIN, el ? representa el DNI que deberá pasarse por
			// parámetros
			String query = "SELECT Usuario, contraseña FROM usuario WHERE Usuario = ?";

			// Prepara la consulta para mandarla a la BD, en este caso está verificando el
			// DNI
			PreparedStatement consultaPreparada = conexion.prepareStatement(query);
			consultaPreparada.setString(1, usuario);

			// Variable que ejecuta la QUERY
			ResultSet resultadoConsulta = consultaPreparada.executeQuery();

			// Variable que ejecuta sacarPasswordEncriptada pasándole como parámetro el DNI
			// ingresado
			String passDesencriptada = sacarPasswordEncriptada(usuario);

			// Si el DNI y la contraseña desencriptada se corresponden con los datos de la
			// BD se iniciará sesión y se cambiará al siguiente panel (PanelSeleccionCine)
			if (resultadoConsulta.next() && usuario.equals(resultadoConsulta.getString(1))
					&& pass.equals(passDesencriptada)) {
				JOptionPane.showMessageDialog(null, "\nSe ha iniciado sesión");
				v.cambiarDePanel(3);
				verificarLogin = true;

			} else {
				JOptionPane.showMessageDialog(null, "Los valores ingresados no son correctos");

			}
			// Una vez que ejecuta la consulta la cierra.
			// System.out.println("Cerrando consulta...");
			consultaPreparada.close();
		} catch (SQLException e) {
			// System.out.println("Conexion incorrecta con la base de datos");
		}
		return verificarLogin;
	}
	
	public String sacarPasswordEncriptada(String usuario) throws Exception {
		gestionINF = new GestionDeLaInformacion();
		String passDesencriptada = "";
		try {
			// System.out.println("Iniciando consulta sacarPasswordEncriptada...");
			String query = "SELECT contraseña FROM usuario WHERE Usuario = ?";
			PreparedStatement consultaPreparada = conexion.prepareStatement(query);
			consultaPreparada.setString(1, usuario);
			ResultSet resultadoConsulta = consultaPreparada.executeQuery();
			if (resultadoConsulta.next()) {
				passDesencriptada = gestionINF.desencriptar(resultadoConsulta.getString(1));
			}
//			System.out.println("Cerrando consulta...");
			consultaPreparada.close();
		} catch (SQLException e) {
			// System.out.println("Conexion incorrecta con la Base de Datos");
		}
		return passDesencriptada;
	}
	
}
