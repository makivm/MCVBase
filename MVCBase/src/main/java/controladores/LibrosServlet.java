package controladores;

import java.io.IOException;

import java.util.List;

import dao.EditorialDao;
import dao.EditorialJDBC;
import dao.LibroDao;
import dao.LibroDaoJDBC;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Editorial;
import modelo.Libro;


public class LibrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LibrosServlet() {
     
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String opcion=request.getParameter("opcion");
		if(opcion==null||opcion.equals("listado")){
			mostrarListado(request,response);
		}
		else if(opcion.equals("nuevo")){
			mostrarFormulario(request,response);
		}
		else if(opcion.equals("eliminar")){
			eliminar(request,response);
		}
		else if(opcion.equals("editar")){
			editar(request,response);
		}
			
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn=request.getParameter("isbn");
		LibroDao dao= new LibroDaoJDBC();
		Libro l=dao.getLibro(isbn);
		request.setAttribute("libro", l);
		EditorialDao daoED= new EditorialJDBC();
		List<Editorial> lista=daoED.getListaEditoriales();
		request.setAttribute("listaeditoriales", lista);
		request.getRequestDispatcher("/libros/editar.jsp").forward(request, response);
		mostrarListado(request,response);
	}
		

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn=request.getParameter("isbn");
		LibroDao dao= new LibroDaoJDBC();
		dao.borrarLibro(isbn);
		mostrarListado(request,response);
	}

	private void mostrarFormulario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EditorialDao dao= new EditorialJDBC();
		List<Editorial> lista=dao.getListaEditoriales();
		request.setAttribute("listaeditoriales", lista);
		request.getRequestDispatcher("/libros/nuevo.jsp").forward(request, response);
	}

	private void mostrarListado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibroDao dao= new LibroDaoJDBC();
		List<Libro> lista=dao.getListaLibros();
		request.setAttribute("listaLibro", lista);
		request.getRequestDispatcher("/libros/listado.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion=request.getParameter("opcion");
		if((opcion!=null)&&(opcion.equals("insertar"))){
			insertarLibro(request,response);
		}else if((opcion!=null)&&opcion.equals("editar")){
			actualizar(request,response);
		}
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn=request.getParameter("isbn");
		String titulo=request.getParameter("titulo");
		int codEditorial=Integer.parseInt(request.getParameter("codEditorial"));
		int año=Integer.parseInt(request.getParameter("anio"));
		int num_pag=Integer.parseInt(request.getParameter("num_pag"));
		float precio=Float.parseFloat(request.getParameter("precio"));
		int cantidad=Integer.parseInt(request.getParameter("cantidad"));
		float precioCD=Float.parseFloat(request.getParameter("precioCD"));
		Libro l= new Libro(isbn,titulo,codEditorial,año,num_pag,precio,cantidad,precioCD);
		LibroDao dao=new LibroDaoJDBC();
		dao.editarLibro(l);	
		mostrarListado(request,response);
		
	}

	private void insertarLibro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn=request.getParameter("isbn");
		String titulo=request.getParameter("titulo");
		int codEditorial=Integer.parseInt(request.getParameter("codEditorial"));
		int año=Integer.parseInt(request.getParameter("anio"));
		int num_pag=Integer.parseInt(request.getParameter("num_pag"));
		float precio=Float.parseFloat(request.getParameter("precio"));
		int cantidad=Integer.parseInt(request.getParameter("cantidad"));
		float precioCD=Float.parseFloat(request.getParameter("precioCD"));
		Libro l= new Libro(isbn,titulo,codEditorial,año,num_pag,precio,cantidad,precioCD);
		LibroDao dao=new LibroDaoJDBC();
		dao.insertarLibro(l);
		mostrarListado(request,response);
	}

}
