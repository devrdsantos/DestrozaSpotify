package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;

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

		setSize(1200, 720);
		setVisible(true);
		setFont(new Font("Open Sans", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));
		;

		JButton btnAtras = new JButton("Ir atrás");
		btnAtras.setBounds(74, 32, 137, 52);
		btnAtras.setFont(new Font("Open Sans", Font.BOLD, 16));

		/**
		 * ACCION DEL BOTON
		 */
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarDePanel(11);
			}
		});
		setLayout(null);
		btnAtras.setBackground(Color.decode("#3f3d3d"));
		btnAtras.setForeground(Color.decode("#ffaa43"));
		btnAtras.setOpaque(true);
		btnAtras.setBorderPainted(false);
		add(btnAtras);

		JLabel lblArtista = new JLabel();
		lblArtista.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblArtista.setForeground(new Color(255, 255, 255));
		lblArtista.setText(gestionINF.devolverArtista());
		lblArtista.setBounds(125, 150, 350, 40);
		add(lblArtista);

		JList<String> listAlbums = new JList<String>();
		listAlbums.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()) {
					gestionINF.albumSeleccionado(listAlbums.getSelectedValue().split("--")[0]);
//     			System.out.println(listAlbums.getSelectedValue().split("--")[0]);
					v.cambiarDePanel(11);
				}
			}
		});
		DefaultListModel<String> modeloAlbums = new DefaultListModel<String>();
		for (int i = 0; i < gestionINF.mostrarArtista().size(); i++) {
			modeloAlbums.addElement(gestionINF.mostrarAlbums().get(i).getNombre() + " -- "
					+ gestionINF.mostrarAlbums().get(i).getFechaPublicacion() + " -- "
					+ gestionINF.mostrarCancion().size() + " canciones");
		}
		listAlbums.setModel(modeloAlbums);
		listAlbums.setBounds(125, 230, 400, 450);
		add(listAlbums);

		JLabel lblNewLabel = new JLabel("Albums:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(125, 201, 130, 20);
		add(lblNewLabel);

		JList<String> listArtista = new JList<String>();
		DefaultListModel<String> modeloArtista = new DefaultListModel<String>();
		modeloArtista.addElement("Genero: \n" + gestionINF.mostrarAlbums().get(0).getGenero());
		modeloArtista.addElement("Descripción: " + gestionINF.mostrarArtista().get(0).getDescripcion());
		listArtista.setModel(modeloArtista);
		listArtista.setBounds(855, 230, 400, 200);
		add(listArtista);

		JLabel lblInformacion = new JLabel("Informacion :");
		lblInformacion.setForeground(Color.WHITE);
		lblInformacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformacion.setBounds(855, 201, 130, 20);
		add(lblInformacion);

		JLabel lblImagenArtista = new JLabel("");
		lblImagenArtista.setIcon(gestionINF.mostrarArtista().get(0).getImagen());
		lblImagenArtista.setBounds(965, 480, 200, 200);
		add(lblImagenArtista);

	}
}
