package view;

import javax.swing.JFrame;

import controller.ControladorDeEntrada;
import controller.GestionDeLaInformacion;
import panel.PanelBienvenida;
import panel.PanelLogin;
import panel.PanelRegistro;

public class VistaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GestionDeLaInformacion gestionINF;
	private ControladorDeEntrada controlador;
	
	public VistaPrincipal() {
		gestionINF =  new GestionDeLaInformacion();
		controlador =  new ControladorDeEntrada();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 720);
		setVisible(true);
		setTitle("Cines ESA");
		setResizable(false);
	}

	public void cambiarDePanel(int i) {

		switch (i) {
		case 0:
			setContentPane(new PanelBienvenida(this));
			break;
		case 1:
			setContentPane(new PanelLogin(this, this.gestionINF));
			break;
		case 2:
			setContentPane(new PanelRegistro(this, this.controlador));
			break;

		case 3:

			break;

		case 4:

			break;

		case 5:

			break;

		case 6:

			break;
		case 7:

			break;

		case 8:

			break;

		}
	}

	public static void main(String[] args) {
		VistaPrincipal v = new VistaPrincipal();
		
		v.setVisible(true);

		v.cambiarDePanel(0);

	}

}
