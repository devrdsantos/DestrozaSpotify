package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.GestionDeLaInformacion;
import view.VistaPrincipal;

public class PanelMenuCliente extends JPanel {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelMenuCliente(VistaPrincipal v, GestionDeLaInformacion gestionINF) {
	setSize(1600, 900);
	setVisible(true);
	setLayout(null);
	setFont(new Font("Tahoma", Font.BOLD, 11));
	setBackground(Color.decode("#142850"));
	
	
	/**
	 * Boton de volver al login
	 */
	JButton btnVolverAlLogin = new JButton("<html><u>Volver al Login<u><html>");
	btnVolverAlLogin.setFont(new Font("Verdana", Font.PLAIN, 16));
	btnVolverAlLogin.setOpaque(true);
	btnVolverAlLogin.setContentAreaFilled(true);
	btnVolverAlLogin.setForeground(Color.decode("#C67ACE"));
	btnVolverAlLogin.setBorderPainted(false);
	btnVolverAlLogin.setBackground(Color.decode("#142850"));
	btnVolverAlLogin.setBounds(21, 23, 254, 39);
	btnVolverAlLogin.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			v.cambiarDePanel(1);
		}
	});
	add(btnVolverAlLogin);
	
	
	/**
	 * Boton Descubrir Musica
	 */
	JButton btnDescubrirMusica = new JButton("Descubrir Música");
	btnDescubrirMusica.setFont(new Font("Verdana", Font.BOLD, 16));
	btnDescubrirMusica.setOpaque(true);
	btnDescubrirMusica.setContentAreaFilled(true);
	btnDescubrirMusica.setForeground(Color.decode("#FFFFFF"));
	btnDescubrirMusica.setBorderPainted(false);
	btnDescubrirMusica.setBackground(Color.decode("#C67ACE"));
	btnDescubrirMusica.setBounds(300, 200, 230, 200);
	btnDescubrirMusica.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			v.cambiarDePanel(8);
		}
	});
	add(btnDescubrirMusica);
  
	/**
	 * Boton Descubrir Podcast
	 */
	JButton btnDescubrirPodcast = new JButton("Descubrir Podcast");
	btnDescubrirPodcast.setFont(new Font("Verdana", Font.BOLD, 16));
	btnDescubrirPodcast.setOpaque(true);
	btnDescubrirPodcast.setContentAreaFilled(true);
	btnDescubrirPodcast.setForeground(Color.decode("#FFFFFF"));
	btnDescubrirPodcast.setBorderPainted(false);
	btnDescubrirPodcast.setBackground(Color.decode("#C67ACE"));
	btnDescubrirPodcast.setBounds(600, 200, 230, 200);
	btnDescubrirPodcast.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			v.cambiarDePanel(9);
		}
	});
	add(btnDescubrirPodcast);
	
	/**
	 * Boton Mi Biblioteca
	 */
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
	
	
	
	
	
	
	
	}
}
