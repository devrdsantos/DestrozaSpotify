package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.VistaPrincipal;

public class PanelBienvenida extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelBienvenida(VistaPrincipal v) {
		setSize(1200, 720);
		setVisible(true);
		setLayout(null);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));
		
		/**
		 * LBL - Fondo 
		 */
		JLabel lblImagen = new JLabel();
		lblImagen.setFont(new Font("Rubik", Font.PLAIN, 16));
		lblImagen.setBounds(0, 0, 1200, 720);
		lblImagen.setIcon(new ImageIcon("imagenes/varios/fondo-bienvenida.jpg"));
		add(lblImagen);
		
	
		
		/*
		* Funcionalidad de la ventana
		*/
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				/**
				 * Este variable es el sustituto de thread sleep Indica que luego de presionar
				 * el click pasen 3 segundos y cambie de panel
				 */
				long tiempoDeActivacion = System.currentTimeMillis() + 1500;
				while (System.currentTimeMillis() < tiempoDeActivacion) {
				}
				v.cambiarDePanel(1);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				

			}
		});
	}
}