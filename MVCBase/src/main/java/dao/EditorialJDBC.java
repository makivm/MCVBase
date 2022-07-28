package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Editorial;
import utilidades.ConexionBD;

public class EditorialJDBC implements EditorialDao {
	private ConexionBD conexion;
	
	public EditorialJDBC() {
		conexion=new ConexionBD();
	}

	@Override
	public List<Editorial> getListaEditoriales() {
		List<Editorial> lista=new ArrayList<>();
		Connection con= conexion.getConexion();
		Statement consulta=null;
		ResultSet rs=null;
		
		try {
			consulta=con.createStatement();
			rs=consulta.executeQuery("select *from editoriales");
			while(rs.next()) {
				int codEditorial= rs.getInt("codEditorial");
				String nombre= rs.getString("nombre");
				int año= rs.getInt("anio");
				
				Editorial editorial=new Editorial(codEditorial, nombre,año);			
				lista.add(editorial);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				consulta.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}return lista;
	}

	@Override
	public Editorial getEditorial(int codEditorial) {
		Connection con= conexion.getConexion();
		PreparedStatement consulta=null;
		ResultSet rs=null;
		Editorial editorial=null;
	
		try {
			consulta=con.prepareStatement("select * from editoriales where codEditorial= ?");
			consulta.setInt(1,codEditorial);
			rs=consulta.executeQuery();
			if(rs.next()) {
				String nombre=rs.getString("nombre");
				int año= rs.getInt("anio");
				
				
				editorial=new Editorial(codEditorial, nombre, año);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				consulta.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return editorial;
	}

	@Override
	public int insertarEditorial(Editorial editorial) {
		Connection con= conexion.getConexion();
		PreparedStatement consulta=null;
		int num=0;
	
		try {
			consulta=con.prepareStatement("insert into editoriales (nombre,anio) values(?,?");
			consulta.setString(1,editorial.getNombre());
			consulta.setInt(2,editorial.getAño());
			
			num=consulta.executeUpdate();
			System.out.println("Editorial insertada correctamente");
		
		} catch (SQLException e) {
			System.out.println("Error insertando editorial");
			e.printStackTrace();
		} finally {
			try {
				consulta.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return num;
	}

	@Override
	public int editarEditorial(Editorial editorial) {
		Connection con= conexion.getConexion();
		PreparedStatement consulta=null;
		int num=0;
	
		try {
			consulta=con.prepareStatement("UPDATE editoriales\r\n"
					+ "SET\r\n"
					+ "nombre =?,\r\n"
					+ "anio = ?\r\n"
					+ "WHERE codEditorial = ?;\r\n"
					+ "");
			
			
			consulta.setString(1,editorial.getNombre());
			consulta.setInt(2,editorial.getAño());
			consulta.setInt(3,editorial.getCodEditorial());
			
			num=consulta.executeUpdate();
			System.out.println("Editorial editada correctamente");
		
		} catch (SQLException e) {
			System.out.println("Error editando editorial");
			e.printStackTrace();
		} finally {
			try {
				consulta.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return num;
	}

	@Override
	public int borrarEditorial(int codEditorial) {
		Connection con= conexion.getConexion();
		PreparedStatement consulta=null;
		int num=0;
	
		try {
			consulta=con.prepareStatement("delete from libros where codEditorial=?");
			consulta.setInt(1,codEditorial);
			
			num=consulta.executeUpdate();
			System.out.println("Editorial eliminada correctamente");
		
		} catch (SQLException e) {
			System.out.println("Error eliminando editorial");
			e.printStackTrace();
		} finally {
			try {
				consulta.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return num;
	}

}
