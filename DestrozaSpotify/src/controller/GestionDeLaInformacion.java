package controller;

import java.security.Key;
import java.util.ArrayList;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import model.Album;
import model.Cancion;
import model.Musico;
import model.Playlist;

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
	
	public GestionDeLaInformacion() {
		gestionBD = new GestionBD();
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
		System.out.println(gestionBD.sacarMusicoPorArtista(artista).get(0).toString());
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
	
	public ArrayList<String> mostrarPodcastPorPodcaster(String podcaster){
		return gestionBD.sacarPodcastPorPodcaster(podcaster);
	}
	
	public void almacenarPodcast(String podcast) {
		this.podcast = podcast;
	}
	
	public String mostrarPodcast() {
		return this.podcast;
	}
	
	public ArrayList<String> mostrarEpisodiosPorPodcast(String podcast){
		return gestionBD.sacarEpisodiosPorPodcast(podcast);
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
	
	public void inserPodcast(String titulo, String fechaCreacion, int idCliente) {
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
	
}
