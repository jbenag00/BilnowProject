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

	private int sexo;

	private String capa;

	private Date fecha_Nacimiento;
	
	private Cita[] citas_Mascota;
	
	private String nombre;

	/**
	 * 
	 * @param id_Mascota
	 */
	public Mascota(){

		try {

			Conecta conexion=new Conecta();

			Connection nueva= conexion.getConexion();

			declaracion=nueva.createStatement();

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

	private void setNombre(String nom) {
		// TODO Auto-generated method stub
		
		this.nombre=nom;
		
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
	public int getSexo() {
		return sexo;
	}

	/**
	 * 
	 * @param i
	 */
	private void setSexo(int i) {
		this.sexo = i;
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

	public Mascota[] getMascotasUsuario(Usuario dueño) {
		// TODO Auto-generated method stub
		
		ArrayList<Mascota> mascotas=new ArrayList<>();
		
		try {
			datos=declaracion.executeQuery("select * from mascota where id_Dueño='"+dueño.getDni_usuario()+"'");
			
			while(datos.next()) {

				Mascota nueva=new Mascota();
				
				nueva.setDni_Mascota(datos.getString(1));
				nueva.setNombre(datos.getString(2));
				nueva.setEspecie(datos.getString(3));
				nueva.setRaza(datos.getString(4));
				nueva.setCapa(datos.getString(5));
				nueva.setFecha_Nacimiento(datos.getDate(6));
				nueva.setSexo(datos.getInt(7));
				
				mascotas.add(nueva);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mascotas.toArray(new Mascota[this.getNumMascotas(dueño.getDni_usuario())]);
	}
	
	/**
	 * 
	 * @param dni_usuario 
	 * @return
	 */
	public int getNumMascotas(String dni_usuario) {

		int num_Mascotas=0;

		try {
			datos=declaracion.executeQuery("select count(*) from mascota where id_Dueño='"+dni_usuario+"';");
			if(datos.next()) {
				num_Mascotas=datos.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return num_Mascotas;
	}

}
