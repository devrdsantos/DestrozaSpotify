package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ControladorDeEntrada;
import de.wannawork.jcalendar.JCalendarComboBox;
import view.VistaPrincipal;
import javax.swing.JRadioButton;

public class PanelRegistro extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JTextField textFieldUsuario;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private SimpleDateFormat formato;
	private boolean premiun = false;
	
	public PanelRegistro(VistaPrincipal v, ControladorDeEntrada controlador) {
		
		formato = new SimpleDateFormat("yyyy-MM-dd");
		
		setSize(1200, 720);
		setVisible(true);
		setLayout(null);
		
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#142850"));
		JLabel mensajeRegistro = new JLabel("Regístrate en Cines ESA");
		mensajeRegistro.setForeground(Color.decode("#ffffff"));
		mensajeRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeRegistro.setFont(new Font("Malgun Gothic", Font.BOLD, 32));
		mensajeRegistro.setBounds(371, 91, 515, 78);
		add(mensajeRegistro);
		
		JLabel lblUsuario = new JLabel("Ingresa tu usuario:");
		lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblUsuario.setBounds(272, 209, 173, 28);
		lblUsuario.setForeground(Color.decode("#FFFFFF"));
		add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Ingresa una contraseña:");
		lblPassword.setForeground(Color.decode("#FFFFFF"));
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPassword.setBounds(230, 336, 228, 28);
		add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(507, 337, 266, 34);
		add(passwordField);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(507, 210, 266, 34);
		add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblTienesCuenta = new JLabel("¿Ya tienes una cuenta?");
		lblTienesCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(1);
			}
		});
		lblTienesCuenta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTienesCuenta.setBounds(639, 592, 211, 20);
		lblTienesCuenta.setForeground(Color.decode("#BE6DB7"));
		add(lblTienesCuenta);
		
		
		JLabel lblRegistro = new JLabel("Ingresa la fecha de nacimiento\r\n:");
		lblRegistro.setForeground(Color.WHITE);
		lblRegistro.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblRegistro.setBounds(173, 458, 295, 28);
		add(lblRegistro);
		
		JLabel lblIngresaTuNombre = new JLabel("Ingresa tu nombre:");
		lblIngresaTuNombre.setForeground(Color.WHITE);
		lblIngresaTuNombre.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblIngresaTuNombre.setBounds(272, 276, 185, 28);
		add(lblIngresaTuNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(507, 277, 266, 34);
		add(textFieldNombre);
		
		JLabel lblIngresaTuApellido = new JLabel("Ingresa tu apellido:");
		lblIngresaTuApellido.setForeground(Color.WHITE);
		lblIngresaTuApellido.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblIngresaTuApellido.setBounds(275, 403, 193, 28);
		add(lblIngresaTuApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(507, 404, 266, 34);
		add(textFieldApellido);
		
		JLabel lblIdioma = new JLabel("Idioma:");
		lblIdioma.setForeground(Color.WHITE);
		lblIdioma.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblIdioma.setBounds(372, 513, 86, 28);
		add(lblIdioma);
		
		JComboBox<String> comboBoxIdioma = new JComboBox<String>();
		comboBoxIdioma.addItem("ESP");
		comboBoxIdioma.addItem("EUS");
		comboBoxIdioma.addItem("ENG");
		comboBoxIdioma.setBounds(507, 517, 150, 28);
		add(comboBoxIdioma);
		
		JCalendarComboBox calendarNacimiento = new JCalendarComboBox();
		calendarNacimiento.setBounds(507, 458, 266, 35);
		add(calendarNacimiento);
		
		JRadioButton rdbtnPremiun = new JRadioButton("Premiun");
		rdbtnPremiun.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnPremiun.setBounds(690, 518, 109, 23);
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
//				@SuppressWarnings("deprecation")
				String passFormulario =  passwordField.getText();
				String nombreFormulario = textFieldNombre.getText();
				String apelldioFormulario = textFieldApellido.getText();
				String idioma = (String) comboBoxIdioma.getSelectedItem();
				
				if (rdbtnPremiun.isSelected()) {
					premiun = true;
				}
				
				String fechaNac = formato.format(calendarNacimiento.getDate());
				
				controlador.validarInformacionFormulario(usuarioFormulario, passFormulario, nombreFormulario, apelldioFormulario, idioma, fechaNac, premiun, v);
					
			}
		});
		btnCrearCuenta.setFont(new Font("Verdana", Font.BOLD, 16));
		btnCrearCuenta.setOpaque(true);
		btnCrearCuenta.setContentAreaFilled(true);
		btnCrearCuenta.setForeground(Color.decode("#FFFFFF"));
		btnCrearCuenta.setBorderPainted(false);
		btnCrearCuenta.setBackground(Color.decode("#C67ACE"));
		btnCrearCuenta.setBounds(465, 582, 150, 39);
		add(btnCrearCuenta);
		
		
		
		
		
		
		
	}
}