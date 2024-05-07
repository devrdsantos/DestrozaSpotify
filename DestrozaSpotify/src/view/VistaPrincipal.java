package view;

import javax.swing.JFrame;

import controller.ControladorDeEntrada;
import controller.GestionBD;
import controller.GestionDeLaInformacion;
import panel.PanelAlbum;
import panel.PanelArtista;
import panel.PanelBienvenida;
import panel.PanelDescubrirMusica;
import panel.PanelDescubrirPodcast;
import panel.PanelEpisodio;
import panel.PanelGestionMusica;
import panel.PanelGestionPodcast;
import panel.PanelArtista;
import panel.PanelGestionMusica;
import panel.PanelGestionPodcast;
import panel.PanelLogin;
import panel.PanelMenuAdministrador;
import panel.PanelMenuCliente;
import panel.PanelMiBiblioteca;
import panel.PanelPodcast;
import panel.PanelRegistro;
import panel.PanelReproductorDeMusica;

public class VistaPrincipal extends JFrame {

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
	public VistaPrincipal() {

		gestionINF =  new GestionDeLaInformacion();
		controlador =  new ControladorDeEntrada();
		gestionBD = new GestionBD();
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(1200, 720);
		setVisible(true);
		setTitle("Destruye Spotify");
	}

	/**
	 * [FUNCIÓN] cambiarDePanel(int i)
	 * 
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
			setContentPane(new PanelMenuAdministrador(this));
			break;
		case 5:
			setContentPane(new PanelGestionMusica(this, this.gestionBD));
			break;
		case 6:
			setContentPane(new PanelGestionPodcast(this, this.gestionBD));
			break;
		case 7:
			setContentPane(new PanelArtista(this, this.gestionINF));
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
		case 11:
			setContentPane(new PanelAlbum(this, this.gestionINF));
			break;
		case 12:
			setContentPane(new PanelReproductorDeMusica(this, this.gestionINF));
			break;
		case 13:
			setContentPane(new PanelPodcast(this, this.gestionINF));
			break;
		case 14:
			setContentPane(new PanelEpisodio(this, this.gestionINF));
			break;
			

		}
	}

	/**
	 * [FUNCIÓN] main()
	 * 
	 * @param args Aquí se ejecuta nuestro programa. Se muestra el Frame y se
	 *             ejecuta cambiarDePanel(int i)
	 */
	public static void main(String[] args) {
		VistaPrincipal v = new VistaPrincipal();
		
		v.setVisible(true);


		v.cambiarDePanel(5);

	}

}
