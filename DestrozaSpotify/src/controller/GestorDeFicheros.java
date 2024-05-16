package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Cancion;

public class GestorDeFicheros {

	public GestorDeFicheros() {
		
	}
	
	public boolean escribirFichero(ArrayList<Cancion> canciones, String nombrePlaylist) {
		try {
			BufferedWriter escribirFichero = new BufferedWriter(new FileWriter("ficheros/" + nombrePlaylist + ".txt"));
			for (int i = 0; i < canciones.size(); i++) {
				escribirFichero.write(canciones.get(i).toString());
				escribirFichero.newLine();
				escribirFichero.write("\n*******************************************************\n");
				escribirFichero.newLine();
			}
			escribirFichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
}
