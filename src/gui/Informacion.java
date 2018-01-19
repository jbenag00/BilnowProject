package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class Informacion {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Informacion window = new Informacion();
					window.frame.setVisible(true);
					window.frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Informacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 633, 748);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Aceptar");
		
		JButton btnIndice = new JButton("Indice");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnIndice, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton_2)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIndice, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 551, Short.MAX_VALUE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(37))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 562, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnInicio.add(mntmSalir);
	}
}
