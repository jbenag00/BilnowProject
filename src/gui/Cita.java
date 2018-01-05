package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
	private JTable tabla_Horarios;

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

		JPanel panel = new JPanel();
		panel.setBounds(461, 67, 420, 250);
		frame.getContentPane().add(panel);
		panel.setLayout(null);


		int x=0;
		int pos=0;		
		for(int i=0;i<5;i++) {
			
			int y=0;
			for(int j=0;j<7;j++) {

				JPanel panel_1 = new JPanel();
				panel_1.setBounds(y, x, 60, 50);
				panel.add(panel_1);
				panel_1.setLayout(null);

				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setText(String.valueOf(pos));			
				lblNewLabel.setBounds(10, 11, 40, 28);
				panel_1.add(lblNewLabel);
				pos++;
				y+=60;

			}

			x+=50;
		}

		JLabel mes_Anio = new JLabel("");
		mes_Anio.setBounds(518, 22, 302, 30);
		frame.getContentPane().add(mes_Anio);

		JButton boton_MesAtras = new JButton("");
		boton_MesAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		boton_MesAtras.setBounds(461, 22, 59, 30);
		frame.getContentPane().add(boton_MesAtras);

		JButton boton_Mesdelante = new JButton("");
		boton_Mesdelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boton_Mesdelante.setBounds(821, 22, 59, 30);
		frame.getContentPane().add(boton_Mesdelante);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(461, 365, 420, 130);
		frame.getContentPane().add(scrollPane);

		tabla_Horarios = new JTable();
		tabla_Horarios.setModel(new DefaultTableModel(
				new Object[][] {
					{new String("8:00")},
					{new String("9:00")},
					{new String("10:00")},
					{new String("11:00")},
					{new String("12:00")},
					{new String("13:00")},
					{new String("16:00")},
					{new String("17:00")},
					{new String("18:00")},
					{new String("19:00")},
				},
				new String[] {
						""
				}
				));
		tabla_Horarios.getColumnModel().getColumn(0).setPreferredWidth(386);
		scrollPane.setViewportView(tabla_Horarios);
		
		JLabel lblInformacinMascota = new JLabel("Informaci\u00F3n Mascota");
		lblInformacinMascota.setBounds(24, 26, 384, 26);
		frame.getContentPane().add(lblInformacinMascota);
		
		JButton btnGuardarCita = new JButton("Guardar Cita");
		btnGuardarCita.setBounds(611, 545, 121, 23);
		frame.getContentPane().add(btnGuardarCita);
	}
}
