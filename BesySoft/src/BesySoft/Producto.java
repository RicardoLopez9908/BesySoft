package BesySoft;

public class Producto {

	private String nombre;
	private String categoria;
	private int precio;
	private long codigo;
	
	public Producto(String nombre, String categoria, int precio, long codigo) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.codigo = codigo;
	}


	public int getPrecio() {
		return this.precio;
	}
	
	public long getCodigo() {
		return this.codigo;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getCategoria() {
		return this.categoria;
	}
	
}
