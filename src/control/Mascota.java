package control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
}
