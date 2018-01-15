package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.Mascota;
import control.Usuario;

import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cliente {

	public static JFrame frame;
	private JTextField textDni;
	private JTextField textDireccion;
	private JTextField textNombre;
	private JTextField textCorreo;
	private Usuario cliente;
	public int pos_Mascota;
	public int pos;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	 * @param user 
	 */
	public Cliente(Usuario user) {
		this.cliente=user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 830, 562);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnPedirCita = new JButton("Pedir cita");
		btnPedirCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Cita nueva=new Cita();
				nueva.main(cliente.getMascota(0),null);	
			}
		});
		btnPedirCita.setBounds(659, 459, 134, 39);

		JLabel lblDni = new JLabel("Dni:");
		lblDni.setBounds(29, 31, 46, 14);
		frame.getContentPane().add(lblDni);

		textDni = new JTextField();
		textDni.setBounds(52, 28, 86, 20);
		frame.getContentPane().add(textDni);
		textDni.setColumns(10);
		textDni.setText(cliente.getDni_usuario());
		//mostrar_Mascotas();

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(29, 69, 66, 14);
		frame.getContentPane().add(lblDireccion);

		textDireccion = new JTextField();
		textDireccion.setBounds(123, 67, 373, 17);
		frame.getContentPane().add(textDireccion);
		textDireccion.setColumns(10);
		textDireccion.setText(cliente.getDireccion_usuario());

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(186, 31, 46, 14);
		frame.getContentPane().add(lblNombre);

		textNombre = new JTextField();
		textNombre.setBounds(242, 28, 251, 17);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		textNombre.setText(cliente.getNombre_usuario());

		JLabel lblCorreoElectronico = new JLabel("Correo electronico:");
		lblCorreoElectronico.setBounds(29, 113, 98, 14);
		frame.getContentPane().add(lblCorreoElectronico);

		textCorreo = new JTextField();
		textCorreo.setBounds(137, 110, 362, 20);
		frame.getContentPane().add(textCorreo);
		textCorreo.setColumns(10);
		textCorreo.setText(cliente.getEmail_usuario());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(29, 183, 761, 248);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JButton btnReserve = new JButton("Reservar");
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Reserva nueva=new Reserva(cliente);
				nueva.main(null);
				
			}
		});
		
		btnReserve.setBounds(571, 43, 209, 55);
		frame.getContentPane().add(btnReserve);
				
		pos=0;
		
		for(int i=0;i<cliente.getNumMascotas();i++) {
			
			Mascota actual=cliente.getMascota(i);	
			
			control.Cita control_Cita=new control.Cita(actual.getDni_Mascota());
			JPanel panel_Mascota = new JPanel();
			panel_Mascota.setForeground(Color.YELLOW);
			panel_Mascota.setBounds(0, pos, 751, 41);
			panel_Mascota.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					
					frame.getContentPane().add(btnPedirCita);

					int pos=panel_Mascota.getY();
					
					if(pos!=0) {
						pos_Mascota=(pos+1)%41;
					}
					else {
						pos_Mascota=pos%10;
					}
					
					frame.repaint();
					
				}
			});
			panel.add(panel_Mascota);
			panel_Mascota.setLayout(null);
			
			JLabel nom_Mascota = new JLabel("New label");
			nom_Mascota.setBounds(33, 11, 46, 14);
			panel_Mascota.add(nom_Mascota);
			
			nom_Mascota.setText(actual.getDni_Mascota());
			
			if(control_Cita.getNumCitas()>0) {
				JButton btnVercitas = new JButton("Ver cita");
				btnVercitas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						gui.Mascota ventana_Mascota = new gui.Mascota(actual);
						ventana_Mascota.main(actual);
						
					}
				});
				btnVercitas.setBounds(633, 7, 89, 23);
				panel_Mascota.add(btnVercitas);
			}
				
			pos=pos+41;
		}
		
	}
}
