package view;

import javax.swing.JFrame;

import controller.ControladorDeEntrada;
import controller.GestionDeLaInformacion;
import panel.PanelBienvenida;
import panel.PanelDescubrirMusica;
import panel.PanelDescubrirPodcast;
import panel.PanelLogin;
import panel.PanelMenuCliente;
import panel.PanelMiBiblioteca;
import panel.PanelRegistro;

public class VistaPrincipal extends JFrame {

	/**
	 * [VARIABLES]
	 */
	private static final long serialVersionUID = 1L;
	private GestionDeLaInformacion gestionINF;
	private ControladorDeEntrada controlador;
	
	
	/**
	 * [CONSTRUCTOR]
	 * Inicializa el ControladorDeEntrada y GestionDeLaInformacion
	 * Le otorga valores al Frame en donde se mostrará nuestro programa.
	 */
	public VistaPrincipal() {
		gestionINF =  new GestionDeLaInformacion();
		controlador =  new ControladorDeEntrada();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1600, 900);
		setVisible(true);
		setTitle("Destruye Spotify");
		setResizable(false);
	}

	/**
	 * [FUNCIÓN] cambiarDePanel(int i)
	 * @param i -> Recibe el número del Panel que va a mostrar
	 */
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
			setContentPane(new PanelMenuCliente(this, this.gestionINF));
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
			setContentPane(new PanelDescubrirMusica(this, this.gestionINF));
			break;
		case 9:
			setContentPane(new PanelDescubrirPodcast(this, this.gestionINF));
			break;
		case 10:
			setContentPane(new PanelMiBiblioteca(this, this.gestionINF));
			break;

		}
	}

	
	/**
	 * [FUNCIÓN] main()
	 * @param args
	 * Aquí se ejecuta nuestro programa. Se muestra el Frame y se ejecuta cambiarDePanel(int i)
	 */
	public static void main(String[] args) {
		VistaPrincipal v = new VistaPrincipal();
		
		v.setVisible(true);


		v.cambiarDePanel(3);

	}

}
