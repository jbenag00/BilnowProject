package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {

	
	private static String driver = "com.mysql.jdbc.Driver";
	
	private static String linea_Conectar = "jdbc:mysql://localhost:3306/bilnow_db?useSSL=false";
	
	private static String usuario = "root";
	
	private static String passwd = "";
	
	private Connection conection = null;
	
	/**
	 * 
	 */
	public Conectar() {
		
		try {
			
			Class.forName(driver);
			
			conection=DriverManager.getConnection(linea_Conectar,usuario,passwd);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConexion() {
		
		return conection;
		
	}
	
}
