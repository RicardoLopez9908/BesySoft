package BesySoft;

public class Vendedor {
	
	private String nombre;
	private int codigo;
	private int sueldo;
	
	
	public Vendedor(String nombre, int codigo, int sueldo) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.sueldo = sueldo;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	
	public String getNombre() {
		return this.nombre;
	}
	
	
	
}
