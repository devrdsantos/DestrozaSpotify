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

public class PanelPodcast extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String podcastSeleccionado;
	
	public PanelPodcast (VistaPrincipal v, GestionDeLaInformacion gestionINF) {
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
				v.cambiarDePanel(9);
			}
		});
		setLayout(null);
		btnAtras.setBackground(Color.decode("#3f3d3d"));
		btnAtras.setForeground(Color.decode("#ffaa43"));
		btnAtras.setOpaque(true);
		btnAtras.setBorderPainted(false);
		add(btnAtras);
		
		JLabel lblTitulo = new JLabel("Descubrir PODCAST");
		lblTitulo.setBounds(325, 50, 524, 74);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 48));
		add(lblTitulo);
		
		JButton btnPerfil = new JButton("Mi Perfil");
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
		
		JComboBox<String> comboBoxPodcast = new JComboBox<String>();
		comboBoxPodcast.setBounds(550, 150, 417, 33);
		comboBoxPodcast.addActionListener(new ActionListener() {//add actionlistner to listen for change
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	podcastSeleccionado = comboBoxPodcast.getSelectedItem().toString();
	            }
		});
		
		for (int i = 0; i < gestionINF.mostrarPodcastPorPodcaster(gestionINF.devolverIdPodcaster(gestionINF.mostrarPodcaster())).size(); i++) {
			comboBoxPodcast.addItem(gestionINF.mostrarPodcastPorPodcaster(gestionINF.devolverIdPodcaster(gestionINF.mostrarPodcaster())).get(i));
		}
		add(comboBoxPodcast);
		
		JLabel lblArtistasXGenero = new JLabel("Escoge el podcast:");
		lblArtistasXGenero.setBounds(300, 150, 224, 41);
		lblArtistasXGenero.setForeground(new Color(255, 255, 255));
		lblArtistasXGenero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArtistasXGenero.setFont(new Font("Open Sans", Font.PLAIN, 20));
		add(lblArtistasXGenero);
	
		
		JButton btnBuscar = new JButton("Ver episodios");
		btnBuscar.setBounds(700, 200, 137, 52);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			gestionINF.almacenarPodcast(podcastSeleccionado);
			v.cambiarDePanel(14);
				
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
