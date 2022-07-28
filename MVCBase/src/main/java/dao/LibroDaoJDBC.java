package dao;

import java.util.ArrayList;
import java.util.List;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Libro;
import utilidades.ConexionBD;

public class LibroDaoJDBC implements LibroDao {
	private ConexionBD conexion;
	
	public LibroDaoJDBC() {
	conexion=new ConexionBD();
	}

	public List<Libro> getListaLibros(){
		List<Libro> lista=new ArrayList<>();
		Connection con= conexion.getConexion();
		Statement consulta=null;
		ResultSet rs=null;
		
		try {
			consulta=con.createStatement();
			rs=consulta.executeQuery("select *from libros");
			while(rs.next()) {
				String isbn= rs.getString("isbn");
				String titulo= rs.getString("titulo");
				int codEditorial= rs.getInt("codEditorial");
				int año= rs.getInt("anio");
				int num_pag= rs.getInt("num_pags");
				float precio= rs.getFloat("precio");
				int cantidad= rs.getInt("cantidad");
				float precioCD= rs.getFloat("precioCD");
				
				Libro libro=new Libro(isbn, titulo, codEditorial, año, num_pag, precio, cantidad, precioCD);			
				lista.add(libro);
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
	
	public Libro getLibro(String isbn) {
		Connection con= conexion.getConexion();
		PreparedStatement consulta=null;
		ResultSet rs=null;
		Libro libro=null;
		
		try {
			consulta=con.prepareStatement("select * from libros where isbn= ?");
			consulta.setString(1, isbn);
			rs=consulta.executeQuery();
			if(rs.next()) {
				String titulo= rs.getString("titulo");
				int codEditorial= rs.getInt("codEditorial");
				int año= rs.getInt("anio");
				int num_pag= rs.getInt("num_pags");
				float precio= rs.getFloat("precio");
				int cantidad= rs.getInt("cantidad");
				float precioCD= rs.getFloat("precioCD");
				
				libro=new Libro(isbn, titulo, codEditorial, año, num_pag, precio, cantidad, precioCD);			
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
		return libro;
	}
	
	public int insertarLibro(Libro l) {
		Connection con= conexion.getConexion();
		PreparedStatement consulta=null;
		int num=0;
		
		try {
			consulta=con.prepareStatement("insert into libros values(?,?,?,?,?,?,?,?");
			
			consulta.setString(1, l.getIsbn());
			consulta.setString(2, l.getTitulo());
			consulta.setInt(3, l.getCodEditorial());
			consulta.setInt(4, l.getAño());
			consulta.setInt(5, l.getNum_pag());
			consulta.setFloat(6, l.getPrecio());
			consulta.setInt(7, l.getCantidad());
			consulta.setFloat(8, l.getPrecioCD());
			
			num=consulta.executeUpdate();
			System.out.println("Libro insertado correctamente");
			
		} catch (SQLException e) {
			System.out.println("Error insertando libro");
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
	
	public int editarLibro(Libro l) {
		Connection con= conexion.getConexion();
		PreparedStatement consulta=null;
		int num=0;
		
		try {
			consulta=con.prepareStatement(	"UPDATE libros\r\n"
					+ "SET\r\n"
					+ "titulo = ?,\r\n"
					+ "codEditorial = ?,\r\n"
					+ "anio = ?,\r\n"
					+ "num_pags = ?,\r\n"
					+ "precio = ?,\r\n"
					+ "cantidad = ?,\r\n"
					+ "precioCD = ?\r\n"
					+ "WHERE isbn = ?;");
			
			
			consulta.setString(1, l.getTitulo());
			consulta.setInt(2, l.getCodEditorial());
			consulta.setInt(3, l.getAño());
			consulta.setInt(4, l.getNum_pag());
			consulta.setFloat(5, l.getPrecio());
			consulta.setInt(6, l.getCantidad());
			consulta.setFloat(7, l.getPrecioCD());
			
			num=consulta.executeUpdate();
			System.out.println("Libro actualizado correctamente");
			
		} catch (SQLException e) {
			System.out.println("Error actualizando libro");
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
	
	public int borrarLibro(String isbn) {
		Connection con= conexion.getConexion();
		PreparedStatement consulta=null;
		int num=0;
		
		try {
			consulta=con.prepareStatement(	"delete from libros where isbn=?"); 
			
			consulta.setString(1, isbn);
			
			num=consulta.executeUpdate();
			System.out.println("Libro borrado correctamente");
			
		} catch (SQLException e) {
			System.out.println("Error borrando libro");
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
