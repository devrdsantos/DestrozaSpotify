package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import controller.GestionBD;
import controller.GestionDeLaInformacion;
import view.VistaPrincipal;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;

public class PanelLogin extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JTextField textFieldUsuario;
	private GestionBD gestionBD = new GestionBD();
	
	
	public PanelLogin(VistaPrincipal v , GestionDeLaInformacion gestionINF) {
		
		setSize(1200, 720);
		setVisible(true);
		setLayout(null);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));
		JLabel mensajeBienvenida = new JLabel("Inicia sesión");
		mensajeBienvenida.setForeground(Color.decode("#ffffff"));
		mensajeBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeBienvenida.setFont(new Font("Malgun Gothic", Font.BOLD, 32));
		mensajeBienvenida.setBounds(371, 169, 515, 78);
		add(mensajeBienvenida);

		JLabel lblUsuario = new JLabel("Ingresa su usuario:");
		lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblUsuario.setBounds(376, 300, 200, 28);
		lblUsuario.setForeground(Color.decode("#FFFFFF"));
		add(lblUsuario);

		JLabel lblPassword = new JLabel("Ingresa tu contraseña:");
		lblPassword.setForeground(Color.decode("#FFFFFF"));
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPassword.setBounds(343, 367, 230, 28);
		add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(574, 367, 266, 34);
		add(passwordField);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(574, 300, 266, 34);
		add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

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
		btnIniciarSesion.setBackground(Color.decode("#C67ACE"));
		btnIniciarSesion.setBounds(420, 446, 170, 39);
		add(btnIniciarSesion);

		JLabel lblSinCuenta = new JLabel("¿Aún no tienes una cuenta?");
		lblSinCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(2);
			}
		});
		lblSinCuenta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSinCuenta.setBounds(606, 456, 211, 20);
		lblSinCuenta.setForeground(Color.decode("#BE6DB7"));
		add(lblSinCuenta);

	}
}