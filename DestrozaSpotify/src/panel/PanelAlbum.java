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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.GestionDeLaInformacion;
import view.VistaPrincipal;

public class PanelAlbum extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int duracionMax;
	
	public PanelAlbum(VistaPrincipal v, GestionDeLaInformacion gestionINF) {
		
		for (int i = 0; i < gestionINF.mostrarCancion().size(); i++) {
			duracionMax = duracionMax + gestionINF.mostrarCancion().get(i).getDuracion();
		}
		
		setSize(1200, 720);
		setVisible(true);
		setFont(new Font("Open Sans", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));;
		
		JButton btnAtras = new JButton("Ir atrás");
		btnAtras.setBounds(74, 32, 137, 52);
		btnAtras.setFont(new Font("Open Sans", Font.BOLD, 16));
		
			/**
			 *  ACCION DEL BOTON
			 */
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarDePanel(6);
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
		lblArtista.setText("Lista de canciones: ");
		lblArtista.setBounds(74, 179, 350, 40);
		add(lblArtista);
		
		
		JList<String> listAlbums = new JList<String>();
		listAlbums.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
			}
		});
		DefaultListModel<String> modeloAlbums = new DefaultListModel<String>();
		for (int i = 0; i < gestionINF.mostrarCancion().size(); i++) {
			modeloAlbums.addElement(gestionINF.mostrarCancion().get(i).getNombre() + " -- " + gestionINF.mostrarCancion().get(i).getDuracion() + " segundos");
		}
		listAlbums.setModel(modeloAlbums);
		listAlbums.setBounds(75, 230, 400, 450);
		add(listAlbums);
		
		JList<String> listArtista = new JList<String>();
		DefaultListModel<String> modeloArtista = new DefaultListModel<String>();
		modeloArtista.addElement("Colaboradores: " + gestionINF.mostrarCancion().get(0).getColaboradores());
		modeloArtista.addElement("Fecha de salida: " + gestionINF.mostrarAlbums().get(0).getFechaPublicacion());
		modeloArtista.addElement("Canciones: " + gestionINF.mostrarCancion().size());
		modeloArtista.addElement("Duracion: " + duracionMax + " segundos");
		listArtista.setModel(modeloArtista);
		listArtista.setBounds(825, 230, 400, 200);
		add(listArtista);
		
		JLabel lblInformacion = new JLabel("Informacion :");
		lblInformacion.setForeground(Color.WHITE);
		lblInformacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformacion.setBounds(825, 201, 130, 20);
		add(lblInformacion);
		
		JLabel lblImagenArtista = new JLabel("");
		lblImagenArtista.setIcon(gestionINF.mostrarAlbums().get(0).getImagen());
		lblImagenArtista.setBounds(925, 450, 200, 200);
		add(lblImagenArtista);
		
		
		
	}
	
}
