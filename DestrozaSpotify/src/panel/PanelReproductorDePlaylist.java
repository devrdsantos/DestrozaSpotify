package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ControladorDeSonido;
import controller.GestionDeLaInformacion;
import model.Cancion;
import model.Musico;
import view.VistaPrincipal;

public class PanelReproductorDePlaylist extends JPanel {

	private int intinerador = 0;
	private boolean bucle = false;
	private boolean anuncio = false;

	/**
	 * Declaramos un arraylist de tipo Cancion para almacenar las canciones que
	 * queremos reproducir
	 */
	private ArrayList<Cancion> canciones;
	private ArrayList<Musico> musico;
	/**
	 * Declaramos el controlador de sonido
	 */
	private ControladorDeSonido sonido;

//	private JButton btnAleatorio;
	private JButton btnAnterior;
	private JButton btnPlay;
	private JButton btnSiguente;
	private JButton btnBucle;
	private JButton btnPlay2;
	private JLabel lblPortadaCancion;
	private JLabel lblTituloCancion;
	private JLabel lblNombreArtista;

	public PanelReproductorDePlaylist(VistaPrincipal v, GestionDeLaInformacion gestionINF) {
		/**
		 * Le asignamos valor al arraylist canciones
		 */
		
		if (gestionINF.devolverFavoritosSeleccionado() == true) {
			canciones = gestionINF.cancionesDePlaylistFavoritos();
			musico = gestionINF.artistasDePlaylistFavoritos(gestionINF.devolverIdCliente(gestionINF.devolverUsuario()));
		} else {
			canciones = gestionINF.devolverCancionesPorTituloPlaylist(gestionINF.devolverNombrePlaylist());
			musico = gestionINF.devolverMusicoPorTituloPlaylist(gestionINF.devolverNombrePlaylist());
		}
		
		/**
		 * Inicializamos la variable sonido y le pasamos como parametro las canciones
		 */
		sonido = new ControladorDeSonido(canciones);

		/**
		 * Declaramos un contador
		 */
		intinerador = gestionINF.devolverIndiceDeLaCancion();
		
		setSize(1200, 720);
		setVisible(true);
		setFont(new Font("Open Sans", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));
		;

		/**
		 * Boton Atrás
		 */
		JButton btnAtras = new JButton("Ir atrás");
		btnAtras.setBounds(74, 32, 137, 52);
		btnAtras.setFont(new Font("Open Sans", Font.BOLD, 16));

		/**
		 * ACCION DEL BOTON
		 */
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarDePanel(10);
				sonido.pausar();
			}
		});
		setLayout(null);
		btnAtras.setBackground(Color.decode("#3f3d3d"));
		btnAtras.setForeground(Color.decode("#ffaa43"));
		btnAtras.setOpaque(true);
		btnAtras.setBorderPainted(false);
		add(btnAtras);

		/**
		 * Label donde se muestra la imagen de la portada de la canción
		 */
		lblPortadaCancion = new JLabel();
		lblPortadaCancion.setIcon(canciones.get(intinerador).getImagen());
		lblPortadaCancion.setBounds(480, 50, 500, 500);
		add(lblPortadaCancion);

		/**
		 * Boton de play
		 */
		btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/**
				 * Condicional que decide si se pasan los anuncios
				 */
				if (anuncio) {
					sonido.anuncio();
					btnPlay.setVisible(false);
					btnPlay2.setVisible(true);
				} else {
					sonido.reproducir(intinerador);
					btnPlay.setVisible(false);
					btnPlay2.setVisible(true);
				}

			}
		});
		btnPlay.setOpaque(true);
		btnPlay.setForeground(new Color(255, 170, 67));
		btnPlay.setFont(new Font("Dialog", Font.BOLD, 16));
		btnPlay.setBorderPainted(false);
		btnPlay.setBackground(new Color(63, 61, 61));
		btnPlay.setBounds(665, 570, 130, 52);
		add(btnPlay);

		/**
		 * Boton Stop
		 */
		btnPlay2 = new JButton("Stop");
		btnPlay2.setVisible(false);
		btnPlay2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Metodo que detiene la canción.
				 */
				sonido.continuarCancion(btnPlay2);
			}
		});
		btnPlay2.setOpaque(true);
		btnPlay2.setForeground(new Color(255, 170, 67));
		btnPlay2.setFont(new Font("Dialog", Font.BOLD, 16));
		btnPlay2.setBorderPainted(false);
		btnPlay2.setBackground(new Color(63, 61, 61));
		btnPlay2.setBounds(665, 570, 130, 52);
		add(btnPlay2);

		/**
		 * Boton para ir a la canción anterior
		 */
		btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Condicional para volver atras de acuerdo al contador
				 */
				if (intinerador == 0) {
					intinerador = canciones.size() - 1;
				} else {
					intinerador = (intinerador - 1) % canciones.size();
				}

				/**
				 * Verifica si eres premium
				 */
				if (gestionINF.devolverPremiun().equalsIgnoreCase("Premiun")) {
					System.out.println("Premiun");

					sonido.setCancionEnReproduccion(intinerador);

					lblPortadaCancion.setIcon(canciones.get(intinerador).getImagen());
					lblTituloCancion.setText("<html>" + canciones.get(intinerador).getNombre() + "</html>");
					lblNombreArtista.setText("<html>" + musico.get(intinerador).getNombreArtistico() + "</html>");
					btnBucle.setForeground(new Color(255, 170, 67));
					bucle = false;

					btnPlay.setVisible(true);
					btnPlay2.setVisible(false);
				} else {
					/**
					 * Condicional para ver si anuncio es false, si lo es reproduce un anuncio
					 */
					if (!anuncio) {
//						System.out.println("anuncio");
						sonido.parar();
						sonido.anuncio();
						lblPortadaCancion.setIcon(new ImageIcon("anuncio/Anuncio.jpg"));
						lblTituloCancion.setText("");
						lblNombreArtista.setText("");
						anuncio = true;
						btnPlay.setVisible(false);
						btnPlay2.setVisible(true);
					} else {
//						System.out.println("no anuncio");
						/**
						 * le asignamos un numero random al contador
						 */
						intinerador = sonido.ramdom();

						/**
						 * reproducimos una cancion de acuerdo al contador
						 */
						sonido.reproducir(intinerador);

						lblPortadaCancion.setIcon(canciones.get(intinerador).getImagen());
						lblTituloCancion.setText("<html>" + canciones.get(intinerador).getNombre() + "</html>");
						lblNombreArtista.setText("<html>" + musico.get(intinerador).getNombreArtistico() + "</html>");
						btnBucle.setForeground(new Color(255, 170, 67));
						bucle = false;
						anuncio = false;
						btnPlay.setVisible(false);
						btnPlay2.setVisible(true);
					}

				}

			}
		});
		btnAnterior.setOpaque(true);
		btnAnterior.setForeground(new Color(255, 170, 67));
		btnAnterior.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAnterior.setBorderPainted(false);
		btnAnterior.setBackground(new Color(63, 61, 61));
		btnAnterior.setBounds(480, 570, 130, 52);
		add(btnAnterior);

		/**
		 * Boton siguiente
		 */
		btnSiguente = new JButton(">");
		btnSiguente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Condicional para saber si es premium
				 */
				if (gestionINF.devolverPremiun().equalsIgnoreCase("Premiun")) {
//					System.out.println("Premiun");

					intinerador = (intinerador + 1) % canciones.size();
					sonido.setCancionEnReproduccion(intinerador);
					lblPortadaCancion.setIcon(canciones.get(intinerador).getImagen());
					lblTituloCancion.setText("<html>" + canciones.get(intinerador).getNombre() + "</html>");
					lblNombreArtista.setText("<html>" + musico.get(intinerador).getNombreArtistico() + "</html>");
					btnBucle.setForeground(new Color(255, 170, 67));
					bucle = false;
					btnPlay.setVisible(true);
					btnPlay2.setVisible(false);

				} else {
					/**
					 * condicional para ver si es un anuncio
					 */
					if (!anuncio) {
//						System.out.println("anuncio");
						sonido.parar();
						sonido.anuncio();
						lblPortadaCancion.setIcon(new ImageIcon("anuncio/Anuncio.jpg"));
						lblTituloCancion.setText("");
						lblNombreArtista.setText("");
						anuncio = true;
						btnPlay.setVisible(false);
						btnPlay2.setVisible(true);
					} else {
//						System.out.println("No Premiun");
						intinerador = sonido.ramdom();
						sonido.reproducir(intinerador);
						lblPortadaCancion.setIcon(canciones.get(intinerador).getImagen());
						lblTituloCancion.setText("<html>" + canciones.get(intinerador).getNombre() + "</html>");
						lblNombreArtista.setText("<html>" + musico.get(intinerador).getNombreArtistico() + "</html>");
						btnBucle.setForeground(new Color(255, 170, 67));
						bucle = false;
						btnPlay.setVisible(false);
						btnPlay2.setVisible(true);
					}
				}

			}
		});
		btnSiguente.setOpaque(true);
		btnSiguente.setForeground(new Color(255, 170, 67));
		btnSiguente.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSiguente.setBorderPainted(false);
		btnSiguente.setBackground(new Color(63, 61, 61));
		btnSiguente.setBounds(850, 570, 130, 52);
		add(btnSiguente);

		/**
		 * Boton bucle
		 */
		btnBucle = new JButton("Bucle");
		btnBucle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Condicional para saber si el boton bucle es true
				 */
				if (bucle) {
					btnPlay.setVisible(true);
					btnPlay2.setVisible(false);
					btnBucle.setForeground(new Color(255, 170, 67));
					bucle = false;

					/**
					 * metodo para colocar la cancion en bucle
					 */
					sonido.bucle(bucle, intinerador);

				} else {
					btnPlay.setVisible(false);
					btnPlay2.setVisible(true);
					btnBucle.setForeground(new Color(0, 255, 0));
					bucle = true;
					sonido.bucle(bucle, intinerador);

				}
			}
		});
		btnBucle.setOpaque(true);
		btnBucle.setForeground(new Color(255, 170, 67));
		btnBucle.setFont(new Font("Dialog", Font.BOLD, 16));
		btnBucle.setBorderPainted(false);
		btnBucle.setBackground(new Color(63, 61, 61));
		btnBucle.setBounds(125, 315, 180, 40);
		add(btnBucle);

		lblTituloCancion = new JLabel();
		lblTituloCancion.setText("<html>" + canciones.get(intinerador).getNombre() + "</html>");
		lblTituloCancion.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTituloCancion.setForeground(new Color(255, 255, 255));
		lblTituloCancion.setBounds(125, 140, 350, 50);
		add(lblTituloCancion);

		lblNombreArtista = new JLabel();
		lblNombreArtista.setText("<html>" + musico.get(intinerador).getNombreArtistico() + "</html>");
		lblNombreArtista.setForeground(new Color(255, 255, 255));
		lblNombreArtista.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombreArtista.setBounds(125, 185, 240, 30);
		add(lblNombreArtista);

		
		 JButton btnMenu = new JButton("Menu"); btnMenu.addActionListener(new
		 ActionListener() { public void actionPerformed(ActionEvent e) { } });
		 btnMenu.setOpaque(true); btnMenu.setForeground(new Color(255, 170, 67));
		 btnMenu.setFont(new Font("Dialog", Font.BOLD, 16));
		 btnMenu.setBorderPainted(false); btnMenu.setBackground(new Color(63, 61,
		 61)); btnMenu.setBounds(125, 366, 180, 40); add(btnMenu);
		 add(btnMenu);

		/**
		 * Boton favoritos, cuando lo clickeas se añade la cancion actual a la playlist
		 * favoritos
		 */
		JButton btnFavoritos = new JButton("Favoritos");
		btnFavoritos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFavoritos.setOpaque(true);
		btnFavoritos.setForeground(new Color(255, 170, 67));
		btnFavoritos.setFont(new Font("Dialog", Font.BOLD, 16));
		btnFavoritos.setBorderPainted(false);
		btnFavoritos.setBackground(new Color(63, 61, 61));
		btnFavoritos.setBounds(125, 417, 180, 40);
		add(btnFavoritos);

	}
}
