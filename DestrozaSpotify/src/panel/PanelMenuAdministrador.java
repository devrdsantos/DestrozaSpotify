package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		JLabel lblMenuAdministrador = new JLabel("MENU ADMINISTRADOR");
		lblMenuAdministrador.setForeground(Color.decode("#ffffff"));
		lblMenuAdministrador.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuAdministrador.setFont(new Font("Malgun Gothic", Font.BOLD, 32));
		lblMenuAdministrador.setBounds(360, 55, 480, 48);
		add(lblMenuAdministrador);
		
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
		
		JButton btnGestionarMusica = new JButton("Gestionar musica");
		btnGestionarMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarDePanel(5);
			}
		});
		btnGestionarMusica.setFont(new Font("Verdana", Font.BOLD, 16));
		btnGestionarMusica.setOpaque(true);
		btnGestionarMusica.setContentAreaFilled(true);
		btnGestionarMusica.setForeground(Color.decode("#FFFFFF"));
		btnGestionarMusica.setBorderPainted(false);
		btnGestionarMusica.setBackground(Color.decode("#C67ACE"));
		btnGestionarMusica.setBounds(410, 270, 380, 35);
		add(btnGestionarMusica);
		
		JButton btnGestionarPodcast = new JButton("Gestionar Podcast");
		btnGestionarPodcast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarDePanel(6);
			}
		});
		btnGestionarPodcast.setFont(new Font("Verdana", Font.BOLD, 16));
		btnGestionarPodcast.setOpaque(true);
		btnGestionarPodcast.setContentAreaFilled(true);
		btnGestionarPodcast.setForeground(Color.decode("#FFFFFF"));
		btnGestionarPodcast.setBorderPainted(false);
		btnGestionarPodcast.setBackground(Color.decode("#C67ACE"));
		btnGestionarPodcast.setBounds(410, 370, 380, 35);
		add(btnGestionarPodcast);
		
		JButton btnEstadisticas = new JButton("Estadisticas");
		btnEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarDePanel(7);
			}
		});
		btnEstadisticas.setFont(new Font("Verdana", Font.BOLD, 16));
		btnEstadisticas.setOpaque(true);
		btnEstadisticas.setContentAreaFilled(true);
		btnEstadisticas.setForeground(Color.decode("#FFFFFF"));
		btnEstadisticas.setBorderPainted(false);
		btnEstadisticas.setBackground(Color.decode("#C67ACE"));
		btnEstadisticas.setBounds(410, 470, 380, 35);
		add(btnEstadisticas);

		
	}
}
