package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 
 * @author Javier
 *
 */

public class Usuario {

	public static java.sql.Statement declaracion;

	private ResultSet datos;

	private static String dni_usuario;

	private String nombre_usuario;

	private String tlf_Usuario;
	
	private String dir_usuario;

	private String email_usuario;

	
	//cambiar esto por un Arraylist<Mascota> hay que cambiar la forma de obtencion de los datos.
	private Mascota[] mascotas_Usuario;

	/**
	 * 
	 * @param usuario
	 * @param password
	 */
	public Usuario(String usuario, String password) {

		Conecta conexion=new Conecta();
		Connection nueva=conexion.getConexion();


		try {
			declaracion=nueva.createStatement();
			datos=declaracion.executeQuery("SELECT * FROM usuario where id_Usuario='"+usuario+"';");
			int i=0;
			if(datos.next()) {

				this.setDni_usuario(datos.getString(1));
				this.setNombre_usuario(datos.getString(2).concat(" "+datos.getString(3)));
				this.setDireccion_usuario(datos.getString(4));
				this.setEmail_usuario(datos.getString(8));

			}

			mascotas_Usuario=new Mascota[this.getNumMascotas()];

			datos=declaracion.executeQuery("SELECT * FROM mascota where id_Dueño='"+usuario+"';");

			if(datos.next()) {

				this.setMascotas_Usuario(new Mascota(datos.getString(1)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * @return
	 */
	public String getDni_usuario() {
		return dni_usuario;
	}


	/**
	 * 
	 * @param dni_usuario
	 */
	private void setDni_usuario(String dni_usuario) {
		this.dni_usuario = dni_usuario;
	}

	/**
	 * 
	 * @return
	 */
	public String getNombre_usuario() {
		return nombre_usuario;
	}

	/**
	 * 
	 * @param nombre_usuario
	 */
	private void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	/**
	 * 
	 * @return
	 */
	public String getDireccion_usuario() {
		return dir_usuario;
	}

	/**
	 * 
	 * @param direccion_usuario
	 */
	private void setDireccion_usuario(String direccion_usuario) {
		this.dir_usuario = direccion_usuario;
	}

	/**
	 * 
	 * @return
	 */
	public String getEmail_usuario() {
		return email_usuario;
	}

	/**
	 * 
	 * @param email_usuario
	 */
	private void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	/**
	 * 
	 * @param mascota_Usuario
	 */
	private void setMascotas_Usuario(Mascota mascota_Usuario) {

		for(int i=0;i<mascotas_Usuario.length;i++){
			if(mascotas_Usuario[i]==null) {
				mascotas_Usuario[i]=mascota_Usuario;
			}

		}

	}

	/**
	 * 
	 * @return
	 */
	public int getNumMascotas() {

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

	/**
	 * 
	 * @param j
	 * @return
	 */
	public Mascota getMascota(int pos_Mascota) {

		return mascotas_Usuario[pos_Mascota];

	}

}
