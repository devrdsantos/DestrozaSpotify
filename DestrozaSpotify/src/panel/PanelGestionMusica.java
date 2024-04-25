package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.GestionBD;
import view.VistaPrincipal;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class PanelGestionMusica extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GestionBD gestionBD;
	private JTextField textFieldDuracion;
	private JTextField textFieldPortada;
	private JTextField textFieldColaboradores;
	private JTextField textFieldAudio;
	private JTextField textFieldNombreCancion;
	private JLabel lblNombreAudio;
	private JLabel lblDescripcion;
	private JLabel lblPortada;
	private JLabel lblColaboradores;
	private JLabel lblAudio;
	private JLabel lblArtista;
	private JLabel lblAlbum;
	private JComboBox comboBoxAlbum;
	private JComboBox comboBoxArtistas;
	private JButton btnSubirPortada;
	private JButton btnSubirWav;
	private JLabel lblNombreAudioE;
	
	public PanelGestionMusica(VistaPrincipal v) {
		gestionBD = new GestionBD();
	
		setSize(1200, 720);
		setVisible(true);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#142850"));
		setLayout(null);
		
		JPanel MenuBotones = new JPanel();
		MenuBotones.setBounds(40, 175, 170, 370);
		add(MenuBotones);
		MenuBotones.setLayout(null);
		
		JButton btnEliminarArtista = new JButton("Eliminar artista");
		btnEliminarArtista.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminarArtista.setBounds(10, 130, 150, 30);
		MenuBotones.add(btnEliminarArtista);
		
		JButton btnAñadirArtista = new JButton("Añadir artista");
		btnAñadirArtista.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAñadirArtista.setBounds(10, 10, 150, 30);
		MenuBotones.add(btnAñadirArtista);
		
		JButton btnModificarArtista = new JButton("Modificar artista");
		btnModificarArtista.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarArtista.setBounds(10, 250, 150, 30);
		MenuBotones.add(btnModificarArtista);
		
		JButton btnEliminarAlbum = new JButton("Eliminar album");
		btnEliminarAlbum.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminarAlbum.setBounds(10, 170, 150, 30);
		MenuBotones.add(btnEliminarAlbum);
		
		JButton btnAñadirAlbum = new JButton("Añadir album");
		btnAñadirAlbum.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAñadirAlbum.setBounds(10, 50, 150, 30);
		MenuBotones.add(btnAñadirAlbum);
		
		JButton btnModificarAlbum = new JButton("Modificar album");
		btnModificarAlbum.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarAlbum.setBounds(10, 290, 150, 30);
		MenuBotones.add(btnModificarAlbum);
		
		JButton btnAñadirCancion = new JButton("Añadir cancion");
		btnAñadirCancion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblArtista.setVisible(true);
				lblAlbum.setVisible(true);
				lblAudio.setVisible(true);
				lblColaboradores.setVisible(true);
				lblDescripcion.setVisible(true);
				lblNombreAudio.setVisible(true);
				lblPortada.setVisible(true);
				textFieldAudio.setVisible(true);
				textFieldColaboradores.setVisible(true);
				textFieldDuracion.setVisible(true);
				textFieldNombreCancion.setVisible(true);
				textFieldPortada.setVisible(true);
				btnSubirPortada.setVisible(true);
				btnSubirWav.setVisible(true);
				comboBoxAlbum.setVisible(true);
				comboBoxArtistas.setVisible(true);
			}
		});
		btnAñadirCancion.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAñadirCancion.setBounds(10, 90, 150, 30);
		MenuBotones.add(btnAñadirCancion);
		
		JButton btnModificarCancion = new JButton("Modificar cancion");
		btnModificarCancion.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarCancion.setBounds(10, 330, 150, 30);
		MenuBotones.add(btnModificarCancion);
		
		JButton btnEliminarCancion = new JButton("Eliminar cancion");
		btnEliminarCancion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnEliminarCancion.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminarCancion.setBounds(10, 210, 150, 30);
		MenuBotones.add(btnEliminarCancion);
		
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
		btnAtras.setBackground(Color.decode("#C67ACE"));
		btnAtras.setBounds(1010, 30, 136, 35);
		add(btnAtras);
		

		JLabel lblMenuAdministrador = new JLabel("Gestion de musica");
		lblMenuAdministrador.setForeground(Color.decode("#ffffff"));
		lblMenuAdministrador.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuAdministrador.setFont(new Font("Malgun Gothic", Font.BOLD, 32));
		lblMenuAdministrador.setBounds(360, 55, 480, 48);
		add(lblMenuAdministrador);
		
		lblNombreAudio = new JLabel("Nombre de la cancion:\r\n");
		lblNombreAudio.setForeground(Color.decode("#ffffff"));
		lblNombreAudio.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNombreAudio.setBounds(270, 175, 211, 48);
		lblNombreAudio.setVisible(false);
		add(lblNombreAudio);
		
		lblDescripcion = new JLabel("Duracion (En segundos):");
		lblDescripcion.setForeground(Color.decode("#ffffff"));
		lblDescripcion.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblDescripcion.setBounds(253, 234, 228, 48);
		lblDescripcion.setVisible(false);
		add(lblDescripcion);
		
		textFieldNombreCancion = new JTextField();
		textFieldNombreCancion.setBounds(510, 188, 288, 30);
		add(textFieldNombreCancion);
		textFieldNombreCancion.setVisible(false);
		textFieldNombreCancion.setColumns(10);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setColumns(10);
		textFieldDuracion.setBounds(510, 247, 288, 30);
		textFieldDuracion.setVisible(false);
		add(textFieldDuracion);
		
		lblPortada = new JLabel("Portada:");
		lblPortada.setForeground(Color.decode("#ffffff"));
		lblPortada.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPortada.setBounds(396, 296, 85, 48);
		lblPortada.setVisible(false);
		add(lblPortada);
		
		textFieldPortada = new JTextField();
		textFieldPortada.setColumns(10);
		textFieldPortada.setBounds(510, 309, 288, 30);
		textFieldPortada.setVisible(false);
		add(textFieldPortada);
		
		btnSubirPortada = new JButton("Subir .jpg");
		btnSubirPortada.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSubirPortada.setBounds(823, 307, 111, 33);
		btnSubirPortada.setVisible(false);
		add(btnSubirPortada);
		
		lblColaboradores = new JLabel("Colaboradores:");
		lblColaboradores.setForeground(Color.decode("#ffffff"));
		lblColaboradores.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblColaboradores.setBounds(333, 355, 148, 48);
		lblColaboradores.setVisible(false);
		add(lblColaboradores);
		
		textFieldColaboradores = new JTextField();
		textFieldColaboradores.setColumns(10);
		textFieldColaboradores.setBounds(510, 368, 288, 30);
		textFieldColaboradores.setVisible(false);
		add(textFieldColaboradores);
		
		lblArtista = new JLabel("Artista:");
		lblArtista.setForeground(Color.decode("#ffffff"));
		lblArtista.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblArtista.setBounds(406, 473, 75, 48);
		lblArtista.setVisible(false);
		add(lblArtista);
		
		comboBoxArtistas = new JComboBox();
		comboBoxArtistas.setBounds(510, 486, 288, 30);
		comboBoxArtistas.setVisible(false);
		add(comboBoxArtistas);
		
		lblAlbum = new JLabel("Album:");
		lblAlbum.setForeground(Color.decode("#ffffff"));
		lblAlbum.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblAlbum.setBounds(406, 532, 75, 48);
		lblAlbum.setVisible(false);
		add(lblAlbum);
		
		comboBoxAlbum = new JComboBox();
		comboBoxAlbum.setBounds(510, 545, 288, 30);
		comboBoxAlbum.setVisible(false);
		add(comboBoxAlbum);
		
		lblAudio = new JLabel("Audio:");
		lblAudio.setForeground(Color.decode("#ffffff"));
		lblAudio.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblAudio.setBounds(416, 414, 65, 48);
		lblAudio.setVisible(false);
		add(lblAudio);
		
		textFieldAudio = new JTextField();
		textFieldAudio.setColumns(10);
		textFieldAudio.setBounds(510, 424, 288, 30);
		textFieldAudio.setVisible(false);
		add(textFieldAudio);
		
		btnSubirWav = new JButton("Subir .wav");
		btnSubirWav.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSubirWav.setBounds(823, 422, 111, 33);
		btnSubirWav.setVisible(false);
		add(btnSubirWav);
		
		lblNombreAudioE = new JLabel("Nombre de la cancion:\r\n");
		lblNombreAudioE.setForeground(Color.decode("#ffffff"));
		lblNombreAudioE.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNombreAudioE.setBounds(270, 175, 211, 48);
		lblNombreAudioE.setVisible(false);
		add(lblNombreAudioE);
		
	}
}
