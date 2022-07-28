package modelo;

import java.util.Objects;

public class Libro {
	private String isbn;
	private String titulo;
	private int codEditorial;
	private int año;
	private int num_pag;
	private float precio;
	private int cantidad;
	private float precioCD;
	
	
	public Libro(String isbn, String titulo, int codEditorial, int año, int num_pag, float precio, int cantidad,
			float precioCD) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.codEditorial = codEditorial;
		this.año = año;
		this.num_pag = num_pag;
		this.precio = precio;
		this.cantidad = cantidad;
		this.precioCD = precioCD;
	}


	public Libro() {
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public int getCodEditorial() {
		return codEditorial;
	}


	public void setCodEditorial(int codEditorial) {
		this.codEditorial = codEditorial;
	}


	public int getAño() {
		return año;
	}


	public void setAño(int año) {
		this.año = año;
	}


	public int getNum_pag() {
		return num_pag;
	}


	public void setNum_pag(int num_pag) {
		this.num_pag = num_pag;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public float getPrecioCD() {
		return precioCD;
	}


	public void setPrecioCD(float precioCD) {
		this.precioCD = precioCD;
	}


	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", codEditorial=" + codEditorial + ", año=" + año
				+ ", num_pag=" + num_pag + ", precio=" + precio + ", cantidad=" + cantidad + ", precioCD=" + precioCD
				+ "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn);
	}
	
}
