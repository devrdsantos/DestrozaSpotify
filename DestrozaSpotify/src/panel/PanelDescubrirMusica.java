package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.GestionDeLaInformacion;
import view.VistaPrincipal;

public class PanelDescubrirMusica extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String generoSeleccionado;

	public PanelDescubrirMusica(VistaPrincipal v, GestionDeLaInformacion gestionINF) {

//		gestionINF.mostrarCancion();
		setLayout(null);
		setSize(1200, 720);
		setVisible(true);
		setFont(new Font("Open Sans", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));
		
		/**
		 * BTN - Atrás
		 */
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarDePanel(3);
			}
		});
		btnAtras.setFont(new Font("Verdana", Font.BOLD, 14));
		btnAtras.setOpaque(true);
		btnAtras.setContentAreaFilled(true);
		btnAtras.setForeground(Color.decode("#FFFFFF"));
		btnAtras.setBorderPainted(false);
		btnAtras.setBackground(Color.decode("#353535"));
		btnAtras.setBounds(52, 54, 100, 40);
		add(btnAtras);

		/**
		 * BTN - Perfil
		 */
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setOpaque(true);
		btnPerfil.setForeground(Color.WHITE);
		btnPerfil.setFont(new Font("Verdana", Font.BOLD, 14));
		btnPerfil.setContentAreaFilled(true);
		btnPerfil.setBorderPainted(false);
		btnPerfil.setBackground(new Color(53, 53, 53));
		btnPerfil.setBounds(1038, 54, 100, 40);
		add(btnPerfil);
		
		
		

		JComboBox<String> comboBoxGeneros = new JComboBox<String>();
		comboBoxGeneros.setFont(new Font("Verdana", Font.PLAIN, 14));
		comboBoxGeneros.setBackground(Color.decode("#DDDDDD"));
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

		JList<String> listaArtistasPorGenero = new JList<String>();
		listaArtistasPorGenero.setFont(new Font("Verdana", Font.PLAIN, 14));
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
		listaArtistasPorGenero.setBounds(100, 320, 1000, 313);
		listaArtistasPorGenero.setBackground(new Color(44, 44, 44));
		listaArtistasPorGenero.setForeground(Color.decode("#FFFFFF"));
		add(listaArtistasPorGenero);

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
		
		
		/**
		 * LBL - Fondo 
		 */
		JLabel lblImagen = new JLabel();
		lblImagen.setFont(new Font("Rubik", Font.PLAIN, 16));
		lblImagen.setBounds(0, 0, 1200, 720);
		lblImagen.setIcon(new ImageIcon("imagenes/varios/fondo-descubrirmusica.jpg"));
		add(lblImagen);
	}

}