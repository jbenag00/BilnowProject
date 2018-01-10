package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * 
 * @author Javier
 *
 */
public class Cita {

	private Connection conexion;
	
	private Statement declaracion;
	
	private ResultSet datos;
	
	private int id_Cita=0;
	
	private String id_Mascota=null;
	
	private Date fecha_Cital=null;
	
	/**
	 * 
	 */
	public Cita() {
		
		Conecta conectar = new Conecta();
		
		conexion = conectar.getConexion();
		
		try {
			
			declaracion = conexion.createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @param id_Mascota
	 * @param fecha_elegida
	 */
	public void aniadir_Cita(String id_Mascota, Date fecha_elegida){
		
		this.id_Mascota=id_Mascota;
		
		this.fecha_Cital=fecha_elegida;
		
	}

	
	
	
	
}
