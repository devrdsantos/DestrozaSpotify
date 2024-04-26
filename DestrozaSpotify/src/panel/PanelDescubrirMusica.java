package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.GestionDeLaInformacion;
import view.VistaPrincipal;

public class PanelDescubrirMusica extends JPanel {

	public PanelDescubrirMusica(VistaPrincipal v , GestionDeLaInformacion gestionINF) {
	setSize(1200, 720);
	setVisible(true);
	setLayout(null);
	setFont(new Font("Tahoma", Font.BOLD, 11));
	setBackground(Color.decode("#142850"));
	
	/**
	 * Boton Volver
	 */
	JButton btnVolver = new JButton("<html><u>Volver<u><html>");
	btnVolver.setFont(new Font("Verdana", Font.PLAIN, 16));
	btnVolver.setOpaque(true);
	btnVolver.setContentAreaFilled(true);
	btnVolver.setForeground(Color.decode("#C67ACE"));
	btnVolver.setBorderPainted(false);
	btnVolver.setBackground(Color.decode("#142850"));
	btnVolver.setBounds(21, 23, 254, 39);
	btnVolver.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			v.cambiarDePanel(3);
		}
	});
	add(btnVolver);
}
}
