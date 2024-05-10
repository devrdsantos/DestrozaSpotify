package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import controller.GestionDeLaInformacion;
import view.VistaPrincipal;

public class PanelMenuCliente extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelMenuCliente(VistaPrincipal v, GestionDeLaInformacion gestionINF) {
		setSize(1200, 720);
		setVisible(true);
		setLayout(null);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));

		/**
		 * Boton de volver al login
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

		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setOpaque(true);
		btnPerfil.setForeground(Color.WHITE);
		btnPerfil.setFont(new Font("Verdana", Font.BOLD, 16));
		btnPerfil.setContentAreaFilled(true);
		btnPerfil.setBorderPainted(false);
		btnPerfil.setBackground(new Color(53, 53, 53));
		btnPerfil.setBounds(1009, 34, 136, 48);
		add(btnPerfil);

		// LBL - Titulo opciones
		JLabel lblOpciones = new JLabel("¿Qué quieres hacer?");
		lblOpciones.setFont(new Font("Rubik", Font.PLAIN, 24));
		lblOpciones.setForeground(Color.decode("#FFFFFF"));
		lblOpciones.setBounds(52, 136, 393, 48);
		add(lblOpciones);

		// BTN - Descubrir Musica
		JButton btnDescMusica = new JButton("Descubrir Música");
		btnDescMusica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDescMusica.setBackground(Color.decode("#FFB850"));
				btnDescMusica.setForeground(Color.decode("#222222"));
			}
		});
		btnDescMusica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnDescMusica.setForeground(Color.decode("#FFB850"));
				btnDescMusica.setBackground(Color.decode("#222222"));		
			}
		});
		btnDescMusica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(8);
			}
		});
		btnDescMusica.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnDescMusica.setOpaque(true);
		btnDescMusica.setContentAreaFilled(true);
		btnDescMusica.setBorderPainted(false);
		btnDescMusica.setBackground(Color.decode("#222222"));
		btnDescMusica.setForeground(Color.decode("#FFB850"));
		btnDescMusica.setBounds(92, 210, 250, 109);
		add(btnDescMusica);

		// SEPARATOR - Descubrir Musica
		JSeparator separatorDescMusica = new JSeparator();
		separatorDescMusica.setForeground(new Color(0, 0, 0));
		separatorDescMusica.setBackground(new Color(255, 184, 80));
		separatorDescMusica.setBounds(92, 330, 250, 13);
		add(separatorDescMusica);

		JButton btnDescubrirPodcast = new JButton("Descubrir Podcast");
		btnDescubrirPodcast.setOpaque(true);
		btnDescubrirPodcast.setForeground(new Color(255, 184, 80));
		btnDescubrirPodcast.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnDescubrirPodcast.setContentAreaFilled(true);
		btnDescubrirPodcast.setBorderPainted(false);
		btnDescubrirPodcast.setBackground(new Color(34, 34, 34));
		btnDescubrirPodcast.setBounds(464, 210, 250, 109);
		btnDescubrirPodcast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDescubrirPodcast.setBackground(Color.decode("#FFB850"));
				btnDescubrirPodcast.setForeground(Color.decode("#222222"));
			}
		});
		btnDescubrirPodcast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnDescubrirPodcast.setForeground(Color.decode("#FFB850"));
				btnDescubrirPodcast.setBackground(Color.decode("#222222"));		
			}
		});
		btnDescubrirPodcast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(9);
			}
		});
		add(btnDescubrirPodcast);
		
		JSeparator separatorDescPodcast = new JSeparator();
		separatorDescPodcast.setForeground(Color.BLACK);
		separatorDescPodcast.setBackground(new Color(255, 184, 80));
		separatorDescPodcast.setBounds(464, 330, 250, 13);
		add(separatorDescPodcast);
		
		JButton btnMisPlaylist = new JButton("Mis Playlist");
		btnMisPlaylist.setOpaque(true);
		btnMisPlaylist.setForeground(new Color(255, 184, 80));
		btnMisPlaylist.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnMisPlaylist.setContentAreaFilled(true);
		btnMisPlaylist.setBorderPainted(false);
		btnMisPlaylist.setBackground(new Color(34, 34, 34));
		btnMisPlaylist.setBounds(862, 210, 250, 109);
		btnMisPlaylist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMisPlaylist.setBackground(Color.decode("#FFB850"));
				btnMisPlaylist.setForeground(Color.decode("#222222"));
			}
		});
		btnMisPlaylist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnMisPlaylist.setForeground(Color.decode("#FFB850"));
				btnMisPlaylist.setBackground(Color.decode("#222222"));		
			}
		});
		btnMisPlaylist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(10);
			}
		});
		add(btnMisPlaylist);
		
		JSeparator separatorDescPodcast_1 = new JSeparator();
		separatorDescPodcast_1.setForeground(Color.BLACK);
		separatorDescPodcast_1.setBackground(new Color(255, 184, 80));
		separatorDescPodcast_1.setBounds(862, 330, 250, 13);
		add(separatorDescPodcast_1);
		
		JLabel lblRecomendacionesParaTi = new JLabel("Recomendaciones para ti");
		lblRecomendacionesParaTi.setForeground(Color.WHITE);
		lblRecomendacionesParaTi.setFont(new Font("Myanmar Text", Font.PLAIN, 20));
		lblRecomendacionesParaTi.setBounds(52, 410, 393, 48);
		add(lblRecomendacionesParaTi);
		
		JPanel panel = new JPanel();
		panel.setBounds(52, 469, 229, 196);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(336, 469, 229, 196);
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(624, 469, 229, 196);
		add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(891, 469, 229, 196);
		add(panel_3);
				
		
		/** Boton Mi Biblioteca
		 */
		/*
		JButton btnMiBiblioteca = new JButton("Mi Biblioteca");
		btnMiBiblioteca.setFont(new Font("Verdana", Font.BOLD, 16));
		btnMiBiblioteca.setOpaque(true);
		btnMiBiblioteca.setContentAreaFilled(true);
		btnMiBiblioteca.setForeground(Color.decode("#FFFFFF"));
		btnMiBiblioteca.setBorderPainted(false);
		btnMiBiblioteca.setBackground(Color.decode("#C67ACE"));
		btnMiBiblioteca.setBounds(450, 450, 230, 200);
		btnMiBiblioteca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(10);
			}
		});
		add(btnMiBiblioteca);
		*/
	}
}
