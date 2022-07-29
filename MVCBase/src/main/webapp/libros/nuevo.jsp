<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="../plantilla/cabecera.jsp"></jsp:include>
<%@page import="java.util.List"%>
<%@page import="modelo.Editorial"%>

<h2> Inserta nuevo libro.. </h2>

<% List <Editorial> listaeditoriales=(List<Editorial>) request.getAttribute("listaeditoriales"); %>

<form action="libros" method="post">

	
	<input type="hidden" name="opcion" value="insertar" />
	<div>
		 <label for="isbn">ISBN: </label>
         <input type="text" name="isbn" id="isbn">
	</div>
	<div>
	 	<label for="titulo">Titulo: </label>
        <input type="text" name="titulo" id="titulo">
	</div>
	<div>
		<label for="codEditorial">Editorial: </label>
		<select name="codEditorial" id="codEditorial"> 
		<% for(Editorial e:listaeditoriales) {%>
		<option value="<%=e.getCodEditorial() %>"><%=e.getNombre() %></option>
		<% }%>
		</select>
	</div>
	<div>
		 <label for="año">Año: </label>
         <input type="number" value="2020" min=1900 name="anio" id="año">
	</div>
	<div>
		 <label for="num_pag">Núm. Páginas: </label>
         <input type="text" name="num_pag" id="num_pag">
	</div>
	<div>
		 <label for="precio">Precio: </label>
         <input type="text" name="precio" id="precio">
	</div>
	<div>
		 <label for="cantidad">Cantidad: </label>
         <input type="number" value=1 min=1 name="cantidad" id="cantidad">
	</div>
	<div>
		 <label for="precioCD">PrecioCD: </label>
         <input type="text" name="precioCD" id="precioCD">
	</div>
	<div>
            <input type="submit" value="Insertar">
    </div>

</form>

<jsp:include page="../plantilla/pie.jsp"></jsp:include>