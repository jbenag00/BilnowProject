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
	private static Usuario administrador;

	/**
	 * Launch the application.
	 */
	public static void main(Usuario user) {
		administrador=user;
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
				
				Aniadircliente.main(null);
				
			}
		});
		mnInicio.add(mntmAadirCliente);
		
		
		
		JMenuItem mntmAadirProducto = new JMenuItem("A\u00F1adir Producto");
		mntmAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Aniadirproducto.main(null);
				
			}
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
				
				
				String usuario=textField.getText();
				boolean existe=false;
				AccesoBD consulta=new AccesoBD();
				existe=consulta.existeUser(usuario);
				if(existe==true) {
					
					JButton btnagregarButton = new JButton("+");
					JButton buttoneliminar = new JButton("-");
					
					Cliente cliente_Edita=new Cliente(new Usuario(usuario),btnagregarButton,buttoneliminar);
					cliente_Edita.main();
					
				}
				else {
					Aniadircliente nuevo_Cliente=new Aniadircliente();
					nuevo_Cliente.main(null);
				}
				
				
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
				Aniadircliente.main(null);
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
				Aniadirproducto.main(null);
			}
		});
		btnAniadirProducto.setBounds(95, 153, 169, 38);
		frame.getContentPane().add(btnAniadirProducto);
	}
}
