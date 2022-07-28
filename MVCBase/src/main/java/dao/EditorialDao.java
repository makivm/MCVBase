package dao;

import java.util.List;

import modelo.Editorial;


public interface EditorialDao {
	public List<Editorial> getListaEditoriales();
	public Editorial getEditorial(int codEditorial);
	public int insertarEditorial(Editorial editorial);
	public int editarEditorial(Editorial editorial);
	public int borrarEditorial(int codEditorial);
}
