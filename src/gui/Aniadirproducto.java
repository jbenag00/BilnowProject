package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Aniadirproducto extends JFrame {

	private JPanel contentPane;
	private JTextField textReferencia;
	private JTextField textNombre;
	private JTextField textCaducidad;
	private JTextField textFabricante;
	private JTextField textPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aniadirproducto frame = new Aniadirproducto();
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
	public Aniadirproducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblAadirProducto = new JLabel("A\u00D1ADIR PRODUCTO");
		lblAadirProducto.setFont(new Font("Consolas", Font.BOLD, 26));
		lblAadirProducto.setBounds(123, 34, 217, 31);
		panel.add(lblAadirProducto);
		
		JLabel lblReferencia = new JLabel("Referencia");
		lblReferencia.setBounds(80, 103, 64, 14);
		panel.add(lblReferencia);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(80, 128, 46, 14);
		panel.add(lblNombre);
		
		JLabel lblFechacaducidad = new JLabel("Fecha caducidad");
		lblFechacaducidad.setBounds(80, 153, 91, 14);
		panel.add(lblFechacaducidad);
		
		JLabel lblFabricante = new JLabel("Fabricante");
		lblFabricante.setBounds(80, 178, 64, 14);
		panel.add(lblFabricante);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(80, 203, 46, 14);
		panel.add(lblPrecio);
		
		textReferencia = new JTextField();
		textReferencia.setBounds(180, 103, 86, 20);
		panel.add(textReferencia);
		textReferencia.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(180, 128, 86, 20);
		panel.add(textNombre);
		
		textCaducidad = new JTextField();
		textCaducidad.setColumns(10);
		textCaducidad.setBounds(180, 153, 86, 20);
		panel.add(textCaducidad);
		
		textFabricante = new JTextField();
		textFabricante.setColumns(10);
		textFabricante.setBounds(180, 178, 86, 20);
		panel.add(textFabricante);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(180, 203, 86, 20);
		panel.add(textPrecio);
		
		JButton btnAniadir = new JButton("A\u00F1adir");
		btnAniadir.setBounds(189, 257, 89, 23);
		panel.add(btnAniadir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(350, 329, 89, 23);
		panel.add(btnCancelar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(277, 103, 110, 23);
		panel.add(btnConsultar);
		
	}

}
