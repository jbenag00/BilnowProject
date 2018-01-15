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
	
	private int rol_usuario;
		
	//cambiar esto por un Arraylist<Mascota> hay que cambiar la forma de obtencion de los datos.
	private Mascota[] mascotas_Usuario;
	
	private Mascota mascota_Control;

	/**
	 * 
	 * @param usuario
	 * @param password
	 */
	public Usuario(String usuario, String password) {

		Conecta conexion=new Conecta();
		Connection nueva=conexion.getConexion();
		mascota_Control=new Mascota();

		try {
			declaracion=nueva.createStatement();
			datos=declaracion.executeQuery("SELECT * FROM usuario where id_Usuario='"+usuario+"';");
			int i=0;
			if(datos.next()) {

				this.setDni_usuario(datos.getString(1));
				this.setNombre_usuario(datos.getString(2).concat(" "+datos.getString(3)));
				this.settlf_Usuario(datos.getString(4));
				this.setDireccion_usuario(datos.getString(5));
				this.setRol(datos.getInt(6));
				this.setEmail_usuario(datos.getString(8));

			}

			mascotas_Usuario=new Mascota[mascota_Control.getNumMascotas(this.getDni_usuario())];
			mascotas_Usuario=mascota_Control.getMascotasUsuario(this);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void setRol(int rol) {
		// TODO Auto-generated method stub
	
		this.rol_usuario=rol;
		
	}

	private void settlf_Usuario(String tlf) {
		// TODO Auto-generated method stub
		
		this.tlf_Usuario=tlf;
		
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
	 * @param j
	 * @return
	 */
	public Mascota getMascota(int pos_Mascota) {

		return mascotas_Usuario[pos_Mascota];

	}

}
