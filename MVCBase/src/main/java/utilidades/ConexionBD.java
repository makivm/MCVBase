package utilidades;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConexionBD {
	private static final String database="biblioteca";
	private static final String usuario="root";
	private static final String contraseña="123456";
	private static final String url="jdbc:mysql://localhost/"+database;
	
	private Connection conexion=null;
	
	public Connection getConexion() {
		if (conexion!=null)
				return conexion;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion=DriverManager.getConnection(url, usuario, contraseña);
			conexion.setCatalog(database);
			System.out.println("Conexion realizada correctamente");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion;
	}
	
	public void cerrarConexion() {
		if(conexion!=null) {
			try {
				conexion.close();
				System.out.println("Conexion cerrada");
				conexion=null;
			} catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}

		}
	}
}
