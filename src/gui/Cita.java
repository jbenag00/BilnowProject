package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import control.Mascota;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Cita {

	private JFrame frame;

	private static Mascota mascota_Cita=null;
	
	private final String[] horarios= {"8:00",
									  "9:00",
									  "10:00",
									  "11:00",
									  "12:00",
									  "13:00",
									  "16:00",
									  "17:00",
									  "18:00",
									  "19:00",
									  "20:00"};

	/**
	 * Launch the application.
	 */
	public static void main(Mascota mascota) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mascota_Cita=mascota;
					Cita window = new Cita();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cita() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 928, 645);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JCalendar calendario=new JCalendar();
		calendario.setBounds(461, 67, 420, 250);
		frame.getContentPane().add(calendario);
		
		JLabel lblInformacinMascota = new JLabel("Informaci\u00F3n Mascota");
		lblInformacinMascota.setBounds(24, 26, 384, 26);
		frame.getContentPane().add(lblInformacinMascota);
		
		JButton btnGuardarCita = new JButton("Guardar Cita");
		btnGuardarCita.setBounds(611, 545, 121, 23);
		frame.getContentPane().add(btnGuardarCita);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(461, 366, 420, 132);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel__Horas = new JPanel();
		scrollPane.setViewportView(panel__Horas);
		
		panel__Horas.setPreferredSize(new Dimension(418,horarios.length*31));
		panel__Horas.setLayout(null);
		
		int pos_Lab=0;
		boolean hora_Libre=true;
		for (int i = 0; i < horarios.length; i++) {
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(0, pos_Lab, 418, 31);
			panel__Horas.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel(horarios[i]);
			lblNewLabel_1.setBounds(27, 11, 46, 14);
			panel_1.add(lblNewLabel_1);
			
			//control
			if(horarios[i]=="13:00") {
				hora_Libre=false;
			}
			
			if(hora_Libre==true) {
				panel_1.setBackground(Color.GREEN);
			}
			else {
				panel_1.setBackground(Color.RED);
			}
			hora_Libre=true;
			pos_Lab+=31;
		}
	}
}
