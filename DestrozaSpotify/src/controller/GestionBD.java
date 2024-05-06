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
import model.Cancion;
import model.Musico;
import model.Podcaster;
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
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/reto4p", "root", "");
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

	/* HECHO!! */
	public boolean verificarLogin(String usuario, String pass, VistaPrincipal v) throws Exception {

		boolean verificarLogin = false;

		try {
			// System.out.println("Iniciando consulta...");
			// QUERY para verificar el LOGIN, el ? representa el DNI que deberá pasarse por
			// parámetros
			String query = "SELECT Usuario, Contraseña, Tipo FROM cliente WHERE Usuario = ?";

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
					v.cambiarDePanel(3);
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
	
	/* HECHO!! */
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
//			Statement consulta = conexion.createStatement();
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

//			System.out.println(datosUsuario);

			// TO DO --> cambiarlo
//			String insert = "INSERT INTO cliente VALUES ('"+ null + "','" + datosUsuario.get(2) + "','" + datosUsuario.get(3) + "','"
//					+ datosUsuario.get(0) + "','" + passEncriptada + "', '" + datosUsuario.get(4) + "', '"
//					+ datosUsuario.get(5) + "', '" + datosUsuario.get(7) + "', '" + datosUsuario.get(8) + "')";

			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO cliente VALUES (?,?,?,?,?,?,?,?,?)");
			consulta.setString(1, null);
			consulta.setString(2, datosUsuario.get(2));
			consulta.setString(3, datosUsuario.get(3));
			consulta.setString(4, datosUsuario.get(0));
			consulta.setString(5, passEncriptada);
			consulta.setString(6, datosUsuario.get(4));
			consulta.setString(7, datosUsuario.get(5));
			consulta.setString(8, datosUsuario.get(7));
			consulta.setString(9, datosUsuario.get(8));
			consulta.executeUpdate();
			
			// Ejecución del INSERT
//			consulta.executeUpdate(insert);
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

	/**
	 * [MÉTODO] sacarGeneros() trabaja con un ArrayList de objetos de tipo Album - -
	 * -
	 * 
	 * @return generos
	 */
	// - - - - - - - - - - - - - -
	public ArrayList<String> sacarGeneros() {
		// Crea el ArrayList
		ArrayList<String> generos = new ArrayList<String>();
		try {
			// System.out.println("Iniciando consulta..");
			// QUERY que selecciona todo de la tabla CINE
			String query = "SELECT DISTINCT Genero FROM album;";
			// Prepara la consulta para mandarla a la BD
			PreparedStatement consultaPreparada = conexion.prepareStatement(query);
			// Ejecuta la consulta
			ResultSet resultadoConsulta = consultaPreparada.executeQuery();

			// Agrega los generos que tiene la tabla album al ArrayList generos donde
			while (resultadoConsulta.next()) {
				generos.add((resultadoConsulta.getString(1)));
			}
			// System.out.println("Cerrando Consulta a la tabla album..");
			consultaPreparada.close();
		} catch (SQLException e) {
			// System.out.println("Conexion incorrecta con la tabla Album");
			e.printStackTrace();
		}
		// Devuelve los generos
		return generos;
	}
	
	public ArrayList<String> sacarPodcasters() {
		// Crea el ArrayList
		ArrayList<String> podcasters = new ArrayList<String>();
		try {
			// System.out.println("Iniciando consulta..");
			// QUERY que selecciona todo de la tabla CINE
			String query = "SELECT DISTINCT Podcaster FROM podcaster;";
			// Prepara la consulta para mandarla a la BD
			PreparedStatement consultaPreparada = conexion.prepareStatement(query);
			// Ejecuta la consulta
			ResultSet resultadoConsulta = consultaPreparada.executeQuery();

			// Agrega los generos que tiene la tabla album al ArrayList generos donde
			while (resultadoConsulta.next()) {
				podcasters.add((resultadoConsulta.getString(1)));
			}
			// System.out.println("Cerrando Consulta a la tabla album..");
			consultaPreparada.close();
		} catch (SQLException e) {
			// System.out.println("Conexion incorrecta con la tabla Album");
			e.printStackTrace();
		}
		// Devuelve los generos
		return podcasters;
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

	public ArrayList<Musico> sacarMusicoInformacion() {
		ImageIcon imagen = new ImageIcon();
		ArrayList<Musico> artistas = new ArrayList<Musico>();

		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT Ar.Nombre, Ar.Imagen, Ar.descripcion, Mu.Caracteristicas FROM Artista Ar join musico Mu on Ar.Nombre = Mu.Artista;");

			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
				Blob imagenBlob = resultadoConsulta.getBlob(2);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
//				artistas.add(new Musico(resultadoConsulta.getString(1), imagen, resultadoConsulta.getString(3),
//						resultadoConsulta.getString(4)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return artistas;
	}

	public void insertAlbum(String nombre, String fechaPub, String genero, String imagenAlb, String nombreArt) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO album VALUES (?,?,?,?,?,?)");
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
			PreparedStatement consulta = conexion.prepareStatement("SELECT DISTINCT * FROM album;");

			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
				Blob imagenBlob = resultadoConsulta.getBlob(5);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				albums.add(new Album(resultadoConsulta.getInt(1), resultadoConsulta.getString(2),
						resultadoConsulta.getString(3), resultadoConsulta.getString(4), imagen,
						resultadoConsulta.getString(6), resultadoConsulta.getInt(7)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return albums;
	}

	public void insertCancion(String colaboradores, String nombreCancion, String album) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO cancion VALUES (?,?,?)");
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

	public void insertAudioMu(String nombre, int duracion, String imagenMu) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO audio VALUES (?,?,?)");
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

	public void insertAudioPodc(String nombre, int duracion, String imagenPodc) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO audio VALUES (?,?,?)");
			consulta.setString(1, nombre);
			consulta.setInt(2, duracion);
			InputStream imagen = new FileInputStream("imagenes/portadasPodcast/" + imagenPodc + ".jpg");
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

	public void deleteCancion(String nombre) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("DELETE FROM `cancion` WHERE `NombreCancion` = ? ");
			consulta.setString(1, nombre);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "La cancion " + nombre + " eliminada correctamente");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}

	}

	public void deleteAudio(String nombre) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("DELETE FROM `audio` WHERE `Nombre` = ? ");
			consulta.setString(1, nombre);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "El audio " + nombre + " eliminado correctamente");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}

	}

	public void deleteAlbum(String nombre) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("DELETE FROM `album` WHERE `Nombre` = ? ");
			consulta.setString(1, nombre);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "El album " + nombre + " eliminada correctamente");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}
	}

	public void deleteArtista(String nombre) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("DELETE FROM `artista` WHERE `Nombre` = ? ");
			consulta.setString(1, nombre);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "El artista " + nombre + " eliminado correctamente");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//				JOptionPane.showMessageDialog(null, "Campos inválidos");
		}

	}

	public void deleteMusico(String nombre) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("DELETE FROM `musico` WHERE `Nombre` = ? ");
			consulta.setString(1, nombre);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "El musico " + nombre + " eliminado correctamente");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//				JOptionPane.showMessageDialog(null, "Campos inválidos");
		}

	}

	public void insertPodcaster(String nombrePodcaster, String genero) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO podcaster VALUES (?,?)");
			consulta.setString(1, genero);
			consulta.setString(2, nombrePodcaster);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "Podcaster creado correctamente");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}

	}

	public ArrayList<Podcaster> sacarPodcasterInformacion() {
		ImageIcon imagen = new ImageIcon();
		ArrayList<Podcaster> podcasters = new ArrayList<Podcaster>();
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("SELECT Po.Genero, Ar.Nombre, Ar.Imagen, Ar.descripcion FROM podcaster Po "
							+ "join artista Ar on Po.Podcaster = Ar.Nombre;");

			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {

				Blob imagenBlob = resultadoConsulta.getBlob(3);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
//				podcasters.add(new Podcaster(resultadoConsulta.getString(2), imagen, resultadoConsulta.getString(4),
//						resultadoConsulta.getString(2)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return podcasters;
	}
	
	
	public void insertPodcast(String descripcion, String nombrePodcast, String podcaster) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO podcast VALUES (?,?,?)");
			consulta.setString(1, descripcion);
			consulta.setString(2, nombrePodcast);
			consulta.setString(3, podcaster);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "Podcast creado correctamente");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}

	}

	public void deletePodcast(String podcast) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("DELETE FROM `podcast` WHERE `NombrePodcast` = ? ");
			consulta.setString(1, podcast);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "El podcast " + podcast + " eliminado correctamente");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//				JOptionPane.showMessageDialog(null, "Campos inválidos");
		}
	}

	public void deletePodcaster(String podcaster) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("DELETE FROM `podcaster` WHERE `Podcaster` = ? ");
			consulta.setString(1, podcaster);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "El podcaster " + podcaster + " eliminado correctamente");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//				JOptionPane.showMessageDialog(null, "Campos inválidos");
		}
	}

	public ArrayList<Musico> sacarMusicoPorArtista(String artista) {
		ImageIcon imagen = new ImageIcon();
		ArrayList<Musico> musicos = new ArrayList<Musico>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT Ar.Nombre, Ar.Imagen, Ar.descripcion, Mu.Caracteristicas FROM `artista` Ar \r\n"
							+ "join musico Mu on Ar.Nombre = Mu.Artista\r\n" + "WHERE Ar.Nombre = ?");
			consulta.setString(1, artista);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {

				Blob imagenBlob = resultadoConsulta.getBlob(2);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
//				musicos.add(new Musico(resultadoConsulta.getString(1), imagen, resultadoConsulta.getString(3),
//						resultadoConsulta.getString(4)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return musicos;

	}

	public ArrayList<Album> sacarAlbumPorArtista(String artista) {
		ImageIcon imagen = new ImageIcon();
		ArrayList<Album> albums = new ArrayList<Album>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT Al.IdAlbum, Al.Nombre,Al.FechaPublicacion,Al.Genero,Al.Imagen, Al.NombreArtista, COUNT(Ca.Album) as Cantidad FROM `album` Al join cancion Ca on Al.Nombre = Ca.Album WHERE `NombreArtista` = ? GROUP BY Ca.Album;");
			consulta.setString(1, artista);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {

				Blob imagenBlob = resultadoConsulta.getBlob(5);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				albums.add(new Album(resultadoConsulta.getInt(1), resultadoConsulta.getString(2),
						resultadoConsulta.getString(3), resultadoConsulta.getString(4), imagen,
						resultadoConsulta.getString(6), resultadoConsulta.getInt(7)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return albums;

	}

	public ArrayList<Cancion> sacarCancionPorArtista(String album) {
		ImageIcon imagen = new ImageIcon();
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT Au.Nombre, Au.Duracion, Au.Imagen, Ca.Colaboradores FROM `cancion` Ca \r\n"
							+ "join audio Au on Ca.NombreCancion = Au.Nombre\r\n" + "WHERE Ca.Album = ?;");
			consulta.setString(1, album);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {

				Blob imagenBlob = resultadoConsulta.getBlob(3);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				canciones.add(new Cancion(resultadoConsulta.getString(1), resultadoConsulta.getInt(2), imagen,
						resultadoConsulta.getString(4)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return canciones;

	}

	public ArrayList<String> sacarArtistaPorGenero(String genero) {

		ArrayList<String> artistas = new ArrayList<String>();
		try {
			PreparedStatement consulta = conexion.prepareStatement("SELECT NombreArtista FROM album WHERE genero = ?");
			consulta.setString(1, genero);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
				artistas.add(new String(resultadoConsulta.getString(1)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return artistas;

	}

	
	public ArrayList<String> sacarPodcastPorPodcaster(String podcaster) {
		
		ArrayList<String> podcasts = new ArrayList<String>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT NombrePodcast FROM podcast WHERE Podcaster = ?");
			consulta.setString(1, podcaster);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
				podcasts.add(new String(resultadoConsulta.getString(1)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return podcasts;

	}
	
	public ArrayList<String> sacarEpisodiosPorPodcast(String podcast) {
		ArrayList<String> episodios = new ArrayList<String>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT Descripcion FROM podcast WHERE NombrePodcast = ?");
			consulta.setString(1, podcast);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
				episodios.add(new String(resultadoConsulta.getString(1)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return episodios;

	}


	public boolean sacarPremiun(String usuario) {
		// Crea el ArrayList
		boolean premiun = false;
		try {
			// System.out.println("Iniciando consulta..");
			// QUERY que selecciona todo de la tabla CINE
			PreparedStatement consulta = conexion.prepareStatement("SELECT IsPremiun FROM cliente where Usuario = ?;");
			consulta.setString(1, usuario);
			// Prepara la consulta para mandarla a la BD
			ResultSet resultadoConsulta = consulta.executeQuery();

			// Agrega los generos que tiene la tabla album al ArrayList generos donde
			while (resultadoConsulta.next()) {
				if (resultadoConsulta.getString(1).equals("1")) {
					premiun = true;
				}
			}
			// System.out.println("Cerrando Consulta a la tabla album..");
			resultadoConsulta.close();
		} catch (SQLException e) {
			// System.out.println("Conexion incorrecta con la tabla Album");
			e.printStackTrace();
		}
		// Devuelve los generos
		return premiun;
	}

	public ArrayList<Album> sacarAlbumArtista() {
		ArrayList<Album> albums = new ArrayList<Album>();
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("SELECT DISTINCT Genero, NombreArtista FROM `album`;");

			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
				Album alb = new Album();
				alb.setGenero(resultadoConsulta.getString(1));
				alb.setNombreArtista(resultadoConsulta.getString(2));
				albums.add(alb);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return albums;
	}

	public void insertPremiun(ArrayList<String> datosUsuario) {
		gestionINF = new GestionDeLaInformacion();
		String fechaBaja;
		try {
			Statement consulta = conexion.createStatement();
			// Toma la contraseña y la encripta a través del método

			if (datosUsuario.get(7) == "1") {
				LocalDate fechaSinFormatoBaja = LocalDate.now();
				DateTimeFormatter formatoBaja = DateTimeFormatter.ofPattern("2025-MM-dd");
				fechaBaja = formatoBaja.format(fechaSinFormatoBaja);
				JOptionPane.showMessageDialog(null, "La fecha de caducidad del Premiun termina el " + fechaBaja);
			} else {
				fechaBaja = "";
			}

//			System.out.println(datosUsuario);

			// TO DO --> cambiarlo
			String insert = "INSERT INTO premiun VALUES ('" + null + "','" + fechaBaja + "')";

			// Ejecución del INSERT
			consulta.executeUpdate(insert);
			// Cambia al Panel para iniciar sesión
			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}

	}
}
