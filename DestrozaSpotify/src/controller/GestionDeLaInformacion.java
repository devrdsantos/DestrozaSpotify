package controller;

import java.security.Key;
import java.util.ArrayList;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import model.Album;
import model.Cancion;
import model.Musico;

public class GestionDeLaInformacion {

	private GestionBD gestionBD;
	private final String CLAVE_ENCRIPTADA = "clavecompartidanorevelarnuncamas";
	
	private String artista;
	private String album;
	private int posicion;
	private boolean premiun;
	
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
		System.out.println(artista);
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
	

	public void indiceDeLaCancion(int posicion) {
		this.posicion = posicion;
	}

	public int devolcerIndiceDeLaCancion() {
		return posicion;
	}

	public void sacarPremiun(String usuario) {
		premiun = gestionBD.sacarPremiun(usuario);
	}
	
	public boolean devolverPremiun() {
		return premiun;
	}
	
}
