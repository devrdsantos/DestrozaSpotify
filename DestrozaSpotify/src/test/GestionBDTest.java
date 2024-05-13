package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import controller.GestionBD;
import model.Musico;
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
		assertTrue(gestionBD.insertAlbum("testAlbum", "2000-01-01", "Cumbia", "Pretty", 1));
	}
	//HECHO
	@Test
	public void testSacarAlbumInformacion() {
		String testAlbumPrueba = "Pretty";
		assertEquals(testAlbumPrueba, gestionBD.sacarAlbumInformacion().get(0).getNombre());
	}
	/*
	@Test
	public void testInsertCancion() {
		
		assertTrue(gestionBD.insertCancion(1, 1, "Izan y Gontzal"));
	}*/

	/*@Test
	public void testInsertAudioMu() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testInsertAudioEpisodio() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testDeleteCancion() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testDeleteAudio() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testDeleteAlbum() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testDeleteMusico() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testInsertPodcaster() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testSacarPodcasterInformacion() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testInsertPodcast() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testDeletePodcast() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testDeletePodcaster() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testSacarMusicoPorArtista() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testSacarAlbumPorArtista() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testSacarCancionPorArtista() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testSacarEpisodiosPorPodcasts() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testSacarArtistaPorGenero() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testSacarPodcastPorPodcaster() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testSacarEpisodiosPorPodcast() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testSacarPremiun() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testSacarAlbumArtista() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testInsertPremiun() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testIdClienteDeUsuario() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testIdMusico() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testIdAlbum() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testIdPodcaster() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testInsertPlaylist() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testSacarPlaylistUsuario() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testDeletePlaylist() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testSacarCancionesPorTituloPlaylist() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testIdPlaylist() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testIdAudio() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testSacarMusicoParaPlaylist() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testInsertCancionEnPlaylist() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testDeleteCancionDePlaylist() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testInsertEpisodio() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testIdPodcast() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testPodcastInformacion() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testInsertFavoritos() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testCancionesDeFavoritos() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testSacarMusicoParaPlaylistFavoritos() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testCapacidadDePlaylist() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testSacarIdiomas() {
		fail("Not yet implemented");
	}*/

}
