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
import javax.swing.SwingConstants;

import view.VistaPrincipal;

public class PanelMenuAdministrador extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelMenuAdministrador(VistaPrincipal v) {
		
		setSize(1200, 720);
		setVisible(true);
		setLayout(null);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));
		
		/**
		 * BTN - Atrás
		 */
		JButton btnAtras = new JButton("Atrás");
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
		
		
		/**
		 * BTN - Gestionar Música
		 */
		JButton btnGestionarMusica = new JButton("Gestionar Música");
		btnGestionarMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGestionarMusica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGestionarMusica.setBackground(Color.decode("#FFAD0D"));
				btnGestionarMusica.setForeground(Color.decode("#222222"));
			}
		});
		btnGestionarMusica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnGestionarMusica.setForeground(Color.decode("#FFAD0D"));
				btnGestionarMusica.setBackground(Color.decode("#222222"));		
			}
		});
		btnGestionarMusica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(5);
			}
		});
		btnGestionarMusica.setFont(new Font("Verdana", Font.BOLD, 16));
		btnGestionarMusica.setOpaque(true);
		btnGestionarMusica.setContentAreaFilled(true);
		btnGestionarMusica.setBorderPainted(false);
		btnGestionarMusica.setBackground(Color.decode("#222222"));
		btnGestionarMusica.setForeground(new Color(255, 173, 13));
		btnGestionarMusica.setBounds(134, 204, 250, 109);
		add(btnGestionarMusica);

		
		/**
		 * BTN - Gestionar Podcast
		 */
		JButton btnGestionarPodcast = new JButton("Gestionar Podcast");
		btnGestionarPodcast.setOpaque(true);
		btnGestionarPodcast.setForeground(new Color(255, 173, 13));
		btnGestionarPodcast.setFont(new Font("Verdana", Font.BOLD, 16));
		btnGestionarPodcast.setContentAreaFilled(true);
		btnGestionarPodcast.setBorderPainted(false);
		btnGestionarPodcast.setBackground(new Color(34, 34, 34));
		btnGestionarPodcast.setBounds(475, 204, 250, 109);
		btnGestionarPodcast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGestionarPodcast.setBackground(Color.decode("#FFAD0D"));
				btnGestionarPodcast.setForeground(Color.decode("#222222"));
			}
		});
		btnGestionarPodcast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnGestionarPodcast.setForeground(Color.decode("#FFAD0D"));
				btnGestionarPodcast.setBackground(Color.decode("#222222"));		
			}
		});
		btnGestionarPodcast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(6);
			}
		});
		add(btnGestionarPodcast);
		
		/**
		 * BTN - Ver estadísticas
		 */
		JButton btnVerEstadisticas = new JButton("Ver Estadísticas");
		btnVerEstadisticas.setOpaque(true);
		btnVerEstadisticas.setForeground(new Color(255, 173, 13));
		btnVerEstadisticas.setFont(new Font("Verdana", Font.BOLD, 16));
		btnVerEstadisticas.setContentAreaFilled(true);
		btnVerEstadisticas.setBorderPainted(false);
		btnVerEstadisticas.setBackground(new Color(34, 34, 34));
		btnVerEstadisticas.setBounds(816, 204, 250, 109);
		btnVerEstadisticas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVerEstadisticas.setBackground(Color.decode("#FFAD0D"));
				btnVerEstadisticas.setForeground(Color.decode("#222222"));
			}
		});
		btnVerEstadisticas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnVerEstadisticas.setForeground(Color.decode("#FFAD0D"));
				btnVerEstadisticas.setBackground(Color.decode("#222222"));		
			}
		});
		btnVerEstadisticas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// esto lo hay que cambiar!!!!!!!!!
				//v.cambiarDePanel(3);
			}
		});
		add(btnVerEstadisticas);
		
		
	

		
		/**
		 * LBL - Fondo 
		 */
		JLabel lblImagen = new JLabel();
		lblImagen.setFont(new Font("Rubik", Font.PLAIN, 16));
		lblImagen.setBounds(0, 0, 1200, 720);
		lblImagen.setIcon(new ImageIcon("imagenes/varios/fondo-menu-admin.jpg"));
		add(lblImagen);
		
	}
}