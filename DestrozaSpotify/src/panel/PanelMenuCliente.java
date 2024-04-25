package panel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;

import controller.GestionDeLaInformacion;
import view.VistaPrincipal;

public class PanelMenuCliente extends JPanel {

	
	
	public PanelMenuCliente(VistaPrincipal v , GestionDeLaInformacion gestionINF) {
	setSize(1200, 720);
	setVisible(true);
	setLayout(null);
	setFont(new Font("Tahoma", Font.BOLD, 11));
	setBackground(Color.decode("#142850"));
	}
}
