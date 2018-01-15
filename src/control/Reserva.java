package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Reserva {

	private Connection conexion;

	private Statement declaracion;

	private ResultSet datos;

	private int id_Reserva;

	private String id_Usuario;

	private boolean recogido;


	/**
	 * 
	 * @param id_Usuarios
	 * @param lista_Productos
	 */
	public Reserva(String id_Usuarios, Date fecha, Producto[] lista_Productos){

		Conecta conectar = new Conecta();

		conexion = conectar.getConexion();

		try {

			declaracion = conexion.createStatement();

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.aniadir_Productos(lista_Productos);

	}


	
	/**
	 * 
	 * @param lista_Productos
	 */
	
	private void aniadir_Productos(Producto[] lista_Productos) {
		// TODO Auto-generated method stub

	}

}
