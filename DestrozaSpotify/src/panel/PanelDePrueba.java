package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ControladorDeSonido;
import controller.GestionDeLaInformacion;
import view.VistaPrincipal;
import javax.swing.ImageIcon;

public class PanelDePrueba extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ControladorDeSonido sonido;

	private int intinerador = 0;
	private boolean bucle = false;
	private boolean random = false;

	private JButton btnAleatorio;
	private JButton btnAnterior;
	private JButton btnPlay;
	private JButton btnSiguente;
	private JButton btnBucle;
	private JButton btnPlay2;
	private JLabel lblPortada;
	private JLabel lblCancion;
	private JLabel lblArtista;

	public PanelDePrueba(VistaPrincipal v, GestionDeLaInformacion gestionINF) {

		sonido = new ControladorDeSonido(gestionINF.mostrarCancion());

		intinerador = gestionINF.devolcerIndiceDeLaCancion();
		
		setSize(1200, 720);
		setVisible(true);
		setFont(new Font("Open Sans", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));
		;

		JButton btnAtras = new JButton("Ir atrás");
		btnAtras.setBounds(32, 32, 137, 52);
		btnAtras.setFont(new Font("Open Sans", Font.BOLD, 16));

		/**
		 * ACCION DEL BOTON
		 */
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarDePanel(3);
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
		lblPortada.setBounds(450, 126, 325, 375);
		add(lblPortada);

		btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sonido.reproducir(intinerador);
				btnPlay.setVisible(false);
				btnPlay2.setVisible(true);
			}
		});
		btnPlay.setOpaque(true);
		btnPlay.setForeground(new Color(255, 170, 67));
		btnPlay.setFont(new Font("Dialog", Font.BOLD, 16));
		btnPlay.setBorderPainted(false);
		btnPlay.setBackground(new Color(63, 61, 61));
		btnPlay.setBounds(569, 542, 130, 52);
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
		btnPlay2.setBounds(569, 542, 130, 52);
		add(btnPlay2);

		btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!random) {
					// Para que vuelva atras sin dar errores
					if (intinerador == 0) {
						intinerador = gestionINF.mostrarCancion().size() - 1;
					} else {
						intinerador = (intinerador - 1) % gestionINF.mostrarCancion().size();
					}

					sonido.setCancionEnReproduccion(intinerador);

					lblPortada.setIcon(gestionINF.mostrarCancion().get(intinerador).getImagen());
					lblCancion.setText("<html>" + gestionINF.mostrarCancion().get(intinerador).getNombre() + "</html>");

					btnBucle.setForeground(new Color(255, 170, 67));
					bucle = false;

					btnPlay.setVisible(true);
					btnPlay2.setVisible(false);
				} else {

					intinerador = sonido.ramdom();

					sonido.reproducir(intinerador);

					lblPortada.setIcon(gestionINF.mostrarCancion().get(intinerador).getImagen());
					lblCancion.setText("<html>" + gestionINF.mostrarCancion().get(intinerador).getNombre() + "</html>");
//					lblArtista.setText("<html>" + gestionINF.mostrarAlbums().get(intinerador).getNombreArtista() + "</html>");
					btnBucle.setForeground(new Color(255, 170, 67));
					bucle = false;
					btnPlay.setVisible(false);
					btnPlay2.setVisible(true);
				}
			}
		});
		btnAnterior.setOpaque(true);
		btnAnterior.setForeground(new Color(255, 170, 67));
		btnAnterior.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAnterior.setBorderPainted(false);
		btnAnterior.setBackground(new Color(63, 61, 61));
		btnAnterior.setBounds(384, 542, 130, 52);
		add(btnAnterior);

		btnSiguente = new JButton(">");
		btnSiguente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!random) {
					intinerador = (intinerador + 1) % gestionINF.mostrarCancion().size();
					sonido.setCancionEnReproduccion(intinerador);
					lblPortada.setIcon(gestionINF.mostrarCancion().get(intinerador).getImagen());
					lblCancion.setText("<html>" + gestionINF.mostrarCancion().get(intinerador).getNombre() + "</html>");
					btnBucle.setForeground(new Color(255, 170, 67));
					bucle = false;
					btnPlay.setVisible(true);
					btnPlay2.setVisible(false);

				} else {

					intinerador = sonido.ramdom();
					sonido.reproducir(intinerador);
					lblPortada.setIcon(gestionINF.mostrarCancion().get(intinerador).getImagen());
					lblCancion.setText("<html>" + gestionINF.mostrarCancion().get(intinerador).getNombre() + "</html>");
//					lblArtista.setText(
//							"<html>" + gestionINF.mostrarAlbums().get(intinerador).getNombreArtista() + "</html>");
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
		btnSiguente.setBounds(754, 542, 130, 52);
		add(btnSiguente);

		btnAleatorio = new JButton("Aleatorio");
		btnAleatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (random) {
					btnAleatorio.setForeground(new Color(255, 170, 67));
					random = false;
				} else {
					btnAleatorio.setForeground(new Color(0, 255, 0));
					sonido.reproducir(intinerador);
					random = true;
				}
			}
		});
		btnAleatorio.setOpaque(true);
		btnAleatorio.setForeground(new Color(255, 170, 67));
		btnAleatorio.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAleatorio.setBorderPainted(false);
		btnAleatorio.setBackground(new Color(63, 61, 61));
		btnAleatorio.setBounds(194, 542, 130, 52);
		add(btnAleatorio);

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
		btnBucle.setBounds(944, 542, 130, 52);
		add(btnBucle);

		lblCancion = new JLabel("Pruebas");
		lblCancion.setText("<html>" + gestionINF.mostrarCancion().get(intinerador).getNombre() + "</html>");
		lblCancion.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCancion.setForeground(new Color(255, 255, 255));
		lblCancion.setBounds(168, 139, 240, 50);
		add(lblCancion);

		lblArtista = new JLabel("Pruebas");
		lblArtista.setText("<html>" +gestionINF.devolverArtista() + "</html>");
		lblArtista.setForeground(new Color(255, 255, 255));
		lblArtista.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblArtista.setBounds(168, 190, 240, 30);
		add(lblArtista);

	}
}
