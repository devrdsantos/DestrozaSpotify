package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ControladorDeEntrada;
import controller.GestionDeLaInformacion;
import de.wannawork.jcalendar.JCalendarComboBox;
import view.VistaPrincipal;

public class PanelRegistro extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JTextField textFieldUsuario;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private SimpleDateFormat formato;
	private String premiun;
	
	public PanelRegistro(VistaPrincipal v, ControladorDeEntrada controlador, GestionDeLaInformacion gestionINF) {
		
		formato = new SimpleDateFormat("yyyy-MM-dd");
		
		setSize(1200, 720);
		setVisible(true);
		setLayout(null);
		
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblUsuario.setBounds(723, 171, 80, 28);
		lblUsuario.setForeground(Color.decode("#FFFFFF"));
		add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setForeground(Color.decode("#FFFFFF"));
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPassword.setBounds(723, 317, 100, 28);
		add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(232, 232, 232));
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 14));
		passwordField.setBounds(823, 317, 266, 28);
		add(passwordField);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBackground(new Color(232, 232, 232));
		textFieldUsuario.setFont(new Font("Verdana", Font.PLAIN, 14));
		textFieldUsuario.setBounds(823, 171, 266, 28);
		add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblTienesCuenta = new JLabel("<html><u>¿Ya tienes una cuenta?</u></html>");
		lblTienesCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(1);
			}
		});
		lblTienesCuenta.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblTienesCuenta.setBounds(826, 570, 211, 20);
		lblTienesCuenta.setForeground(new Color(255, 173, 13));
		add(lblTienesCuenta);
		
		
		JLabel lblRegistro = new JLabel("Fecha de nacimiento:");
		lblRegistro.setForeground(Color.WHITE);
		lblRegistro.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblRegistro.setBounds(723, 363, 160, 28);
		add(lblRegistro);
		
		JLabel lblIngresaTuNombre = new JLabel("Nombre/s:");
		lblIngresaTuNombre.setForeground(Color.WHITE);
		lblIngresaTuNombre.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblIngresaTuNombre.setBounds(723, 220, 80, 28);
		add(lblIngresaTuNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBackground(new Color(232, 232, 232));
		textFieldNombre.setFont(new Font("Verdana", Font.PLAIN, 14));
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(823, 220, 266, 28);
		add(textFieldNombre);
		
		JLabel lblIngresaTuApellido = new JLabel("Apellido/s:");
		lblIngresaTuApellido.setForeground(Color.WHITE);
		lblIngresaTuApellido.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblIngresaTuApellido.setBounds(723, 270, 80, 28);
		add(lblIngresaTuApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBackground(new Color(232, 232, 232));
		textFieldApellido.setFont(new Font("Verdana", Font.PLAIN, 14));
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(823, 270, 266, 28);
		add(textFieldApellido);
		
		JLabel lblIdioma = new JLabel("Selecciona un idioma:");
		lblIdioma.setForeground(Color.WHITE);
		lblIdioma.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblIdioma.setBounds(723, 412, 160, 28);
		add(lblIdioma);
		
		JComboBox<String> comboBoxIdioma = new JComboBox<String>();
		comboBoxIdioma.setBackground(new Color(232, 232, 232));
		comboBoxIdioma.setFont(new Font("Verdana", Font.PLAIN, 14));
		for (int i = 0; i < gestionINF.idiomas().size(); i++) {
			comboBoxIdioma.addItem(gestionINF.idiomas().get(i));
		}
		comboBoxIdioma.setBounds(887, 412, 150, 28);
		add(comboBoxIdioma);
		
		JCalendarComboBox calendarNacimiento = new JCalendarComboBox();
		calendarNacimiento.setBackground(new Color(240, 240, 240));
		calendarNacimiento.setBounds(887, 363, 202, 30);
		add(calendarNacimiento);
		
		JRadioButton rdbtnPremiun = new JRadioButton("Cuenta Premium");
		rdbtnPremiun.setOpaque(false);
		rdbtnPremiun.setFont(new Font("Verdana", Font.PLAIN, 14));
		rdbtnPremiun.setForeground(Color.decode("#FFFFFF"));
		rdbtnPremiun.setBounds(821, 465, 150, 23);
		add(rdbtnPremiun);
		
		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrearCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	
				String usuarioFormulario = textFieldUsuario.getText();
				@SuppressWarnings("deprecation")
				String passFormulario =  passwordField.getText();
				String nombreFormulario = textFieldNombre.getText();
				String apelldioFormulario = textFieldApellido.getText();
				String idioma = (String) comboBoxIdioma.getSelectedItem();
				
				if (rdbtnPremiun.isSelected()) {
					premiun = "Premiun";
				} else {
					premiun = "Free";
				}
				
				String fechaNac = formato.format(calendarNacimiento.getDate());
				
				controlador.validarInformacionFormulario(usuarioFormulario, passFormulario, nombreFormulario, apelldioFormulario, idioma, fechaNac, premiun, v);
					
			}
		});
		btnCrearCuenta.setFont(new Font("Verdana", Font.BOLD, 14));
		btnCrearCuenta.setOpaque(true);
		btnCrearCuenta.setContentAreaFilled(true);
		btnCrearCuenta.setForeground(Color.decode("#FFFFFF"));
		btnCrearCuenta.setBorderPainted(false);
		btnCrearCuenta.setBackground(new Color(237, 2, 139));
		btnCrearCuenta.setBounds(845, 513, 150, 40);
		add(btnCrearCuenta);
		
		
		

		/**
		 * LBL - Fondo 
		 */
		JLabel lblImagen = new JLabel();
		lblImagen.setFont(new Font("Rubik", Font.PLAIN, 16));
		lblImagen.setBounds(0, 0, 1200, 720);
		lblImagen.setIcon(new ImageIcon("imagenes/varios/fondo-registro.jpg"));
		add(lblImagen);
		
		
		
	}
}
