package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		setLayout(null);
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setOpaque(true);
		btnPerfil.setForeground(Color.WHITE);
		btnPerfil.setFont(new Font("Verdana", Font.BOLD, 16));
		btnPerfil.setContentAreaFilled(true);
		btnPerfil.setBorderPainted(false);
		btnPerfil.setBackground(new Color(53, 53, 53));
		btnPerfil.setBounds(1009, 34, 136, 48);
		btnPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(19);
			}
		});
		add(btnPerfil);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarDePanel(3);
			}
		});
		btnAtras.setFont(new Font("Verdana", Font.BOLD, 16));
		btnAtras.setOpaque(true);
		btnAtras.setContentAreaFilled(true);
		btnAtras.setForeground(Color.decode("#FFFFFF"));
		btnAtras.setBorderPainted(false);
		btnAtras.setBackground(Color.decode("#353535"));
		btnAtras.setBounds(52, 34, 136, 48);
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
		podcastSeleccionado = gestionINF.mostrarPodcast();
		
		for (int i = 0; i < gestionINF.mostrarEpisodiosPorPodcast(gestionINF.devolverIdPodcast(podcastSeleccionado)).size(); i++) {
			
				EpisodiosPorPodcast.addElement(gestionINF.mostrarEpisodiosPorPodcast(gestionINF.devolverIdPodcast(podcastSeleccionado)).get(i));
		}
		listaEpisodios.setModel(EpisodiosPorPodcast);
		listaEpisodios.setBounds(100, 300, 1000, 313);
		add(listaEpisodios);
		

	}
	
	
		}

