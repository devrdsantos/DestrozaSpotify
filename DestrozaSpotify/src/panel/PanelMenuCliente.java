package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import controller.GestionDeLaInformacion;
import view.VistaPrincipal;
import javax.swing.SwingConstants;

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
		btnAtras.setFont(new Font("Verdana", Font.BOLD, 14));
		btnAtras.setOpaque(true);
		btnAtras.setContentAreaFilled(true);
		btnAtras.setForeground(Color.decode("#FFFFFF"));
		btnAtras.setBorderPainted(false);
		btnAtras.setBackground(Color.decode("#353535"));
		btnAtras.setBounds(52, 54, 100, 40);
		add(btnAtras);

		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setOpaque(true);
		btnPerfil.setForeground(Color.WHITE);
		btnPerfil.setFont(new Font("Verdana", Font.BOLD, 14));
		btnPerfil.setContentAreaFilled(true);
		btnPerfil.setBorderPainted(false);
		btnPerfil.setBackground(new Color(53, 53, 53));
		btnPerfil.setBounds(1038, 54, 100, 40);
		add(btnPerfil);

		// BTN - Descubrir Musica
		JButton btnDescMusica = new JButton("Descubrir Música");
		btnDescMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDescMusica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDescMusica.setBackground(Color.decode("#FFAD0D"));
				btnDescMusica.setForeground(Color.decode("#222222"));
			}
		});
		btnDescMusica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnDescMusica.setForeground(Color.decode("#FFAD0D"));
				btnDescMusica.setBackground(Color.decode("#222222"));		
			}
		});
		btnDescMusica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(8);
			}
		});
		btnDescMusica.setFont(new Font("Verdana", Font.BOLD, 16));
		btnDescMusica.setOpaque(true);
		btnDescMusica.setContentAreaFilled(true);
		btnDescMusica.setBorderPainted(false);
		btnDescMusica.setBackground(Color.decode("#222222"));
		btnDescMusica.setForeground(new Color(255, 173, 13));
		btnDescMusica.setBounds(134, 204, 250, 109);
		add(btnDescMusica);

		JButton btnDescubrirPodcast = new JButton("Descubrir Podcast");
		btnDescubrirPodcast.setOpaque(true);
		btnDescubrirPodcast.setForeground(new Color(255, 173, 13));
		btnDescubrirPodcast.setFont(new Font("Verdana", Font.BOLD, 16));
		btnDescubrirPodcast.setContentAreaFilled(true);
		btnDescubrirPodcast.setBorderPainted(false);
		btnDescubrirPodcast.setBackground(new Color(34, 34, 34));
		btnDescubrirPodcast.setBounds(475, 204, 250, 109);
		btnDescubrirPodcast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDescubrirPodcast.setBackground(Color.decode("#FFAD0D"));
				btnDescubrirPodcast.setForeground(Color.decode("#222222"));
			}
		});
		btnDescubrirPodcast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnDescubrirPodcast.setForeground(Color.decode("#FFAD0D"));
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
		
		JButton btnMisPlaylist = new JButton("Mis Playlist");
		btnMisPlaylist.setOpaque(true);
		btnMisPlaylist.setForeground(new Color(255, 173, 13));
		btnMisPlaylist.setFont(new Font("Verdana", Font.BOLD, 16));
		btnMisPlaylist.setContentAreaFilled(true);
		btnMisPlaylist.setBorderPainted(false);
		btnMisPlaylist.setBackground(new Color(34, 34, 34));
		btnMisPlaylist.setBounds(816, 204, 250, 109);
		btnMisPlaylist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMisPlaylist.setBackground(Color.decode("#FFAD0D"));
				btnMisPlaylist.setForeground(Color.decode("#222222"));
			}
		});
		btnMisPlaylist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnMisPlaylist.setForeground(Color.decode("#FFAD0D"));
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
		
		
		
		/**
		 * LBL - Titulo 1
		 */
		JLabel lblTitulo1 = new JLabel("<html>dynamic FDDSSSSSSSSSSSSSSSSSSSSS/html>");
		lblTitulo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblTitulo1.setForeground(new Color(192, 192, 192));
		lblTitulo1.setBounds(84, 540, 180, 46);
		add(lblTitulo1);
		
		/**
		 * BTN - Ver más 1
		 */
		
		JButton btnBtn1 = new JButton("<html><u>Ver más</u></html>");
		btnBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBtn1.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnBtn1.setOpaque(true);
		btnBtn1.setContentAreaFilled(true);
		btnBtn1.setBorderPainted(false);
		btnBtn1.setBackground(Color.decode("#222222"));
		btnBtn1.setForeground(new Color(255, 173, 13));
		btnBtn1.setBounds(127, 593, 89, 23);
		add(btnBtn1);
		
		/**
		 * LBL - Imagen 1
		 */
		JLabel lblImagen1 = new JLabel("Imagen");
		lblImagen1.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen1.setForeground(Color.LIGHT_GRAY);
		lblImagen1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblImagen1.setBackground(Color.decode("#000000"));
		lblImagen1.setOpaque(true);
		lblImagen1.setBounds(84, 429, 180, 109);
		add(lblImagen1);

		
		/**
		 * LBL - Titulo 2
		 */
		JLabel lblTitulo2 = new JLabel("<html>dynamic FDDSSSSSSSSSSSSSSSSSSSSS/html>");
		lblTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo2.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblTitulo2.setForeground(new Color(192, 192, 192));
		lblTitulo2.setBounds(364, 540, 180, 46);
		add(lblTitulo2);
		
		/**
		 * BTN - Ver más 2
		 */
		
		JButton btnBtn2 = new JButton("<html><u>Ver más</u></html>");
		btnBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBtn2.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnBtn2.setOpaque(true);
		btnBtn2.setContentAreaFilled(true);
		btnBtn2.setBorderPainted(false);
		btnBtn2.setBackground(new Color(41, 41, 41));
		btnBtn2.setForeground(new Color(255, 173, 13));
		btnBtn2.setBounds(410, 593, 89, 23);
		add(btnBtn2);
		
		/**
		 * LBL - Imagen 2
		 */
		JLabel lblImagen2 = new JLabel("Imagen");
		lblImagen2.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen2.setForeground(Color.LIGHT_GRAY);
		lblImagen2.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblImagen2.setBackground(Color.decode("#000000"));
		lblImagen2.setOpaque(true);
		lblImagen2.setBounds(364, 429, 180, 109);
		add(lblImagen2);
		

		/**
		 * LBL - Imagen 3
		 */
		JLabel lblImagen3 = new JLabel("Imagen");
		lblImagen3.setOpaque(true);
		lblImagen3.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen3.setForeground(Color.LIGHT_GRAY);
		lblImagen3.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblImagen3.setBackground(Color.BLACK);
		lblImagen3.setBounds(644, 429, 180, 109);
		add(lblImagen3);
		
		
		/**
		 * LBL - Titulo 3
		 */
		JLabel lblTitulo3 = new JLabel("<html>dynamic FDDSSSSSSSSSSSSSSSSSSSSS/html>");
		lblTitulo3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo3.setForeground(Color.LIGHT_GRAY);
		lblTitulo3.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblTitulo3.setBounds(644, 540, 180, 46);
		add(lblTitulo3);
		
		/**
		 * BTN - Ver más 3
		 */
		JButton btnBtn3 = new JButton("<html><u>Ver más</u></html>");
		btnBtn3.setOpaque(true);
		btnBtn3.setForeground(new Color(255, 173, 13));
		btnBtn3.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnBtn3.setContentAreaFilled(true);
		btnBtn3.setBorderPainted(false);
		btnBtn3.setBackground(new Color(41, 41, 41));
		btnBtn3.setBounds(690, 593, 89, 23);
		add(btnBtn3);
		
		/**
		 * LBL - Imagen 4
		 */
		JLabel lblImagen4 = new JLabel("Imagen");
		lblImagen4.setOpaque(true);
		lblImagen4.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen4.setForeground(Color.LIGHT_GRAY);
		lblImagen4.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblImagen4.setBackground(Color.BLACK);
		lblImagen4.setBounds(924, 429, 180, 109);
		add(lblImagen4);
		
		/**
		 * LBL - Titulo 4
		 */
		JLabel lblTitulo4 = new JLabel("<html>dynamic FDDSSSSSSSSSSSSSSSSSSSSS/html>");
		lblTitulo4.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo4.setForeground(Color.LIGHT_GRAY);
		lblTitulo4.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblTitulo4.setBounds(924, 540, 180, 46);
		add(lblTitulo4);
		
		/**
		 * BTN - Ver más 4
		 */
		JButton btnBtn4 = new JButton("<html><u>Ver más</u></html>");
		btnBtn4.setOpaque(true);
		btnBtn4.setForeground(new Color(255, 173, 13));
		btnBtn4.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnBtn4.setContentAreaFilled(true);
		btnBtn4.setBorderPainted(false);
		btnBtn4.setBackground(new Color(34, 34, 34));
		btnBtn4.setBounds(970, 593, 89, 23);
		add(btnBtn4);
		
		
		
		/**
		 * LBL - Fondo 
		 */
		JLabel lblImagen = new JLabel();
		lblImagen.setFont(new Font("Rubik", Font.PLAIN, 16));
		lblImagen.setBounds(0, 0, 1200, 720);
		lblImagen.setIcon(new ImageIcon("imagenes/varios/fondo-comun.jpg"));
		add(lblImagen);
		
		
		
		
	}
}
