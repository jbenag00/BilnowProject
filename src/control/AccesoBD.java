package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccesoBD {
	
	private Statement declaracion;
	
	private ResultSet datos;
	
	
	public AccesoBD() {


		Conecta nuevo=new Conecta();

		Connection conexion=nuevo.getConexion();

		try {

			declaracion=conexion.createStatement();

		} catch (SQLException e) {

			e.printStackTrace();
		
		}
	
	}
	
	
	/**
	 * 
	 * @return
	 */
	public ResultSet getProductosBD(){


		try {
		
			datos=declaracion.executeQuery("SELECT * FROM `productos`;");


		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return datos;

	}
	
	/**
	 * 
	 * @return
	 */
	public ResultSet getNumProductosBD() {

		try {
			datos=declaracion.executeQuery("SELECT count(*) from productos");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return datos;
	}
	

}
