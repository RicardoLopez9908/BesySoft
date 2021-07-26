package BesySoft;
import java.util.ArrayList;

public class Aplicacion {

	//EJEMPLO DE PATRÓN SINGLENTON
	
	private static Aplicacion aplicacion = new Aplicacion();
	
	private ArrayList<Venta> ventas = new ArrayList<>();
	
	private ArrayList<Producto> productos = new ArrayList<>();
	
	
	
	private Aplicacion(){}
	
	public static Aplicacion getAplicacion() {
		return aplicacion;
	}
	
	public void setVenta(Venta venta) {
		ventas.add(venta);
	}
	
	public void setProducto(Producto productoNuevo) throws ExcepcionProductoRepetido {
		for(Producto productoLista : productos) {
			if((productoLista.getCodigo() == productoNuevo.getCodigo()) || (productoLista.getNombre().equals(productoNuevo.getNombre()) )) {
				throw new ExcepcionProductoRepetido("El producto "+ productoNuevo.getNombre() + " ya se encuentra en el inventario.");
			}
		}
		productos.add(productoNuevo);
	}
	
	
	
	public double calcularComision(Vendedor vendedor) {
		int contadorDeVentas = 0;
		int totalVendido = 0;
		for(Venta venta : ventas) {
			if(vendedor.getCodigo() == venta.getVendedor().getCodigo()) {
				contadorDeVentas = contadorDeVentas + 1;
				totalVendido = totalVendido + venta.getProducto().getPrecio();
			}
		}
		if(contadorDeVentas > 2) {
			return totalVendido * 0.10 ;
		}else {
			return totalVendido * 0.05 ;
		}
		
	}
	
	//---------BUSCADORES DE PRODUCTO-------------------
	
	public ArrayList<Producto> buscarProductos(String categoria) {
		ArrayList<Producto> productosEncontrados = new ArrayList<>();
		for(Producto producto: productos) {
			if(producto.getCategoria().toLowerCase().equals(categoria.toLowerCase())){
				productosEncontrados.add(producto);
			}
		}
		return productosEncontrados;
	}
    
	public ArrayList<Producto> buscarProductos(int precio ) {
		ArrayList<Producto> productosEncontrados = new ArrayList<>();
		for(Producto producto: productos) {
			if(producto.getPrecio() == precio){
				productosEncontrados.add(producto);
			}
		}
		return productosEncontrados;	
	}
	
	public Producto buscarProducto(long codigo) {
		for(Producto producto: productos) {
			if(producto.getCodigo() == codigo){
				return producto;
			}
		}
		return null;
	}
	
	public Producto buscarProducto(String nombre) {
		for(Producto producto: productos) {
			if(producto.getNombre().toLowerCase().equals(nombre.toLowerCase())){
				return producto;
			}
		}
		return null;
		
	}
	
}
