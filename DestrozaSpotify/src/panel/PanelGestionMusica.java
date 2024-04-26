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
import view.VistaPrincipal;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class PanelGestionMusica extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GestionBD gestionBD;
	
	private JPanel panelAñadirMusica;
	private JPanel panelEliminarMusica;
	private JPanel panelModificarMusica;
	private JPanel panelAñadirArtista;
	private JPanel panelAñadirAlbum;
	private JPanel panelEliminarAlbum;
	private JPanel panelEliminarArtista;
	
	private String archivoMusica;
	private String archivoPortadaMu;
	private String archivoImagenArt;
	private String archivoPortadaAlb;
	
	
	public PanelGestionMusica(VistaPrincipal v) {
		gestionBD = new GestionBD();
	
		setSize(1200, 720);
		setVisible(true);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#142850"));
		setLayout(null);
		
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

/* ----- Panel menu botones ---------------------------------------------------------------------------------------- */	
		
		JPanel MenuBotones = new JPanel();
		MenuBotones.setBounds(40, 175, 180, 370);
		add(MenuBotones);
		MenuBotones.setLayout(null);
		
		JButton btnEliminarArtista = new JButton("Eliminar artista");
		btnEliminarArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEliminarAlbum.setVisible(false);
				panelAñadirAlbum.setVisible(false);
				panelEliminarMusica.setVisible(false);
				panelAñadirMusica.setVisible(false);
				panelAñadirArtista.setVisible(false);
				panelEliminarArtista.setVisible(true);
			}
		});
		btnEliminarArtista.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminarArtista.setBounds(10, 130, 160, 30);
		MenuBotones.add(btnEliminarArtista);
		
		JButton btnAñadirArtista = new JButton("Añadir artista");
		btnAñadirArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEliminarArtista.setVisible(false);
				panelEliminarAlbum.setVisible(false);
				panelAñadirAlbum.setVisible(false);
				panelEliminarMusica.setVisible(false);
				panelAñadirMusica.setVisible(false);
				panelAñadirArtista.setVisible(true);
			
			}
		});
		btnAñadirArtista.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAñadirArtista.setBounds(10, 10, 160, 30);
		MenuBotones.add(btnAñadirArtista);
		
		JButton btnModificarArtista = new JButton("Modificar artista");
		btnModificarArtista.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarArtista.setBounds(10, 250, 160, 30);
		MenuBotones.add(btnModificarArtista);
		
		JButton btnEliminarAlbum = new JButton("Eliminar album");
		btnEliminarAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEliminarArtista.setVisible(false);
				panelAñadirAlbum.setVisible(false);
				panelAñadirArtista.setVisible(false);
				panelAñadirMusica.setVisible(false);
				panelEliminarMusica.setVisible(false);
				panelEliminarAlbum.setVisible(true);
			}
		});
		btnEliminarAlbum.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminarAlbum.setBounds(10, 170, 160, 30);
		MenuBotones.add(btnEliminarAlbum);
		
		JButton btnAñadirAlbum = new JButton("Añadir album");
		btnAñadirAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEliminarArtista.setVisible(false);
				panelEliminarAlbum.setVisible(false);
				panelEliminarMusica.setVisible(false);
				panelAñadirArtista.setVisible(false);
				panelAñadirMusica.setVisible(false);
				panelAñadirAlbum.setVisible(true);
			}
		});
		btnAñadirAlbum.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAñadirAlbum.setBounds(10, 50, 160, 30);
		MenuBotones.add(btnAñadirAlbum);
		
		JButton btnModificarAlbum = new JButton("Modificar album");
		btnModificarAlbum.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarAlbum.setBounds(10, 290, 160, 30);
		MenuBotones.add(btnModificarAlbum);
		
		JButton btnAñadirCancion = new JButton("Añadir cancion");
		btnAñadirCancion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEliminarArtista.setVisible(false);
				panelEliminarAlbum.setVisible(false);
				panelAñadirAlbum.setVisible(false);
				panelEliminarMusica.setVisible(false);
				panelAñadirArtista.setVisible(false);
				panelAñadirMusica.setVisible(true);
			}
		});
		btnAñadirCancion.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAñadirCancion.setBounds(10, 90, 160, 30);
		MenuBotones.add(btnAñadirCancion);
		
		JButton btnModificarCancion = new JButton("Modificar cancion");
		btnModificarCancion.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarCancion.setBounds(10, 330, 160, 30);
		MenuBotones.add(btnModificarCancion);
		
		JButton btnEliminarCancion = new JButton("Eliminar cancion");
		btnEliminarCancion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEliminarArtista.setVisible(false);
				panelEliminarAlbum.setVisible(false);
				panelAñadirAlbum.setVisible(false);
				panelAñadirArtista.setVisible(false);
				panelAñadirMusica.setVisible(false);
				panelEliminarMusica.setVisible(true);
			}
		});
		btnEliminarCancion.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminarCancion.setBounds(10, 210, 160, 30);
		MenuBotones.add(btnEliminarCancion);
		
/* ------------------------------------------------------------------------------------------------------------------------------ */		

/* ----- Panel añadir musica ---------------------------------------------------------------------------------------------------- */
		
		panelAñadirMusica = new JPanel();
		panelAñadirMusica.setBounds(275, 175, 880, 500);
		panelAñadirMusica.setBackground(Color.decode("#142850"));
		panelAñadirMusica.setVisible(false);
		add(panelAñadirMusica);
		panelAñadirMusica.setLayout(null);
		
		JLabel lblNombreAudio = new JLabel("Nombre de la cancion:");
		lblNombreAudio.setBounds(27, 10, 211, 48);
		lblNombreAudio.setForeground(Color.decode("#ffffff"));
		lblNombreAudio.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirMusica.add(lblNombreAudio);
		
		JLabel lblDuracion = new JLabel("Duracion (En segundos):");
		lblDuracion.setBounds(10, 58, 228, 48);
		lblDuracion.setForeground(Color.decode("#ffffff"));
		lblDuracion.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirMusica.add(lblDuracion);
		
		JTextField textFieldNombreCancion = new JTextField();
		textFieldNombreCancion.setBounds(248, 20, 288, 30);
		textFieldNombreCancion.setColumns(10);
		panelAñadirMusica.add(textFieldNombreCancion);
		
		JTextField textFieldDuracion = new JTextField();
		textFieldDuracion.setBounds(248, 70, 288, 30);
		textFieldDuracion.setColumns(10);
		panelAñadirMusica.add(textFieldDuracion);
		
		JLabel lblPortada = new JLabel("Portada:");
		lblPortada.setBounds(153, 106, 85, 48);
		lblPortada.setForeground(Color.decode("#ffffff"));
		lblPortada.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirMusica.add(lblPortada);
		
		JTextField textFieldPortada = new JTextField();
		textFieldPortada.setBounds(248, 116, 288, 30);
		textFieldPortada.setColumns(10);
		panelAñadirMusica.add(textFieldPortada);
		
		JButton btnSubirPortada = new JButton("Subir .jpg");
		btnSubirPortada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Seleccione un archivo .ppg");
				fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos .jpg", "jpg"));

				int userSelection = fileChooser.showOpenDialog(null);

				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					archivoPortadaMu = selectedFile.getName();
					textFieldPortada.setText(archivoPortadaMu);
					Path sourcePath = selectedFile.toPath();
					Path destinationPath = new File("imagenes/portadasMu", archivoPortadaMu).toPath();
					
					try {
						Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
						System.out.println("Archivo subido correctamente a la carpeta 'imagenes/portadasMu'.");
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
				
			}
		});
		btnSubirPortada.setBounds(555, 114, 111, 33);
		btnSubirPortada.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelAñadirMusica.add(btnSubirPortada);
		
		JLabel lblColaboradores = new JLabel("Colaboradores:");
		lblColaboradores.setBounds(90, 154, 148, 48);
		lblColaboradores.setForeground(Color.decode("#ffffff"));
		lblColaboradores.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirMusica.add(lblColaboradores);
		
		JTextField textFieldColaboradores = new JTextField();
		textFieldColaboradores.setBounds(248, 165, 288, 30);
		textFieldColaboradores.setColumns(10);
		panelAñadirMusica.add(textFieldColaboradores);	
		
		JLabel lblArtista = new JLabel("Artista:");
		lblArtista.setBounds(163, 202, 75, 48);
		lblArtista.setForeground(Color.decode("#ffffff"));
		lblArtista.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirMusica.add(lblArtista);
		
		JComboBox comboBoxArtistas = new JComboBox();
		comboBoxArtistas.setBounds(248, 212, 288, 30);
		panelAñadirMusica.add(comboBoxArtistas);
		
		JLabel lblAlbum = new JLabel("Album:");
		lblAlbum.setBounds(163, 250, 75, 48);
		lblAlbum.setForeground(Color.decode("#ffffff"));
		lblAlbum.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirMusica.add(lblAlbum);
		
		JComboBox comboBoxAlbum = new JComboBox();
		comboBoxAlbum.setBounds(248, 260, 288, 30);
		panelAñadirMusica.add(comboBoxAlbum);
		
		JLabel lblAudio = new JLabel("Audio:");
		lblAudio.setBounds(173, 298, 65, 48);
		lblAudio.setForeground(Color.decode("#ffffff"));
		lblAudio.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirMusica.add(lblAudio);
		
		JTextField textFieldAudio = new JTextField();
		textFieldAudio.setBounds(248, 308, 288, 30);
		textFieldAudio.setColumns(10);
		panelAñadirMusica.add(textFieldAudio);
		
		JButton btnSubirWav = new JButton("Subir .wav");
		btnSubirWav.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Seleccione un archivo .wav");
				fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos .wav", "wav"));

				int userSelection = fileChooser.showOpenDialog(null);

				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					archivoMusica = selectedFile.getName();
					textFieldAudio.setText(archivoMusica);
					Path sourcePath = selectedFile.toPath();
					Path destinationPath = new File("musica", archivoMusica).toPath();
					
					try {
						Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
						System.out.println("Archivo subido correctamente a la carpeta 'musica'.");
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnSubirWav.setBounds(555, 306, 111, 33);
		btnSubirWav.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelAñadirMusica.add(btnSubirWav);
		
		JButton btnAñadir = new JButton("Añadir");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAñadir.setFont(new Font("Verdana", Font.BOLD, 16));
		btnAñadir.setOpaque(true);
		btnAñadir.setContentAreaFilled(true);
		btnAñadir.setForeground(Color.decode("#FFFFFF"));
		btnAñadir.setBorderPainted(false);
		btnAñadir.setBackground(Color.decode("#C67ACE"));
		btnAñadir.setBounds(730, 450, 136, 35);
		panelAñadirMusica.add(btnAñadir);

/* ---------------------------------------------------------------------------------------------------------------------------- */	
		
/* ---- Panel eliminar musica ------------------------------------------------------------------------------------------------- */			
		
		panelEliminarMusica = new JPanel();
		panelEliminarMusica.setBounds(275, 175, 880, 500);
		panelEliminarMusica.setBackground(Color.decode("#142850"));
		panelEliminarMusica.setVisible(false);
		add(panelEliminarMusica);
		panelEliminarMusica.setLayout(null);
		
		JLabel lblEliminarMusica = new JLabel("Nombre de la cancion que quiera eliminar:");
		lblEliminarMusica.setBounds(27, 10, 400, 48);
		lblEliminarMusica.setForeground(Color.decode("#ffffff"));
		lblEliminarMusica.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelEliminarMusica.add(lblEliminarMusica);
		
		JTextField textFieldEliminarCancion = new JTextField();
		textFieldEliminarCancion.setBounds(27, 60, 308, 30);
		textFieldEliminarCancion.setColumns(10);
		panelEliminarMusica.add(textFieldEliminarCancion);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setFont(new Font("Verdana", Font.BOLD, 16));
		btnEliminar.setOpaque(true);
		btnEliminar.setContentAreaFilled(true);
		btnEliminar.setForeground(Color.decode("#FFFFFF"));
		btnEliminar.setBorderPainted(false);
		btnEliminar.setBackground(Color.decode("#C67ACE"));
		btnEliminar.setBounds(27, 110, 136, 35);
		panelEliminarMusica.add(btnEliminar);
	
/* ---------------------------------------------------------------------------------------------------------------------------- */	
		
/* ---- Panel añadir artista ------------------------------------------------------------------------------------------------- */
		
		panelAñadirArtista = new JPanel();
		panelAñadirArtista.setBounds(275, 175, 880, 500);
		panelAñadirArtista.setBackground(Color.decode("#142850"));
		panelAñadirArtista.setVisible(false);
		add(panelAñadirArtista);
		panelAñadirArtista.setLayout(null);
		
		JLabel lblNombreArtista = new JLabel("Nombre del artista:");
		lblNombreArtista.setBounds(50, 10, 211, 48);
		lblNombreArtista.setForeground(Color.decode("#ffffff"));
		lblNombreArtista.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirArtista.add(lblNombreArtista);

		JTextField textFieldNombreArtista = new JTextField();
		textFieldNombreArtista.setBounds(248, 20, 288, 30);
		textFieldNombreArtista.setColumns(10);
		panelAñadirArtista.add(textFieldNombreArtista);

		JLabel lblImagenAr = new JLabel("Imagen:");
		lblImagenAr.setBounds(145, 61, 85, 48);
		lblImagenAr.setForeground(Color.decode("#ffffff"));
		lblImagenAr.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirArtista.add(lblImagenAr);

		JTextField textFieldImagen = new JTextField();
		textFieldImagen.setBounds(248, 70, 288, 30);
		textFieldImagen.setColumns(10);
		panelAñadirArtista.add(textFieldImagen);

		JButton btnSubirImagen = new JButton("Subir .jpg");
		btnSubirImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Seleccione un archivo .ppg");
				fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos .jpg", "jpg"));

				int userSelection = fileChooser.showOpenDialog(null);

				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					archivoImagenArt = selectedFile.getName();
					textFieldImagen.setText(archivoImagenArt);
					Path sourcePath = selectedFile.toPath();
					Path destinationPath = new File("imagenes/imagenArt", archivoImagenArt).toPath();
					
					try {
						Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
						System.out.println("Archivo subido correctamente a la carpeta 'imagenes/imagenArt'.");
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
				
			}
		});
		btnSubirImagen.setBounds(555, 68, 111, 33);
		btnSubirImagen.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelAñadirArtista.add(btnSubirImagen);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(112, 116, 128, 48);
		lblDescripcion.setForeground(Color.decode("#ffffff"));
		lblDescripcion.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirArtista.add(lblDescripcion);

		JTextField textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(248, 124, 288, 30);
		textFieldDescripcion.setColumns(10);
		panelAñadirArtista.add(textFieldDescripcion);

		JLabel lblAlbumAr = new JLabel("Album:");
		lblAlbumAr.setBounds(163, 172, 75, 48);
		lblAlbumAr.setForeground(Color.decode("#ffffff"));
		lblAlbumAr.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirArtista.add(lblAlbumAr);

		JComboBox comboBoxAlbumAr = new JComboBox();
		comboBoxAlbumAr.setBounds(248, 180, 288, 30);
		panelAñadirArtista.add(comboBoxAlbumAr);
		
		JLabel lblCaracteristicas = new JLabel("Caracteristicas:");
		lblCaracteristicas.setBounds(86, 222, 150, 48);
		lblCaracteristicas.setForeground(Color.decode("#ffffff"));
		lblCaracteristicas.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirArtista.add(lblCaracteristicas);
		
		JTextField textFieldCaracteristicas = new JTextField();
		textFieldCaracteristicas.setBounds(248, 232, 288, 30);
		textFieldCaracteristicas.setColumns(10);
		panelAñadirArtista.add(textFieldCaracteristicas);
		
		JButton btnAñadirAr = new JButton("Añadir");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAñadirAr.setFont(new Font("Verdana", Font.BOLD, 16));
		btnAñadirAr.setOpaque(true);
		btnAñadirAr.setContentAreaFilled(true);
		btnAñadirAr.setForeground(Color.decode("#FFFFFF"));
		btnAñadirAr.setBorderPainted(false);
		btnAñadirAr.setBackground(Color.decode("#C67ACE"));
		btnAñadirAr.setBounds(730, 450, 136, 35);
		panelAñadirArtista.add(btnAñadirAr);

/* ---------------------------------------------------------------------------------------------------------------------------- */	
		
/* ---- Panel añadir album --------------------------------------------------------------------------------------------------- */
		
		panelAñadirAlbum = new JPanel();
		panelAñadirAlbum.setBounds(275, 175, 880, 500);
		panelAñadirAlbum.setBackground(Color.decode("#142850"));
		panelAñadirAlbum.setVisible(false);
		add(panelAñadirAlbum);
		panelAñadirAlbum.setLayout(null);
		
		JLabel lblNombreAlbum = new JLabel("Nombre del album:");
		lblNombreAlbum.setBounds(55, 10, 180, 48);
		lblNombreAlbum.setForeground(Color.decode("#ffffff"));
		lblNombreAlbum.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirAlbum.add(lblNombreAlbum);
		
		JLabel lblFecha = new JLabel("Fecha (yyyy-MM-dd):");
		lblFecha.setBounds(37, 58, 200, 48);
		lblFecha.setForeground(Color.decode("#ffffff"));
		lblFecha.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirAlbum.add(lblFecha);
		
		JTextField textFieldNombreAlbum = new JTextField();
		textFieldNombreAlbum.setBounds(248, 20, 288, 30);
		textFieldNombreAlbum.setColumns(10);
		panelAñadirAlbum.add(textFieldNombreAlbum);
		
		JTextField textFieldFecha = new JTextField();
		textFieldFecha.setBounds(248, 70, 288, 30);
		textFieldFecha.setColumns(10);
		panelAñadirAlbum.add(textFieldFecha);
		
		JLabel lblPortadaAlb = new JLabel("Portada:");
		lblPortadaAlb.setBounds(153, 106, 85, 48);
		lblPortadaAlb.setForeground(Color.decode("#ffffff"));
		lblPortadaAlb.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirAlbum.add(lblPortadaAlb);
		
		JTextField textFieldPortadaAlb = new JTextField();
		textFieldPortadaAlb.setBounds(248, 116, 288, 30);
		textFieldPortadaAlb.setColumns(10);
		panelAñadirAlbum.add(textFieldPortadaAlb);
		
		JButton btnSubirPortadaAlb = new JButton("Subir .jpg");
		btnSubirPortadaAlb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Seleccione un archivo .ppg");
				fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos .jpg", "jpg"));

				int userSelection = fileChooser.showOpenDialog(null);

				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					archivoPortadaAlb = selectedFile.getName();
					textFieldPortadaAlb.setText(archivoPortadaAlb);
					Path sourcePath = selectedFile.toPath();
					Path destinationPath = new File("imagenes/portadasAlb", archivoPortadaAlb).toPath();
					
					try {
						Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
						System.out.println("Archivo subido correctamente a la carpeta 'imagenes/portadasAlb'.");
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
				
			}
		});
		btnSubirPortadaAlb.setBounds(555, 114, 111, 33);
		btnSubirPortadaAlb.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelAñadirAlbum.add(btnSubirPortadaAlb);
		
		JLabel lblArtistaAlb = new JLabel("Artista:");
		lblArtistaAlb.setBounds(163, 154, 70, 48);
		lblArtistaAlb.setForeground(Color.decode("#ffffff"));
		lblArtistaAlb.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirAlbum.add(lblArtistaAlb);
		
		JComboBox comboBoxAlbumAlb = new JComboBox();
		comboBoxAlbumAlb.setBounds(248, 164, 288, 30);
		panelAñadirAlbum.add(comboBoxAlbumAlb);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(154, 200, 85, 48);
		lblGenero.setForeground(Color.decode("#ffffff"));
		lblGenero.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirAlbum.add(lblGenero);
		
		JTextField textFieldGenero = new JTextField();
		textFieldGenero.setBounds(248, 210, 288, 30);
		textFieldGenero.setColumns(10);
		panelAñadirAlbum.add(textFieldGenero);
		
		JButton btnAñadirAlb = new JButton("Añadir");
		btnAñadirAlb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAñadirAlb.setFont(new Font("Verdana", Font.BOLD, 16));
		btnAñadirAlb.setOpaque(true);
		btnAñadirAlb.setContentAreaFilled(true);
		btnAñadirAlb.setForeground(Color.decode("#FFFFFF"));
		btnAñadirAlb.setBorderPainted(false);
		btnAñadirAlb.setBackground(Color.decode("#C67ACE"));
		btnAñadirAlb.setBounds(730, 450, 136, 35);
		panelAñadirAlbum.add(btnAñadirAlb);

/* ---------------------------------------------------------------------------------------------------------------------------- */		
	
/* ---- Panel eliminar album --------------------------------------------------------------------------------------------------- */
		
		panelEliminarAlbum = new JPanel();
		panelEliminarAlbum.setBounds(275, 175, 880, 500);
		panelEliminarAlbum.setBackground(Color.decode("#142850"));
		panelEliminarAlbum.setVisible(false);
		add(panelEliminarAlbum);
		panelEliminarAlbum.setLayout(null);
		
		JLabel lblEliminarAlbum = new JLabel("Nombre del album que quiera eliminar:");
		lblEliminarAlbum.setBounds(27, 10, 400, 48);
		lblEliminarAlbum.setForeground(Color.decode("#ffffff"));
		lblEliminarAlbum.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelEliminarAlbum.add(lblEliminarAlbum);
		
		JTextField textFieldEliminarAlbum = new JTextField();
		textFieldEliminarAlbum.setBounds(27, 60, 308, 30);
		textFieldEliminarAlbum.setColumns(10);
		panelEliminarAlbum.add(textFieldEliminarAlbum);
		
		JButton btnEliminarAlb = new JButton("Eliminar");
		btnEliminarAlb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminarAlb.setFont(new Font("Verdana", Font.BOLD, 16));
		btnEliminarAlb.setOpaque(true);
		btnEliminarAlb.setContentAreaFilled(true);
		btnEliminarAlb.setForeground(Color.decode("#FFFFFF"));
		btnEliminarAlb.setBorderPainted(false);
		btnEliminarAlb.setBackground(Color.decode("#C67ACE"));
		btnEliminarAlb.setBounds(27, 110, 136, 35);
		panelEliminarAlbum.add(btnEliminarAlb);
		
/* ---------------------------------------------------------------------------------------------------------------------------- */
		
/* ---- Panel eliminar album --------------------------------------------------------------------------------------------------- */
		
		panelEliminarArtista = new JPanel();
		panelEliminarArtista.setBounds(275, 175, 880, 500);
		panelEliminarArtista.setBackground(Color.decode("#142850"));
		panelEliminarArtista.setVisible(false);
		add(panelEliminarArtista);
		panelEliminarArtista.setLayout(null);
		
		JLabel lblEliminarArtista = new JLabel("Nombre del artista que quiera eliminar:");
		lblEliminarArtista.setBounds(27, 10, 400, 48);
		lblEliminarArtista.setForeground(Color.decode("#ffffff"));
		lblEliminarArtista.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelEliminarArtista.add(lblEliminarArtista);
		
		JTextField textFieldEliminarArtista = new JTextField();
		textFieldEliminarArtista.setBounds(27, 60, 308, 30);
		textFieldEliminarArtista.setColumns(10);
		panelEliminarArtista.add(textFieldEliminarArtista);
		
		JButton btnEliminarArt = new JButton("Eliminar");
		btnEliminarArt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminarArt.setFont(new Font("Verdana", Font.BOLD, 16));
		btnEliminarArt.setOpaque(true);
		btnEliminarArt.setContentAreaFilled(true);
		btnEliminarArt.setForeground(Color.decode("#FFFFFF"));
		btnEliminarArt.setBorderPainted(false);
		btnEliminarArt.setBackground(Color.decode("#C67ACE"));
		btnEliminarArt.setBounds(27, 110, 136, 35);
		panelEliminarArtista.add(btnEliminarArt);

/* ---------------------------------------------------------------------------------------------------------------------------- */
	}
}
