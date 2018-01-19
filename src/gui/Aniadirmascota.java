package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Aniadirmascota extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDNIMascota;
	private JTextField textNombre;
	private JTextField textField_3;
	private JTextField textRaza;
	private JTextField textEspecie;
	private JTextField textFecha;
	private JTextField textDNIDuenio;
	private JTextField textCapa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aniadirmascota frame = new Aniadirmascota();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Aniadirmascota() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblAadirMascota = new JLabel("A\u00D1ADIR MASCOTA");
		lblAadirMascota.setFont(new Font("Consolas", Font.BOLD, 26));
		lblAadirMascota.setBounds(143, 22, 196, 31);
		panel.add(lblAadirMascota);
		
		JLabel lblDnimascota = new JLabel("DNI Mascota");
		lblDnimascota.setBounds(43, 77, 64, 14);
		panel.add(lblDnimascota);
		
		textFieldDNIMascota = new JTextField();
		textFieldDNIMascota.setBounds(152, 77, 162, 20);
		panel.add(textFieldDNIMascota);
		textFieldDNIMascota.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(43, 102, 46, 14);
		panel.add(lblNombre);
		
		JLabel lblCapa = new JLabel("Capa");
		lblCapa.setBounds(43, 177, 46, 14);
		panel.add(lblCapa);
		
		textNombre = new JTextField();
		textNombre.setBounds(152, 102, 116, 20);
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		textEspecie = new JTextField();
		textEspecie.setBounds(152, 127, 116, 20);
		panel.add(textEspecie);
		textEspecie.setColumns(10);
		
		JLabel lblEspecie = new JLabel("Especie");
		lblEspecie.setBounds(43, 127, 46, 14);
		panel.add(lblEspecie);
		
		JLabel lblRaza = new JLabel("Raza");
		lblRaza.setBounds(43, 152, 46, 14);
		panel.add(lblRaza);
		
		JLabel lblFechanacimiento = new JLabel("Fecha de nacimiento");
		lblFechanacimiento.setBounds(43, 202, 110, 14);
		panel.add(lblFechanacimiento);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(43, 232, 35, 14);
		panel.add(lblSexo);
		
		JCheckBox chckbxHembra = new JCheckBox("Hembra");
		chckbxHembra.setBounds(131, 228, 64, 23);
		panel.add(chckbxHembra);
		
		JCheckBox chckbxMacho = new JCheckBox("Macho");
		chckbxMacho.setBounds(77, 228, 57, 23);
		panel.add(chckbxMacho);
		
		JLabel lblDniDuenio = new JLabel("DNI Due\u00F1o");
		lblDniDuenio.setBounds(43, 257, 64, 14);
		panel.add(lblDniDuenio);
		
		textRaza = new JTextField();
		textRaza.setColumns(10);
		textRaza.setBounds(152, 152, 116, 20);
		panel.add(textRaza);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(152, 202, 116, 20);
		panel.add(textFecha);
		
		textDNIDuenio = new JTextField();
		textDNIDuenio.setColumns(10);
		textDNIDuenio.setBounds(152, 257, 116, 20);
		panel.add(textDNIDuenio);
		
		textCapa = new JTextField();
		textCapa.setColumns(10);
		textCapa.setBounds(152, 177, 116, 20);
		panel.add(textCapa);
		
		JButton btnAniadir = new JButton("A\u00F1adir");
		btnAniadir.setBounds(191, 308, 89, 23);
		panel.add(btnAniadir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(353, 343, 89, 23);
		panel.add(btnCancelar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(324, 76, 110, 23);
		panel.add(btnConsultar);
	}

}
