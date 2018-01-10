package gui;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;
import javax.swing.JPanel;

/**
 * 
 * @author Javier
 *
 */
public class Administrador {

	private static JFrame frame;
	private JTextField textnom;
	private JTextField Apellido;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private JTextField textEmail;
	private JTextField textDni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	 */
	public Administrador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 658, 509);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 642, 449);
		panel.setLayout(null);
		
			
		JPanel panel_Cli = new JPanel();
		panel_Cli.setBounds(0, 0, 642, 449);
		panel_Cli.setLayout(null);
				
			
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		/**
		 * 
		 * Crea una pesaña en el menu
		 * 
		 */
		JMenuItem mntmAadirCliente = new JMenuItem("A\u00F1adir Cliente");
		mntmAadirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				crear_Cliente();
			}

			/**
			 * 
			 */
			public void crear_Cliente() {
						
				frame.getContentPane().add(panel_Cli);
				
				JLabel lblTelefono = new JLabel("Telefono:");
				lblTelefono.setBounds(10, 194, 46, 14);
				panel_Cli.add(lblTelefono);
				
				JLabel lblEmail = new JLabel("email");
				lblEmail.setBounds(10, 254, 24, 14);
				panel_Cli.add(lblEmail);
				
				JLabel lblNombre = new JLabel("nombre:");
				lblNombre.setBounds(10, 101, 40, 14);
				panel_Cli.add(lblNombre);
				
				JLabel lblApellindo = new JLabel("apellindo");
				lblApellindo.setBounds(233, 101, 42, 14);
				panel_Cli.add(lblApellindo);
				
				JLabel lblDireccion = new JLabel("Direccion:");
				lblDireccion.setBounds(10, 152, 47, 14);
				panel_Cli.add(lblDireccion);
				
				JLabel lblDni = new JLabel("dni: ");
				lblDni.setBounds(13, 34, 86, 14);
				panel_Cli.add(lblDni);
				
				textnom = new JTextField();
				textnom.setBounds(286, 98, 86, 20);
				panel_Cli.add(textnom);
				textnom.setColumns(10);
				
				Apellido = new JTextField();
				Apellido.setBounds(67, 152, 86, 20);
				panel_Cli.add(Apellido);
				Apellido.setColumns(10);
				
				textDireccion = new JTextField();
				textDireccion.setBounds(60, 191, 86, 20);
				panel_Cli.add(textDireccion);
				textDireccion.setText("");
				textDireccion.setColumns(10);
				
				textTelefono = new JTextField();
				textTelefono.setBounds(44, 251, 86, 20);
				panel_Cli.add(textTelefono);
				textTelefono.setColumns(10);
				
				textEmail = new JTextField();
				textEmail.setBounds(144, 31, 86, 20);
				panel_Cli.add(textEmail);
				textEmail.setColumns(10);
				
				textDni = new JTextField();
				textDni.setBounds(60, 98, 86, 20);
				panel_Cli.add(textDni);
				textDni.setColumns(10);
				
				JButton btnGenerarContrasea = new JButton("Generar Contrase\u00F1a");
				btnGenerarContrasea.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						generarContraseña();
						
					}
					private void generarContraseña() {
						// TODO Auto-generated method stub
						
					}
				});
				btnGenerarContrasea.setBounds(469, 388, 131, 23);
				panel_Cli.add(btnGenerarContrasea);
				
				frame.repaint();
				
			}
		});
		mnInicio.add(mntmAadirCliente);
		
		JMenuItem mntmAadirMascota = new JMenuItem("A\u00F1adir Mascota");
		mnInicio.add(mntmAadirMascota);
		
		JMenuItem mntmAadirProducto = new JMenuItem("A\u00F1adir Producto");
		mntmAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				aniadir_Producto();
				
			}

			private void aniadir_Producto() {
				// TODO Auto-generated method stub
				
				frame.getContentPane().add(panel);
				
				JLabel lblAadirProducto = new JLabel("A\u00F1adir Producto");
				lblAadirProducto.setBounds(88, 11, 325, 75);
				panel.add(lblAadirProducto);
				
				frame.repaint();
				
			}
		});
		mnInicio.add(mntmAadirProducto);
	}
}
