package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.GestionBD;
import view.VistaPrincipal;

public class PanelPruebaDescubrirMusica extends JPanel {

	public PanelPruebaDescubrirMusica(VistaPrincipal v, GestionBD gestionBD) {
		setSize(1200, 720);
		setVisible(true);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));
		setLayout(null);
		
		
		/**
		 * BTN - Ir atrás
		 */
		JButton btnAtras = new JButton("Atrás");
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
		btnAtras.setBackground(Color.decode("#353535"));
		btnAtras.setForeground(Color.decode("#FFFFFF"));
		btnAtras.setOpaque(true);
		btnAtras.setBorderPainted(false);
		add(btnAtras);

		JLabel lblTitulo = new JLabel("Descubrir Música");
		lblTitulo.setBounds(325, 50, 524, 74);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 48));
		add(lblTitulo);
		
		/**
		 * BTN - Perfil
		 */
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setBounds(1000, 32, 137, 52);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPerfil.setOpaque(true);
		btnPerfil.setFont(new Font("Open Sans", Font.BOLD, 16));
		btnPerfil.setBorderPainted(false);
		
		btnPerfil.setBackground(Color.decode("#353535"));
		btnPerfil.setForeground(Color.decode("#FFFFFF"));
		add(btnPerfil);

		/**
		 * [COMBOBOX] - comboBoxGeneros
		 */
		JComboBox<String> comboBoxGeneros = new JComboBox<String>();
		comboBoxGeneros.setForeground(Color.decode("#DDDDDD"));
		comboBoxGeneros.setBounds(100, 213, 417, 33);
		comboBoxGeneros.addActionListener(new ActionListener() {// add actionlistner to listen for change
			@Override
			public void actionPerformed(ActionEvent e) {
				generoSeleccionado = comboBoxGeneros.getSelectedItem().toString();
			}
		});

		for (int i = 0; i < gestionINF.mostrarGeneros().size(); i++) {
			comboBoxGeneros.addItem(gestionINF.mostrarGeneros().get(i));
		}
		add(comboBoxGeneros);

		JLabel lblArtistasXGenero = new JLabel("Artistas por Género:");
		lblArtistasXGenero.setBounds(100, 161, 224, 41);
		lblArtistasXGenero.setForeground(new Color(255, 255, 255));
		lblArtistasXGenero.setHorizontalAlignment(SwingConstants.LEFT);
		lblArtistasXGenero.setFont(new Font("Verdana", Font.PLAIN, 18));
		add(lblArtistasXGenero);

		JLabel lblNewLabel = new JLabel("Resultados:");
		lblNewLabel.setBounds(100, 327, 159, 27);
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		add(lblNewLabel);

		/**
		 * [LIST] - Lista Artistas por Género
		 */
		JList<String> listaArtistasPorGenero = new JList<String>();
		listaArtistasPorGenero.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()) {
					gestionINF.artistaSeleccionado(listaArtistasPorGenero.getSelectedValue());
					v.cambiarDePanel(7);
				}
			}
		});
		DefaultListModel<String> artistaPorGenero = new DefaultListModel<String>();
		for (int i = 0; i < gestionINF.mostrarArtistasPorAlbum().size(); i++) {
			if (gestionINF.mostrarArtistasPorAlbum().get(i).equals(generoSeleccionado)) {
				artistaPorGenero.addElement(gestionINF.mostrarArtistasPorAlbum().get(i + 1));
			}
		}
		listaArtistasPorGenero.setModel(artistaPorGenero);
		listaArtistasPorGenero.setBounds(100, 364, 1000, 313);
		listaArtistasPorGenero.setBackground(Color.decode("#DDDDDD"));
		add(listaArtistasPorGenero);

		/**
		 * BTN - Buscar
		 */
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(527, 213, 117, 33);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				artistaPorGenero.removeAllElements();
				for (int i = 0; i < gestionINF.mostrarArtistasPorAlbum().size(); i++) {
					if (gestionINF.mostrarArtistasPorAlbum().get(i).equals(generoSeleccionado)) {
						artistaPorGenero.addElement(gestionINF.mostrarArtistasPorAlbum().get(i + 1));
					}
				}
			}
		});
		btnBuscar.setOpaque(true);
		btnBuscar.setForeground(Color.decode("#FFFFFF"));
		btnBuscar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnBuscar.setBorderPainted(false);
		btnBuscar.setBackground(Color.decode("#ED028B"));
		add(btnBuscar);
	}

	}}
