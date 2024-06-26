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

import model.Cancion;

public class ControladorDeSonido {

	private ArrayList<Cancion> canciones;
	private int cancionEnReproduccion;
	private Clip cancionEnCurso;
	private Random random = new Random();
	private int numeroAleatorioAnterior = -1;
	private long continuar = 0;
	private boolean enReproduccion = true;
	boolean anuncion = false;

	public ControladorDeSonido(ArrayList<Cancion> canciones) {
		this.canciones = canciones;
		try {
			cancionEnCurso = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			System.out.println(e.getMessage());
		}
	}

	public void setCancionEnReproduccion(int can) {
		if (canciones.get(cancionEnReproduccion).sonando()) {
			cancionEnCurso.stop();
		}

//		if (!(can < 0 || can >= canciones.size())) {
//			this.cancionEnReproduccion = can;
//			reproducir(can);
//		}

	}

	public void reproducir(int cola) {
		try {
			if (canciones.get(cola).sonando()) {
				cancionEnCurso.stop();
				cancionEnCurso.close();
			}

			cancionEnCurso.open(AudioSystem.getAudioInputStream(
					new File("musica/" + canciones.get(cola).getNombre().replace(" ", "") + ".wav")));
			cancionEnCurso.start();
			enReproduccion = false;

		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pausar() {
		cancionEnCurso.stop();
	}

	public boolean cancionActiva() {
		return cancionEnCurso.isActive();
	}

	public void bucle(boolean activo, int cola) {

		if (activo == true) {
//			System.out.println(activo);
			reproducir(cola);
			cancionEnCurso.loop(100);
//			cancionEnCurso.stop();
		} else {
			reproducir(cola);
			cancionEnCurso.loop(0);
			cancionEnCurso.stop();
//			System.out.println(activo);

		}

	}

	public int ramdom() {
		int numeroAleatorioActual;

		do {
			numeroAleatorioActual = random.nextInt(canciones.size());
		} while (numeroAleatorioActual == numeroAleatorioAnterior);

		numeroAleatorioAnterior = numeroAleatorioActual;
		return numeroAleatorioActual;
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
		try {
			cancionEnCurso.open(AudioSystem.getAudioInputStream(new File("anuncio/Anuncio.wav")));
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cancionEnCurso.start();
	}
	
	public void parar() {
		cancionEnCurso.stop();
		cancionEnCurso.close();
	}

}
