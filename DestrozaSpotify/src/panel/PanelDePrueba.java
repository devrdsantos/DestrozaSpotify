package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelDePrueba extends JPanel {
	
	public PanelDePrueba () {
	setSize(1600, 900);
	setVisible(true);
	setFont(new Font("Open Sans", Font.BOLD, 11));
	setBackground(Color.decode("#222222"));
	
	
	// BTN - Ir atrás ///////////////////////////////////////////////////////
	JButton btnAtras = new JButton("Ir atrás");
	btnAtras.setBounds(74, 32, 137, 52);
	btnAtras.setFont(new Font("Open Sans", Font.BOLD, 16));
	
		// ACCIÓN
	btnAtras.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	setLayout(null);
	btnAtras.setBackground(Color.decode("#3f3d3d"));
	btnAtras.setForeground(Color.decode("#ffaa43"));
	btnAtras.setOpaque(true);
	btnAtras.setBorderPainted(false);
	add(btnAtras);
	
	// LBL - Titulo principal
	JLabel lblTitulo = new JLabel("Descubrir Música");
	lblTitulo.setBounds(591, 131, 524, 74);
	lblTitulo.setForeground(new Color(255, 255, 255));
	lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
	lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 48));
	add(lblTitulo);
	
	// BTN - Perfil
	JButton btnPerfil = new JButton("Perfil");
	btnPerfil.setBounds(1355, 32, 137, 52);

		// Acción
	btnPerfil.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	
	btnPerfil.setOpaque(true);
	btnPerfil.setForeground(new Color(255, 170, 67));
	btnPerfil.setFont(new Font("Open Sans", Font.BOLD, 16));
	btnPerfil.setBorderPainted(false);
	btnPerfil.setBackground(new Color(63, 61, 61));
	add(btnPerfil);
	
	// COMBOBOX - Género
	JComboBox comboBoxGeneros = new JComboBox();
	comboBoxGeneros.setBounds(775, 256, 417, 33);
	add(comboBoxGeneros);
	
	JLabel lblArtistasXGenero = new JLabel("Artistas por Género:");
	lblArtistasXGenero.setBounds(538, 249, 224, 41);
	lblArtistasXGenero.setForeground(new Color(255, 255, 255));
	lblArtistasXGenero.setHorizontalAlignment(SwingConstants.RIGHT);
	lblArtistasXGenero.setFont(new Font("Open Sans", Font.PLAIN, 20));
	add(lblArtistasXGenero);
	
	JLabel lblNewLabel = new JLabel("Resultados:");
	lblNewLabel.setBounds(115, 355, 159, 22);
	lblNewLabel.setForeground(new Color(255, 255, 255));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setFont(new Font("Open Sans", Font.PLAIN, 18));
	add(lblNewLabel);
	
	// BTN - Resultado: Artista
	JPanel panel = new JPanel();

		// Acción
	panel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		}
	});
	
	panel.setBackground(Color.decode("#3f3d3d"));
	panel.setBounds(146, 399, 280, 300);
	add(panel);
	panel.setLayout(null);
	
		// LBL - Nombre Artista
	JLabel lblNombreArtista = new JLabel("<html>Nombre Artista</html>");
	lblNombreArtista.setForeground(new Color(255, 255, 255));
	lblNombreArtista.setHorizontalAlignment(SwingConstants.CENTER);
	lblNombreArtista.setFont(new Font("Open Sans", Font.PLAIN, 14));
	lblNombreArtista.setBounds(51, 237, 160, 38);
	panel.add(lblNombreArtista);
	
		// LBL - IMG
	JLabel lblImg = new JLabel("Soy una imagen");
	lblImg.setBounds(41, 26, 200, 200);
	panel.add(lblImg);
	lblImg.setHorizontalAlignment(SwingConstants.CENTER);
	lblImg.setBackground(Color.decode("#FFFFFF"));
	lblImg.setOpaque(true);

	
	
	

	// PRUEBA ALEJANDRO
	/*DefaultListModel<Panel> listModel = new DefaultListModel<>();
	for (String elemento : elementos) {
		if (true) // insertar condicion
			listModel.addElement(elemento);
	}
	getContentPane().setLayout(null);

	JList<String> jList = new JList<String>(listModel);

	JPanel panel = new JPanel();
	panel.setBounds(0, 200, 350, 200);
	getContentPane().add(panel);

	JScrollPane jScrollPane = new JScrollPane(jList);
	jScrollPane.setPreferredSize(new Dimension(300, panel.getHeight()));
	panel.add(jScrollPane);*/
	
	
	

}
	}
