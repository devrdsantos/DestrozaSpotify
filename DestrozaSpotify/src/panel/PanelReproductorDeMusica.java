package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import controller.ControladorDeSonidoCancion;
import controller.GestionDeLaInformacion;
import interfaces.ControladorDeSonido;
import model.Cancion;
import view.VistaPrincipal;

public class PanelReproductorDeMusica extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int intinerador = 0;
	private boolean bucle = false;
	private boolean anuncio = false;

	/**
	 * Declaramos un arraylist de tipo Cancion para almacenar las canciones que
	 * queremos reproducir
	 */
	private ArrayList<Cancion> canciones;
	/**
	 * Declaramos el controlador de sonido
	 */
	private ControladorDeSonido sonido;

//	private JButton btnAleatorio;
	private JButton btnAnterior;
	private JButton btnPlay;
	private JButton btnPlay2;
	private JButton btnSiguente;
	private JButton btnBucle;
	private JButton btnPause;
	private JLabel lblPortadaCancion;
	private JLabel lblTituloCancion;
	private JLabel lblNombreArtista;
	private JButton btnFavoritos;
	private JButton btnMenu;
	private JLabel lblReproduciendo;
	private JLabel lblAlbum;

	public PanelReproductorDeMusica(VistaPrincipal v, GestionDeLaInformacion gestionINF) {

		Timer timerAnuncio = new Timer(34000, new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btnSiguente.setEnabled(true);
		        btnAnterior.setEnabled(true);
		    }
		});
		
		Timer timer = new Timer(180000, new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btnSiguente.setEnabled(true);
		    }
		});
		
		/**
		 * Le asignamos valor al arraylist canciones
		 */
		canciones = gestionINF.mostrarCancion();
		/**
		 * Inicializamos la variable sonido y le pasamos como parametro las canciones
		 */
		sonido = new ControladorDeSonidoCancion(canciones);

		/**
		 * Declaramos un contador
		 */
		intinerador = gestionINF.devolverIndiceDeLaCancion();

		setSize(1200, 720);
		setVisible(true);
		setFont(new Font("Open Sans", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));
		;

		setLayout(null);
		



		/**
		 * BTN - Atrás
		 */
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sonido.parar();
				v.cambiarDePanel(8);
			}
		});
		btnAtras.setFont(new Font("Verdana", Font.BOLD, 16));
		btnAtras.setOpaque(true);
		btnAtras.setContentAreaFilled(true);
		btnAtras.setForeground(Color.decode("#FFFFFF"));
		btnAtras.setBorderPainted(false);
		btnAtras.setBackground(Color.decode("#353535"));
		btnAtras.setBounds(52, 34, 136, 48);
		add(btnAtras);
		
		/**
		 * BTN - Perfil
		 */
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setOpaque(true);
		btnPerfil.setForeground(Color.WHITE);
		btnPerfil.setFont(new Font("Verdana", Font.BOLD, 16));
		btnPerfil.setContentAreaFilled(true);
		btnPerfil.setBorderPainted(false);
		btnPerfil.setBackground(new Color(53, 53, 53));
		btnPerfil.setBounds(1009, 34, 136, 48);
		btnPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sonido.parar();
				v.cambiarDePanel(17);
			}
		});
		add(btnPerfil);


		/**
		 * Label donde se muestra la imagen de la portada de la canción
		 */
		lblPortadaCancion = new JLabel();
		lblPortadaCancion.setIcon(gestionINF.mostrarCancion().get(intinerador).getImagen());
		lblPortadaCancion.setBounds(356, 129, 440, 360);
		add(lblPortadaCancion);

		/**
		 * Boton de play
		 */
		btnPlay = new JButton("▶");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/**
				 * Condicional que decide si se pasan los anuncios
				 */
				if (anuncio) {
					sonido.anuncio();
					btnPlay.setVisible(false);
					btnPause.setVisible(true);
				} else {
					sonido.reproducir(intinerador);
					btnPlay.setVisible(false);
					btnPause.setVisible(true);
				}

			}
		});
		btnPlay.setOpaque(true);
		btnPlay.setForeground(new Color(255, 255, 255));
		btnPlay.setFont(new Font("Dialog", Font.BOLD, 12));
		btnPlay.setBorderPainted(false);
		btnPlay.setBackground(new Color(53, 53, 53));
		btnPlay.setBounds(546, 600, 60, 60);
		add(btnPlay);

		/**
		 * Boton Stop
		 */
		btnPause = new JButton("⏸");
		btnPause.setVisible(false);
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Metodo que detiene la canción.
				 */
				sonido.continuarCancion(btnPause);
			}
		});
		btnPause.setOpaque(true);
		btnPause.setForeground(new Color(255, 255, 255));
		btnPause.setFont(new Font("Dialog", Font.BOLD, 12));
		btnPause.setBorderPainted(false);
		btnPause.setBackground(new Color(63, 61, 61));
		btnPause.setBounds(546, 600, 60, 60);
		add(btnPause);
		
		
		/**
		 * Boton Stop
		 */
		btnPlay2 = new JButton("⏸");
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
		btnAnterior = new JButton("⏪");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Condicional para volver atras de acuerdo al contador
				 */
				if (intinerador == 0) {
					intinerador = canciones.size() - 1;
				} else {
					intinerador = (intinerador - 1) % gestionINF.mostrarCancion().size();
				}

				/**
				 * Verifica si eres premium
				 */
				if (gestionINF.devolverPremiun().equalsIgnoreCase("Premiun")) {
					sonido.setCancionEnReproduccion(intinerador);

					lblPortadaCancion.setIcon(canciones.get(intinerador).getImagen());
					lblTituloCancion.setText("<html>" + canciones.get(intinerador).getNombre() + "</html>");

					btnBucle.setForeground(new Color(255, 255, 255));
					bucle = false;

					btnPlay.setVisible(true);
					btnPause.setVisible(false);
				} else {
					/**
					 * Condicional para ver si anuncio es false, si lo es reproduce un anuncio
					 */
					if (!anuncio) {
						btnSiguente.setEnabled(false);
						btnAnterior.setEnabled(false);
						btnBucle.setVisible(false);
						btnPlay.setVisible(false);
						btnMenu.setVisible(false);
						btnFavoritos.setVisible(false);
						btnPause.setVisible(true);
						timerAnuncio.restart();
									
						sonido.parar();
						sonido.anuncio();
						lblPortadaCancion.setIcon(new ImageIcon("anuncio/Anuncio.jpg"));
						lblTituloCancion.setText("");
						lblNombreArtista.setText("");
						anuncio = true;
						btnBucle.setForeground(new Color(255, 255, 255));
					} else {
						btnAnterior.setEnabled(false);
						btnSiguente.setEnabled(false);
						timer.restart();
						
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
						lblNombreArtista.setText("<html>" + gestionINF.devolverArtista() + "</html>");
						btnBucle.setForeground(new Color(255, 255, 255));
						bucle = false;
						anuncio = false;
						btnPlay.setVisible(false);
						btnPause.setVisible(true);
						btnSiguente.setEnabled(true);
						btnAnterior.setEnabled(true);
						btnBucle.setVisible(true);
						btnMenu.setVisible(true);
						btnFavoritos.setVisible(true);
					}

				}

			}
		});
		btnAnterior.setOpaque(true);
		btnAnterior.setForeground(new Color(255, 255, 255));
		btnAnterior.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnAnterior.setBorderPainted(false);
		btnAnterior.setBackground(new Color(53, 53, 53));
		btnAnterior.setBounds(486, 600, 60, 60);
		add(btnAnterior);

		/**
		 * Boton siguiente
		 */
		btnSiguente = new JButton("⏩");
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
					btnBucle.setForeground(new Color(255, 255, 255));
					bucle = false;
					btnPlay.setVisible(true);
					btnPause.setVisible(false);

				} else {
					/**
					 * condicional para ver si es un anuncio
					 */
					if (!anuncio) {
//						System.out.println("anuncio");
						btnSiguente.setEnabled(false);
						btnAnterior.setEnabled(false);
						btnBucle.setVisible(false);
						btnPlay.setVisible(false);
						btnMenu.setVisible(false);
						btnFavoritos.setVisible(false);
						btnPause.setVisible(true);
						timerAnuncio.restart();
						
						sonido.parar();
						sonido.anuncio();
						lblPortadaCancion.setIcon(new ImageIcon("anuncio/Anuncio.jpg"));
						lblTituloCancion.setText("");
						lblNombreArtista.setText("");
						anuncio = true;
						btnBucle.setForeground(new Color(255, 255, 255));
					} else {
						btnAnterior.setEnabled(false);
						btnSiguente.setEnabled(false);
						timer.restart();
						
						System.out.println("No Premiun");
						intinerador = sonido.ramdom();
						sonido.reproducir(intinerador);
						lblPortadaCancion.setIcon(canciones.get(intinerador).getImagen());
						lblTituloCancion.setText("<html>" + canciones.get(intinerador).getNombre() + "</html>");
						lblNombreArtista.setText("<html>" + gestionINF.devolverArtista() + "</html>");
						btnBucle.setForeground(new Color(255, 255, 255));
						bucle = false;
						anuncio = false;
						btnPlay.setVisible(false);
						btnPause.setVisible(true);
						btnSiguente.setEnabled(true);
						btnAnterior.setEnabled(true);
						btnBucle.setVisible(true);
						btnMenu.setVisible(true);
						btnFavoritos.setVisible(true);
					}
				}
			}
		});
		btnSiguente.setOpaque(true);
		btnSiguente.setForeground(new Color(255, 255, 255));
		btnSiguente.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnSiguente.setBorderPainted(false);
		btnSiguente.setBackground(new Color(53, 53, 53));
		btnSiguente.setBounds(607, 600, 60, 60);
		add(btnSiguente);

		/**
		 * Boton bucle
		 */
		btnBucle = new JButton("🔁 ");
		btnBucle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Condicional para saber si el boton bucle es true
				 */
				if (bucle) {
					btnPlay.setVisible(true);
					btnPause.setVisible(false);
					btnBucle.setForeground(new Color(255, 255, 255));
					bucle = false;

					/**
					 * metodo para colocar la cancion en bucle
					 */
					sonido.bucle(bucle, intinerador);

				} else {
					btnPlay.setVisible(false);
					btnPause.setVisible(true);
					btnBucle.setForeground(new Color(255, 170, 67));
					bucle = true;
					sonido.bucle(bucle, intinerador);

				}
			}
		});
		btnBucle.setOpaque(true);
		btnBucle.setForeground(new Color(255, 255, 255));
		btnBucle.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnBucle.setBorderPainted(false);
		btnBucle.setBackground(new Color(53, 53, 53));
		btnBucle.setBounds(424, 600, 60, 60);
		add(btnBucle);

		lblTituloCancion = new JLabel();
		lblTituloCancion.setText("<html>" + canciones.get(intinerador).getNombre() + "</html>");
		lblTituloCancion.setFont(new Font("Verdana", Font.BOLD, 20));
		lblTituloCancion.setForeground(new Color(255, 255, 255));
		lblTituloCancion.setBounds(356, 499, 440, 50);
		add(lblTituloCancion);

		lblNombreArtista = new JLabel();
		lblNombreArtista.setText("<html>" + gestionINF.devolverArtista() + "</html>");
		lblNombreArtista.setForeground(Color.decode("#FFB850"));
		lblNombreArtista.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombreArtista.setBounds(356, 560, 298, 30);
		add(lblNombreArtista);

		btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame f = new JFrame();
				String playlist = JOptionPane.showInputDialog(f, "Introduzca el nombre de la playlist:");

				if (gestionINF.capacidadDePlaylist(gestionINF.devolverIdPlaylist(playlist)) == 3) {
					JOptionPane.showMessageDialog(null,
							"Has llegado a la capacidad maxima de la playlist " + playlist + "!!");
				} else {
					gestionINF.añadirCancionAPlaylist(
							gestionINF.sacarIdDelAudio(canciones.get(intinerador).getNombre()),
							gestionINF.devolverIdPlaylist(playlist));
				}
			}
		});
		btnMenu.setOpaque(true);
		btnMenu.setForeground(new Color(255, 170, 67));
		btnMenu.setFont(new Font("Dialog", Font.BOLD, 16));
		btnMenu.setBorderPainted(false);
		btnMenu.setBackground(new Color(63, 61, 61));
		btnMenu.setBounds(125, 366, 180, 40);
		add(btnMenu);

		/**
		 * Boton favoritos, cuando lo clickeas se añade la cancion actual a la playlist
		 * favoritos
		 */
		
		btnFavoritos = new JButton("❤");
		btnFavoritos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionINF.favoritos(gestionINF.devolverIdCliente(gestionINF.devolverUsuario()),
						gestionINF.sacarIdDelAudio(canciones.get(intinerador).getNombre()));
			}
		});
		btnFavoritos.setOpaque(true);
		btnFavoritos.setForeground(new Color(255, 255, 255));
		btnFavoritos.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnFavoritos.setBorderPainted(false);
		btnFavoritos.setBackground(new Color(53, 53, 53));
		btnFavoritos.setBounds(668, 600, 60, 60);
		add(btnFavoritos);
		
		lblReproduciendo = new JLabel("REPRODUCIENDO DESDE ÁLBUM");
		lblReproduciendo.setForeground(new Color(255, 255, 255));
		lblReproduciendo.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblReproduciendo.setBounds(456, 51, 234, 30);
		add(lblReproduciendo);
		
		lblAlbum = new JLabel(".getNombreAlbum()");
		lblAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbum.setForeground(Color.decode("#FFB850"));
		lblAlbum.setFont(new Font("Verdana", Font.BOLD, 16));
		lblAlbum.setBounds(356, 77, 391, 41);
		lblAlbum.setText(gestionINF.devolerAlbum());
		add(lblAlbum);

	}
}

