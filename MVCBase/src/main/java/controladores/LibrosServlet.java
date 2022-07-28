package controladores;

import java.io.IOException;
import java.util.List;

import dao.LibroDao;
import dao.LibroDaoJDBC;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Libro;

public class LibrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LibrosServlet() {
     
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String opcion=request.getParameter("opcion");
		if(opcion==null||opcion.equals(opcion)){
			mostrarListado(request,response);
		}
	}
	
	private void mostrarListado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibroDao dao= new LibroDaoJDBC();
		List<Libro> lista=dao.getListaLibros();
		request.setAttribute("listaLibro", lista);
		request.getRequestDispatcher("/libros/listado.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
