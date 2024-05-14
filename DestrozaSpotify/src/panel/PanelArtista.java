package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.GestionDeLaInformacion;
import view.VistaPrincipal;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.SwingConstants;

public class PanelArtista extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelArtista(VistaPrincipal v, GestionDeLaInformacion gestionINF) {

		// ELIMINARME!!!
//	gestionINF.artistaSeleccionado("Artemas");
//	gestionINF.albumSeleccionado("Pretty");
		
		setLayout(null);
		setSize(1200, 720);
		setVisible(true);
		setFont(new Font("Open Sans", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));

		
		/**
		 * BTN - Atrás

		 */
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Verdana", Font.BOLD, 16));
		btnAtras.setOpaque(true);
		btnAtras.setContentAreaFilled(true);
		btnAtras.setForeground(Color.decode("#FFFFFF"));
		btnAtras.setBorderPainted(false);
		btnAtras.setBackground(Color.decode("#353535"));
		btnAtras.setBounds(52, 34, 136, 48);
		/**
		 * ACCION DEL BOTON
		 */
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarDePanel(8);
			}
		});
	
		add(btnAtras);
		
		/**
		 * BTN - Perfil
		 */
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setOpaque(true);
		btnPerfil.setForeground(Color.WHITE);
		btnPerfil.setFont(new Font("Verdana", Font.BOLD, 16));
		btnPerfil.setContentAreaFilled(true);
		btnPerfil.setBorderPainted(false);
		btnPerfil.setBackground(new Color(53, 53, 53));
		btnPerfil.setBounds(1009, 34, 136, 48);
		btnPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(19);
			}
		});
		add(btnPerfil);

		/**
		 * LBL - Nombre Artista
		 */
		JLabel lblArtista = new JLabel();
		lblArtista.setFont(new Font("Dialog", Font.BOLD, 38));
		lblArtista.setForeground(new Color(255, 255, 255));
		lblArtista.setText(gestionINF.devolverArtista());
		lblArtista.setBounds(228, 116, 763, 68);
		add(lblArtista);
		
		/**
		 * LIST - Lista de álbums
		 */
		JList<String> listAlbums = new JList<String>();
		listAlbums.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()) {
					gestionINF.albumSeleccionado(listAlbums.getSelectedValue().split("--")[0]);
//					gestionINF.indiceAlbum(listAlbums.getSelectedIndex());
					System.out.println(listAlbums.getSelectedValue().split("--")[0]);
					v.cambiarDePanel(11);
				}
			}
		});
		listAlbums.setBackground(Color.decode("#DDDDDD"));
		
		DefaultListModel<String> modeloAlbums = new DefaultListModel<String>();
		for (int i = 0; i < gestionINF.mostrarAlbumsPorArtista().size(); i++) {
			modeloAlbums.addElement(gestionINF.mostrarAlbumsPorArtista().get(i).getNombre() + " -- "
					+ gestionINF.mostrarAlbumsPorArtista().get(i).getFechaPublicacion() + " -- "
					+ gestionINF.mostrarAlbumsPorArtista().get(i).getCantidadCanciones() + " canciones");
		}
		listAlbums.setModel(modeloAlbums);
		listAlbums.setBounds(228, 436, 763, 242);
		add(listAlbums);

		JLabel lblNewLabel = new JLabel("Albums:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel.setBounds(230, 399, 130, 28);
		add(lblNewLabel);

//		JList<String> listArtista = new JList<String>();
//		DefaultListModel<String> modeloArtista = new DefaultListModel<String>();
//		modeloArtista.addElement("Genero: \n" + gestionINF.mostrarAlbums().get(0).getGenero());
//		modeloArtista.addElement("Descripción: " + gestionINF.mostrarArtista().get(0).getDescripcion());
//		listArtista.setModel(modeloArtista);
//		listArtista.setBounds(720, 230, 400, 200);
//		add(listArtista);
		
		/**
		 * TEXTAREA - Información del artista
		 */
		JTextArea textAreaInformacionArtista = new JTextArea();
		textAreaInformacionArtista.setForeground(new Color(255, 255, 255));
		textAreaInformacionArtista.setFont(new Font("Verdana", Font.PLAIN, 16));
		textAreaInformacionArtista.setEditable(false);
		textAreaInformacionArtista.setWrapStyleWord(true);
		textAreaInformacionArtista.setLineWrap(true);
		textAreaInformacionArtista.setText(gestionINF.mostrarAlbumsPorArtista().get(0).getGenero()
				+ "\n\n" + gestionINF.mostrarArtista().get(0).getDescripcion());

		textAreaInformacionArtista.setBackground(Color.decode("#222222"));
		textAreaInformacionArtista.setBounds(339, 211, 397, 184);
		add(textAreaInformacionArtista);
		
		/*
		JLabel lblInformacion = new JLabel("Informacion :");
		lblInformacion.setForeground(Color.WHITE);
		lblInformacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformacion.setBounds(720, 200, 130, 20);
		add(lblInformacion);
		*/
		
		/**
		 * LBL - Imagen
		 */
		JLabel lblImagenArtista = new JLabel("");
		lblImagenArtista.setIcon(gestionINF.mostrarArtista().get(0).getImagen());
		lblImagenArtista.setBounds(791, 195, 200, 200);
		add(lblImagenArtista);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 128));
		panel.setBounds(203, 116, 10, 68);
		add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Género:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(223, 207, 110, 28);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Descripción:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(227, 251, 110, 28);
		add(lblNewLabel_1_1);

	}
}