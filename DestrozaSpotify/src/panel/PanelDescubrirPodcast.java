package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

public class PanelDescubrirPodcast extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String podcasterSeleccionado;
	
	public PanelDescubrirPodcast (VistaPrincipal v, GestionDeLaInformacion gestionINF) {
		setSize(1200, 720);
		setVisible(true);
		setFont(new Font("Open Sans", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));
		setLayout(null);
		
		/**
		 *  BTN - Ir atrás 
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
		
		JLabel lblTitulo = new JLabel("Descubrir Podcaster");
		lblTitulo.setBounds(325, 50, 524, 74);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 48));
		add(lblTitulo);
		
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
		
		JComboBox<String> comboBoxPodcasters = new JComboBox<String>();
		comboBoxPodcasters.setBounds(550, 150, 417, 33);
		comboBoxPodcasters.addActionListener(new ActionListener() {//add actionlistner to listen for change
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	podcasterSeleccionado = comboBoxPodcasters.getSelectedItem().toString();
	            }
		});
		
		for (int i = 0; i < gestionINF.mostrarPodcasters().size(); i++) {
			comboBoxPodcasters.addItem(gestionINF.mostrarPodcasters().get(i));
		}
		add(comboBoxPodcasters);
		
		JLabel lblArtistasXGenero = new JLabel("Escoge el podcaster:");
		lblArtistasXGenero.setBounds(300, 150, 224, 41);
		lblArtistasXGenero.setForeground(new Color(255, 255, 255));
		lblArtistasXGenero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArtistasXGenero.setFont(new Font("Open Sans", Font.PLAIN, 20));
		add(lblArtistasXGenero);
	
		
		JButton btnBuscar = new JButton("Descubrir");
		btnBuscar.setBounds(700, 200, 137, 52);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			gestionINF.almacenarPodcaster(podcasterSeleccionado);
			v.cambiarDePanel(13);
			
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
