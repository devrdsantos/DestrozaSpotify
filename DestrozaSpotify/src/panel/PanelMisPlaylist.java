package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.GestionDeLaInformacion;
import view.VistaPrincipal;

public class PanelMisPlaylist extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelMisPlaylist(VistaPrincipal v, GestionDeLaInformacion gestionINF) {
		setSize(1200, 720);
		setVisible(true);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));
		setLayout(null);
		

		/**
		 * Boton Volver
		 */
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarDePanel(1);
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
		

		JList<String> listCanciones = new JList<String>();
		DefaultListModel<String> modeloPlaylist = new DefaultListModel<String>();
		for (int i = 0; i < gestionINF.devolverCancionesPorTituloPlaylist(gestionINF.devolverNombrePlaylist())
				.size(); i++) {
			modeloPlaylist.addElement(gestionINF.devolverCancionesPorTituloPlaylist(gestionINF.devolverNombrePlaylist())
					.get(i).getNombre());
		}
		listCanciones.setModel(modeloPlaylist);
		listCanciones.setBounds(800, 175, 300, 400);
		add(listCanciones);

		JLabel lblMisCanciones = new JLabel("Mis canciones:");
		lblMisCanciones.setBounds(800, 125, 213, 34);
		lblMisCanciones.setForeground(new Color(255, 255, 255));
		lblMisCanciones.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblMisCanciones);

		JButton btnBorrarCancion = new JButton("Borrar cancion");
		btnBorrarCancion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionINF.deleteCancionDePlaylist(gestionINF.sacarIdDelAudio(listCanciones.getSelectedValue()));

				v.cambiarDePanel(15);
			}
		});
		btnBorrarCancion.setBounds(50, 327, 188, 40);
		btnBorrarCancion.setOpaque(true);
		btnBorrarCancion.setForeground(new Color(255, 170, 67));
		btnBorrarCancion.setFont(new Font("Dialog", Font.BOLD, 16));
		btnBorrarCancion.setBorderPainted(false);
		btnBorrarCancion.setBackground(new Color(63, 61, 61));
		add(btnBorrarCancion);

		JButton btnAñadirCancion = new JButton("Añadir cancion");
		btnAñadirCancion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame();
				String titulo = JOptionPane.showInputDialog(f, "Introduzca el nombre de la cancion:");
				gestionINF.añadirCancionAPlaylist(gestionINF.sacarIdDelAudio(titulo),
						gestionINF.devolverIdPlaylist(gestionINF.devolverNombrePlaylist()));
				v.cambiarDePanel(15);
			}
		});
		btnAñadirCancion.setBounds(50, 276, 188, 40);
		btnAñadirCancion.setOpaque(true);
		btnAñadirCancion.setForeground(new Color(255, 170, 67));
		btnAñadirCancion.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAñadirCancion.setBorderPainted(false);
		btnAñadirCancion.setBackground(new Color(63, 61, 61));
		add(btnAñadirCancion);

		JButton btnReproducir = new JButton("Reproducir");
		btnReproducir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionINF.indiceDeLaCancion(listCanciones.getSelectedIndex());
				v.cambiarDePanel(16);
			}
		});
		btnReproducir.setBounds(50, 378, 188, 40);
		btnReproducir.setOpaque(true);
		btnReproducir.setForeground(new Color(255, 170, 67));
		btnReproducir.setFont(new Font("Dialog", Font.BOLD, 16));
		btnReproducir.setBorderPainted(false);
		btnReproducir.setBackground(new Color(63, 61, 61));
		add(btnReproducir);
	}

}
