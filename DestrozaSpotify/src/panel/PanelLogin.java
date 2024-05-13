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
		
		

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblUsuario.setBounds(398, 430, 100, 28);
		lblUsuario.setForeground(Color.decode("#FFFFFF"));
		add(lblUsuario);

		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setForeground(Color.decode("#FFFFFF"));
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPassword.setBounds(410, 496, 87, 28);
		add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 14));
		passwordField.setBackground(new Color(239, 237, 237));
		passwordField.setBounds(508, 496, 266, 28);
		add(passwordField);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Verdana", Font.PLAIN, 14));
		textFieldUsuario.setBackground(new Color(239, 237, 237));
		textFieldUsuario.setBounds(508, 430, 266, 28);
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
		btnIniciarSesion.setFont(new Font("Verdana", Font.BOLD, 14));
		btnIniciarSesion.setOpaque(true);
		btnIniciarSesion.setContentAreaFilled(true);
		btnIniciarSesion.setForeground(Color.decode("#FFFFFF"));
		btnIniciarSesion.setBorderPainted(false);
		btnIniciarSesion.setBackground(Color.decode("#ED028B"));
		btnIniciarSesion.setBounds(536, 559, 170, 39);
		add(btnIniciarSesion);
		

		/**
		 * LBL - ¿Aún sin cuenta?
		 */
		JLabel lblSinCuenta = new JLabel("<html><u>¿Aún no tienes una cuenta?</u></html>");
		lblSinCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(2);
			}
		});
		lblSinCuenta.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblSinCuenta.setBounds(522, 617, 211, 20);
		lblSinCuenta.setForeground(new Color(255, 173, 13));
		add(lblSinCuenta);
		
		/**
		 * LBL - Imagen 
		 */
		JLabel lblImagen = new JLabel();
		lblImagen.setFont(new Font("Rubik", Font.PLAIN, 16));
		lblImagen.setBounds(0, 0, 1200, 720);
		lblImagen.setIcon(new ImageIcon("imagenes/varios/fondo-login.jpg"));
		add(lblImagen);

	}
}