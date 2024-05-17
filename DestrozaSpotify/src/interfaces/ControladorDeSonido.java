package interfaces;

import javax.swing.JButton;

public interface ControladorDeSonido {

	/**
	 * Metodo para ver si la cancion/podcast esta en reproduccion y pararla
	 * @param can
	 */
	void setCancionEnReproduccion(int can);

	/**
	 * Metodo para reproducir la cancion/podcast pasandole un numero, el cual sería la cancion siguente o la presente
	 * @param cola
	 */
	void reproducir(int cola);

	/**
	 * Metodo para parar la cancion
	 */
	void pausar();
 
	/**
	 * Metodo para poner la cancion en bucle 
	 * @param activo Mira si la cancion esta activa o no
	 * @param cola 
	 */
	void bucle(boolean activo, int cola);

	/**
	 * Metodo para generar numeros random y que no se repitan seguidos
	 * @return
	 */
	int ramdom();

	/**
	 * Recoge los segundos de la cancion/podcast
	 * @return
	 */
	long seguirCancion();

	/**
	 * Sigue la cancion/podcast por el segundo que se ha pausado
	 * @param play2
	 */
	void continuarCancion(JButton play2);

	/**
	 * Metodo para poner el anuncio
	 */
	void anuncio();

	/**
	 * Metodo para parar y cerrar la cancion/podcast
	 */
	void parar();
	
}