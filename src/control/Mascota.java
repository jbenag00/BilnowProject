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


	public ResultSet datos;

	private String dni_Mascota;
	
	private String nombre;

	private String especie;

	private String raza;

	private int sexo;

	private String capa;
	
	private String id_Duenio;

	private java.util.Date fecha_Nacimiento;
	
	private AccesoBD declaracion;

	/**
	 * 
	 * @param id_Mascota
	 */
	public Mascota(){

		declaracion=new AccesoBD();
		
	}
	
	public Mascota(String dni, String nom, String espec, String raz, String capa,
			java.util.Date date, int sexo, String id_duenio){

		this.setDni_Mascota(dni);
		this.setNombre(nom);
		this.setEspecie(espec);
		this.setRaza(raz);
		this.setCapa(capa);
		this.setFecha_Nacimiento(date);
		this.setSexo(sexo);
		this.setDniDuenio(id_duenio);
		
		
	}

	/**
	 * 
	 * @param id_duenio
	 */
	private void setDniDuenio(String id_duenio) {
		
		this.id_Duenio=id_duenio;
		
	}

	/**
	 * 
	 * @return
	 */
	public String getDniDuenio() {
		
		return this.id_Duenio;
		
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
	 * @param nom
	 */
	private void setNombre(String nom) {
		// TODO Auto-generated method stub
		
		this.nombre=nom;
		
	}
	
	public String getNombre() {
		return this.nombre;
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
	public java.util.Date getFecha_Nacimiento() {
		return fecha_Nacimiento;
	}

	/**
	 * 
	 * @param date
	 */
	private void setFecha_Nacimiento(java.util.Date date) {
		this.fecha_Nacimiento = date;
	}

	public Mascota[] getMascotasUsuario(Usuario duenio) {
		// TODO Auto-generated method stub
		
		ArrayList<Mascota> mascotas=new ArrayList<>();
		
		try {
			datos=declaracion.getMascotasUsuarioBD(duenio.getDni_usuario());
			
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
		
		return mascotas.toArray(new Mascota[this.getNumMascotas(duenio.getDni_usuario())]);
	}
	
	/**
	 * 
	 * @param dni_usuario 
	 * @return
	 */
	public int getNumMascotas(String dni_usuario) {

		int num_Mascotas=0;

		try {
			datos=declaracion.getNumMascotasBD(dni_usuario);
			if(datos.next()) {
				num_Mascotas=datos.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return num_Mascotas;
	}

	public void aniadir_Mascota(Mascota mascota) {
		
			declaracion.aniadir_MascotaBD(mascota);
		
	}

	public void eliminar_Mascota(String dni_Mascota2) {
		
		declaracion.eliminarCitaMascotaBD(dni_Mascota2);
		declaracion.eliminarMascotaBD(dni_Mascota2);
		
	}

}
