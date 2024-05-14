package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.GestionDeLaInformacion;
import view.VistaPrincipal;

public class PanelPerfil extends JPanel {
	
	public PanelPerfil(VistaPrincipal v, GestionDeLaInformacion gestionInformacion) {
		
		setSize(1200, 720);
		setVisible(true);
		setLayout(null);

		/**
		 * BTN - Inicio
		 */
		JButton btnAtras = new JButton("Inicio");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarDePanel(3);
			}
		});
		btnAtras.setFont(new Font("Verdana", Font.BOLD, 16));
		btnAtras.setOpaque(true);
		btnAtras.setContentAreaFilled(true);
		btnAtras.setForeground(Color.decode("#FFFFFF"));
		btnAtras.setBorderPainted(false);
		btnAtras.setBackground(new Color(56, 56, 56));
		btnAtras.setBounds(48, 50, 136, 48);
		add(btnAtras);
		
		

		/**
		 * LBL - Nombre
		 */
		JLabel lblNombre = new JLabel("<dynamic>");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNombre.setBounds(544, 181, 416, 36);
		add(lblNombre);
		
		/**
		 * LBL - Apellido
		 */
		JLabel lblApellido = new JLabel("<dynamic>");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblApellido.setBounds(544, 225, 416, 36);
		add(lblApellido);
		
		/**LBL - Usuario
		 * 
		 */
		JLabel lblUsuario = new JLabel("<dynamic>");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblUsuario.setBounds(544, 268, 416, 36);
		add(lblUsuario);
		
		/**
		 * LBL - Fecha de Nacimiento
		 */
		JLabel lblFecNacimiento = new JLabel("<dynamic>");
		lblFecNacimiento.setForeground(Color.WHITE);
		lblFecNacimiento.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblFecNacimiento.setBounds(669, 312, 416, 36);
		add(lblFecNacimiento);
		

		/**
		 * LBL - Fecha de registro
		 */
		JLabel lblFecRegistro = new JLabel("<dynamic>");
		lblFecRegistro.setForeground(Color.WHITE);
		lblFecRegistro.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblFecRegistro.setBounds(634, 356, 416, 36);
		add(lblFecRegistro);
		
		
		/**
		 * LBL - Idioma
		 */
		JLabel lblIdioma = new JLabel("<dynamic>");
		lblIdioma.setForeground(Color.WHITE);
		lblIdioma.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblIdioma.setBounds(531, 400, 416, 36);
		add(lblIdioma);
		
		/**
		 * LBL - Tipo de cuenta
		 */
		JLabel lblTipoCuenta = new JLabel("<dynamic>");
		lblTipoCuenta.setForeground(Color.WHITE);
		lblTipoCuenta.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblTipoCuenta.setBounds(609, 443, 416, 36);
		add(lblTipoCuenta);
		
		/**
		 * LBL - Fecha de Alta Premium
		 */
		JLabel lblFecAltaPremium = new JLabel("<dynamic>");
		lblFecAltaPremium.setForeground(Color.WHITE);
		lblFecAltaPremium.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblFecAltaPremium.setBounds(684, 487, 416, 36);
		add(lblFecAltaPremium);
		
		/**
		 * LBL - Fecha de Baja Premium
		 */
		JLabel lblFecBajaPremium = new JLabel("<dynamic>");
		lblFecBajaPremium.setForeground(Color.WHITE);
		lblFecBajaPremium.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblFecBajaPremium.setBounds(690, 532, 416, 36);
		add(lblFecBajaPremium);
		
		/**
		 * LBL - Fondo 
		 */
		JLabel lblImagen = new JLabel();
		lblImagen.setFont(new Font("Rubik", Font.PLAIN, 16));
		lblImagen.setBounds(0, 0, 1200, 720);
		lblImagen.setIcon(new ImageIcon("imagenes/varios/fondo-perfil.jpg"));
		add(lblImagen);
		
		
		
		
		
		
		
		
	

		
		
	
		
	}
}
