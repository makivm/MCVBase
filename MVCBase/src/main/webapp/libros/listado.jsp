<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="javax.swing.plaf.metal.MetalBorders.Flush3DBorder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.List"%>
<%@page import="modelo.Libro"%>

<a href="?opcion=nuevo" >Insetar libro</a>

<jsp:include page="../plantilla/cabecera.jsp"></jsp:include>

<h2>Listado de libros</h2>
<% List <Libro> lista=(List<Libro>) request.getAttribute("listaLibro");

if (lista== null || lista.size()==0) { %>
	<h3>No se han encontrado libros</h3>
<%} else{%>
		<table class="estilo-tabla">
			<tr>
				<th>ISBN</th>
				<th>Titulo</th>
				<th>Cod. editorial</th>
				<th>Año</th>
				<th>Núm. páginas</th>
				<th>Precio</th>
				<th>Cantidad</th>
				<th>PrecioCD</th>
				<th>Eliminar</th>
				<th>Editar</th>
			</tr>
		<% 
		for(Libro l:lista) {
		%>
			<tr>
				<td><%= l.getIsbn() %></td>
				<td><%= l.getTitulo() %></td>
				<td><%= l.getCodEditorial() %></td>
				<td><%= l.getAño() %></td>
				<td><%= l.getNum_pag() %></td>
				<td><%= l.getPrecio() %></td>
				<td><%= l.getCantidad() %></td>
				<td><%= l.getPrecioCD() %></td>
				<td><%= l.getPrecioCD() %></td>
				<td><a href="?opcion=eliminar&isbn=<%=l.getIsbn() %>" >X </a></td>
				<td><a href="?opcion=editar&isbn=<%=l.getIsbn() %>" >editar </a></td>

			</tr>	
		<%
		}
		%>
		</table>
<% } %>

<jsp:include page="../plantilla/pie.jsp"></jsp:include>