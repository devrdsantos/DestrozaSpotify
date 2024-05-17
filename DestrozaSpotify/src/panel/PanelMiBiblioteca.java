package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.GestionDeLaInformacion;
import controller.GestorDeFicheros;
import view.VistaPrincipal;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelMiBiblioteca extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelMiBiblioteca(VistaPrincipal v, GestionDeLaInformacion gestionINF, GestorDeFicheros ficheros) {
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
				v.cambiarDePanel(3);
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
		 * Boton para ir a perfil
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
				v.cambiarDePanel(19);
			}
		});
		add(btnPerfil);

		/**
		 * Enseña todas las playlist del cliente + la de Favoritos
		 */
		JList<String> listPlaylist = new JList<String>();
		DefaultListModel<String> modeloPlaylist = new DefaultListModel<String>();
		modeloPlaylist.addElement("Favoritos");
		for (int i = 0; i < gestionINF
				.devolverPlaylistCliente(gestionINF.devolverIdCliente(gestionINF.devolverUsuario())).size(); i++) {
			modeloPlaylist.addElement(
					gestionINF.devolverPlaylistCliente(gestionINF.devolverIdCliente(gestionINF.devolverUsuario()))
							.get(i).getNombre());
		}
		listPlaylist.setModel(modeloPlaylist);
		listPlaylist.setBounds(800, 175, 300, 400);
		listPlaylist.setBackground(new Color(44, 44, 44));
		listPlaylist.setForeground(Color.decode("#FFFFFF"));
		add(listPlaylist);

		JLabel lblMiPlaylist = new JLabel("Mi playlist:");
		lblMiPlaylist.setBounds(800, 125, 213, 34);
		lblMiPlaylist.setForeground(new Color(255, 255, 255));
		lblMiPlaylist.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblMiPlaylist);

		/**
		 * Boton para crear una nueva playlist
		 */
		JButton btnCrearNueva = new JButton("Crear nueva");
		btnCrearNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Fecha de creacion
				LocalDate fechaSinFormato = LocalDate.now();
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String fechaCreacion = formato.format(fechaSinFormato);

				// Titulo de la playlist
				JFrame f = new JFrame();
				String titulo = JOptionPane.showInputDialog(f, "Introduzca el nombre de la playlist:");

				gestionINF.insertPlaylist(titulo, fechaCreacion,
						gestionINF.devolverIdCliente(gestionINF.devolverUsuario()));

				v.cambiarDePanel(10);

			}
		});
		btnCrearNueva.setBounds(50, 225, 188, 40);
		btnCrearNueva.setOpaque(true);
		btnCrearNueva.setForeground(new Color(255, 170, 67));
		btnCrearNueva.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCrearNueva.setBorderPainted(false);
		btnCrearNueva.setBackground(new Color(63, 61, 61));
		add(btnCrearNueva);

		/**
		 * Boton para borrar playlist seleccionada
		 */
		JButton btnBorrarPlaylist = new JButton("Borrar playlist");
		btnBorrarPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listPlaylist.getSelectedValue().equals("Favoritos")) {
					JOptionPane.showMessageDialog(v, "La playlist favoritos no se puede borrar!");
				} else {
					gestionINF.deletePlaylist(listPlaylist.getSelectedValue());
					v.cambiarDePanel(10);
				}
			}
		});
		btnBorrarPlaylist.setBounds(50, 276, 188, 40);
		btnBorrarPlaylist.setOpaque(true);
		btnBorrarPlaylist.setForeground(new Color(255, 170, 67));
		btnBorrarPlaylist.setFont(new Font("Dialog", Font.BOLD, 16));
		btnBorrarPlaylist.setBorderPainted(false);
		btnBorrarPlaylist.setBackground(new Color(63, 61, 61));
		add(btnBorrarPlaylist);

		JButton btnImportar = new JButton("Importar");
		btnImportar.setBounds(50, 327, 188, 40);
		btnImportar.setOpaque(true);
		btnImportar.setForeground(new Color(255, 170, 67));
		btnImportar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnImportar.setBorderPainted(false);
		btnImportar.setBackground(new Color(63, 61, 61));
		add(btnImportar);

		/**
		 * Exportar las canciones de la playlist seleccionada
		 */
		JButton btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listPlaylist.getSelectedValue().equals("Favoritos")) {
					ficheros.escribirFichero(gestionINF.cancionesDePlaylistFavoritos(), "Favoritos");
					JOptionPane.showMessageDialog(v, "Fichero creado correctamente!");
				} else {
					ficheros.escribirFichero(gestionINF.devolverCancionesPorTituloPlaylist(listPlaylist.getSelectedValue()), listPlaylist.getSelectedValue());
					JOptionPane.showMessageDialog(v, "Fichero creado correctamente!");
				}
			}
		});
		btnExportar.setBounds(50, 378, 188, 40);
		btnExportar.setOpaque(true);
		btnExportar.setForeground(new Color(255, 170, 67));
		btnExportar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnExportar.setBorderPainted(false);
		btnExportar.setBackground(new Color(63, 61, 61));
		add(btnExportar);

		/**
		 * Boton para ver el contenido de la playlist seleccionada
		 */
		JButton btnVerPlaylist = new JButton("Ver playlist");
		btnVerPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listPlaylist.getSelectedValue().equalsIgnoreCase("Favoritos")) {
					gestionINF.favoritosSeleccionado(listPlaylist.getSelectedValue());
					gestionINF.playlistFavoritos(gestionINF.devolverIdCliente(gestionINF.devolverUsuario()));
					v.cambiarDePanel(15);
				} else {
					gestionINF.favoritosSeleccionado(listPlaylist.getSelectedValue());
					gestionINF.recogerNombrePlaylist(listPlaylist.getSelectedValue());
					v.cambiarDePanel(15);
				}
			}
		});
		btnVerPlaylist.setBounds(50, 480, 188, 40);
		btnVerPlaylist.setOpaque(true);
		btnVerPlaylist.setForeground(new Color(255, 170, 67));
		btnVerPlaylist.setFont(new Font("Dialog", Font.BOLD, 16));
		btnVerPlaylist.setBorderPainted(false);
		btnVerPlaylist.setBackground(new Color(63, 61, 61));
		add(btnVerPlaylist);
	}
}
