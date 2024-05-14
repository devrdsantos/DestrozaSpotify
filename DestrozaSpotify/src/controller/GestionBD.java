package controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.Album;
import model.Cancion;
import model.Episodio;
import model.Musico;
import model.Playlist;
import model.Podcast;
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

			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/reto4grupo35", "root", "");

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
			String query = "SELECT Usuario, Contraseña FROM cliente WHERE Usuario = ?";

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
				if (resultadoConsulta.getString(1).equals("Admin")) {
					JOptionPane.showMessageDialog(null, "\nSe ha iniciado sesión con administrador");
					v.cambiarDePanel(4);
					verificarLogin = true;
				} else {
					JOptionPane.showMessageDialog(null, "\nSe ha iniciado sesión");
					v.cambiarDePanel(3);
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

	/* HECHO!! */
	public void insertUsuario(ArrayList<String> datosUsuario, VistaPrincipal v) {
		gestionINF = new GestionDeLaInformacion();
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
	/* HECHO!! */
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

	/* HECHO!! */
	public ArrayList<String> sacarPodcasters() {
		// Crea el ArrayList
		ArrayList<String> podcasters = new ArrayList<String>();
		try {
			// System.out.println("Iniciando consulta..");
			// QUERY que selecciona todo de la tabla CINE
			String query = "SELECT DISTINCT NombreArtistico FROM podcaster;";
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

//	public void insertArtista(String nombre, String imagenArt, String descripcion) {
//		try {
//			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO artista VALUES (?,?,?)");
//			consulta.setString(1, nombre);
//			InputStream imagen = new FileInputStream("imagenes/imagenArt/" + imagenArt + ".jpg");
//			consulta.setBlob(2, imagen);
//			consulta.setString(3, descripcion);
//			consulta.executeUpdate();
//			JOptionPane.showMessageDialog(null, "Artista creado correctamente");
//			// Cambia al Panel para iniciar sesión
//
//			// Cierra la consulta
//			consulta.close();
//
//		} catch (Exception e) {
//			System.out.println(e);
////			JOptionPane.showMessageDialog(null, "Campos inválidos");
//		}
//
//	}

	/* HECHO!! */
	public void insertMusico(String nombreArtistico, String imagenMu, String caracteristicas, String descripcion) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO musico VALUES (?,?,?,?,?)");
			consulta.setString(1, null);
			consulta.setString(2, nombreArtistico);
			InputStream imagen = new FileInputStream("imagenes/imagenArt/" + imagenMu + ".jpg");
			consulta.setBlob(3, imagen);
			consulta.setString(4, caracteristicas);
			consulta.setString(5, descripcion);
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

	/* HECHO!! */
	public ArrayList<Musico> sacarMusicoInformacion() {
		ImageIcon imagen = new ImageIcon();
		ArrayList<Musico> artistas = new ArrayList<Musico>();

		try {
			PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM Musico;");

			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
				Blob imagenBlob = resultadoConsulta.getBlob(3);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				artistas.add(new Musico(resultadoConsulta.getInt(1), resultadoConsulta.getString(2), imagen,
						resultadoConsulta.getString(4), resultadoConsulta.getString(5)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return artistas;
	}

	/* HECHO!! */
	public void insertAlbum(String nombre, String fechaPub, String genero, String imagenAlb, int idMusico) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO album VALUES (?,?,?,?,?,?)");
			consulta.setString(1, null);
			consulta.setString(2, nombre);
			consulta.setString(3, fechaPub);
			consulta.setString(4, genero);
			InputStream imagen = new FileInputStream("imagenes/portadasAlb/" + imagenAlb + ".jpg");
			consulta.setBlob(5, imagen);
			consulta.setInt(6, idMusico);
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

	/* HECHO!! */
	public ArrayList<Album> sacarAlbumInformacion() {
		ImageIcon imagen = new ImageIcon();
		ArrayList<Album> albums = new ArrayList<Album>();
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("SELECT *, COUNT(IDalbum) FROM `album` GROUP BY IDalbum;");

			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
				Blob imagenBlob = resultadoConsulta.getBlob(5);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				albums.add(new Album(resultadoConsulta.getInt(1), resultadoConsulta.getString(2),
						resultadoConsulta.getString(3), resultadoConsulta.getString(4), imagen,
						resultadoConsulta.getInt(6), resultadoConsulta.getInt(7)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return albums;
	}

	/* HECHO!! */
	public void insertCancion(int idAudio, int idAlbum, String colaboradores) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO cancion VALUES (?,?,?)");
			consulta.setInt(1, idAudio);
			consulta.setInt(2, idAlbum);
			consulta.setString(3, colaboradores);
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

	/* HECHO!! */
	public void insertAudioMu(String nombre, int duracion, String imagenMu) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO audio VALUES (?,?,?,?,?)");
			consulta.setString(1, null);
			consulta.setString(2, nombre);
			consulta.setInt(3, duracion);
			InputStream imagen = new FileInputStream("imagenes/portadasMu/" + imagenMu + ".jpg");
			consulta.setBlob(4, imagen);
			consulta.setString(5, "Canción");
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

	/* HECHO!! */
	public void insertAudioEpisodio(String nombre, int duracion, String imagenPodc) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO audio VALUES (?,?,?,?,?)");
			consulta.setString(1, null);
			consulta.setString(2, nombre);
			consulta.setInt(3, duracion);
			InputStream imagen = new FileInputStream("imagenes/portadasEpisodio/" + imagenPodc + ".jpg");
			consulta.setBlob(4, imagen);
			consulta.setString(5, "Podcast");
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

	public void deleteCancion(int idAudio) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("DELETE FROM `cancion` WHERE `IdAudio` = ? ");
			consulta.setInt(1, idAudio);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "La cancion con el id " + idAudio + " eliminada correctamente");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}

	}

	/* HECHO!!! */
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

	/* HECHO!!! */
	public void deleteAlbum(String nombre) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("DELETE FROM `album` WHERE `Titulo` = ? ");
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

	/* HECHO!!! */
	public void deleteMusico(String nombre) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("DELETE FROM `musico` WHERE `NombreArtistico` = ? ");
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

	/* HECHO!! */
	public void insertPodcaster(String nombrePodcaster, String imagenPod, String genero, String descripcion) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO podcaster VALUES (?,?,?,?,?)");
			consulta.setString(1, null);
			consulta.setString(2, nombrePodcaster);
			InputStream imagen = new FileInputStream("imagenes/imagenArt/" + imagenPod.replace(" ", "") + ".jpg");
			consulta.setBlob(3, imagen);
			consulta.setString(4, genero);
			consulta.setString(5, descripcion);
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

	/* HECHO!! */
	public ArrayList<Podcaster> sacarPodcasterInformacion() {
		ImageIcon imagen = new ImageIcon();
		ArrayList<Podcaster> podcasters = new ArrayList<Podcaster>();
		try {
			PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM Podcaster");

			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {

				Blob imagenBlob = resultadoConsulta.getBlob(3);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				podcasters.add(new Podcaster(resultadoConsulta.getInt(1), resultadoConsulta.getString(2), imagen,
						resultadoConsulta.getString(4), resultadoConsulta.getString(5)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return podcasters;
	}

	/* HECHO!! */
	public void insertPodcast(String nombrePodcast, String imagenPodcast, int idPodcaster) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO podcast VALUES (?,?,?,?)");
			consulta.setString(1, null);
			consulta.setString(2, nombrePodcast);
			InputStream imagen = new FileInputStream(
					"imagenes/portadasPodcast/" + imagenPodcast.replace(" ", "") + ".jpg");
			consulta.setBlob(3, imagen);
			consulta.setInt(4, idPodcaster);
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

	/* HECHO!!! */
	public void deletePodcast(String podcast) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("DELETE FROM `podcast` WHERE `Titulo` = ? ");
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

	/* HECHO!!! */
	public void deletePodcaster(String podcaster) {
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("DELETE FROM `podcaster` WHERE `NombreArtistico` = ? ");
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

	/* HECHO!! */
	public ArrayList<Musico> sacarMusicoPorArtista(String artista) {
		ImageIcon imagen = new ImageIcon();
		ArrayList<Musico> musicos = new ArrayList<Musico>();
		try {
			PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM musico WHERE NombreArtistico = ?");
			consulta.setString(1, artista);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {

				Blob imagenBlob = resultadoConsulta.getBlob(3);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				musicos.add(new Musico(resultadoConsulta.getInt(1), resultadoConsulta.getString(2), imagen,
						resultadoConsulta.getString(4), resultadoConsulta.getString(5)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return musicos;

	}

	/* HECHO!! */
	public ArrayList<Album> sacarAlbumPorArtista(String artista) {
		ImageIcon imagen = new ImageIcon();
		ArrayList<Album> albums = new ArrayList<Album>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT Al.IdAlbum, Al.Titulo, Al.Año, Al.Genero, Al.Imagen, Al.IDMusico, COUNT(Au.Nombre) as Cantidad FROM album Al JOIN cancion Ca ON Al.IDAlbum = Ca.IDAlbum JOIN Audio Au ON Ca.IDAudio = Au.IDAudio JOIN musico Mu ON Al.IDMusico = Mu.IDMusico WHERE Mu.NombreArtistico = ? GROUP BY Al.IdAlbum;");
			consulta.setString(1, artista);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {

				Blob imagenBlob = resultadoConsulta.getBlob(5);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				albums.add(new Album(resultadoConsulta.getInt(1), resultadoConsulta.getString(2),
						resultadoConsulta.getString(3), resultadoConsulta.getString(4), imagen,
						resultadoConsulta.getInt(6), resultadoConsulta.getInt(7)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return albums;

	}

	/* HECHO!! */
	public ArrayList<Cancion> sacarCancionPorArtista(String album) {
		ImageIcon imagen = new ImageIcon();
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT Au.IDAudio, Au.Nombre, Au.Duracion, Au.Imagen, Au.Tipo, Ca.IDAlbum, Ca.Artistas_invitados FROM `audio`Au join cancion Ca on Au.IDAudio = Ca.IDAudio join album Al on Ca.IDAlbum = Al.IDalbum Where Al.titulo = ?;");
			consulta.setString(1, album);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {

				Blob imagenBlob = resultadoConsulta.getBlob(4);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				canciones.add(new Cancion(resultadoConsulta.getInt(1), resultadoConsulta.getString(2),
						resultadoConsulta.getInt(3), imagen, resultadoConsulta.getString(5),
						resultadoConsulta.getInt(6), resultadoConsulta.getString(7)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return canciones;

	}

	public ArrayList<Episodio> sacarEpisodiosPorPodcasts(int idPodcast) {
		ImageIcon imagen = new ImageIcon();
		ArrayList<Episodio> episodios = new ArrayList<Episodio>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT a.idAudio, a.Nombre, a.Duracion, a.Imagen, e.Colaboradores FROM audio a JOIN episodio e ON a.IDAudio = e.IDAudio WHERE e.IDPodcast = ?");
			consulta.setInt(1, idPodcast);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {

				Blob imagenBlob = resultadoConsulta.getBlob(4);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				episodios.add(new Episodio(resultadoConsulta.getInt(1), resultadoConsulta.getString(2),
						resultadoConsulta.getInt(3), imagen, resultadoConsulta.getString(5)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return episodios;

	}

	/* HECHO!! */
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

	/* HECHO!! */
	public ArrayList<String> sacarPodcastPorPodcaster(int idPodcaster) {

		ArrayList<String> podcasts = new ArrayList<String>();
		try {
			PreparedStatement consulta = conexion.prepareStatement("SELECT Titulo FROM podcast WHERE idPodcaster = ?");
			consulta.setInt(1, idPodcaster);
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

	/* HECHO!! */
	public ArrayList<String> sacarEpisodiosPorPodcast(int idPodcast) {
		ArrayList<String> episodios = new ArrayList<String>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT a.Nombre FROM audio a JOIN episodio e ON a.IDAudio = e.IDAudio WHERE e.IDPodcast = ?");
			consulta.setInt(1, idPodcast);
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

	/* HECHO!! */
	public String sacarPremiun(String usuario) {

		String premiun = null;
		try {

			PreparedStatement consulta = conexion.prepareStatement("SELECT Tipo FROM cliente where Usuario = ?;");
			consulta.setString(1, usuario);

			ResultSet resultadoConsulta = consulta.executeQuery();

			while (resultadoConsulta.next()) {
				premiun = resultadoConsulta.getString(1);
			}

			resultadoConsulta.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return premiun;
	}

	/* HECHO!! */
	public ArrayList<String> sacarAlbumArtista() {
		ArrayList<String> albums = new ArrayList<String>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT DISTINCT Genero, NombreArtistico FROM `album` Al join musico Mu on Al.IDmusico = Mu.IDMusico");

			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
//				Album alb = new Album();
//				alb.setGenero(resultadoConsulta.getString(1));
//				alb.setNombreArtista(resultadoConsulta.getString(2));
				albums.add(resultadoConsulta.getString(1));
				albums.add(resultadoConsulta.getString(2));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return albums;
	}

	/* HECHO!! */
	public void insertPremiun(ArrayList<String> datosUsuario, int id) {
		gestionINF = new GestionDeLaInformacion();
		String fechaBaja;
		try {
			if (datosUsuario.get(7).equalsIgnoreCase("Premiun")) {
				LocalDate fechaSinFormatoBaja = LocalDate.now();
				DateTimeFormatter formatoBaja = DateTimeFormatter.ofPattern("2025-MM-dd");
				fechaBaja = formatoBaja.format(fechaSinFormatoBaja);
				JOptionPane.showMessageDialog(null, "La fecha de caducidad del Premiun termina el " + fechaBaja);
			} else {
				fechaBaja = "";
			}

			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO premiun VALUES (?,?)");
			consulta.setInt(1, id);
			consulta.setString(2, fechaBaja);
			consulta.executeUpdate();

			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}

	}

	/* HECHO!! */
	public int idClienteDeUsuario(String usuario) {
		int idCliente = 0;
		try {

			PreparedStatement consulta = conexion
					.prepareStatement("SELECT `IDCliente` FROM `cliente` WHERE `Usuario` = ?;");
			consulta.setString(1, usuario);

			ResultSet resultadoConsulta = consulta.executeQuery();

			while (resultadoConsulta.next()) {
				idCliente = resultadoConsulta.getInt(1);
			}

			resultadoConsulta.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return idCliente;
	}

	/* HECHO!! */
	public int idMusico(String musico) {
		int idMusico = 0;
		try {

			PreparedStatement consulta = conexion
					.prepareStatement("SELECT `IDMusico`FROM `musico` WHERE `NombreArtistico` = ?;");
			consulta.setString(1, musico);

			ResultSet resultadoConsulta = consulta.executeQuery();

			while (resultadoConsulta.next()) {
				idMusico = resultadoConsulta.getInt(1);
			}

			resultadoConsulta.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return idMusico;
	}

	/* HECHO!! */
	public int idAlbum(String album) {
		int idAlbum = 0;
		try {

			PreparedStatement consulta = conexion.prepareStatement("SELECT IDalbum FROM `album` Where titulo = ?;");
			consulta.setString(1, album);

			ResultSet resultadoConsulta = consulta.executeQuery();

			while (resultadoConsulta.next()) {
				idAlbum = resultadoConsulta.getInt(1);
			}

			resultadoConsulta.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return idAlbum;
	}

	/* HECHO!! */
	public int idPodcaster(String podcaster) {
		int idPodcaster = 0;
		try {

			PreparedStatement consulta = conexion
					.prepareStatement("SELECT IDPodcaster FROM `podcaster` Where NombreArtistico = ?;");
			consulta.setString(1, podcaster);

			ResultSet resultadoConsulta = consulta.executeQuery();

			while (resultadoConsulta.next()) {
				idPodcaster = resultadoConsulta.getInt(1);
			}

			resultadoConsulta.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return idPodcaster;
	}

	/* HECHO!! */
	public void insertPlaylist(String titulo, String fechaCreacion, int idCliente) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO playlist VALUES (?,?,?,?)");
			consulta.setString(1, null);
			consulta.setString(2, titulo);
			consulta.setString(3, fechaCreacion);
			consulta.setInt(4, idCliente);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "Playlist creado correctamente");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}

	}

	/* HECHO!! */
	public ArrayList<Playlist> sacarPlaylistUsuario(int idUsuario) {
		ArrayList<Playlist> playlists = new ArrayList<Playlist>();
		try {
			PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM `playlist` WHERE `IDCliente` = ?;");
			consulta.setInt(1, idUsuario);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
				playlists.add(new Playlist(resultadoConsulta.getInt(1), resultadoConsulta.getString(2),
						resultadoConsulta.getString(3), resultadoConsulta.getInt(4)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return playlists;
	}

	/* HECHO!! */
	public void deletePlaylist(String titulo) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("DELETE FROM `playlist` WHERE `Titulo` = ? ");
			consulta.setString(1, titulo);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "La playlist con el " + titulo + " eliminado correctamente");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//				JOptionPane.showMessageDialog(null, "Campos inválidos");
		}
	}

	/* HECHO!! */
	public ArrayList<Cancion> sacarCancionesPorTituloPlaylist(String titulo) {
		ImageIcon imagen = new ImageIcon();
		ArrayList<Cancion> playlistCanciones = new ArrayList<Cancion>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT Au.IDAudio, Au.Nombre, Au.Duracion, AU.Imagen, Au.Tipo, Ca.IDAlbum, Ca.Artistas_invitados from playlist Pl join playlist_cancion Pc on Pl.IDplaylist = Pc.IDplaylist join audio Au on Pc.IDCancion = Au.IDAudio join cancion Ca on Au.IDAudio = Ca.IDAudio Where Pl.Titulo = ?;");
			consulta.setString(1, titulo);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
				Blob imagenBlob = resultadoConsulta.getBlob(4);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				playlistCanciones.add(new Cancion(resultadoConsulta.getInt(1), resultadoConsulta.getString(2),
						resultadoConsulta.getInt(3), imagen, resultadoConsulta.getString(5),
						resultadoConsulta.getInt(6), resultadoConsulta.getString(7)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return playlistCanciones;
	}

	/* HECHO!! */
	public int idPlaylist(String titulo) {
		int idPlaylist = 0;
		try {

			PreparedStatement consulta = conexion
					.prepareStatement("SELECT IDplaylist FROM `playlist` Where Titulo = ?;");
			consulta.setString(1, titulo);

			ResultSet resultadoConsulta = consulta.executeQuery();

			while (resultadoConsulta.next()) {
				idPlaylist = resultadoConsulta.getInt(1);
			}

			resultadoConsulta.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return idPlaylist;
	}

	/* HECHO!! */
	public int idAudio(String nombre) {
		int idAudio = 0;
		try {

			PreparedStatement consulta = conexion.prepareStatement("SELECT IDAudio FROM `audio` Where Nombre = ?;");
			consulta.setString(1, nombre);

			ResultSet resultadoConsulta = consulta.executeQuery();

			while (resultadoConsulta.next()) {
				idAudio = resultadoConsulta.getInt(1);
			}

			resultadoConsulta.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Cancion no encontrada!!");
			e.printStackTrace();
		}

		return idAudio;
	}

	/* HECHO!! */
	public ArrayList<Musico> sacarMusicoParaPlaylist(String titulo) {
		ImageIcon imagen = new ImageIcon();
		ArrayList<Musico> artista = new ArrayList<Musico>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT Mu.IDMusico, Mu.NombreArtistico, Mu.Imagen, Mu.Caracteristica, Mu.Descripcion from playlist Pl join playlist_cancion Pc on Pl.IDplaylist = Pc.IDplaylist join cancion Ca on Pc.IDCancion = Ca.IDAudio join album Al on Ca.IDAlbum = Al.IDalbum join musico Mu on Al.IDmusico = Mu.IDMusico Where Pl.Titulo = ?");
			consulta.setString(1, titulo);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
				Blob imagenBlob = resultadoConsulta.getBlob(3);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				artista.add(new Musico(resultadoConsulta.getInt(1), resultadoConsulta.getString(2), imagen,
						resultadoConsulta.getString(4), resultadoConsulta.getString(5)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return artista;
	}

	/* HECHO!! */
	public void insertCancionEnPlaylist(int idPlaylist, int idAudio) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO playlist_cancion VALUES (?,?,?)");
			System.out.println(idPlaylist);
			System.out.println(idAudio);
			consulta.setInt(1, idAudio);
			consulta.setInt(2, idPlaylist);
			LocalDate fechaSinFormato = LocalDate.now();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String fechaCreacion = formato.format(fechaSinFormato);
			consulta.setString(3, fechaCreacion);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cancion añadida!");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}

	}

	/* HECHO!! */
	public void deleteCancionDePlaylist(int idAudio) {
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("DELETE FROM `playlist_cancion` WHERE `IDCancion` = ? ");
			consulta.setInt(1, idAudio);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cancion eliminada");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//				JOptionPane.showMessageDialog(null, "Campos inválidos");
		}
	}

	/* HECHO!! */
	public void insertEpisodio(int idAudio, int idPodcast, String colaboradores) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO episodio VALUES (?,?,?)");
			consulta.setInt(1, idAudio);
			consulta.setInt(2, idPodcast);
			consulta.setString(3, colaboradores);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "Episodio creado correctamente");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}

	}

	/* HECHO!! */
	public int idPodcast(String titulo) {
		int idPodcast = 0;
		try {

			PreparedStatement consulta = conexion.prepareStatement("SELECT IDPodcast FROM `podcast` Where Titulo = ?;");
			consulta.setString(1, titulo);

			ResultSet resultadoConsulta = consulta.executeQuery();

			while (resultadoConsulta.next()) {
				idPodcast = resultadoConsulta.getInt(1);
			}

			resultadoConsulta.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return idPodcast;
	}

	/* HECHO!! */
	public ArrayList<Podcast> podcastInformacion() {
		ImageIcon imagen = new ImageIcon();
		ArrayList<Podcast> podcasts = new ArrayList<Podcast>();
		try {
			PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM `podcast`;");
			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
				Blob imagenBlob = resultadoConsulta.getBlob(3);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				podcasts.add(new Podcast(resultadoConsulta.getInt(1), resultadoConsulta.getString(2), imagen,
						resultadoConsulta.getInt(4)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return podcasts;
	}

	/* HECHO!! */
	public void insertFavoritos(int idCliente, int idAudio) {
		try {
			PreparedStatement consulta = conexion.prepareStatement("INSERT INTO gustos VALUES (?,?)");
			consulta.setInt(1, idCliente);
			consulta.setInt(2, idAudio);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cancion añadida a favoritos");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}

	}

	/* HECHO!! */
	public ArrayList<Cancion> cancionesDeFavoritos(int idCliente) {
		ImageIcon imagen = new ImageIcon();
		ArrayList<Cancion> favoritos = new ArrayList<Cancion>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT Au.IDAudio, Au.Nombre, Au.Duracion, AU.Imagen, Au.Tipo, Ca.IDAlbum, Ca.Artistas_invitados FROM `gustos` Gu join audio Au on Gu.IDAudio = AU.IDAudio join Cancion Ca on Au.IDAudio = CA.IDAudio WHERE IDCliente = ?;");
			consulta.setInt(1, idCliente);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
				Blob imagenBlob = resultadoConsulta.getBlob(4);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				favoritos.add(new Cancion(resultadoConsulta.getInt(1), resultadoConsulta.getString(2),
						resultadoConsulta.getInt(3), imagen, resultadoConsulta.getString(5),
						resultadoConsulta.getInt(6), resultadoConsulta.getString(7)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return favoritos;
	}

	/* HECHO!! */
	public ArrayList<Musico> sacarMusicoParaPlaylistFavoritos(int idCliente) {
		ImageIcon imagen = new ImageIcon();
		ArrayList<Musico> artista = new ArrayList<Musico>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT Mu.IDMusico, Mu.NombreArtistico, Mu.Imagen, Mu.Caracteristica, Mu.Descripcion FROM `gustos` Gu join cancion Ca on Gu.IDAudio = Ca.IDAudio join album Al on Ca.IDAlbum = Al.IDalbum join Musico Mu on Al.IDmusico = Mu.IDMusico WHere IDCliente = ?;");
			consulta.setInt(1, idCliente);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
				Blob imagenBlob = resultadoConsulta.getBlob(3);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				artista.add(new Musico(resultadoConsulta.getInt(1), resultadoConsulta.getString(2), imagen,
						resultadoConsulta.getString(4), resultadoConsulta.getString(5)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return artista;
	}

	/* HECHO!! */
	public int capacidadDePlaylist(int idPlaylist) {
		int capacidad = 0;
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("SELECT COUNT(IDCancion) FROM `playlist_cancion` Where IDplaylist = ?");
			consulta.setInt(1, idPlaylist);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
				capacidad = resultadoConsulta.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return capacidad;
	}

	/* HECHO!! */
	public ArrayList<String> sacarIdiomas() {
		// Crea el ArrayList
		ArrayList<String> idiomas = new ArrayList<String>();
		try {

			String query = "SELECT IDidioma FROM `idioma`;";
			PreparedStatement consultaPreparada = conexion.prepareStatement(query);
			ResultSet resultadoConsulta = consultaPreparada.executeQuery();

			while (resultadoConsulta.next()) {
				idiomas.add((resultadoConsulta.getString(1)));
			}
			// System.out.println("Cerrando Consulta a la tabla album..");
			consultaPreparada.close();
		} catch (SQLException e) {
			// System.out.println("Conexion incorrecta con la tabla Album");
			e.printStackTrace();
		}
		// Devuelve los generos
		return idiomas;
	}

	/* HECHO!! */
	public void updateMusico(String nombreArtisticoMo, String imagenMo, String caracteristicasMo,
			String descripcionMo, String artista) {
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"UPDATE `musico` SET `NombreArtistico`=?,`Imagen`=?,`Caracteristica`=?,`Descripcion`=? WHERE `NombreArtistico` = ?");
			consulta.setString(1, nombreArtisticoMo);
			InputStream imagen = new FileInputStream("imagenes/imagenArt/" + imagenMo + ".jpg");
			consulta.setBlob(2, imagen);
			consulta.setString(3, caracteristicasMo);
			consulta.setString(4, descripcionMo);
			
			consulta.setString(5, artista);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "Musico modificado");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}
	}

	/* HECHO!! */
	public void updateAlbum(String tituloMo, String añoMo, String generoMo,
			String imagenMo, String titulo) {
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"UPDATE `album` SET `titulo`=?,`año`=?,`genero`=?,`imagen`=? WHERE `titulo` = ?");
			consulta.setString(1, tituloMo);
			consulta.setString(2, añoMo);
			consulta.setString(3, generoMo);
			InputStream imagen = new FileInputStream("imagenes/portadasAlb/" + imagenMo + ".jpg");
			consulta.setBlob(4, imagen);
			
			consulta.setString(5, titulo);
			consulta.executeUpdate();
			JOptionPane.showMessageDialog(null, "Album modificado");
			// Cambia al Panel para iniciar sesión

			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}
	}
	
	/* HECHO!! */
	public ArrayList<Album> albumPorTitulo(String titulo) {
		ImageIcon imagen = new ImageIcon();
		ArrayList<Album> albums = new ArrayList<Album>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT Al.IdAlbum, Al.Titulo, Al.Año, Al.Genero, Al.Imagen, Al.IDMusico, COUNT(Au.Nombre) as Cantidad FROM album Al JOIN cancion Ca ON Al.IDAlbum = Ca.IDAlbum JOIN Audio Au ON Ca.IDAudio = Au.IDAudio WHERE Al.titulo = ? GROUP BY Al.IdAlbum;");
			consulta.setString(1, titulo);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {

				Blob imagenBlob = resultadoConsulta.getBlob(5);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				albums.add(new Album(resultadoConsulta.getInt(1), resultadoConsulta.getString(2),
						resultadoConsulta.getString(3), resultadoConsulta.getString(4), imagen,
						resultadoConsulta.getInt(6), resultadoConsulta.getInt(7)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return albums;

	}
}
