package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;

import interfaces.ControladorDeSonido;
import model.Podcast;

public class ControladorDeSonidoEpisodio implements ControladorDeSonido {

	private ArrayList<Podcast> episodios;
	private int cancionEnReproduccion;
	private Clip cancionEnCurso;
	private Random random = new Random();
	private int numeroAleatorioAnterior = -1;
	private long continuar = 0;
	private boolean enReproduccion = true;
	boolean anuncion = false;

	public ControladorDeSonidoEpisodio(ArrayList<Podcast> episodios) {
		this.episodios = episodios;
		try {
			cancionEnCurso = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			System.out.println(e.getMessage());
		}
	}

	public void setCancionEnReproduccion(int can) {
//		if (epidodios.get(cancionEnReproduccion).sonando()) {
//			cancionEnCurso.stop();
//		}

//		if (!(can < 0 || can >= canciones.size())) {
//			this.cancionEnReproduccion = can;
//			reproducir(can);
//		}

	}

	public void reproducir(int cola) {
//		try {
//			if (epidodios.get(cola).sonando()) {
//				cancionEnCurso.stop();
//				cancionEnCurso.close();
//			}

//			cancionEnCurso.open(AudioSystem.getAudioInputStream(
//					new File("musica/" + epidodios.get(cola).getNombre().replace(" ", "") + ".wav")));
			cancionEnCurso.start();
			enReproduccion = false;

//		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public void pausar() {
		cancionEnCurso.stop();
	}

	public boolean cancionActiva() {
		return cancionEnCurso.isActive();
	}

	public void bucle(boolean activo, int cola) {

	System.out.println("Inutilizado");

	}

	public int ramdom() {
		return 1;
	}

	public long seguirCancion() {
		cancionEnCurso.stop();
		return cancionEnCurso.getMicrosecondPosition();
	}

	public void continuarCancion(JButton play2) {

		if (!enReproduccion) {
			continuar = cancionEnCurso.getMicrosecondPosition();
			cancionEnCurso.stop();
			play2.setText("Play");
			enReproduccion = true;
		} else {
			cancionEnCurso.setMicrosecondPosition(continuar);
			cancionEnCurso.start();
			play2.setText("Stop");
			enReproduccion = false;
		}

	}

	public void anuncio() {
		System.out.println("Inutilizado");
	}
	
	public void parar() {
		cancionEnCurso.stop();
		cancionEnCurso.close();
	}

}
