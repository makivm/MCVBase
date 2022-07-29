<%@page import="modelo.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="../plantilla/cabecera.jsp"></jsp:include>
<%@page import="java.util.List"%>
<%@page import="modelo.Editorial"%>

<h2>Editar libro..</h2>

<% List <Editorial> listaeditoriales=(List<Editorial>) request.getAttribute("listaeditoriales"); 
	Libro l=(Libro) request.getAttribute("libro");
%>

<form action="libros" method="post">


	<input type="hidden" name="opcion" value="editar" />
	<div>
		<label for="isbn">ISBN: </label> <input type="text" name="isbn"
			id="isbn" value="<%=l.getIsbn() %>"readonly />
	</div>
	<div>
		<label for="titulo">Titulo: </label> <input type="text" name="titulo"
			id="titulo" value="<%=l.getTitulo() %>" />
	</div>
	<div>
		<label for="codEditorial">Editorial: </label> <select
			name="codEditorial" id="codEditorial">
			<% for(Editorial e:listaeditoriales) {%>
			<option value="<%=e.getCodEditorial() %>"
			<% if(e.getCodEditorial()==l.getCodEditorial()){
				out.println(" selected ");
			}%>
			><%= e.getNombre() %></option>
			<% }%>
			
		</select>
	</div>
	<div>
		<label for="año">Año: </label> <input type="number" min=1900 name="anio" id="año" value="<%=l.getAño() %>">
	</div>
	<div>
		<label for="num_pag">Núm. Páginas: </label> <input type="text"
			name="num_pag" id="num_pag" value="<%=l.getNum_pag()%>">
	</div>
	<div>
		<label for="precio">Precio: </label> <input type="text" name="precio" id="precio" value="<%=l.getPrecio() %>">
	</div>
	<div>
		<label for="cantidad">Cantidad: </label> <input type="number" min=1 name="cantidad" id="cantidad" value="<%=l.getCantidad() %>">
	</div>
	<div>
		<label for="precioCD">PrecioCD: </label> 
		<input type="text" name="precioCD" id="precioCD" value="<%=l.getPrecioCD()%>">
	</div>
	<div>
		<input type="submit" value="Editar">
	</div>

</form>

<jsp:include page="../plantilla/pie.jsp"></jsp:include>