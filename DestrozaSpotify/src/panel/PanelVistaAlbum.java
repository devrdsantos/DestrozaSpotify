package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.GestionDeLaInformacion;
import view.VistaPrincipal;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelVistaAlbum extends JPanel {
	
	
	public PanelVistaAlbum (VistaPrincipal v, GestionDeLaInformacion gestionINF) {
		
		setLayout(null);
		setSize(1200, 720);
		setVisible(true);
		setFont(new Font("Open Sans", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));
	
	/**
	 * BTN - Atrás
	 */
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
	
	

	/**
	 * LBL - Nombre Albúm
	 */
	JLabel lblAlbum = new JLabel();
	lblAlbum.setFont(new Font("Dialog", Font.BOLD, 38));
	lblAlbum.setForeground(new Color(255, 255, 255));
	lblAlbum.setText(gestionINF.devolverArtista());
	lblAlbum.setBounds(228, 74, 763, 68);
	add(lblAlbum);
	
	/**
	 * LIST - Lista de canciones
	 */
	JList<String> listAlbums = new JList<String>();
	listAlbums.setFont(new Font("Verdana", Font.PLAIN, 14));
	listAlbums.addListSelectionListener(new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent arg0) {
			if (!arg0.getValueIsAdjusting()) {
				gestionINF.albumSeleccionado(listAlbums.getSelectedValue().split("--")[0]);
				gestionINF.indiceAlbum(listAlbums.getSelectedIndex());
// 			System.out.println(listAlbums.getSelectedValue().split("--")[0]);
				v.cambiarDePanel(11);
			}
		}
	});
	listAlbums.setBackground(Color.decode("#DDDDDD"));
	
	DefaultListModel<String> modeloAlbums = new DefaultListModel<String>();
	for (int i = 0; i < gestionINF.mostrarAlbums().size(); i++) {
		modeloAlbums.addElement(gestionINF.mostrarAlbums().get(i).getNombre() + " -- "
				+ gestionINF.mostrarAlbums().get(i).getFechaPublicacion() + " -- "
				+ gestionINF.mostrarAlbums().get(i).getCantidadCanciones() + " canciones");
	}
	listAlbums.setModel(modeloAlbums);
	listAlbums.setBounds(228, 436, 763, 242);
	add(listAlbums);

	/**
	 * LBL - Canciones
	 */
	
	JLabel lblCanciones = new JLabel("Canciones:");
	lblCanciones.setForeground(new Color(255, 255, 255));
	lblCanciones.setFont(new Font("Verdana", Font.PLAIN, 18));
	lblCanciones.setBounds(228, 400, 130, 27);
	add(lblCanciones);
	
	/**
	 * LBL - Por
	 */
	JLabel lblNewLabel = new JLabel("Por");
	lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
	lblNewLabel.setForeground(new Color(192, 192, 192));
	lblNewLabel.setBounds(228, 158, 33, 27);
	add(lblNewLabel);
	
	
	/**
	 * LBL - Artista
	 */
	JLabel lblArtista = new JLabel();
	lblArtista.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			v.cambiarDePanel(7);
		}
	});
	lblArtista.setForeground(Color.decode("#FFB850"));
	lblArtista.setText(gestionINF.devolverArtista());
	lblArtista.setFont(new Font("Verdana", Font.PLAIN, 16));
	lblArtista.setBounds(264, 158, 496, 27);
	add(lblArtista);
	
	/**
	 * LBL - Fecha de publicación
	 */
	JLabel lblFecha = new JLabel("Fecha de publicación:");
	lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
	lblFecha.setFont(new Font("Verdana", Font.BOLD, 16));
	lblFecha.setForeground(new Color(255, 255, 255));
	lblFecha.setBounds(227, 201, 193, 28);
	add(lblFecha);
	
	/**
	 * LBL - Género
	 */
	JLabel lblDescripcion = new JLabel("Género:");
	lblDescripcion.setHorizontalAlignment(SwingConstants.LEFT);
	lblDescripcion.setForeground(Color.WHITE);
	lblDescripcion.setFont(new Font("Verdana", Font.BOLD, 16));
	lblDescripcion.setBounds(227, 245, 76, 28);
	add(lblDescripcion);
	
	/**
	 * LBL - Cantidad de canciones
	 */
	JLabel lblCantidadDeCanciones = new JLabel("Cantidad de canciones:");
	lblCantidadDeCanciones.setHorizontalAlignment(SwingConstants.LEFT);
	lblCantidadDeCanciones.setForeground(Color.WHITE);
	lblCantidadDeCanciones.setFont(new Font("Verdana", Font.BOLD, 16));
	lblCantidadDeCanciones.setBounds(228, 288, 205, 28);
	add(lblCantidadDeCanciones);
	
	/**
	 * LBL - Duración
	 */
	JLabel lblDuracin = new JLabel("Duración:");
	lblDuracin.setHorizontalAlignment(SwingConstants.LEFT);
	lblDuracin.setForeground(Color.WHITE);
	lblDuracin.setFont(new Font("Verdana", Font.BOLD, 16));
	lblDuracin.setBounds(228, 333, 90, 28);
	add(lblDuracin);
	
	/**
	 * LBL - (Dato) Fecha de publicación
	 */
	JLabel lblDatoFecha = new JLabel("Fecha de publicación");
	lblDatoFecha.setHorizontalAlignment(SwingConstants.LEFT);
	lblDatoFecha.setForeground(Color.WHITE);
	lblDatoFecha.setFont(new Font("Verdana", Font.PLAIN, 16));
	lblDatoFecha.setBounds(421, 201, 239, 28);
	add(lblDatoFecha);
	
	/**
	 * LBL - (Dato) Genero
	 */
	JLabel lblDatoGenero = new JLabel("Género");
	lblDatoGenero.setHorizontalAlignment(SwingConstants.LEFT);
	lblDatoGenero.setForeground(Color.WHITE);
	lblDatoGenero.setFont(new Font("Verdana", Font.PLAIN, 16));
	lblDatoGenero.setBounds(306, 245, 340, 28);
	add(lblDatoGenero);
	
	/**
	 * LBL - (For) Cantidad de canciones
	 */
	JLabel lblDatoCantidadCanciones = new JLabel("Cantidad de canciones");
	lblDatoCantidadCanciones.setHorizontalAlignment(SwingConstants.LEFT);
	lblDatoCantidadCanciones.setForeground(Color.WHITE);
	lblDatoCantidadCanciones.setFont(new Font("Verdana", Font.PLAIN, 16));
	lblDatoCantidadCanciones.setBounds(438, 288, 340, 28);
	add(lblDatoCantidadCanciones);
	
	/**
	 * LBL - (For y suma) Fecha de publicación
	 */
	JLabel lblDatoDuracion = new JLabel("Duración del álbum en minutos");
	lblDatoDuracion.setHorizontalAlignment(SwingConstants.LEFT);
	lblDatoDuracion.setForeground(Color.WHITE);
	lblDatoDuracion.setFont(new Font("Verdana", Font.PLAIN, 16));
	lblDatoDuracion.setBounds(320, 333, 340, 28);
	add(lblDatoDuracion);
	
	
	/**
	 * LBL - Imagen
	 */
	JLabel lblImagenArtista = new JLabel("");
	lblImagenArtista.setIcon(gestionINF.mostrarArtista().get(0).getImagen());
	lblImagenArtista.setBounds(789, 160, 200, 200);
	add(lblImagenArtista);

}	
}
