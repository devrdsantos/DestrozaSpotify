package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.GestionBD;
import view.VistaPrincipal;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PanelDePrueba extends JPanel {

	public PanelDePrueba(VistaPrincipal v, GestionBD gestionBD) {

		setSize(1200, 720);
		setVisible(true);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));
		setLayout(null);

		/**
		 * Boton para volver atras
		 */
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarDePanel(4);
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
	
		

	}
}

