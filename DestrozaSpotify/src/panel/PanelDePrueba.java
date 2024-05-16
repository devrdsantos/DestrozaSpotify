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

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.GestionBD;
import controller.GestionDeLaInformacion;
import view.VistaPrincipal;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class PanelDePrueba extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	private GestionBD gestionBD;

	private JPanel panelAñadirMusica;
	private JPanel panelAñadirMusico;
	private JPanel panelAñadirAlbum;
	private JPanel panelEliminarMusica;
	private JPanel panelEliminarAlbum;
	private JPanel panelEliminarMusico;
	private JPanel panelModificarMusica;
	
	private JPanel panelModificarImagen;
	
	private String archivoMusica;
	private String archivoPortadaMu;
	private String archivoImagenArt;
	private String archivoPortadaAlb;
	
	
	public PanelDePrueba(VistaPrincipal v, GestionBD gestionBD, GestionDeLaInformacion gestionINF) {
//		gestionBD = new GestionBD();
	
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
		
		JLabel lblMenuAdministrador = new JLabel("Gestion de musica");
		lblMenuAdministrador.setForeground(Color.decode("#ffffff"));
		lblMenuAdministrador.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuAdministrador.setFont(new Font("Malgun Gothic", Font.BOLD, 32));
		lblMenuAdministrador.setBounds(360, 55, 480, 48);
		add(lblMenuAdministrador);

/* ----- Panel menu botones ---------------------------------------------------------------------------------------- */	
		
		JPanel MenuBotones = new JPanel();
		MenuBotones.setBounds(40, 175, 180, 370);
		add(MenuBotones);
		MenuBotones.setLayout(null);
		
		/**
		 * Boton para mostrar el panel de eliminar Artistas
		 */
		JButton btnEliminarMusico = new JButton("Eliminar musico");
		btnEliminarMusico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEliminarAlbum.setVisible(false);
				panelAñadirAlbum.setVisible(false);
				panelEliminarMusica.setVisible(false);
				panelAñadirMusica.setVisible(false);
				panelAñadirMusico.setVisible(false);
				panelEliminarMusico.setVisible(true);
			}
		});
		btnEliminarMusico.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminarMusico.setBounds(10, 130, 160, 30);
		MenuBotones.add(btnEliminarMusico);
		
		/**
		 * Boton para mostrar el panel de añadir Artistas
		 */
		JButton btnAñadirMusico = new JButton("Añadir musico");
		btnAñadirMusico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEliminarMusico.setVisible(false);
				panelEliminarAlbum.setVisible(false);
				panelAñadirAlbum.setVisible(false);
				panelEliminarMusica.setVisible(false);
				panelAñadirMusica.setVisible(false);
				panelAñadirMusico.setVisible(true);
			
			}
		});
		btnAñadirMusico.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAñadirMusico.setBounds(10, 10, 160, 30);
		MenuBotones.add(btnAñadirMusico);
		
		/**
		 * Boton para mostrar el panel de modificar Artistas
		 */
		JButton btnModificarMusico = new JButton("Modificar musico");
		btnModificarMusico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelModificarImagen.setVisible(true);
			}
		});
		btnModificarMusico.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarMusico.setBounds(10, 250, 160, 30);
		MenuBotones.add(btnModificarMusico);
		
		/**
		 * Boton para mostrar el panel de eliminar Albums
		 */
		JButton btnEliminarAlbum = new JButton("Eliminar album");
		btnEliminarAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEliminarMusico.setVisible(false);
				panelAñadirAlbum.setVisible(false);
				panelAñadirMusico.setVisible(false);
				panelAñadirMusica.setVisible(false);
				panelEliminarMusica.setVisible(false);
				panelEliminarAlbum.setVisible(true);
			}
		});
		btnEliminarAlbum.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminarAlbum.setBounds(10, 170, 160, 30);
		MenuBotones.add(btnEliminarAlbum);
		
		/**
		 * Boton para mostrar el panel de añadir Albums
		 */
		JButton btnAñadirAlbum = new JButton("Añadir album");
		btnAñadirAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEliminarMusico.setVisible(false);
				panelEliminarAlbum.setVisible(false);
				panelEliminarMusica.setVisible(false);
				panelAñadirMusico.setVisible(false);
				panelAñadirMusica.setVisible(false);
				panelAñadirAlbum.setVisible(true);
			}
		});
		btnAñadirAlbum.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAñadirAlbum.setBounds(10, 50, 160, 30);
		MenuBotones.add(btnAñadirAlbum);
		
		/**
		 * Boton para mostrar el panel de modificar albums
		 */
		JButton btnModificarAlbum = new JButton("Modificar album");
		btnModificarAlbum.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarAlbum.setBounds(10, 290, 160, 30);
		MenuBotones.add(btnModificarAlbum);
		
		/**
		 * Boton para mostrar el panel de añadir Canciones
		 */
		JButton btnAñadirCancion = new JButton("Añadir cancion");
		btnAñadirCancion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEliminarMusico.setVisible(false);
				panelEliminarAlbum.setVisible(false);
				panelAñadirAlbum.setVisible(false);
				panelEliminarMusica.setVisible(false);
				panelAñadirMusico.setVisible(false);
				panelAñadirMusica.setVisible(true);
			}
		});
		btnAñadirCancion.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAñadirCancion.setBounds(10, 90, 160, 30);
		MenuBotones.add(btnAñadirCancion);
		
		/**
		 * Boton para mostrar el panel de modificar las Canciones
		 */
		JButton btnModificarCancion = new JButton("Modificar cancion");
		btnModificarCancion.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarCancion.setBounds(10, 330, 160, 30);
		MenuBotones.add(btnModificarCancion);
		
		/**
		 * Boton para mostrar el panel de eliminar las Canciones
		 */
		JButton btnEliminarCancion = new JButton("Eliminar cancion");
		btnEliminarCancion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEliminarMusico.setVisible(false);
				panelEliminarAlbum.setVisible(false);
				panelAñadirAlbum.setVisible(false);
				panelAñadirMusico.setVisible(false);
				panelAñadirMusica.setVisible(false);
				panelEliminarMusica.setVisible(true);
			}
		});
		btnEliminarCancion.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminarCancion.setBounds(10, 210, 160, 30);
		MenuBotones.add(btnEliminarCancion);
		
/* ------------------------------------------------------------------------------------------------------------------------------ */		

/* ---- Panel modificar artista --------------------------------------------------------------------------------------------------- */	
	
	panelModificarImagen = new JPanel();
	panelModificarImagen.setBounds(275, 175, 880, 500);
	panelModificarImagen.setBackground(Color.decode("#142850"));
	panelModificarImagen.setVisible(false);
	add(panelModificarImagen);
	panelModificarImagen.setLayout(null);
	
	JLabel lblModificarMusico = new JLabel("Nombre del podcaster:");
	lblModificarMusico.setForeground(Color.WHITE);
	lblModificarMusico.setFont(new Font("Verdana", Font.PLAIN, 18));
	lblModificarMusico.setBounds(27, 10, 211, 48);
	panelModificarImagen.add(lblModificarMusico);
	
	JLabel lblModificarNombreAu = new JLabel("Nombre artistico:");
	lblModificarNombreAu.setHorizontalAlignment(SwingConstants.RIGHT);
	lblModificarNombreAu.setForeground(Color.WHITE);
	lblModificarNombreAu.setFont(new Font("Verdana", Font.PLAIN, 18));
	lblModificarNombreAu.setBounds(27, 107, 211, 48);
	panelModificarImagen.add(lblModificarNombreAu);
	
	JLabel lblModificarImagenAu = new JLabel("Imagen:");
	lblModificarImagenAu.setHorizontalAlignment(SwingConstants.RIGHT);
	lblModificarImagenAu.setForeground(Color.WHITE);
	lblModificarImagenAu.setFont(new Font("Verdana", Font.PLAIN, 18));
	lblModificarImagenAu.setBounds(27, 225, 211, 48);
	panelModificarImagen.add(lblModificarImagenAu);
	
	JLabel lblModificarDuracionAu = new JLabel("Genero:");
	lblModificarDuracionAu.setHorizontalAlignment(SwingConstants.RIGHT);
	lblModificarDuracionAu.setForeground(Color.WHITE);
	lblModificarDuracionAu.setFont(new Font("Verdana", Font.PLAIN, 18));
	lblModificarDuracionAu.setBounds(27, 166, 211, 48);
	panelModificarImagen.add(lblModificarDuracionAu);
	
	JLabel lblModificarColaboracionCa = new JLabel("Descripcion:");
	lblModificarColaboracionCa.setHorizontalAlignment(SwingConstants.RIGHT);
	lblModificarColaboracionCa.setForeground(Color.WHITE);
	lblModificarColaboracionCa.setFont(new Font("Verdana", Font.PLAIN, 18));
	lblModificarColaboracionCa.setBounds(27, 285, 211, 48);
	panelModificarImagen.add(lblModificarColaboracionCa);
	
	JTextField textFieldNombreArtistico = new JTextField();
	textFieldNombreArtistico.setColumns(10);
	textFieldNombreArtistico.setBounds(248, 117, 288, 30);
	panelModificarImagen.add(textFieldNombreArtistico);
	
	JTextField textFieldGenero = new JTextField();
	textFieldGenero.setColumns(10);
	textFieldGenero.setBounds(248, 175, 288, 30);
	panelModificarImagen.add(textFieldGenero);
	
	JTextField textFieldDescripcionMo = new JTextField();
	textFieldDescripcionMo.setColumns(10);
	textFieldDescripcionMo.setBounds(248, 295, 288, 30);
	panelModificarImagen.add(textFieldDescripcionMo);
	
	JTextField textFieldImagenPodcasterMo = new JTextField();
	textFieldImagenPodcasterMo.setColumns(10);
	textFieldImagenPodcasterMo.setBounds(248, 235, 288, 30);
	panelModificarImagen.add(textFieldImagenPodcasterMo);
	
	JButton btnModificarPodcaster = new JButton("Modificar");
	btnModificarPodcaster.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnModificarPodcaster.setOpaque(true);
	btnModificarPodcaster.setForeground(Color.WHITE);
	btnModificarPodcaster.setFont(new Font("Verdana", Font.BOLD, 16));
	btnModificarPodcaster.setContentAreaFilled(true);
	btnModificarPodcaster.setBorderPainted(false);
	btnModificarPodcaster.setBackground(new Color(198, 122, 206));
	btnModificarPodcaster.setBounds(730, 450, 136, 35);
	panelModificarImagen.add(btnModificarPodcaster);

	JComboBox comboBoxPodcasterMo = new JComboBox();
	comboBoxPodcasterMo.setBounds(248, 23, 288, 30);
	panelModificarImagen.add(comboBoxPodcasterMo);
	
	JButton btnSubirImagenPodcasterMo = new JButton("Subir .jpg");
	btnSubirImagenPodcasterMo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnSubirImagenPodcasterMo.setFont(new Font("Tahoma", Font.BOLD, 13));
	btnSubirImagenPodcasterMo.setBounds(546, 233, 111, 33);
	panelModificarImagen.add(btnSubirImagenPodcasterMo);
	
	JButton btnCambiarPodcaster = new JButton("Cambiar");
	btnCambiarPodcaster.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnCambiarPodcaster.setFont(new Font("Tahoma", Font.BOLD, 13));
	btnCambiarPodcaster.setBounds(560, 20, 111, 33);
	panelModificarImagen.add(btnCambiarPodcaster);
	
	
	
	}
}