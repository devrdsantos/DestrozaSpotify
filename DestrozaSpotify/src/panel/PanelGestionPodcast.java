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
import controller.GestionDeLaInformacion;
import view.VistaPrincipal;

public class PanelGestionPodcast extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelAñadirPodcast;
	private JPanel panelAñadirPodcaster;
	private JPanel panelAñadirEpisodio;
	private JPanel panelEliminarPodcast;
	private JPanel panelEliminarPodcaster;
	private JPanel panelEliminarEpisodio;
	private JPanel panelModificarPodcast;
	private JPanel panelModificarPodcaster;

	
	private String archivoPortadaPodcaster;
	private String archivoMusicaPodcast;

	public PanelGestionPodcast(VistaPrincipal v, GestionBD gestionBD, GestionDeLaInformacion gestionINF) {

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

		JLabel lblMenuAdministrador = new JLabel("Gestion de podcast");
		lblMenuAdministrador.setForeground(Color.decode("#ffffff"));
		lblMenuAdministrador.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuAdministrador.setFont(new Font("Malgun Gothic", Font.BOLD, 32));
		lblMenuAdministrador.setBounds(360, 55, 480, 48);
		add(lblMenuAdministrador);

		/*
		 * ----- Panel menu botones
		 * -----------------------------------------------------------------------------
		 * -----------
		 */

		JPanel MenuBotones = new JPanel();
		MenuBotones.setBounds(40, 250, 190, 370);
		add(MenuBotones);
		MenuBotones.setLayout(null);

		/**
		 * Boton para mostrar el panel de eliminar Podcast
		 */
		JButton btnEliminarPodcast = new JButton("Eliminar podcast");
		btnEliminarPodcast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAñadirPodcast.setVisible(false);
				panelAñadirPodcaster.setVisible(false);
				panelEliminarPodcaster.setVisible(false);
				panelEliminarPodcast.setVisible(true);
			}
		});
		btnEliminarPodcast.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminarPodcast.setBounds(10, 170, 170, 30);
		MenuBotones.add(btnEliminarPodcast);

		/**
		 * Boton para mostrar el panel de añadir Podcaster
		 */
		JButton btnAñadirPod = new JButton("Añadir podcaster");
		btnAñadirPod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEliminarPodcaster.setVisible(false);
				panelEliminarPodcast.setVisible(false);
				panelAñadirPodcast.setVisible(false);
				panelAñadirPodcaster.setVisible(true);
			}
		});
		btnAñadirPod.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAñadirPod.setBounds(10, 10, 170, 30);
		MenuBotones.add(btnAñadirPod);

		/**
		 * Boton para mostrar el panel de añadir Podcast
		 */
		JButton btnAñadirPodcast = new JButton("Añadir podcast");
		btnAñadirPodcast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEliminarPodcaster.setVisible(false);
				panelEliminarPodcast.setVisible(false);
				panelAñadirPodcaster.setVisible(false);
				panelAñadirPodcast.setVisible(true);
			}
		});
		btnAñadirPodcast.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAñadirPodcast.setBounds(10, 50, 170, 30);
		MenuBotones.add(btnAñadirPodcast);

		/**
		 * Boton para mostrar el panel de eliminar Podcaster
		 */
		JButton btnEliminarPodcaster = new JButton("Eliminar podcaster");
		btnEliminarPodcaster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEliminarPodcast.setVisible(false);
				panelAñadirPodcast.setVisible(false);
				panelAñadirPodcaster.setVisible(false);
				panelEliminarPodcaster.setVisible(true);
			}
		});
		btnEliminarPodcaster.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminarPodcaster.setBounds(10, 130, 170, 30);
		MenuBotones.add(btnEliminarPodcaster);

		/**
		 * Boton para mostrar el panel de modificar el Podcaster
		 */
		JButton btnModificarPodcaster = new JButton("Modificar podcaster");
		btnModificarPodcaster.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarPodcaster.setBounds(10, 250, 170, 30);
		MenuBotones.add(btnModificarPodcaster);

		/**
		 * Boton para mostrar el panel de modificar Podcast
		 */
		JButton btnModificarPodcast = new JButton("Modificar podcast");
		btnModificarPodcast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificarPodcast.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarPodcast.setBounds(10, 290, 170, 30);
		MenuBotones.add(btnModificarPodcast);
		
		JButton btnAadirEpisodio = new JButton("Añadir episodio");
		btnAadirEpisodio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEliminarPodcast.setVisible(false);
				panelAñadirPodcast.setVisible(false);
				panelAñadirPodcaster.setVisible(false);
				panelEliminarPodcaster.setVisible(false);
				panelAñadirEpisodio.setVisible(true);
			}
		});
		btnAadirEpisodio.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAadirEpisodio.setBounds(10, 90, 170, 30);
		MenuBotones.add(btnAadirEpisodio);
		
		JButton btnEliminarPodcast_1 = new JButton("Eliminar episodio");
		btnEliminarPodcast_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminarPodcast_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminarPodcast_1.setBounds(10, 210, 170, 30);
		MenuBotones.add(btnEliminarPodcast_1);
		
		JButton btnEliminarPodcast_1_1 = new JButton("Modificar episodio");
		btnEliminarPodcast_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminarPodcast_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminarPodcast_1_1.setBounds(10, 330, 170, 30);
		MenuBotones.add(btnEliminarPodcast_1_1);

		/*
		 * -----------------------------------------------------------------------------
		 * ----------------------------------------------------
		 */

		/*
		 * ----- Panel añadir podcaster
		 * -----------------------------------------------------------------------------
		 * -----------------------
		 */

		panelAñadirPodcaster = new JPanel();
		panelAñadirPodcaster.setBounds(275, 175, 880, 500);
		panelAñadirPodcaster.setBackground(Color.decode("#142850"));
		panelAñadirPodcaster.setVisible(false);
		add(panelAñadirPodcaster);
		panelAñadirPodcaster.setLayout(null);

		JLabel lblNombrePodcaster = new JLabel("Nombre del podcaster:");
		lblNombrePodcaster.setBounds(27, 10, 211, 48);
		lblNombrePodcaster.setForeground(Color.decode("#ffffff"));
		lblNombrePodcaster.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirPodcaster.add(lblNombrePodcaster);

		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(160, 58, 228, 48);
		lblGenero.setForeground(Color.decode("#ffffff"));
		lblGenero.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirPodcaster.add(lblGenero);

		JTextField textFieldNombrePodcaster = new JTextField();
		textFieldNombrePodcaster.setBounds(248, 20, 288, 30);
		textFieldNombrePodcaster.setColumns(10);
		panelAñadirPodcaster.add(textFieldNombrePodcaster);

		JTextField textFieldGenero = new JTextField();
		textFieldGenero.setBounds(248, 70, 288, 30);
		textFieldGenero.setColumns(10);
		panelAñadirPodcaster.add(textFieldGenero);

		JLabel lblPortadaPodcaster = new JLabel("Portada:");
		lblPortadaPodcaster.setBounds(153, 106, 85, 48);
		lblPortadaPodcaster.setForeground(Color.decode("#ffffff"));
		lblPortadaPodcaster.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirPodcaster.add(lblPortadaPodcaster);

		JTextField textFieldPortadaPodcaster = new JTextField();
		textFieldPortadaPodcaster.setBounds(248, 116, 288, 30);
		textFieldPortadaPodcaster.setColumns(10);
		panelAñadirPodcaster.add(textFieldPortadaPodcaster);

		/**
		 * Boton para subir la portada del Podcaster
		 */
		JButton btnSubirPortadaPodcaster = new JButton("Subir .jpg");
		btnSubirPortadaPodcaster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * El selector de archivos para guardarlos en el proyecto
				 */
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Seleccione un archivo .ppg");
				/**
				 * Filtro para solo elegir archivos .jpg
				 */
				fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos .jpg", "jpg"));

				int userSelection = fileChooser.showOpenDialog(null);

				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					archivoPortadaPodcaster = selectedFile.getName();
					textFieldPortadaPodcaster.setText(archivoPortadaPodcaster);
					Path sourcePath = selectedFile.toPath();
					/**
					 * En que parte debe dejar el archivo subido
					 */
					Path destinationPath = new File("imagenes/imagenArt", archivoPortadaPodcaster).toPath();

					try {
						Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
						System.out.println("Archivo subido correctamente a la carpeta 'imagenes/portadasPodcast'.");
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}

			}
		});
		btnSubirPortadaPodcaster.setBounds(555, 114, 111, 33);
		btnSubirPortadaPodcaster.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelAñadirPodcaster.add(btnSubirPortadaPodcaster);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(130, 154, 148, 48);
		lblDescripcion.setForeground(Color.decode("#ffffff"));
		lblDescripcion.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirPodcaster.add(lblDescripcion);

		JTextField textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(248, 165, 288, 30);
		textFieldDescripcion.setColumns(10);
		panelAñadirPodcaster.add(textFieldDescripcion);

		/**
		 * Boton para añadir el Podcaster
		 */
		JButton btnAñadir = new JButton("Añadir");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				gestionBD.insertPodcaster(textFieldNombrePodcaster.getText(), textFieldNombrePodcaster.getText(),
						textFieldGenero.getText(), textFieldDescripcion.getText());

				v.cambiarDePanel(6);

			}
		});
		btnAñadir.setFont(new Font("Verdana", Font.BOLD, 16));
		btnAñadir.setOpaque(true);
		btnAñadir.setContentAreaFilled(true);
		btnAñadir.setForeground(Color.decode("#FFFFFF"));
		btnAñadir.setBorderPainted(false);
		btnAñadir.setBackground(Color.decode("#C67ACE"));
		btnAñadir.setBounds(730, 450, 136, 35);
		panelAñadirPodcaster.add(btnAñadir);

		/*
		 * -----------------------------------------------------------------------------
		 * -------------------------------------------------
		 */

		/*
		 * ----- Panel añadir podcast
		 * -----------------------------------------------------------------------------
		 * ----------------------
		 */

		panelAñadirPodcast = new JPanel();
		panelAñadirPodcast.setBounds(275, 175, 880, 500);
		panelAñadirPodcast.setBackground(Color.decode("#142850"));
		panelAñadirPodcast.setVisible(false);
		add(panelAñadirPodcast);
		panelAñadirPodcast.setLayout(null);

		JLabel lblNombreAudio = new JLabel("Nombre del podcast:");
		lblNombreAudio.setBounds(45, 10, 211, 48);
		lblNombreAudio.setForeground(Color.decode("#ffffff"));
		lblNombreAudio.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirPodcast.add(lblNombreAudio);
		
		JTextField textFieldNombrePodcast = new JTextField();
		textFieldNombrePodcast.setBounds(248, 20, 288, 30);
		textFieldNombrePodcast.setColumns(10);
		panelAñadirPodcast.add(textFieldNombrePodcast);

		JLabel lblPortada = new JLabel("Portada:");
		lblPortada.setBounds(153, 58, 85, 48);
		lblPortada.setForeground(Color.decode("#ffffff"));
		lblPortada.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirPodcast.add(lblPortada);

		JTextField textFieldPortada = new JTextField();
		textFieldPortada.setBounds(248, 68, 288, 30);
		textFieldPortada.setColumns(10);
		panelAñadirPodcast.add(textFieldPortada);

		/**
		 * Boton para subir la portada del Podcast
		 */
		JButton btnSubirPortada = new JButton("Subir .jpg");
		btnSubirPortada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * El selector de archivos para guardarlos en el proyecto
				 */
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Seleccione un archivo .jpg");
				/**
				 * Filtro para solo elegir archivos .jpg
				 */
				fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos .jpg", "jpg"));

				int userSelection = fileChooser.showOpenDialog(null);

				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					archivoPortadaPodcaster = selectedFile.getName();
					textFieldPortada.setText(archivoPortadaPodcaster);
					Path sourcePath = selectedFile.toPath();
					/**
					 * En que parte debe dejar el archivo subido
					 */
					Path destinationPath = new File("imagenes/portadasPodcast", archivoPortadaPodcaster).toPath();

					try {
						Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
						System.out.println("Archivo subido correctamente a la carpeta 'imagenes/portadasPodcast'.");
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}

			}
		});
		btnSubirPortada.setBounds(555, 64, 111, 33);
		btnSubirPortada.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelAñadirPodcast.add(btnSubirPortada);

		JLabel lblPodcaster = new JLabel("Podcaster:");
		lblPodcaster.setBounds(136, 106, 120, 48);
		lblPodcaster.setForeground(Color.decode("#ffffff"));
		lblPodcaster.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirPodcast.add(lblPodcaster);

		/**
		 * ComboBox para enseñar los Podcasters
		 */
		JComboBox<String> comboBoxPodcaster = new JComboBox<String>();
		for (int i = 0; i < gestionBD.sacarPodcasterInformacion().size(); i++) {
			comboBoxPodcaster.addItem(gestionBD.sacarPodcasterInformacion().get(i).getNombreArtistico());
		}
		comboBoxPodcaster.setBounds(248, 116, 288, 30);
		panelAñadirPodcast.add(comboBoxPodcaster);



		/**
		 * Boton para subir el Podcast
		 */
		JButton btnAñadirPodc = new JButton("Añadir");
		btnAñadirPodc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println(textFieldNombreCancion.getText().replace(" ", ""));

				gestionBD.insertPodcast(textFieldNombrePodcast.getText(),textFieldNombrePodcast.getText() , gestionBD.idPodcaster(comboBoxPodcaster.getSelectedItem().toString()));

				v.cambiarDePanel(5);

			}
		});
		btnAñadirPodc.setFont(new Font("Verdana", Font.BOLD, 16));
		btnAñadirPodc.setOpaque(true);
		btnAñadirPodc.setContentAreaFilled(true);
		btnAñadirPodc.setForeground(Color.decode("#FFFFFF"));
		btnAñadirPodc.setBorderPainted(false);
		btnAñadirPodc.setBackground(Color.decode("#C67ACE"));
		btnAñadirPodc.setBounds(730, 450, 136, 35);
		panelAñadirPodcast.add(btnAñadirPodc);

		/*
		 * -----------------------------------------------------------------------------
		 * ----------------------------------------------------
		 */
		
		/*
		 * ----- Panel añadir episodio
		 * -----------------------------------------------------------------------------
		 * --------------------
		 */
		
		panelAñadirEpisodio = new JPanel();
		panelAñadirEpisodio.setBounds(275, 175, 880, 500);
		panelAñadirEpisodio.setBackground(Color.decode("#142850"));
		panelAñadirEpisodio.setVisible(false);
		add(panelAñadirEpisodio);
		panelAñadirEpisodio.setLayout(null);
		
		JLabel lblNombreEpisodio = new JLabel("Nombre del episodio:");
		lblNombreEpisodio.setBounds(45, 10, 211, 48);
		lblNombreEpisodio.setForeground(Color.decode("#ffffff"));
		lblNombreEpisodio.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirEpisodio.add(lblNombreEpisodio);
		
		JTextField textFieldNombreEpisodio = new JTextField();
		textFieldNombreEpisodio.setBounds(248, 20, 288, 30);
		textFieldNombreEpisodio.setColumns(10);
		panelAñadirEpisodio.add(textFieldNombreEpisodio);
		
		JLabel lblAudio = new JLabel("Audio:");
		lblAudio.setBounds(173, 250, 65, 48);
		lblAudio.setForeground(Color.decode("#ffffff"));
		lblAudio.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirEpisodio.add(lblAudio);

		JTextField textFieldAudio = new JTextField();
		textFieldAudio.setBounds(248, 260, 288, 30);
		textFieldAudio.setColumns(10);
		panelAñadirEpisodio.add(textFieldAudio);

		/**
		 * Boton para subir el wav
		 */
		JButton btnSubirWav = new JButton("Subir .wav");
		btnSubirWav.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * El selector de archivos para guardarlos en el proyecto
				 */
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Seleccione un archivo .wav");
				/**
				 * Filtro para solo elegir archivos .wav
				 */
				fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos .wav", "wav"));

				int userSelection = fileChooser.showOpenDialog(null);

				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					archivoMusicaPodcast = selectedFile.getName();
					textFieldAudio.setText(archivoMusicaPodcast);
					Path sourcePath = selectedFile.toPath();
					/**
					 * En que parte debe dejar el archivo subido
					 */
					Path destinationPath = new File("musica", archivoMusicaPodcast).toPath();

					try {
						Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
						System.out.println("Archivo subido correctamente a la carpeta 'musica'.");
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnSubirWav.setBounds(555, 258, 111, 33);
		btnSubirWav.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelAñadirEpisodio.add(btnSubirWav);

		JLabel lblDescripcionPodc = new JLabel("Descripcion:");
		lblDescripcionPodc.setBounds(122, 154, 148, 48);
		lblDescripcionPodc.setForeground(Color.decode("#ffffff"));
		lblDescripcionPodc.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirEpisodio.add(lblDescripcionPodc);

		JTextField textFieldDescripcionPodc = new JTextField();
		textFieldDescripcionPodc.setBounds(248, 165, 288, 30);
		textFieldDescripcionPodc.setColumns(10);
		panelAñadirEpisodio.add(textFieldDescripcionPodc);
		
		JLabel lblColaboradores = new JLabel("Colaboradores:");
		lblColaboradores.setBounds(92, 200, 148, 48);
		lblColaboradores.setForeground(Color.decode("#ffffff"));
		lblColaboradores.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirEpisodio.add(lblColaboradores);

		JTextField textFieldColaboradores = new JTextField();
		textFieldColaboradores.setBounds(248, 210, 288, 30);
		textFieldColaboradores.setColumns(10);
		panelAñadirEpisodio.add(textFieldColaboradores);
		
		JLabel lblDuracion = new JLabel("Duracion (En segundos):");
		lblDuracion.setBounds(10, 58, 228, 48);
		lblDuracion.setForeground(Color.decode("#ffffff"));
		lblDuracion.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirEpisodio.add(lblDuracion);

		JTextField textFieldDuracion = new JTextField();
		textFieldDuracion.setBounds(248, 70, 288, 30);
		textFieldDuracion.setColumns(10);
		panelAñadirEpisodio.add(textFieldDuracion);
		
		JLabel lblPortadaEpisodio = new JLabel("Portada:");
		lblPortadaEpisodio.setBounds(153, 106, 85, 48);
		lblPortadaEpisodio.setForeground(Color.decode("#ffffff"));
		lblPortadaEpisodio.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirEpisodio.add(lblPortadaEpisodio);

		JTextField textFieldPortadaEpisodio = new JTextField();
		textFieldPortadaEpisodio.setBounds(248, 116, 288, 30);
		textFieldPortadaEpisodio.setColumns(10);
		panelAñadirEpisodio.add(textFieldPortadaEpisodio);

		/**
		 * Boton para subir la portada del Episodio
		 */
		JButton btnSubirPortadaEpisodio = new JButton("Subir .jpg");
		btnSubirPortadaEpisodio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * El selector de archivos para guardarlos en el proyecto
				 */
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Seleccione un archivo .jpg");
				/**
				 * Filtro para solo elegir archivos .jpg
				 */
				fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos .jpg", "jpg"));

				int userSelection = fileChooser.showOpenDialog(null);

				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					archivoPortadaPodcaster = selectedFile.getName();
					textFieldPortadaEpisodio.setText(archivoPortadaPodcaster);
					Path sourcePath = selectedFile.toPath();
					/**
					 * En que parte debe dejar el archivo subido
					 */
					Path destinationPath = new File("imagenes/portadasEpisodio", archivoPortadaPodcaster).toPath();

					try {
						Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
						System.out.println("Archivo subido correctamente a la carpeta 'imagenes/portadasEpisodio'.");
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}

			}
		});
		btnSubirPortadaEpisodio.setBounds(555, 114, 111, 33);
		btnSubirPortadaEpisodio.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelAñadirEpisodio.add(btnSubirPortadaEpisodio);
		
		JLabel lblPodcast = new JLabel("Podcast:");
		lblPodcast.setBounds(156, 300, 120, 48);
		lblPodcast.setForeground(Color.decode("#ffffff"));
		lblPodcast.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirEpisodio.add(lblPodcast);

		/**
		 * ComboBox para enseñar los Podcasters
		 */
		JComboBox<String> comboBoxPodcast = new JComboBox<String>();
		for (int i = 0; i < gestionINF.sacarPodcastInformacion().size(); i++) {
			comboBoxPodcast.addItem(gestionINF.sacarPodcastInformacion().get(i).getTitulo());
		}
		comboBoxPodcast.setBounds(248, 312, 288, 30);
		panelAñadirEpisodio.add(comboBoxPodcast);
		
		JButton btnAñadirEpisodio = new JButton("Añadir");
		btnAñadirEpisodio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				gestionINF.insertAudio(textFieldNombreEpisodio.getText(), Integer.parseInt(textFieldDuracion.getText()), textFieldNombreEpisodio.getText().replace(" ", ""));
				gestionINF.insertEpisodio(gestionINF.sacarIdDelAudio(textFieldNombreEpisodio.getText()), gestionINF.devolverIdPodcast(comboBoxPodcast.getSelectedItem().toString()), textFieldColaboradores.getText());

				v.cambiarDePanel(5);

			}
		});
		btnAñadirEpisodio.setFont(new Font("Verdana", Font.BOLD, 16));
		btnAñadirEpisodio.setOpaque(true);
		btnAñadirEpisodio.setContentAreaFilled(true);
		btnAñadirEpisodio.setForeground(Color.decode("#FFFFFF"));
		btnAñadirEpisodio.setBorderPainted(false);
		btnAñadirEpisodio.setBackground(Color.decode("#C67ACE"));
		btnAñadirEpisodio.setBounds(730, 450, 136, 35);
		panelAñadirEpisodio.add(btnAñadirEpisodio);
		
		
		/*
		 * -----------------------------------------------------------------------------
		 * -------------------------------------------------
		 */
		

		/*
		 * ----- Panel eliminar podcast
		 * -----------------------------------------------------------------------------
		 * -----------------------
		 */

		panelEliminarPodcast = new JPanel();
		panelEliminarPodcast.setBounds(275, 175, 880, 500);
		panelEliminarPodcast.setBackground(Color.decode("#142850"));
		panelEliminarPodcast.setVisible(false);
		add(panelEliminarPodcast);
		panelEliminarPodcast.setLayout(null);

		JLabel lblEliminarPodcast = new JLabel("Nombre del podcast que quiera eliminar:");
		lblEliminarPodcast.setBounds(27, 10, 400, 48);
		lblEliminarPodcast.setForeground(Color.decode("#ffffff"));
		lblEliminarPodcast.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelEliminarPodcast.add(lblEliminarPodcast);

		JTextField textFieldEliminarPodcast = new JTextField();
		textFieldEliminarPodcast.setBounds(27, 60, 308, 30);
		textFieldEliminarPodcast.setColumns(10);
		panelEliminarPodcast.add(textFieldEliminarPodcast);

		/**
		 * Boton para eliminar el Podcast
		 */
		JButton btnEliminarPodc = new JButton("Eliminar");
		btnEliminarPodc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				gestionBD.deletePodcast(textFieldEliminarPodcast.getText());
				gestionBD.deleteAudio(textFieldEliminarPodcast.getText());

				/**
				 * Elimina los archivos de la Cancion (.jpg, .wav)
				 */
				File f1 = new File(
						"imagenes/portadasPodcast/" + textFieldEliminarPodcast.getText().replace(" ", "") + ".jpg");
				File f2 = new File("musica/" + textFieldEliminarPodcast.getText().replace(" ", "") + ".wav");

				f1.delete();
				f2.delete();

				v.cambiarDePanel(5);

			}
		});
		btnEliminarPodc.setFont(new Font("Verdana", Font.BOLD, 16));
		btnEliminarPodc.setOpaque(true);
		btnEliminarPodc.setContentAreaFilled(true);
		btnEliminarPodc.setForeground(Color.decode("#FFFFFF"));
		btnEliminarPodc.setBorderPainted(false);
		btnEliminarPodc.setBackground(Color.decode("#C67ACE"));
		btnEliminarPodc.setBounds(27, 110, 136, 35);
		panelEliminarPodcast.add(btnEliminarPodc);

		/*
		 * -----------------------------------------------------------------------------
		 * -------------------------------------------------
		 */
		
		

		/*
		 * ----- Panel eliminar podcaster
		 * -----------------------------------------------------------------------------
		 * --------------------
		 */

		panelEliminarPodcaster = new JPanel();
		panelEliminarPodcaster.setBounds(275, 175, 880, 500);
		panelEliminarPodcaster.setBackground(Color.decode("#142850"));
		panelEliminarPodcaster.setVisible(false);
		add(panelEliminarPodcaster);
		panelEliminarPodcaster.setLayout(null);

		JLabel lblEliminarPodcaster = new JLabel("Nombre del podcaster que quiera eliminar:");
		lblEliminarPodcaster.setBounds(27, 10, 400, 48);
		lblEliminarPodcaster.setForeground(Color.decode("#ffffff"));
		lblEliminarPodcaster.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelEliminarPodcaster.add(lblEliminarPodcaster);

		JTextField textFieldEliminarPodcaster = new JTextField();
		textFieldEliminarPodcaster.setBounds(27, 60, 308, 30);
		textFieldEliminarPodcaster.setColumns(10);
		panelEliminarPodcaster.add(textFieldEliminarPodcaster);

		/**
		 * Boton para eliminar el Podcaster
		 */
		JButton btnDeletePodcaster = new JButton("Eliminar");
		btnDeletePodcaster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				gestionBD.deletePodcaster(textFieldEliminarPodcaster.getText());

				/**
				 * Elimina los archivos de la Cancion (.jpg, .wav)
				 */
				File f = new File(
						"imagenes/imagenArt/" + textFieldEliminarPodcaster.getText().replace(" ", "") + ".jpg");

				f.delete();

				v.cambiarDePanel(5);

			}
		});
		btnDeletePodcaster.setFont(new Font("Verdana", Font.BOLD, 16));
		btnDeletePodcaster.setOpaque(true);
		btnDeletePodcaster.setContentAreaFilled(true);
		btnDeletePodcaster.setForeground(Color.decode("#FFFFFF"));
		btnDeletePodcaster.setBorderPainted(false);
		btnDeletePodcaster.setBackground(Color.decode("#C67ACE"));
		btnDeletePodcaster.setBounds(27, 110, 136, 35);
		panelEliminarPodcaster.add(btnDeletePodcaster);
		
		/*
		 * ----- Panel eliminar episodio
		 * -----------------------------------------------------------------------------
		 * --------------------
		 */
		
		panelEliminarEpisodio = new JPanel();
		panelEliminarEpisodio.setBounds(275, 175, 880, 500);
		panelEliminarEpisodio.setBackground(Color.decode("#142850"));
		panelEliminarEpisodio.setVisible(false);
		add(panelEliminarEpisodio);
		panelEliminarEpisodio.setLayout(null);

		JLabel lblEliminarEpisodio = new JLabel("Nombre del episodio que quiera eliminar:");
		lblEliminarEpisodio.setBounds(27, 10, 400, 48);
		lblEliminarEpisodio.setForeground(Color.decode("#ffffff"));
		lblEliminarEpisodio.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelEliminarPodcaster.add(lblEliminarEpisodio);

		JTextField textFieldEliminarEpisodio = new JTextField();
		textFieldEliminarEpisodio.setBounds(27, 60, 308, 30);
		textFieldEliminarEpisodio.setColumns(10);
		panelEliminarPodcaster.add(textFieldEliminarEpisodio);

		/**
		 * Boton para eliminar el Podcaster
		 */
		JButton btnDeleteEpisodio = new JButton("Eliminar");
		btnDeleteEpisodio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionBD.deleteEpisodio(gestionINF.sacarIdDelAudio(textFieldEliminarEpisodio.getText()));

				/**
				 * Elimina los archivos de la Cancion (.jpg, .wav)
				 */
				File f = new File(
						"imagenes/portadasEpisodio/" + textFieldEliminarEpisodio.getText().replace(" ", "") + ".jpg");
				File f1 = new File("musica/"+ textFieldEliminarEpisodio.getText().replace(" ", "") + ".wav");
				
				f.delete();
				f1.delete();

				v.cambiarDePanel(5);

			}
		});
		btnDeleteEpisodio.setFont(new Font("Verdana", Font.BOLD, 16));
		btnDeleteEpisodio.setOpaque(true);
		btnDeleteEpisodio.setContentAreaFilled(true);
		btnDeleteEpisodio.setForeground(Color.decode("#FFFFFF"));
		btnDeleteEpisodio.setBorderPainted(false);
		btnDeleteEpisodio.setBackground(Color.decode("#C67ACE"));
		btnDeleteEpisodio.setBounds(27, 110, 136, 35);
		panelEliminarPodcaster.add(btnDeleteEpisodio);

		/*
		 * ----- Panel modificar podcaster
		 * -----------------------------------------------------------------------------
		 * --------------------
		 */
		
		panelModificarPodcaster = new JPanel();
		panelModificarPodcaster.setBounds(275, 175, 880, 500);
		panelModificarPodcaster.setBackground(Color.decode("#142850"));
		panelModificarPodcaster.setVisible(false);
		add(panelModificarPodcaster);
		panelModificarPodcaster.setLayout(null);
		
		JLabel lblModificarMusico = new JLabel("Nombre del podcaster:");
		lblModificarMusico.setForeground(Color.WHITE);
		lblModificarMusico.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblModificarMusico.setBounds(27, 10, 211, 48);
		panelModificarPodcaster.add(lblModificarMusico);
		
		JLabel lblModificarNombreAu = new JLabel("Nombre artistico:");
		lblModificarNombreAu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModificarNombreAu.setForeground(Color.WHITE);
		lblModificarNombreAu.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblModificarNombreAu.setBounds(27, 107, 211, 48);
		panelModificarPodcaster.add(lblModificarNombreAu);
		
		JLabel lblModificarImagenAu = new JLabel("Imagen:");
		lblModificarImagenAu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModificarImagenAu.setForeground(Color.WHITE);
		lblModificarImagenAu.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblModificarImagenAu.setBounds(27, 225, 211, 48);
		panelModificarPodcaster.add(lblModificarImagenAu);
		
		JLabel lblModificarDuracionAu = new JLabel("Genero:");
		lblModificarDuracionAu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModificarDuracionAu.setForeground(Color.WHITE);
		lblModificarDuracionAu.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblModificarDuracionAu.setBounds(27, 166, 211, 48);
		panelModificarPodcaster.add(lblModificarDuracionAu);
		
		JLabel lblModificarColaboracionCa = new JLabel("Descripcion:");
		lblModificarColaboracionCa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModificarColaboracionCa.setForeground(Color.WHITE);
		lblModificarColaboracionCa.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblModificarColaboracionCa.setBounds(27, 285, 211, 48);
		panelModificarPodcaster.add(lblModificarColaboracionCa);
		
		JTextField textFieldNombreArtistico = new JTextField();
		textFieldNombreArtistico.setColumns(10);
		textFieldNombreArtistico.setBounds(248, 117, 288, 30);
		panelModificarPodcaster.add(textFieldNombreArtistico);
		
		JTextField textFieldGeneroPodcaster = new JTextField();
		textFieldGeneroPodcaster.setColumns(10);
		textFieldGeneroPodcaster.setBounds(248, 175, 288, 30);
		panelModificarPodcaster.add(textFieldGeneroPodcaster);
		
		JTextField textFieldDescripcionMo = new JTextField();
		textFieldDescripcionMo.setColumns(10);
		textFieldDescripcionMo.setBounds(248, 295, 288, 30);
		panelModificarPodcaster.add(textFieldDescripcionMo);
		
		JTextField textFieldImagenPodcasterMo = new JTextField();
		textFieldImagenPodcasterMo.setColumns(10);
		textFieldImagenPodcasterMo.setBounds(248, 235, 288, 30);
		panelModificarPodcaster.add(textFieldImagenPodcasterMo);
		
		JButton btnModificarPodcasterMo = new JButton("Modificar");
		btnModificarPodcasterMo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificarPodcasterMo.setOpaque(true);
		btnModificarPodcasterMo.setForeground(Color.WHITE);
		btnModificarPodcasterMo.setFont(new Font("Verdana", Font.BOLD, 16));
		btnModificarPodcasterMo.setContentAreaFilled(true);
		btnModificarPodcasterMo.setBorderPainted(false);
		btnModificarPodcasterMo.setBackground(new Color(198, 122, 206));
		btnModificarPodcasterMo.setBounds(730, 450, 136, 35);
		panelModificarPodcaster.add(btnModificarPodcasterMo);

		JComboBox<String> comboBoxPodcasterMo = new JComboBox<String>();
		comboBoxPodcasterMo.setBounds(248, 23, 288, 30);
		panelModificarPodcaster.add(comboBoxPodcasterMo);
		
		JButton btnSubirImagenPodcasterMo = new JButton("Subir .jpg");
		btnSubirImagenPodcasterMo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubirImagenPodcasterMo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSubirImagenPodcasterMo.setBounds(546, 233, 111, 33);
		panelModificarPodcaster.add(btnSubirImagenPodcasterMo);
		
		JButton btnCambiarPodcaster = new JButton("Cambiar");
		btnCambiarPodcaster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCambiarPodcaster.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCambiarPodcaster.setBounds(560, 20, 111, 33);
		panelModificarPodcaster.add(btnCambiarPodcaster);
		
	}
}

