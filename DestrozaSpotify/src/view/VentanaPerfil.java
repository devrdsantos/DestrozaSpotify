package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ControladorDeEntrada;
import controller.GestionBD;
import controller.GestionDeLaInformacion;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class VentanaPerfil extends JFrame {


	/**
	 * [VARIABLES]
	 */
	private static final long serialVersionUID = 1L;
	private GestionDeLaInformacion gestionINF;
	private ControladorDeEntrada controlador;
	private GestionBD gestionBD;
	
	/**
	 * [CONSTRUCTOR] Inicializa el ControladorDeEntrada y GestionDeLaInformacion Le
	 * otorga valores al Frame en donde se mostrará nuestro programa.
	 */
	public VentanaPerfil() {

		gestionINF =  new GestionDeLaInformacion();
		controlador =  new ControladorDeEntrada();
		gestionBD = new GestionBD();
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(1200, 720);
		setVisible(true);
		setTitle("SoundScape");		
		setResizable(false);
		setBackground(Color.decode("#222222"));


		/**
		 * LBL - Fondo 
		 */
		JLabel lblImagen = new JLabel();
		lblImagen.setFont(new Font("Rubik", Font.PLAIN, 16));
		lblImagen.setBounds(0, 0, 1200, 720);
		lblImagen.setIcon(new ImageIcon("imagenes/varios/fondo-login.jpg"));
		getContentPane().add(lblImagen);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		

	}
}
