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
	private JTextField textFieldNombreCancion;
	private JTextField textFieldDuracion;
	private JTextField textFieldPortada;
	private JTextField textFieldColaboradores;
	private JTextField textField;
	
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
		btnAñadirCancion.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAñadirCancion.setBounds(10, 90, 150, 30);
		MenuBotones.add(btnAñadirCancion);
		
		JButton btnModificarCancion = new JButton("Modificar cancion");
		btnModificarCancion.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarCancion.setBounds(10, 330, 150, 30);
		MenuBotones.add(btnModificarCancion);
		
		JButton btnEliminarCancion = new JButton("Eliminar cancion");
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
		
		JLabel lblNombreAudio = new JLabel("Nombre de la cancion:\r\n");
		lblNombreAudio.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNombreAudio.setBounds(270, 175, 211, 48);
		add(lblNombreAudio);
		
		JLabel lblDescripcion = new JLabel("Duracion (En segundos):");
		lblDescripcion.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblDescripcion.setBounds(253, 234, 228, 48);
		add(lblDescripcion);
		
		textFieldNombreCancion = new JTextField();
		textFieldNombreCancion.setBounds(510, 188, 288, 30);
		add(textFieldNombreCancion);
		textFieldNombreCancion.setColumns(10);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setColumns(10);
		textFieldDuracion.setBounds(510, 247, 288, 30);
		add(textFieldDuracion);
		
		JLabel lblPortada = new JLabel("Portada:");
		lblPortada.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPortada.setBounds(396, 296, 85, 48);
		add(lblPortada);
		
		textFieldPortada = new JTextField();
		textFieldPortada.setColumns(10);
		textFieldPortada.setBounds(510, 309, 288, 30);
		add(textFieldPortada);
		
		JButton btnSubirPortada = new JButton("Subir .jpg");
		btnSubirPortada.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSubirPortada.setBounds(823, 307, 111, 33);
		add(btnSubirPortada);
		
		JLabel lblColaboradores = new JLabel("Colaboradores:");
		lblColaboradores.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblColaboradores.setBounds(333, 355, 148, 48);
		add(lblColaboradores);
		
		textFieldColaboradores = new JTextField();
		textFieldColaboradores.setColumns(10);
		textFieldColaboradores.setBounds(510, 368, 288, 30);
		add(textFieldColaboradores);
		
		JLabel lblArtista = new JLabel("Artista:");
		lblArtista.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblArtista.setBounds(406, 473, 75, 48);
		add(lblArtista);
		
		JComboBox comboBoxArtistas = new JComboBox();
		comboBoxArtistas.setBounds(510, 486, 288, 30);
		add(comboBoxArtistas);
		
		JLabel lblAlbum = new JLabel("Album:");
		lblAlbum.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblAlbum.setBounds(406, 532, 75, 48);
		add(lblAlbum);
		
		JComboBox comboBoxAlbum = new JComboBox();
		comboBoxAlbum.setBounds(510, 545, 288, 30);
		add(comboBoxAlbum);
		
		JLabel lblAudio = new JLabel("Audio:");
		lblAudio.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblAudio.setBounds(416, 414, 65, 48);
		add(lblAudio);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(510, 424, 288, 30);
		add(textField);
		
		JButton btnSubirWav = new JButton("Subir .wav");
		btnSubirWav.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSubirWav.setBounds(823, 423, 111, 33);
		add(btnSubirWav);
		
	}
}
