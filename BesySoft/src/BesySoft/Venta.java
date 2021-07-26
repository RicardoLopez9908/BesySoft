package BesySoft;

public class Venta {

	private Producto producto;
	private Vendedor vendedor;
	
	public Venta(Producto producto, Vendedor vendedor) {
		this.producto = producto;
		this.vendedor = vendedor;
	}
	
	public Producto getProducto() {
		return this.producto;
	}
	
	public Vendedor getVendedor() {
		return this.vendedor;
	}
	
	
}
