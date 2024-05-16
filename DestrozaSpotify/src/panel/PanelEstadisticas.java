package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import controller.GestionDeLaInformacion;
import view.VistaPrincipal;

public class PanelEstadisticas extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelEstadisticas(VistaPrincipal v, GestionDeLaInformacion gestionINF) {
		setSize(1200, 720);
		setVisible(true);
		setLayout(null);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));
		

		/**
		 * BTN - Atrás
		 */
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarDePanel(3);
			}
		});
		btnAtras.setFont(new Font("Verdana", Font.BOLD, 14));
		btnAtras.setOpaque(true);
		btnAtras.setContentAreaFilled(true);
		btnAtras.setForeground(Color.decode("#FFFFFF"));
		btnAtras.setBorderPainted(false);
		btnAtras.setBackground(Color.decode("#353535"));
		btnAtras.setBounds(52, 54, 100, 40);
		add(btnAtras);

	
		
		JList<String> list = new JList<String>();
		list.setBackground(Color.decode("#222222"));
		list.setFont(new Font("Verdana", Font.PLAIN, 14));
		list.setBounds(140, 266, 256, 286);
		add(list);
		
		JList<String> list_1 = new JList<String>();
		list_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		list_1.setBackground(new Color(34, 34, 34));
		list_1.setBounds(472, 266, 256, 286);
		add(list_1);
		
		JList<String> list_1_1 = new JList<String>();
		list_1_1.setForeground(new Color(255, 255, 255));
		list_1_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		list_1_1.setBackground(new Color(34, 34, 34));
		list_1_1.setBounds(804, 266, 256, 286);
		add(list_1_1);
		
		
		/**
		 * LBL - Fondo 
		 */
		JLabel lblImagen = new JLabel();
		lblImagen.setFont(new Font("Rubik", Font.PLAIN, 16));
		lblImagen.setBounds(0, 0, 1200, 720);
		lblImagen.setIcon(new ImageIcon("imagenes/varios/fondo-estadisticas.jpg"));
		add(lblImagen);
		
		
		
		
		
}
}