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

public class PanelGestionPodcast extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelAñadirPodcast;
	private JPanel panelAñadirPodcaster;
	private JPanel panelEliminarPodcast;
	private JPanel panelEliminarPodcaster;
	private JPanel panelModificarPodcast;
	private JPanel panelModificarPodcaster;

	private String archivoPortadaPodcaster;
	private String archivoMusicaPodcast;

	public PanelGestionPodcast(VistaPrincipal v, GestionBD gestionBD) {

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
		btnAtras.setBackground(Color.decode("#C67ACE"));
		btnAtras.setBounds(1010, 30, 136, 35);
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
		MenuBotones.setBounds(40, 250, 190, 250);
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
		btnEliminarPodcast.setBounds(10, 130, 170, 30);
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
		btnEliminarPodcaster.setBounds(10, 90, 170, 30);
		MenuBotones.add(btnEliminarPodcaster);

		/**
		 * Boton para mostrar el panel de modificar el Podcaster
		 */
		JButton btnModificarPodcaster = new JButton("Modificar podcaster");
		btnModificarPodcaster.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModificarPodcaster.setBounds(10, 170, 170, 30);
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
		btnModificarPodcast.setBounds(10, 210, 170, 30);
		MenuBotones.add(btnModificarPodcast);

/* --------------------------------------------------------------------------------------------------------------------------------- */

/* ----- Panel añadir podcaster ---------------------------------------------------------------------------------------------------- */

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

//				gestionBD.insertArtista(textFieldNombrePodcaster.getText(), textFieldNombrePodcaster.getText(),
//						textFieldDescripcion.getText());
				gestionBD.insertPodcaster(textFieldNombrePodcaster.getText(), textFieldGenero.getText());

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

/* ------------------------------------------------------------------------------------------------------------------------------ */

/* ----- Panel añadir podcast --------------------------------------------------------------------------------------------------- */

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

		JLabel lblDuracion = new JLabel("Duracion (En segundos):");
		lblDuracion.setBounds(10, 58, 228, 48);
		lblDuracion.setForeground(Color.decode("#ffffff"));
		lblDuracion.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirPodcast.add(lblDuracion);

		JTextField textFieldNombrePodcast = new JTextField();
		textFieldNombrePodcast.setBounds(248, 20, 288, 30);
		textFieldNombrePodcast.setColumns(10);
		panelAñadirPodcast.add(textFieldNombrePodcast);

		JTextField textFieldDuracion = new JTextField();
		textFieldDuracion.setBounds(248, 70, 288, 30);
		textFieldDuracion.setColumns(10);
		panelAñadirPodcast.add(textFieldDuracion);

		JLabel lblPortada = new JLabel("Portada:");
		lblPortada.setBounds(153, 106, 85, 48);
		lblPortada.setForeground(Color.decode("#ffffff"));
		lblPortada.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirPodcast.add(lblPortada);

		JTextField textFieldPortada = new JTextField();
		textFieldPortada.setBounds(248, 116, 288, 30);
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
		btnSubirPortada.setBounds(555, 114, 111, 33);
		btnSubirPortada.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelAñadirPodcast.add(btnSubirPortada);

		JLabel lblPodcaster = new JLabel("Podcaster:");
		lblPodcaster.setBounds(136, 202, 120, 48);
		lblPodcaster.setForeground(Color.decode("#ffffff"));
		lblPodcaster.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirPodcast.add(lblPodcaster);
		
		/**
		 * ComboBox para enseñar los Podcasters
		 */
		JComboBox<String> comboBoxPodcaster = new JComboBox<String>();
		for (int i = 0; i < gestionBD.sacarPodcasterInformacion().size(); i++) {
			comboBoxPodcaster.addItem(gestionBD.sacarPodcasterInformacion().get(i).getNombre());
		}
		comboBoxPodcaster.setBounds(248, 212, 288, 30);
		panelAñadirPodcast.add(comboBoxPodcaster);

		JLabel lblAudio = new JLabel("Audio:");
		lblAudio.setBounds(173, 250, 65, 48);
		lblAudio.setForeground(Color.decode("#ffffff"));
		lblAudio.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirPodcast.add(lblAudio);

		JTextField textFieldAudio = new JTextField();
		textFieldAudio.setBounds(248, 260, 288, 30);
		textFieldAudio.setColumns(10);
		panelAñadirPodcast.add(textFieldAudio);

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
		btnSubirWav.setBounds(555, 260, 111, 33);
		btnSubirWav.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelAñadirPodcast.add(btnSubirWav);

		JLabel lblDescripcionPodc = new JLabel("Descripcion:");
		lblDescripcionPodc.setBounds(122, 154, 148, 48);
		lblDescripcionPodc.setForeground(Color.decode("#ffffff"));
		lblDescripcionPodc.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAñadirPodcast.add(lblDescripcionPodc);

		JTextField textFieldDescripcionPodc = new JTextField();
		textFieldDescripcionPodc.setBounds(248, 165, 288, 30);
		textFieldDescripcionPodc.setColumns(10);
		panelAñadirPodcast.add(textFieldDescripcionPodc);

		/**
		 * Boton para subir el Podcast
		 */
		JButton btnAñadirPodc = new JButton("Añadir");
		btnAñadirPodc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println(textFieldNombreCancion.getText().replace(" ", ""));

				gestionBD.insertPodcast(textFieldDescripcionPodc.getText(),
						textFieldNombrePodcast.getText().replace(" ", ""),
						(String) comboBoxPodcaster.getSelectedItem());
				gestionBD.insertAudioPodc(textFieldNombrePodcast.getText(),
						Integer.valueOf(textFieldDuracion.getText()),
						textFieldNombrePodcast.getText().replace(" ", ""));

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

/* --------------------------------------------------------------------------------------------------------------------------------- */

/* ----- Panel eliminar podcast ---------------------------------------------------------------------------------------------------- */

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

/*  ------------------------------------------------------------------------------------------------------------------------------ */

/* ----- Panel eliminar podcaster -------------------------------------------------------------------------------------------------  */

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
				gestionBD.deleteArtista(textFieldEliminarPodcaster.getText());

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

	}
}
