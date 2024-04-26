package controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.Album;
import model.Artista;
import model.Cancion;
import model.Musico;
import view.VistaPrincipal;

public class GestionBD {

	private Connection conexion;
	private GestionDeLaInformacion gestionINF;
//	private ControladorDeEntrada controlador;

	public GestionBD() {
		iniciarConexion();
	}

	public void iniciarConexion() {
		System.out.println("Conectando...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/reto4", "root", "");
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
			String query = "SELECT Usuario, Contraseña, Rol FROM cliente WHERE Usuario = ?";

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
				if (resultadoConsulta.getString(3).equals("Cliente")) {
					JOptionPane.showMessageDialog(null, "\nSe ha iniciado sesión");
//					v.cambiarDePanel(3);
					verificarLogin = true;
				} else {
					JOptionPane.showMessageDialog(null, "\nSe ha iniciado sesión con administrador");
					v.cambiarDePanel(4);
					verificarLogin = true;
				}

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
			String query = "SELECT Contraseña FROM cliente WHERE Usuario = ?";
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

	public void insertUsuario(ArrayList<String> datosUsuario, VistaPrincipal v) {
		gestionINF = new GestionDeLaInformacion();
		String fechaAlta, fechaBaja;
		try {
			Statement consulta = conexion.createStatement();
			// Toma la contraseña y la encripta a través del método
			String passEncriptada = gestionINF.encriptar(datosUsuario.get(1));

			// QUERY que inserta datos a la tabla
			// 0 -> Usuario
			// 2 -> Nombre
			// 3 -> Apellido
			// 4 -> FechaNacimiento
			// 5 -> FechaRegistro
			// 6 -> Rol
			// 7 -> Premium
			// 8 -> Idioma

			if (datosUsuario.get(7) == "1") {
				LocalDate fechaSinFormatoAlta = LocalDate.now();
				DateTimeFormatter formatoAlta = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				fechaAlta = formatoAlta.format(fechaSinFormatoAlta);

				LocalDate fechaSinFormatoBaja = LocalDate.now();
				DateTimeFormatter formatoBaja = DateTimeFormatter.ofPattern("2025-MM-dd");
				fechaBaja = formatoBaja.format(fechaSinFormatoBaja);
				JOptionPane.showMessageDialog(null, "La fecha de caducidad del Premiun termina el " + fechaBaja);
			} else {
				fechaAlta = "";
				fechaBaja = "";
			}

//			System.out.println(datosUsuario);

			// TO DO --> cambiarlo
			String insert = "INSERT INTO cliente VALUES ('" + datosUsuario.get(0) + "','" + passEncriptada + "','"
					+ datosUsuario.get(2) + "','" + datosUsuario.get(6) + "', '" + datosUsuario.get(3) + "', '"
					+ datosUsuario.get(5) + "', '" + datosUsuario.get(7) + "', '" + datosUsuario.get(8) + "', '"
					+ datosUsuario.get(4) + "', '" + fechaAlta + "', '" + fechaBaja + "')";

			// Ejecución del INSERT
			consulta.executeUpdate(insert);
			JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
			// Cambia al Panel para iniciar sesión

			v.cambiarDePanel(1);
			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
			v.cambiarDePanel(2);
		}

	}

	public void insertArtista(String nombre, String imagenArt, String descripcion) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO artista VALUES (?,?,?)");
			consulta.setString(1, nombre);
			InputStream imagen = new FileInputStream("imagenes/imagenArt/" + imagenArt + ".jpg");
			consulta.setBlob(2, imagen);
			consulta.setString(3, descripcion);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "Artista creado correctamente");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}

	}

	public void insertMusico(String caracteristicas, String nombre) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO musico VALUES (?,?)");
			consulta.setString(1, caracteristicas);
			consulta.setString(2, nombre);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "Musico creado correctamente");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}

	}

	public ArrayList<Musico> sacarArtistasInformacion() {
		ImageIcon imagen = new ImageIcon();
		ArrayList<Musico> artistas = new ArrayList<Musico>();

		try {
			PreparedStatement consulta = conexion
					.prepareStatement("SELECT * FROM Artista Ar join musico Mu on Ar.Nombre = Mu.Artista;");

			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
				Blob imagenBlob = resultadoConsulta.getBlob(2);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				artistas.add(new Musico(resultadoConsulta.getString(1), imagen, resultadoConsulta.getString(3),
						resultadoConsulta.getString(4)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return artistas;
	}

	public void insertAlbum(String nombre, String fechaPub, String genero, String imagenAlb, String nombreArt) {
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"INSERT INTO album VALUES (?,?,?,?,?,?)");
			consulta.setString(1, null);
			consulta.setString(2, nombre);
			consulta.setString(3, fechaPub);
			consulta.setString(4, genero);
			InputStream imagen = new FileInputStream("imagenes/portadasAlb/" + imagenAlb + ".jpg");
			consulta.setBlob(5, imagen);
			consulta.setString(6, nombreArt);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "Album creado correctamente");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}

	}
	
	public ArrayList<Album> sacarAlbumInformacion() {
		ImageIcon imagen = new ImageIcon();
		ArrayList<Album> albums = new ArrayList<Album>();
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("SELECT * FROM album;");

			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
				Blob imagenBlob = resultadoConsulta.getBlob(5);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				albums.add(new Album(resultadoConsulta.getInt(1), resultadoConsulta.getString(2), resultadoConsulta.getString(3) ,resultadoConsulta.getString(4), imagen, resultadoConsulta.getString(6)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return albums;
	}
	
	public void insertCancion(String colaboradores, String nombreCancion, String album) {
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"INSERT INTO cancion VALUES (?,?,?)");
			consulta.setString(1, colaboradores);
			consulta.setString(2, nombreCancion);
			consulta.setString(3, album);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cancion creado correctamente");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}

	}

	public void insertAudio(String nombre, int duracion, String imagenMu) {
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"INSERT INTO audio VALUES (?,?,?)");
			consulta.setString(1, nombre);
			consulta.setInt(2, duracion);
			InputStream imagen = new FileInputStream("imagenes/portadasMu/" + imagenMu + ".jpg");
			consulta.setBlob(3, imagen);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "Audio creado correctamente");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}

	}
	
}
