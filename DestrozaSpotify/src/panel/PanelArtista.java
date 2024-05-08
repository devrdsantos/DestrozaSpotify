package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		;

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarDePanel(8);
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
		add(btnPerfil);

		JLabel lblArtista = new JLabel();
		lblArtista.setFont(new Font("Dialog", Font.BOLD, 38));
		lblArtista.setForeground(new Color(255, 255, 255));
		lblArtista.setText(gestionINF.devolverArtista());
		lblArtista.setBounds(228, 116, 763, 68);
		add(lblArtista);
		

		JList<String> listAlbums = new JList<String>();
		listAlbums.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()) {
					gestionINF.albumSeleccionado(listAlbums.getSelectedValue().split("--")[0]);
					gestionINF.indiceAlbum(listAlbums.getSelectedIndex());
//     			System.out.println(listAlbums.getSelectedValue().split("--")[0]);
					v.cambiarDePanel(11);
				}
			}
		});
		DefaultListModel<String> modeloAlbums = new DefaultListModel<String>();
		for (int i = 0; i < gestionINF.mostrarAlbums().size(); i++) {
			modeloAlbums.addElement(gestionINF.mostrarAlbums().get(i).getNombre() + " -- "
					+ gestionINF.mostrarAlbums().get(i).getFechaPublicacion() + " -- "
					+ gestionINF.mostrarAlbums().get(i).getCantidadCanciones() + " canciones");
		}
		listAlbums.setModel(modeloAlbums);
		listAlbums.setBounds(228, 436, 763, 242);
		add(listAlbums);

		JLabel lblNewLabel = new JLabel("Albums:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(230, 407, 130, 20);
		add(lblNewLabel);

//		JList<String> listArtista = new JList<String>();
//		DefaultListModel<String> modeloArtista = new DefaultListModel<String>();
//		modeloArtista.addElement("Genero: \n" + gestionINF.mostrarAlbums().get(0).getGenero());
//		modeloArtista.addElement("Descripción: " + gestionINF.mostrarArtista().get(0).getDescripcion());
//		listArtista.setModel(modeloArtista);
//		listArtista.setBounds(720, 230, 400, 200);
//		add(listArtista);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setText(gestionINF.mostrarAlbums().get(0).getGenero()
				+ "\n" + gestionINF.mostrarArtista().get(0).getDescripcion());
		textArea.setBounds(232, 195, 400, 201);
		add(textArea);
		
		/*
		JLabel lblInformacion = new JLabel("Informacion :");
		lblInformacion.setForeground(Color.WHITE);
		lblInformacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformacion.setBounds(720, 200, 130, 20);
		add(lblInformacion);
		*/
		
		JLabel lblImagenArtista = new JLabel("");
		lblImagenArtista.setIcon(gestionINF.mostrarArtista().get(0).getImagen());
		lblImagenArtista.setBounds(791, 195, 200, 200);
		add(lblImagenArtista);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 128));
		panel.setBounds(203, 116, 10, 68);
		add(panel);

	}
}