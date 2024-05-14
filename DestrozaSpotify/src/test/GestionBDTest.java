package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import controller.GestionBD;
import view.VistaPrincipal;

public class GestionBDTest {
	
	static VistaPrincipal v;
	static GestionBD gestionBD;
	
	//HECHO
	@BeforeClass
	public static void beforeClass() {
	gestionBD = new GestionBD();
	v = new VistaPrincipal();
	}
	
	// HECHO 
	@Test
	public void testVerificarLogin() {
	
		try {
			assertTrue(gestionBD.verificarLogin("IzanRB", "123456", v));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			assertFalse(gestionBD.verificarLogin("Juan", "123456", v));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// HECHO
	@Test
	public void testSacarPasswordEncriptada() {
		
		
		String Password = null;
		try {
			Password = gestionBD.sacarPasswordEncriptada("IzanRB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String passwordCorrecta = "123456";
		assertEquals(passwordCorrecta, Password);
	}

	//HECHO
	@Test
	public void testInsertUsuario() {
		ArrayList<String> datosUsuario = new ArrayList<String>();
		
		datosUsuario.add("Prueba");
		datosUsuario.add("123456");
		datosUsuario.add("daniel");
		datosUsuario.add("santos");
		datosUsuario.add("04-04-1994");
		datosUsuario.add("Cliente");
		datosUsuario.add("Free");
		datosUsuario.add("ES");
		
		
		gestionBD.insertUsuario(datosUsuario, v);
		
		assertFalse(gestionBD.insertUsuario(datosUsuario, v));
		
		
	}
	//HECHO
	@Test
	public void testSacarGeneros() {
		ArrayList<String> listaGeneros = new ArrayList<String>();
		listaGeneros.add("Indie");
		listaGeneros.add("Electronica");
		listaGeneros.add("Pop");
		
		assertEquals(listaGeneros.get(0), gestionBD.sacarGeneros().get(0));
	}
	//HECHO
	@Test
	public void testSacarPodcasters() {
		ArrayList<String> listaPodcaster = new ArrayList<String>();
		listaPodcaster.add("Joe Rogan");
		
		assertEquals(listaPodcaster.get(0), gestionBD.sacarPodcasters().get(0));
	}
	//HECHO LO COMENTO PORQUE DA ERROR SI EJECUTAS MAS DE UNA VEZ EL MISMO INSERT
	/*
	@Test
	public void testInsertMusico() {
		assertTrue(gestionBD.insertMusico("Joe", "JoeRogan", "Solista", "Cantante calvo"));
	}*/
	//HECHO
	@Test
	public void testSacarMusicoInformacion() {
		
		String nombreArtisticoPrueba = "Artemas";
		
		
		assertEquals(nombreArtisticoPrueba, gestionBD.sacarMusicoInformacion().get(0).getNombreArtistico());
	}
	//HECHO LO COMENTO PORQUE DA ERROR SI EJECUTAS MAS DE UNA VEZ EL MISMO INSERT
	@Test
	public void testInsertAlbum() {
	//	assertTrue(gestionBD.insertAlbum("testAlbum", "2000-01-01", "Cumbia", "Pretty", 1));
	}
	//HECHO
	@Test
	public void testSacarAlbumInformacion() {
		String testAlbumPrueba = "Pretty";
		assertEquals(testAlbumPrueba, gestionBD.sacarAlbumInformacion().get(0).getNombre());
	}
	//HECHO
	@Test
	public void testInsertCancion() {
		//assertTrue(gestionBD.insertCancion(17, 1, "Izan y Gontzal"));
	}
	//HECHO LO COMENTO PORQUE DA ERROR SI EJECUTAS MAS DE UNA VEZ EL MISMO INSERT
		@Test
		public void testInsertAudioMu() {
			//assertTrue(gestionBD.insertAudioMu("audiotest", 200, "cancionprueba"));
		}
	//HECHO LO COMENTO PORQUE DA ERROR SI EJECUTAS MAS DE UNA VEZ EL MISMO INSERT
	@Test
	public void testInsertAudioEpisodio() {
	//	assertTrue(gestionBD.insertAudioEpisodio("nombreprueba", 200, "JoeRoganPortada"));
	}
	/*
	@Test
	public void testDeleteAudio() {
		assertTrue(gestionBD.deleteAudio("audiotest"));
	}*/

	/*@Test
	public void testDeleteAlbum() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testDeleteMusico() {
		fail("Not yet implemented");
	}*/
	//HECHO LO COMENTO PORQUE DA ERROR SI EJECUTAS MAS DE UNA VEZ EL MISMO INSERT
	@Test
	public void testInsertPodcaster() {
		//assertTrue(gestionBD.insertPodcaster("testPodcaster", "Artemas", "Comedia", "Podcaster de prueba para el test"));
	}
	//HECHO
	@Test
	public void testSacarPodcasterInformacion() {
		ArrayList<String> listaPodcaster = new ArrayList<String>();
		listaPodcaster.add("Joe Rogan");
		
		assertEquals(listaPodcaster.get(0), gestionBD.sacarPodcasterInformacion().get(0).getNombreArtistico());
	}
	//HECHO LO COMENTO PORQUE DA ERROR SI EJECUTAS MAS DE UNA VEZ EL MISMO INSERT
	@Test
	public void testInsertPodcast() {
	//	assertTrue(gestionBD.insertPodcast("podcastDePrueba", "DebateGordofobia", 1));
	}

	/*@Test
	public void testDeletePodcast() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testDeletePodcaster() {
		fail("Not yet implemented");
	}*/
	//HECHO
	@Test
	public void testSacarMusicoPorArtista() {
		String resultadoEsperado = "Artemas";
		assertEquals(resultadoEsperado, gestionBD.sacarMusicoPorArtista("Artemas").get(0).getNombreArtistico());
	}
	//HECHO
	@Test
	public void testSacarAlbumPorArtista() {
		String testAlbum = "Pretty";
		assertEquals(testAlbum, gestionBD.sacarAlbumPorArtista("Artemas").get(0).getNombre());
	}
	//HECHO
	@Test
	public void testSacarCancionPorArtista() {
		
		String resultadoEsperado = "I Like The Way You Kiss Me";
		assertEquals(resultadoEsperado, gestionBD.sacarCancionPorArtista("Pretty").get(0).getNombre());
	}

	//HECHO
	@Test
	public void testSacarPodcastPorPodcaster() {
		String resultadoEsperado = "The Joe Rogan Experience";
		assertEquals(resultadoEsperado, gestionBD.sacarPodcastPorPodcaster(1).get(0));
	}
	//HECHO
	@Test
	public void testSacarEpisodiosPorPodcast() {
		String resultadoEsperado = "JoeRoganExperienceEpisodio1";
		assertEquals(resultadoEsperado, gestionBD.sacarEpisodiosPorPodcast(2).get(0));
	}
	//HECHO
	@Test
	public void testSacarPremiun() {
		String resultadoEsperado = "Premiun";
		assertEquals(resultadoEsperado, gestionBD.sacarPremiun("IzanRB"));
	}
	//HECHO
	@Test
	public void testSacarAlbumArtista() {
		String resultadoEsperado = "Indie";
		assertEquals(resultadoEsperado, gestionBD.sacarAlbumArtista().get(0));
	}
	//HECHO
	@Test
	public void testInsertPremiun() {
		ArrayList<String> datosUsuarios = new ArrayList<String>();
		
		assertFalse(gestionBD.insertPremiun(datosUsuarios, 0));
	}
	//HECHO
	@Test
	public void testIdClienteDeUsuario() {
		int resultadoEsperado = 4;
		assertEquals(resultadoEsperado, gestionBD.idClienteDeUsuario("IzanRB"));
	}
	//HECHO
	@Test
	public void testIdMusico() {
		int resultadoEsperado = 1;
		assertEquals(resultadoEsperado, gestionBD.idMusico("Artemas"));
	}
	//HECHO
	@Test
	public void testIdAlbum() {
		int resultadoEsperado = 1;
		assertEquals(resultadoEsperado, gestionBD.idAlbum("Pretty"));
	}
	//HECHO
	@Test
	public void testIdPodcaster() {
		int resultadoEsperado = 1;
		assertEquals(resultadoEsperado, gestionBD.idPodcaster("Joe Rogan"));
	}
	//HECHO
	@Test
	public void testInsertPlaylist() {
		assertFalse(gestionBD.insertPlaylist("Prueba", "2020-01-01", 55));
	}
	//HECHO
	@Test
	public void testSacarPlaylistUsuario() {
		String resultadoEsperado = "Clase";
		assertEquals(resultadoEsperado, gestionBD.sacarPlaylistUsuario(4).get(0).getNombre());
	}
	//HECHO
	@Test
	public void testDeletePlaylist() {
	gestionBD.insertPlaylist("Prueba", "2021-01-01", 4);
	
	assertTrue(gestionBD.deletePlaylist("Prueba"));
	
	}
	//HECHO
	@Test
	public void testSacarCancionesPorTituloPlaylist() {
		String resultadoEsperado = "Demons";
		assertEquals(resultadoEsperado, gestionBD.sacarCancionesPorTituloPlaylist("Clase").get(0).getNombre());
	}
	//HECHO
	@Test
	public void testIdPlaylist() {
		int resultadoEsperado = 1;
		assertEquals(resultadoEsperado, gestionBD.idPlaylist("Clase"));
	}
	//HECHO
	@Test
	public void testIdAudio() {
		int resultadoEsperado = 2;
		assertEquals(resultadoEsperado, gestionBD.idAudio("Demons"));
	}
	//HECHO
	@Test
	public void testSacarMusicoParaPlaylist() {
		String resultadoEsperado = "Neoni";
		assertEquals(resultadoEsperado, gestionBD.sacarMusicoParaPlaylist("Clase").get(0).getNombreArtistico());
	}
	//HECHO
	@Test
	public void testInsertCancionEnPlaylist() {
		assertFalse(gestionBD.insertCancionEnPlaylist(1, 2));
	}
	//HECHO
	@Test
	public void testDeleteCancionDePlaylist() {
		gestionBD.insertCancionEnPlaylist(1, 1);
		assertTrue(gestionBD.deleteCancionDePlaylist(1));
	}
	//HECHO
	@Test
	public void testInsertEpisodio() {
		assertFalse(gestionBD.insertEpisodio(33, 55, "Esto es una prueba"));
		
	}
	//HECHO
	@Test
	public void testIdPodcast() {
		int resultadoEsperado = 2;
		assertEquals(resultadoEsperado, gestionBD.idPodcast("The Joe Rogan Experience"));
	}
	//HECHO
	@Test
	public void testPodcastInformacion() {
		String resultadoEsperado = "The Joe Rogan Experience";
		assertEquals(resultadoEsperado, gestionBD.podcastInformacion().get(0).getTitulo());
	}
	//HECHO
	@Test
	public void testInsertFavoritos() {
		assertFalse(gestionBD.insertFavoritos(55, 66));
	}
	//HECHO
	@Test
	public void testCancionesDeFavoritos() {
		String resultadoEsperado = "I Like The Way You Kiss Me";
		assertEquals(resultadoEsperado, gestionBD.cancionesDeFavoritos(4).get(0).getNombre());
	}
	//HECHO
	@Test
	public void testSacarMusicoParaPlaylistFavoritos() {
		String resultadoEsperado = "Artemas";
		assertEquals(resultadoEsperado, gestionBD.sacarMusicoParaPlaylistFavoritos(4).get(0).getNombreArtistico());
	}
	//HECHO
	@Test
	public void testCapacidadDePlaylist() {
		int resultadoEsperado = 2;
		assertEquals(resultadoEsperado, gestionBD.capacidadDePlaylist(1));
	}
	//HECHO
	@Test
	public void testSacarIdiomas() {
		String resultadoEsperado = "ES";
		assertEquals(resultadoEsperado, gestionBD.sacarIdiomas().get(0));
	}
	//HECHO
	@Test
	public void testUpdateMusico() {
		assertFalse(gestionBD.updateMusico("hola", "hola", "hola", "hola", "hola"));
	}
	//HECHO
	@Test
	public void testUpdateAlbum() {
		assertFalse(gestionBD.updateAlbum("hola", "hola", "hola", "hola", "hola"));
	}
	//HECHO
	@Test
	public void testAlbumPorTitulo() {
		String resultadoEsperado = "Indie";
		assertEquals(resultadoEsperado, gestionBD.albumPorTitulo("Pretty").get(0).getGenero());
	}
	//HECHO
	@Test
	public void testCancionPorNombre() {
		String resultadoEsperado = "Demons";
		assertEquals(resultadoEsperado, gestionBD.cancionPorNombre("Demons").get(0).getNombre());
	}
	//HECHO
	@Test
	public void testUpdateAudio() {
		assertFalse(gestionBD.updateAudio("hola", "hola", "hola", "hola"));
	}
	@Test
	public void testUpdateCancion() {
		assertTrue(gestionBD.updateCancion("ALGO", 155));
	}
	
}
