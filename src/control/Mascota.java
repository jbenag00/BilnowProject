package control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author Javier
 *
 */

public class Mascota {

	public static java.sql.Statement declaracion;

	public ResultSet datos;

	private String dni_Mascota;

	private String especie;

	private String raza;

	private String sexo;

	private String capa;

	private Date fecha_Nacimiento;

	private Cita[] citas_Mascota;

	/**
	 * 
	 * @param id_Mascota
	 */
	public Mascota(String id_Mascota){

		try {

			Conecta conexion=new Conecta();

			Connection nueva= conexion.getConexion();

			declaracion=nueva.createStatement();

			datos=declaracion.executeQuery("SELECT * FROM mascota where id_Mascota='"+id_Mascota+"';");

			while(datos.next()) {

				this.setDni_Mascota(datos.getString(1));
				this.setEspecie(especie=datos.getString(2));
				this.setRaza(raza=datos.getString(3));
				this.setSexo(datos.getString(4));
				this.setFecha_Nacimiento(datos.getDate(6, null));
				//this.getCitasMascota();

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @return
	 */
	public String getDni_Mascota() {
		return dni_Mascota;
	}

	/**
	 * 
	 * @param dni_Mascota
	 */
	private void setDni_Mascota(String dni_Mascota) {
		this.dni_Mascota = dni_Mascota;
	}

	/**
	 * 
	 * @return
	 */
	public String getEspecie() {
		return especie;
	}

	/**
	 * 
	 * @param especie
	 */
	private void setEspecie(String especie) {
		this.especie = especie;
	}

	/**
	 * 
	 * @return
	 */
	public String getRaza() {
		return raza;
	}

	/**
	 * 
	 * @param raza
	 */
	private void setRaza(String raza) {
		this.raza = raza;
	}

	/**
	 * 
	 * @return
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * 
	 * @param sexo
	 */
	private void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * 
	 * @return
	 */
	public String getCapa() {
		return capa;
	}

	/**
	 * 
	 * @param capa
	 */
	private void setCapa(String capa) {
		this.capa = capa;
	}

	/**
	 * 
	 */
	public void getCitasMascota() {

		ArrayList<Cita> cita_mascota= new ArrayList<Cita>();

		try {
			datos=declaracion.executeQuery("Select * from cita where id_Mascota = "+this.getDni_Mascota()+";");

			while (datos.next()) {

				Cita cita_nueva=new Cita(this.getDni_Mascota());
				cita_nueva.setId_Cita(datos.getInt(1));
				cita_nueva.setFecha_Cita(datos.getDate(2));
				cita_nueva.setId_Mascota(datos.getString(3));


				cita_mascota.add(cita_nueva);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		citas_Mascota=cita_mascota.toArray(new Cita[this.getNumCitas()]);	
	}

	/**
	 * 
	 * @return
	 */
	public Date getFecha_Nacimiento() {
		return fecha_Nacimiento;
	}

	/**
	 * 
	 * @param fecha_Nacimiento
	 */
	private void setFecha_Nacimiento(Date fecha_Nacimiento) {
		this.fecha_Nacimiento = fecha_Nacimiento;
	}

	public void aniadirCita(java.util.Date cita_Fecha) {
		// TODO Auto-generated method stub

		try {
			declaracion.executeUpdate("INSERT INTO `cita` (`id_Cita`, `fecha_cita`, `id_Mascota`) VALUES (NULL, '"+new java.sql.Date(cita_Fecha.getTime())+"', '"+this.getDni_Mascota()+"');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}

	}

	public int getNumCitas() {
		// TODO Auto-generated method stub

		int num_Citas=0;

		try {
			datos=declaracion.executeQuery("SELECT count(*) from cita where id_Mascota ='"+this.getDni_Mascota()+"';");

			if(datos.next()) {
				num_Citas=datos.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return num_Citas;
	}

	public String getCita(int i) {
		
		return citas_Mascota[i].getFecha_Cita().toString();

	}

	public void eliminarCita(int id_Cita) {
		// TODO Auto-generated method stub
		
		try {
			declaracion.execute("DELETE FROM `cita` WHERE `cita`.`id_Cita` = '"+citas_Mascota[id_Cita].getId_Cita()+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gui.Mascota.frame.repaint();
	}

}
