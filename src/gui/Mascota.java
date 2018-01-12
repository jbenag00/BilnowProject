package gui;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import control.Usuario;

import javax.swing.JButton;

public class Mascota {

	public static JFrame frame;
	
	private control.Mascota mascota_seleccionada;
	
	private int cita_Seleccionada;

	/**
	 * Launch the application.
	 */
	public static void main(control.Mascota actual) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mascota window = new Mascota(actual);
					
					frame.setVisible(true);
					frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param actual 
	 */
	public Mascota(control.Mascota actual) {
		
		this.mascota_seleccionada=actual;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 499, 731);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(28, 403, 428, 169);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JButton btnBorrarCita = new JButton("Borrar Cita");
		btnBorrarCita.setBounds(74, 595, 116, 42);
		
		
		JButton btnEditarCita = new JButton("Editar Cita");
		btnEditarCita.setBounds(280, 595, 124, 42);
		
		panel.setPreferredSize(new Dimension(426, 43*mascota_seleccionada.getNumCitas()));
		
		mascota_seleccionada.getCitasMascota();

		int pos=0;
		
		for(int i=0;i< mascota_seleccionada.getNumCitas();i++) {
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(0, pos, 426, 43);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel label_Fecha = new JLabel(mascota_seleccionada.getCita(i));
			label_Fecha.setBounds(50, 11, 46, 14);
			panel_1.add(label_Fecha);
			
			panel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					
					frame.getContentPane().add(btnBorrarCita);
					
					frame.getContentPane().add(btnEditarCita);

					
					int pos=panel_1.getY();
					
					if(pos!=0) {
						cita_Seleccionada=pos/43;
					}
					else {
						cita_Seleccionada=0;
					}
					
					frame.repaint();
					
				}
			});
			
			pos=pos+43;
			
		}
		
		btnBorrarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				mascota_seleccionada.eliminarCita(cita_Seleccionada);
									
			}
		});
		
		btnEditarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				gui.Cita editar_Reserva=new gui.Cita();
				JButton btnEditarCita = new JButton("Editar cita");
				editar_Reserva.main(mascota_seleccionada,btnEditarCita);
				
				frame.setVisible(false);
				
			}
		});
			
				
	}
}