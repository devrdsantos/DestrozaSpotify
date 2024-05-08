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
		 * BTN - Ir atrás
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


		JLabel lblTitulo = new JLabel("Descubrir Música");
		lblTitulo.setBounds(325, 50, 524, 74);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 48));
		add(lblTitulo);
		
		/**
		 * BOTON PERFIL
		 */
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setOpaque(true);
		btnPerfil.setForeground(Color.WHITE);
		btnPerfil.setFont(new Font("Verdana", Font.BOLD, 16));
		btnPerfil.setContentAreaFilled(true);
		btnPerfil.setBorderPainted(false);
		btnPerfil.setBackground(new Color(53, 53, 53));
		btnPerfil.setBounds(1009, 34, 136, 48);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnPerfil);
		

		JComboBox<String> comboBoxGeneros = new JComboBox<String>();
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

		JLabel lblArtistasXGenero = new JLabel("Artistas por Género:");
		lblArtistasXGenero.setBounds(100, 161, 224, 41);
		lblArtistasXGenero.setForeground(new Color(255, 255, 255));
		lblArtistasXGenero.setHorizontalAlignment(SwingConstants.LEFT);
		lblArtistasXGenero.setFont(new Font("Verdana", Font.PLAIN, 18));
		add(lblArtistasXGenero);

		JLabel lblNewLabel = new JLabel("Resultados:");
		lblNewLabel.setBounds(100, 290, 159, 27);
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		add(lblNewLabel);

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
		listaArtistasPorGenero.setBounds(100, 320, 1000, 313);
		listaArtistasPorGenero.setBackground(Color.decode("#DDDDDD"));
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
	}

}