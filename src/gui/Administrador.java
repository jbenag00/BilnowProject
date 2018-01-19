package gui;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

import control.AccesoBD;
import control.Producto;
import control.Usuario;

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
	private JTextField textField;
	public Usuario administrador;

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
	 * @wbp.parser.entryPoint
	 */
	public Administrador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 371, 354);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
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
				
				aniadircliente.main(null);
			}

			/**
			 * 
			 */
		/*	public void crear_Cliente() {
						
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
				
			}*/
		});
		mnInicio.add(mntmAadirCliente);
		
		JMenuItem mntmAadirMascota = new JMenuItem("A\u00F1adir Mascota");
		mnInicio.add(mntmAadirMascota);
		
		
		
		JMenuItem mntmAadirProducto = new JMenuItem("A\u00F1adir Producto");
		mntmAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				aniadirproducto.main(null);
				
			}

		/*	private void aniadir_Producto() {
				// TODO Auto-generated method stub
				
				frame.getContentPane().add(panel);
				
				JLabel lblAadirProducto = new JLabel("A\u00F1adir Producto");
				lblAadirProducto.setBounds(88, 11, 325, 75);
				panel.add(lblAadirProducto);
				
				frame.repaint();
				
			}*/
		});
		mnInicio.add(mntmAadirProducto);
		
		JMenu mnOpcionesAdmin = new JMenu("Opciones Admin");
		menuBar.add(mnOpcionesAdmin);
		
		JMenuItem mntmBackup = new JMenuItem("Backup");
		mntmBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AccesoBD consulta=new AccesoBD();
				
				JFileChooser fileChooser = new JFileChooser();
			    fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			    
			    int result = fileChooser.showSaveDialog(mntmBackup);

			    File fileName=null;
			    
			    if (result != JFileChooser.CANCEL_OPTION) {

			        fileName = fileChooser.getSelectedFile();

					consulta.backup(fileName);
					
			    }
								
			}
		});
		mnOpcionesAdmin.add(mntmBackup);
		frame.getContentPane().setLayout(null);
		
		JLabel lblConsultarCliente = new JLabel("Consultar cliente");
		lblConsultarCliente.setBounds(38, 215, 126, 14);
		frame.getContentPane().add(lblConsultarCliente);
		
		textField = new JTextField();
		textField.setBounds(104, 237, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setBounds(200, 236, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnCatlogoDeProductos = new JButton("Cat\u00E1logo de productos");
		btnCatlogoDeProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					Reserva nueva=new Reserva(administrador);
					nueva.main(null);
					
			}
		});
		btnCatlogoDeProductos.setBounds(95, 53, 169, 38);
		frame.getContentPane().add(btnCatlogoDeProductos);
		
		JButton btnAadirCliente = new JButton("A\u00F1adir cliente");
		btnAadirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aniadircliente.main(null);
			}
		});
		btnAadirCliente.setBounds(95, 103, 169, 38);
		frame.getContentPane().add(btnAadirCliente);
		
		JLabel lblDni_1 = new JLabel("DNI");
		lblDni_1.setBounds(66, 240, 46, 14);
		frame.getContentPane().add(lblDni_1);
		
		JButton btnAniadirProducto = new JButton("A\u00F1adir producto");
		btnAniadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aniadirproducto.main(null);
			}
		});
		btnAniadirProducto.setBounds(95, 153, 169, 38);
		frame.getContentPane().add(btnAniadirProducto);
	}
}
