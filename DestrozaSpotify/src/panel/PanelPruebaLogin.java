package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.GestionBD;
import controller.GestionDeLaInformacion;
import view.VistaPrincipal;

public class PanelPruebaLogin extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JTextField textFieldUsuario;
	private GestionBD gestionBD = new GestionBD();
	
	
	public PanelPruebaLogin(VistaPrincipal v , GestionDeLaInformacion gestionINF) {
		
		setSize(1200, 720);
		setVisible(true);
		setLayout(null);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));
		JLabel mensajeBienvenida = new JLabel("Inicia sesión");
		mensajeBienvenida.setForeground(Color.decode("#ffffff"));
		mensajeBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeBienvenida.setFont(new Font("Verdana", Font.BOLD, 28));
		mensajeBienvenida.setBounds(183, 174, 280, 78);
		add(mensajeBienvenida);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblUsuario.setBounds(122, 320, 100, 28);
		lblUsuario.setForeground(Color.decode("#FFFFFF"));
		add(lblUsuario);

		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setForeground(Color.decode("#FFFFFF"));
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblPassword.setBounds(122, 404, 100, 28);
		add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(239, 237, 237));
		passwordField.setBounds(232, 404, 266, 34);
		add(passwordField);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setBackground(new Color(239, 237, 237));
		textFieldUsuario.setBounds(232, 320, 266, 34);
		add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		/**
		 * BTN - Iniciar sesión
		 */
		JButton btnIniciarSesion = new JButton("Iniciar sesión");
		btnIniciarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String usuario = textFieldUsuario.getText();
//				System.out.println(usuario);
//				@SuppressWarnings("deprecation")
				@SuppressWarnings("deprecation")
				String pass = passwordField.getText();
//				System.out.println(pass);
//				gestionINF.recogerDNI(usuario);
				
				try {
					gestionBD.verificarLogin(usuario, pass, v);
					gestionINF.sacarPremiun(usuario);
					gestionINF.sacarUsuario(usuario);
				} catch (Exception e1) {
					System.out.println("salio mal");
					e1.printStackTrace();
				}
			}
		});
		btnIniciarSesion.setFont(new Font("Verdana", Font.BOLD, 16));
		btnIniciarSesion.setOpaque(true);
		btnIniciarSesion.setContentAreaFilled(true);
		btnIniciarSesion.setForeground(Color.decode("#FFFFFF"));
		btnIniciarSesion.setBorderPainted(false);
		btnIniciarSesion.setBackground(Color.decode("#ED028B"));
		btnIniciarSesion.setBounds(118, 520, 170, 39);
		add(btnIniciarSesion);

		/**
		 * LBL - ¿Aún sin cuenta?
		 */
		JLabel lblSinCuenta = new JLabel("¿Aún no tienes una cuenta?");
		lblSinCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(2);
			}
		});
		lblSinCuenta.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblSinCuenta.setBounds(298, 530, 211, 20);
		lblSinCuenta.setForeground(Color.decode("#FFB850"));
		add(lblSinCuenta);
		
		/**
		 * LBL - Imagen 
		 */
		JLabel lblImagen = new JLabel();
		lblImagen.setBackground(new Color(255, 128, 0));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setIcon(new ImageIcon ( "logo.jpg" ) ) ; 
		lblImagen.setBounds(650, 0, 550, 720);
		add(lblImagen);

	}
}
