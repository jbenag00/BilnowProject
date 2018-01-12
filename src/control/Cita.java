package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

	private Date fecha_Cita=null;
	
	private ArrayList<Cita> citas_Mascota=null;

	/**
	 * @param id_Mascota 
	 * 
	 */
	public Cita(String id_Mascota) {

		this.setId_Mascota(id_Mascota);

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
	 * @return
	 */
	public int getId_Cita() {
		return id_Cita;
	}

	/**
	 * 
	 * @param id_Cita
	 */
	public void setId_Cita(int id_Cita) {
		this.id_Cita = id_Cita;
	}

	/**
	 * 
	 * @return
	 */
	public String getId_Mascota() {
		return id_Mascota;
	}

	/**
	 * 
	 * @param id_Mascota
	 */
	public void setId_Mascota(String id_Mascota) {
		this.id_Mascota = id_Mascota;
	}

	/**
	 * 
	 * @return
	 */
	public Date getFecha_Cita() {
		return fecha_Cita;
	}

	/**
	 * 
	 * @param fecha_Cita
	 */
	public void setFecha_Cita(Date fecha_Cita) {
		this.fecha_Cita = fecha_Cita;
	}
	/**
	 * 
	 * @param pos_Mascota
	 * @return 
	 */

	public Cita getCita(int pos_Cita) {
		// TODO Auto-generated method stub
		
		return this.citas_Mascota.get(pos_Cita);
		
	}

	
}
