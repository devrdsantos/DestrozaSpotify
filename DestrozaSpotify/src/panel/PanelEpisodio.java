package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.GestionDeLaInformacion;
import view.VistaPrincipal;

public class PanelEpisodio extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String generoSeleccionado;
	private String podcastSeleccionado;
	
	public PanelEpisodio (VistaPrincipal v, GestionDeLaInformacion gestionINF) {
		setSize(1200, 720);
		setVisible(true);
		setFont(new Font("Open Sans", Font.BOLD, 11));
		setBackground(Color.decode("#222222"));
		
		
		/**
		 *  BTN - Ir atrás 
		 */
		JButton btnAtras = new JButton("Ir atrás");
		btnAtras.setBounds(32, 32, 137, 52);
		btnAtras.setFont(new Font("Open Sans", Font.BOLD, 16));
		
			/**
			 *  ACCION DEL BOTON
			 */
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarDePanel(3);
			}
		});
		setLayout(null);
		btnAtras.setBackground(Color.decode("#3f3d3d"));
		btnAtras.setForeground(Color.decode("#ffaa43"));
		btnAtras.setOpaque(true);
		btnAtras.setBorderPainted(false);
		add(btnAtras);
		
								
		JLabel lblNewLabel = new JLabel("Episodios:");
		lblNewLabel.setBounds(100, 250, 159, 22);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans", Font.PLAIN, 18));
		add(lblNewLabel);
		
		JList<String> listaEpisodios = new JList<String>();
		listaEpisodios.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				gestionINF.artistaSeleccionado(listaEpisodios.getSelectedValue());
				v.cambiarDePanel(7);
			}
		});
		DefaultListModel<String> EpisodiosPorPodcast = new DefaultListModel<String>();
		for (int i = 0; i < gestionINF.mostrarEpisodiosPorPodcast(gestionINF.mostrarPodcast()).size(); i++) {
			
				EpisodiosPorPodcast.addElement(gestionINF.mostrarEpisodiosPorPodcast(gestionINF.mostrarPodcast()).get(i));
		}
		listaEpisodios.setModel(EpisodiosPorPodcast);
		listaEpisodios.setBounds(100, 300, 1000, 313);
		add(listaEpisodios);
		

	}
	
	
		}

