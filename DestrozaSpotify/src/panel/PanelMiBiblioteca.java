package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.GestionDeLaInformacion;
import view.VistaPrincipal;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelMiBiblioteca extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelMiBiblioteca(VistaPrincipal v , GestionDeLaInformacion gestionINF) {
		setSize(1200, 720);
		setVisible(true);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));
		
		/**
		 * Boton Volver
		 */
		JButton btnVolver = new JButton("<html><u>Volver<u><html>");
		btnVolver.setBounds(21, 23, 254, 39);
		btnVolver.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnVolver.setOpaque(true);
		btnVolver.setContentAreaFilled(true);
		btnVolver.setForeground(Color.decode("#C67ACE"));
		btnVolver.setBorderPainted(false);
		btnVolver.setBackground(Color.decode("#142850"));
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(3);
			}
		});
		setLayout(null);
		add(btnVolver);
		
		JList<String> listPlaylist = new JList<String>();
		DefaultListModel<String> modeloPlaylist = new DefaultListModel<String>();
		for (int i = 0; i < gestionINF.devolverPlaylistCliente(gestionINF.devolverIdCliente(gestionINF.devolverUsuario())).size(); i++) {
			modeloPlaylist.addElement(gestionINF.devolverPlaylistCliente(gestionINF.devolverIdCliente(gestionINF.devolverUsuario())).get(i).getNombre());
		}
		listPlaylist.setModel(modeloPlaylist);
		listPlaylist.setBounds(800, 175, 300, 400);
		add(listPlaylist);
		
		JLabel lblNewLabel = new JLabel("Mi playlist:");
		lblNewLabel.setBounds(800, 125, 213, 34);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblNewLabel);
		
		JButton btnCrearNueva = new JButton("Crear nueva");
		btnCrearNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Fecha de creacion
				LocalDate fechaSinFormato = LocalDate.now();
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String fechaCreacion = formato.format(fechaSinFormato);
				
				//Titulo de la playlist
				JFrame f =new JFrame();   
				String titulo =JOptionPane.showInputDialog(f,"Introduzca el nombre de la playlist:");  
				
				gestionINF.inserPodcast(titulo, fechaCreacion, gestionINF.devolverIdCliente(gestionINF.devolverUsuario()));
				
				v.cambiarDePanel(10);
			}
		});
		btnCrearNueva.setBounds(50, 225, 188, 40);
		btnCrearNueva.setOpaque(true);
		btnCrearNueva.setForeground(new Color(255, 170, 67));
		btnCrearNueva.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCrearNueva.setBorderPainted(false);
		btnCrearNueva.setBackground(new Color(63, 61, 61));
		add(btnCrearNueva);
		
		JButton btnBorrarPlaylist = new JButton("Borrar playlist");
		btnBorrarPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionINF.deletePlaylist(listPlaylist.getSelectedValue());
				
				v.cambiarDePanel(10);
			}
		});
		btnBorrarPlaylist.setBounds(50, 276, 188, 40);
		btnBorrarPlaylist.setOpaque(true);
		btnBorrarPlaylist.setForeground(new Color(255, 170, 67));
		btnBorrarPlaylist.setFont(new Font("Dialog", Font.BOLD, 16));
		btnBorrarPlaylist.setBorderPainted(false);
		btnBorrarPlaylist.setBackground(new Color(63, 61, 61));
		add(btnBorrarPlaylist);
		
		JButton btnImportar = new JButton("Importar");
		btnImportar.setBounds(50, 327, 188, 40);
		btnImportar.setOpaque(true);
		btnImportar.setForeground(new Color(255, 170, 67));
		btnImportar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnImportar.setBorderPainted(false);
		btnImportar.setBackground(new Color(63, 61, 61));
		add(btnImportar);
		
		JButton btnExportar = new JButton("Exportar");
		btnExportar.setBounds(50, 378, 188, 40);
		btnExportar.setOpaque(true);
		btnExportar.setForeground(new Color(255, 170, 67));
		btnExportar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnExportar.setBorderPainted(false);
		btnExportar.setBackground(new Color(63, 61, 61));
		add(btnExportar);
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setBounds(50, 429, 188, 40);
		btnPerfil.setOpaque(true);
		btnPerfil.setForeground(new Color(255, 170, 67));
		btnPerfil.setFont(new Font("Dialog", Font.BOLD, 16));
		btnPerfil.setBorderPainted(false);
		btnPerfil.setBackground(new Color(63, 61, 61));
		add(btnPerfil);
		
		JButton btnVerPlaylist = new JButton("Ver playlist");
		btnVerPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Recojer el nombre de la playlist
				v.cambiarDePanel(15);
			}
		});
		btnVerPlaylist.setBounds(50, 480, 188, 40);
		btnVerPlaylist.setOpaque(true);
		btnVerPlaylist.setForeground(new Color(255, 170, 67));
		btnVerPlaylist.setFont(new Font("Dialog", Font.BOLD, 16));
		btnVerPlaylist.setBorderPainted(false);
		btnVerPlaylist.setBackground(new Color(63, 61, 61));
		add(btnVerPlaylist);
}
}
