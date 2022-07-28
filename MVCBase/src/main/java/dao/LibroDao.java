package dao;

import java.util.List;
import modelo.Libro;

public interface LibroDao {
	
	public List<Libro> getListaLibros();
	public Libro getLibro(String isbn);
	public int insertarLibro(Libro l);
	public int editarLibro(Libro l);
	public int borrarLibro(String isbn);
}
