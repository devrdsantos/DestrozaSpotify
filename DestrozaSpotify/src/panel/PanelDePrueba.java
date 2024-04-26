package panel;

import java.awt.Color;
import java.awt.Font;

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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

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
	
	JLabel lblTitulo = new JLabel("Descubrir Música");
	lblTitulo.setBounds(591, 131, 524, 74);
	lblTitulo.setForeground(new Color(255, 255, 255));
	lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
	lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 48));
	add(lblTitulo);
	
	JButton btnPerfil = new JButton("Perfil");
	btnPerfil.setBounds(1355, 32, 137, 52);
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
	
	JComboBox comboBoxGeneros = new JComboBox();
	comboBoxGeneros.setBounds(775, 272, 417, 33);
	add(comboBoxGeneros);
	
	JLabel lblArtistasXGenero = new JLabel("Artistas por Género:");
	lblArtistasXGenero.setBounds(538, 265, 224, 41);
	lblArtistasXGenero.setForeground(new Color(255, 255, 255));
	lblArtistasXGenero.setHorizontalAlignment(SwingConstants.RIGHT);
	lblArtistasXGenero.setFont(new Font("Open Sans", Font.PLAIN, 20));
	add(lblArtistasXGenero);
	
	JLabel lblNewLabel = new JLabel("Resultados:");
	lblNewLabel.setBounds(139, 395, 159, 22);
	lblNewLabel.setForeground(new Color(255, 255, 255));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setFont(new Font("Open Sans", Font.PLAIN, 18));
	add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("New label");
	lblNewLabel_1.setBounds(242, 203, 186, 171);
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	add(lblNewLabel_1);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(173, 445, 1133, 413);
	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPane.setToolTipText("");
	scrollPane.setLayout(null);
	add(scrollPane);

}
	}
