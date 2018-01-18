package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

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
	public ResultSet getUsuaioBD(String id_Usuario){


		try {
			
			datos=declaracion.executeQuery("SELECT * FROM usuario where id_Usuario='"+id_Usuario+"';");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datos;
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
	
	/**
	 * 
	 * @param id_Mascota 
	 * 
	 */
	public ResultSet getNumCitasBD(String id_Mascota) {
		// TODO Auto-generated method stub

		try {
			datos=declaracion.executeQuery("SELECT count(*) from cita where id_Mascota ='"+id_Mascota+"';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datos;
		
	}
	
	/**
	 * @param string 
	 * @return 
	 * 
	 */
	public ResultSet getCitasMascotaBD(String id_Mascota) {

			try {
	
				datos=declaracion.executeQuery("SELECT * FROM `cita` WHERE `id_Mascota` = '"+id_Mascota+"'");
								
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return datos;
	}
	
	/**
	 * 
	 * @param id_Usuario
	 * @return
	 */
	public ResultSet getMascotasUsuarioBD(String id_Usuario) {
		// TODO Auto-generated method stub
		
		
		try {
			datos=declaracion.executeQuery("select * from mascota where id_Duenio='"+id_Usuario+"'");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return datos;
	}
	
	/**
	 * 
	 * @param dni_usuario 
	 * @return
	 */
	public ResultSet getNumMascotasBD(String id_usuario) {

		try {
			datos=declaracion.executeQuery("select count(*) from mascota where id_Duenio='"+id_usuario+"';");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datos;
	}
	
	/**
	 * 
	 * 
	 */
	public void aniadirCitaBD(java.util.Date cita_Fecha, String id_Mascota) {
		// TODO Auto-generated method stub

		try {
			declaracion.executeUpdate("INSERT INTO `cita` (`id_Cita`, `fecha_cita`, `id_Mascota`) VALUES (NULL, '"+new java.sql.Date(cita_Fecha.getTime())+"', '"+id_Mascota+"');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}

	}

	/*
	 * 
	 * 
	 */
	public void eliminarCitaBD(long id_Cita) {
		// TODO Auto-generated method stub
		
		try {
			declaracion.execute("DELETE FROM `cita` WHERE`id_Cita` = '"+id_Cita+"';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * 
	 * @param nuevo_usuario
	 */
	public void aniadir_UsuarioBD(Usuario nuevo_usuario) {

		try {
			declaracion.execute("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * 
	 * @param id_Usuario
	 */
	public void eliminar_UsuarioBD(String id_Usuario) {

		try {
			declaracion.execute("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 
	 * @param new_Producto
	 */
	public void aniadir_ProductoBD(Producto new_Producto) {

		try {
			declaracion.execute("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * 
	 * @param id_Producto
	 */
	public void borrar_ProductoBD(String id_Producto) {

		try {
			declaracion.execute("DELETE FROM `productos` WHERE`id_Producto` = '"+id_Producto+"';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * 
	 * @param id_Usuario
	 * @param fecha
	 */
	public void aniadir_ReservaBD(String id_Usuario, Date fecha) {
		try {
			declaracion.execute("INSERT INTO `reserva` (`id_Reserva`, `id_Usuario`, `pedido_Recogido`, `fecha_Pedido`) VALUES (NULL, '"+id_Usuario+"', '0', '"+fecha+"');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 
	 * @param id_Usuarios
	 * @param fecha
	 * @return
	 */
	public int getId_ReservaBD(String id_Usuarios, Date fecha) {
		// TODO Auto-generated method stub
		
		int id=0;
		
		try {
			datos=declaracion.executeQuery("SELECT * FROM `reserva` WHERE `id_Usuario`='"+id_Usuarios+"' and `fecha_Pedido`='"+fecha+"';");
			
			if(datos.next()) {
				id=datos.getInt(1);
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(id);
		return id;
	}

	/**
	 * 
	 * @param id_Prod
	 * @param id_Reserva
	 */
	public void aniadirReservaProductoBD(String id_Prod, int id_Reserva) {
		// TODO Auto-generated method stub
		
		System.out.println(id_Prod+"+"+id_Reserva);
		
		try {
			declaracion.execute("INSERT INTO `productosreservados` (`cont_Reserva`, `id_Reserva`, `id_Producto`) VALUES (NULL, '"+id_Reserva+"', '"+id_Prod+"');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
