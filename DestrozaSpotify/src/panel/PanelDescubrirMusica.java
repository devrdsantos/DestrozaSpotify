package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
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
	
	public PanelDescubrirMusica (VistaPrincipal v, GestionDeLaInformacion gestionINF) {
		setSize(1200, 720);
		setVisible(true);
		setFont(new Font("Open Sans", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));
		
		
		/**
		 *  BTN - Ir atrás 
		 */
		JButton btnAtras = new JButton("Ir atrás");
		btnAtras.setBounds(32, 32, 137, 52);
		btnAtras.setFont(new Font("Open Sans", Font.BOLD, 16));
		
			/**
			 *  ACCION DEL BOTON
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
		
		JLabel lblTitulo = new JLabel("Descubrir Música");
		lblTitulo.setBounds(325, 50, 524, 74);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 48));
		add(lblTitulo);
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setBounds(1000, 32, 137, 52);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPerfil.setOpaque(true);
		btnPerfil.setForeground(new Color(255, 170, 67));
		btnPerfil.setFont(new Font("Open Sans", Font.BOLD, 16));
		btnPerfil.setBorderPainted(false);
		btnPerfil.setBackground(new Color(63, 61, 61));
		add(btnPerfil);
		
		JComboBox comboBoxGeneros = new JComboBox();
		comboBoxGeneros.setBounds(550, 150, 417, 33);
		comboBoxGeneros.addActionListener(new ActionListener() {//add actionlistner to listen for change
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
		lblArtistasXGenero.setBounds(300, 150, 224, 41);
		lblArtistasXGenero.setForeground(new Color(255, 255, 255));
		lblArtistasXGenero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArtistasXGenero.setFont(new Font("Open Sans", Font.PLAIN, 20));
		add(lblArtistasXGenero);
		
		JLabel lblNewLabel = new JLabel("Resultados:");
		lblNewLabel.setBounds(100, 250, 159, 22);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans", Font.PLAIN, 18));
		add(lblNewLabel);
		
		JList<String> listaArtistasPorGenero = new JList<String>();
		listaArtistasPorGenero.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				gestionINF.artistaSeleccionado(listaArtistasPorGenero.getSelectedValue());
				v.cambiarDePanel(7);
			}
		});
		DefaultListModel<String> artistaPorGenero = new DefaultListModel<String>();
		for (int i = 0; i < gestionINF.mostrarArtistas().size(); i++) {
			if(gestionINF.mostrarArtistas().get(i).getGenero().equals(generoSeleccionado)){
			artistaPorGenero.addElement(gestionINF.mostrarArtistas().get(i).getNombreArtista());
		}}
		listaArtistasPorGenero.setModel(artistaPorGenero);
		listaArtistasPorGenero.setBounds(100, 300, 1000, 313);
		add(listaArtistasPorGenero);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(700, 200, 137, 52);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				artistaPorGenero.removeAllElements();
				for (int i = 0; i < gestionINF.mostrarArtistas().size(); i++) {
					if(gestionINF.mostrarArtistas().get(i).getGenero().equals(generoSeleccionado)){
					artistaPorGenero.addElement(gestionINF.mostrarArtistas().get(i).getNombreArtista());
				}}
			}
		});
		btnBuscar.setOpaque(true);
		btnBuscar.setForeground(new Color(255, 170, 67));
		btnBuscar.setFont(new Font("Open Sans", Font.BOLD, 16));
		btnBuscar.setBorderPainted(false);
		btnBuscar.setBackground(new Color(63, 61, 61));
		add(btnBuscar);
	}
	
	
		}
