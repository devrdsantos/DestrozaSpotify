package interfaces;

import javax.swing.JButton;

public interface ControladorDeSonido {

	void setCancionEnReproduccion(int can);

	void reproducir(int cola);

	void pausar();

	boolean cancionActiva();

	void bucle(boolean activo, int cola);

	int ramdom();

	long seguirCancion();

	void continuarCancion(JButton play2);

	void anuncio();

	void parar();

}