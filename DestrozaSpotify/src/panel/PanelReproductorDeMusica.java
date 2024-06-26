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

public class PanelReproductorDeMusica extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ControladorDeSonido sonido;

	private int intinerador = 0;
	private boolean bucle = false;
	private boolean anuncio = false;

	private ArrayList<Cancion> canciones;
	private ArrayList<Musico> artistas;

//	private JButton btnAleatorio;
	private JButton btnAnterior;
	private JButton btnPlay;
	private JButton btnSiguente;
	private JButton btnBucle;
	private JButton btnPlay2;
	private JLabel lblPortada;
	private JLabel lblCancion;
	private JLabel lblArtista;

	public PanelReproductorDeMusica(VistaPrincipal v, GestionDeLaInformacion gestionINF) {

		canciones = gestionINF.mostrarCancion();
		artistas = gestionINF.mostrarArtista();

		sonido = new ControladorDeSonido(canciones);

		intinerador = gestionINF.devolcerIndiceDeLaCancion();

		setSize(1200, 720);
		setVisible(true);
		setFont(new Font("Open Sans", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));
		;

		JButton btnAtras = new JButton("Ir atrás");
		btnAtras.setBounds(74, 32, 137, 52);
		btnAtras.setFont(new Font("Open Sans", Font.BOLD, 16));

		/**
		 * ACCION DEL BOTON
		 */
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarDePanel(8);
				sonido.pausar();
			}
		});
		setLayout(null);
		btnAtras.setBackground(Color.decode("#3f3d3d"));
		btnAtras.setForeground(Color.decode("#ffaa43"));
		btnAtras.setOpaque(true);
		btnAtras.setBorderPainted(false);
		add(btnAtras);

		lblPortada = new JLabel();
		lblPortada.setIcon(gestionINF.mostrarCancion().get(intinerador).getImagen());
		lblPortada.setBounds(480, 50, 500, 500);
		add(lblPortada);

		btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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

		btnPlay2 = new JButton("Stop");
		btnPlay2.setVisible(false);
		btnPlay2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

		btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Para que vuelva atras sin dar errores
				if (intinerador == 0) {
					intinerador = canciones.size() - 1;
				} else {
					intinerador = (intinerador - 1) % gestionINF.mostrarCancion().size();
				}

				if (gestionINF.devolverPremiun() == true) {
					System.out.println("Premiun");

					sonido.setCancionEnReproduccion(intinerador);

					lblPortada.setIcon(canciones.get(intinerador).getImagen());
					lblCancion.setText("<html>" + canciones.get(intinerador).getNombre() + "</html>");

					btnBucle.setForeground(new Color(255, 170, 67));
					bucle = false;

					btnPlay.setVisible(true);
					btnPlay2.setVisible(false);
				} else {

					if (!anuncio) {
						System.out.println("anuncio");
						sonido.parar();
						sonido.anuncio();
						lblPortada.setIcon(new ImageIcon("anuncio/Anuncio.jpg"));
						lblCancion.setText("");
						lblArtista.setText("");
						anuncio = true;
						btnPlay.setVisible(false);
						btnPlay2.setVisible(true);
					} else {
						System.out.println("no anuncio");
						intinerador = sonido.ramdom();

						sonido.reproducir(intinerador);

						lblPortada.setIcon(canciones.get(intinerador).getImagen());
						lblCancion.setText("<html>" + canciones.get(intinerador).getNombre() + "</html>");
						lblArtista.setText("<html>" + gestionINF.devolverArtista() + "</html>");
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

		btnSiguente = new JButton(">");
		btnSiguente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gestionINF.devolverPremiun() == true) {
					System.out.println("Premiun");

					intinerador = (intinerador + 1) % canciones.size();
					sonido.setCancionEnReproduccion(intinerador);
					lblPortada.setIcon(canciones.get(intinerador).getImagen());
					lblCancion.setText("<html>" + canciones.get(intinerador).getNombre() + "</html>");
					btnBucle.setForeground(new Color(255, 170, 67));
					bucle = false;
					btnPlay.setVisible(true);
					btnPlay2.setVisible(false);

				} else {
					System.out.println("No Premiun");
					intinerador = sonido.ramdom();
					sonido.reproducir(intinerador);
					lblPortada.setIcon(canciones.get(intinerador).getImagen());
					lblCancion.setText("<html>" + canciones.get(intinerador).getNombre() + "</html>");
					lblArtista.setText("<html>" + gestionINF.devolverArtista() + "</html>");
					btnBucle.setForeground(new Color(255, 170, 67));
					bucle = false;
					btnPlay.setVisible(false);
					btnPlay2.setVisible(true);

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

		btnBucle = new JButton("Bucle");
		btnBucle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bucle) {
					btnPlay.setVisible(true);
					btnPlay2.setVisible(false);
					btnBucle.setForeground(new Color(255, 170, 67));
					bucle = false;

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

		lblCancion = new JLabel("Pruebas");
		lblCancion.setText("<html>" + canciones.get(intinerador).getNombre() + "</html>");
		lblCancion.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCancion.setForeground(new Color(255, 255, 255));
		lblCancion.setBounds(125, 140, 350, 50);
		add(lblCancion);

		lblArtista = new JLabel("Pruebas");
		lblArtista.setText("<html>" + gestionINF.devolverArtista() + "</html>");
		lblArtista.setForeground(new Color(255, 255, 255));
		lblArtista.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblArtista.setBounds(125, 185, 240, 30);
		add(lblArtista);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMenu.setOpaque(true);
		btnMenu.setForeground(new Color(255, 170, 67));
		btnMenu.setFont(new Font("Dialog", Font.BOLD, 16));
		btnMenu.setBorderPainted(false);
		btnMenu.setBackground(new Color(63, 61, 61));
		btnMenu.setBounds(125, 366, 180, 40);
		add(btnMenu);
		
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
