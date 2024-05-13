package controller;

import java.security.Key;
import java.util.ArrayList;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import model.Album;
import model.Cancion;
import model.Cliente;
import model.Episodio;
import model.Musico;
import model.Playlist;
import model.Podcast;

public class GestionDeLaInformacion {

	private GestionBD gestionBD;
	private final String CLAVE_ENCRIPTADA = "clavecompartidanorevelarnuncamas";
	
	private String artista;
	private String album;
	private String podcaster;
	private String podcast;
	private int posicion;
	private String premiun;
	private int indiceAlbum;
	private String usuario;
	private String tituloPlaylist;
	private boolean favoritos = false;;
	
	private Cliente cliente;
	
	
	public GestionDeLaInformacion() {
		gestionBD = new GestionBD();
		cliente = new Cliente();
	}
	
	public String desencriptar(String mensajeEncriptado) throws Exception {

		byte[] mensajeBytes = Base64.getDecoder().decode(mensajeEncriptado);

		Key ClaveaAES = new SecretKeySpec(CLAVE_ENCRIPTADA.getBytes(), "AES");

		Cipher cipher = Cipher.getInstance("AES");

		cipher.init(Cipher.DECRYPT_MODE, ClaveaAES);

		String desencriptado = new String(cipher.doFinal(mensajeBytes));

		return desencriptado;
	}
	
	public String encriptar(String mensaje) throws Exception {
		Key claveAES = new SecretKeySpec(CLAVE_ENCRIPTADA.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, claveAES);

		byte[] mensajeEncriptado = cipher.doFinal(mensaje.getBytes());

		return Base64.getEncoder().encodeToString(mensajeEncriptado);
	}
	
	public ArrayList<String> mostrarGeneros (){
		
		return gestionBD.sacarGeneros();
	}
	
	public void artistaSeleccionado(String artista) {
		this.artista = artista;
	}
	
	public String devolverArtista() {
		return artista;
	}
	
	public void albumSeleccionado(String album) {
		this.album = album;
	}
	
	public String devolerAlbum() {
		return album;
	}
	
	public ArrayList<Musico> mostrarArtista() {
		return gestionBD.sacarMusicoPorArtista(artista);
	}
	
	public ArrayList<Album> mostrarAlbums() {
		return gestionBD.sacarAlbumPorArtista(artista);
	}
	
	public ArrayList<Cancion> mostrarCancion() {
		return gestionBD.sacarCancionPorArtista(album);
	}
	

	public ArrayList<Album> mostrarArtistas(){
		return gestionBD.sacarAlbumInformacion();
	}
	
	public ArrayList<String> mostrarPodcasters(){
		return gestionBD.sacarPodcasters();
	}
	
	public void almacenarPodcaster(String podcaster) {
		this.podcaster = podcaster;
	}
	
	public String mostrarPodcaster() {
		return this.podcaster;
	}
	
	public ArrayList<String> mostrarPodcastPorPodcaster(int podcaster){
		return gestionBD.sacarPodcastPorPodcaster(podcaster);
	}
	
	public void almacenarPodcast(String podcast) {
		this.podcast = podcast;
	}
	
	public String mostrarPodcast() {
		return this.podcast;
	}
	
	public ArrayList<String> mostrarEpisodiosPorPodcast(int idPodcast){
		return gestionBD.sacarEpisodiosPorPodcast(idPodcast);
	}
	
	public void indiceDeLaCancion(int posicion) {
		this.posicion = posicion;
	}

	public int devolverIndiceDeLaCancion() {
		return posicion;
	}
	
	public void sacarPremiun(String usuario) {
		premiun = gestionBD.sacarPremiun(usuario);
	}
	
	public String devolverPremiun() {
		return premiun;
	}
	
	public ArrayList<String> mostrarArtistasPorAlbum() {
		return gestionBD.sacarAlbumArtista();
	}

	public void indiceAlbum(int indice) {
		this.indiceAlbum = indice;
	}
	
	public int devolverIndiceAlbum() {
		return indiceAlbum;
	}

	
	public int devolverIdCliente(String cliente) {
		return gestionBD.idClienteDeUsuario(cliente);
	}
	
	public void insertPlaylist(String titulo, String fechaCreacion, int idCliente) {
		gestionBD.insertPlaylist(titulo, fechaCreacion, idCliente);
	}

	public void sacarUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String devolverUsuario() {
		return usuario;
	}
	
	public ArrayList<Playlist> devolverPlaylistCliente(int idCliente) {
		return gestionBD.sacarPlaylistUsuario(idCliente);
	}
	
	public void deletePlaylist(String titulo) {
		gestionBD.deletePlaylist(titulo);
	}
	
	public ArrayList<Cancion> devolverCancionesPorTituloPlaylist(String titulo) {
		return gestionBD.sacarCancionesPorTituloPlaylist(titulo);
	}
	
	public int devolverIdPlaylist(String titulo) {
		return gestionBD.idPlaylist(titulo);
	}
	
	public void recogerNombrePlaylist(String titulo) {
		this.tituloPlaylist = titulo;
	}
	
	public String devolverNombrePlaylist() {
		return tituloPlaylist;
	}
	
	public ArrayList<Musico> devolverMusicoPorTituloPlaylist(String titulo) {
		return gestionBD.sacarMusicoParaPlaylist(titulo);
	}

	public void añadirCancionAPlaylist(int idAudio, int idPlaylist) {
		gestionBD.insertCancionEnPlaylist(idAudio, idPlaylist);
	}
	
	public int sacarIdDelAudio(String nombre) {
		return gestionBD.idAudio(nombre);
	}
	
	public void deleteCancionDePlaylist(int idAudio) {
		gestionBD.deleteCancionDePlaylist(idAudio);
	}
	
	public void insertEpisodio(int idAudio, int idPodcast, String colaboradores) {
		gestionBD.insertEpisodio(idAudio, idPodcast, colaboradores);
	}
	
	public void insertAudio(String nombre, int duracion, String imagenPodc) {
		gestionBD.insertAudioEpisodio(nombre, duracion, imagenPodc);
	}
	
	public int devolverIdPodcast(String titulo) {
		return gestionBD.idPodcast(titulo); 
	}
	
	public ArrayList<Podcast> sacarPodcastInformacion() {
		return gestionBD.podcastInformacion();
	}
	
	public void favoritos(int idCliente, int idAudio) {
		gestionBD.insertFavoritos(idCliente, idAudio);
	}
	
	public void playlistFavoritos(int idCliente) {
		cliente.setFavoritos(gestionBD.cancionesDeFavoritos(idCliente));
	}
	
	public ArrayList<Cancion> cancionesDePlaylistFavoritos() {
		return cliente.getFavoritos();
	}
	
	public void favoritosSeleccionado(String favoritos) {
		if (favoritos.equalsIgnoreCase("Favoritos")) {
			this.favoritos = true;
		} else {
			this.favoritos = false;
		}
	}
	
	public boolean devolverFavoritosSeleccionado() {
		return favoritos;
	}
	
	public ArrayList<Musico> artistasDePlaylistFavoritos(int idCliente) {
		return gestionBD.sacarMusicoParaPlaylistFavoritos(idCliente);
	}
	
	public int capacidadDePlaylist(int idPlaylist) {
		return gestionBD.capacidadDePlaylist(idPlaylist);
	}
	
	public ArrayList<String> idiomas() {
		return gestionBD.sacarIdiomas();
	}

	public int devolverIdPodcaster(String nombreArtistico) {
		return gestionBD.idPodcaster(nombreArtistico);
	}
	
	public ArrayList<Episodio> mostrarEpisodioss(int idPodcast){
		return gestionBD.sacarEpisodiosPorPodcasts(idPodcast);
	}
	
}

