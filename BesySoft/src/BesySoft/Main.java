package BesySoft;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Aplicacion app = Aplicacion.getAplicacion();

		ingresarDatosEjemplo(app);
		
		buscarProductos(app);
	}

	private static void ingresarDatosEjemplo(Aplicacion app) {
		System.out.println("INGRESANDO PRODUCTOS DE EJEMPLO...");

		Producto p1 = new Producto("Shampoo", "Belleza", 120, 568645465);
		Producto p2 = new Producto("Acondicionador", "Belleza", 170, 568645467);
		Producto p3 = new Producto("Lata de tomates", "Comida", 65, 465656548);
		Producto p4 = new Producto("Paquete de fideos", "Comida", 61, 686516464);
		Producto p5 = new Producto("Muñeco de Batman", "Juguetes", 950, 568645445);
		Producto p6 = new Producto("Pelota de basquet", "Juguetes", 1890, 465466528);
		Producto p7 = new Producto("Resma de hojas A4", "Oficina", 570, 646836464);
		Producto p8 = new Producto("Mouse inalambrico", "Computación", 4157, 789563343);

		try {
			app.setProducto(p1);
			app.setProducto(p2);
			app.setProducto(p3);
			app.setProducto(p4);
			app.setProducto(p5);
			app.setProducto(p6);
			app.setProducto(p7);
			app.setProducto(p8);
		} catch (ExcepcionProductoRepetido e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		System.out.println("INGRESANDO VENDEDORES DE EJEMPLO...");

		Vendedor v1 = new Vendedor("Pedro", 168331, 65000);
		Vendedor v2 = new Vendedor("José", 168332, 65000);
		Vendedor v3 = new Vendedor("Esteban", 168333, 70000);
		Vendedor v4 = new Vendedor("Miguel", 168334, 85000);
		Vendedor v5 = new Vendedor("Sebastian", 168335, 90000);

		System.out.println("INGRESANDO VENTAS DE EJEMPLO...\n");

		app.setVenta(new Venta(p1, v1));
		app.setVenta(new Venta(p4, v2));
		app.setVenta(new Venta(p3, v3));
		app.setVenta(new Venta(p2, v4));
		app.setVenta(new Venta(p5, v5));
		app.setVenta(new Venta(p1, v1));
		app.setVenta(new Venta(p2, v2));
		app.setVenta(new Venta(p8, v3));
		app.setVenta(new Venta(p6, v5));
		app.setVenta(new Venta(p3, v1));
		app.setVenta(new Venta(p2, v3));
		app.setVenta(new Venta(p6, v3));
		app.setVenta(new Venta(p3, v3));
		app.setVenta(new Venta(p4, v2));
		app.setVenta(new Venta(p7, v4));
		app.setVenta(new Venta(p1, v3));
		app.setVenta(new Venta(p8, v4));
		app.setVenta(new Venta(p2, v5));
		app.setVenta(new Venta(p5, v5));
		app.setVenta(new Venta(p6, v5));
		app.setVenta(new Venta(p3, v5));

		System.out.println("--------------CALCULO DE COMISIONES--------------");
		System.out.println(
				"La comisión de " + v1.getNombre() + " es de $" + String.format("%.2f", app.calcularComision(v1)));
		System.out.println(
				"La comisión de " + v2.getNombre() + " es de $" + String.format("%.2f", app.calcularComision(v2)));
		System.out.println(
				"La comisión de " + v3.getNombre() + " es de $" + String.format("%.2f", app.calcularComision(v3)));
		System.out.println(
				"La comisión de " + v4.getNombre() + " es de $" + String.format("%.2f", app.calcularComision(v4)));
		System.out.println(
				"La comisión de " + v5.getNombre() + " es de $" + String.format("%.2f", app.calcularComision(v5)));

	}
	
	private static void buscarProductos(Aplicacion app){
		System.out.println("\n--------------BUSQUEDA DE PRODUCTOS--------------\n");

		System.out.println("Por favor, ingrese un numero:\n" + "1 ---> busqueda por nombre\n"
				+ "2 ---> busqueda por categoria\n" + "3 ---> busqueda por precio\n" + "4 ---> busqueda por codigo\n");

		int eleccion = ingresarNumero();
		Scanner sc = new Scanner(System.in);
		switch (eleccion) {
		case 1:
			System.out.println("Ingrese el nombre del producto");
			Producto resultadoNombre = app.buscarProducto(sc.nextLine());

			if (resultadoNombre != null) {
				System.out.println("La información del producto es:\n" + "\n" + "Nombre: " + resultadoNombre.getNombre()
						+ "\n" + "Categoria: " + resultadoNombre.getCategoria() + "\n" + "Precio: $"
						+ resultadoNombre.getPrecio() + "\n" + "Codigo: " + resultadoNombre.getCodigo() + "\n");
			} else
				System.out.println("Articulo no encontrado");
			break;
		case 2:
			System.out.println("Ingrese la categoria del producto");
			ArrayList<Producto> resultadoCategoria = app.buscarProductos(sc.nextLine());
			if (resultadoCategoria.size() != 0) {
				System.out.println("Productos encontrados: \n");
				for (Producto productoCategoria : resultadoCategoria) {
					System.out.println("Nombre: " + productoCategoria.getNombre() + "\n" + "Categoria: "
							+ productoCategoria.getCategoria() + "\n" + "Precio: $" + productoCategoria.getPrecio()
							+ "\n" + "Codigo: " + productoCategoria.getCodigo() + "\n" + "\n");
				}
			} else {
				System.out.println("No se encontraron articulos de esa categoria");
			}
			break;
		case 3:
			System.out.println("Ingrese el precio del producto");
			ArrayList<Producto> resultadoPrecio = null;
			try {
				resultadoPrecio = app.buscarProductos(Integer.parseInt((sc.nextLine())));
			} catch (Exception e) {
				resultadoPrecio = new ArrayList<Producto>();
			}
			if (resultadoPrecio.size() != 0) {
				System.out.println("Productos encontrados: \n");
				for (Producto productoPrecio : resultadoPrecio) {
					System.out.println("Nombre: " + productoPrecio.getNombre() + "\n" + "Categoria: "
							+ productoPrecio.getCategoria() + "\n" + "Precio: $" + productoPrecio.getPrecio() + "\n"
							+ "Codigo: " + productoPrecio.getCodigo() + "\n" + "\n");
				}
			} else {
				System.out.println("No se encontraron articulos con ese precio");
			}
			break;
		case 4:
			System.out.println("Ingrese el codigo del producto");
			Producto resultadoCodigo = null;
			try {
				resultadoCodigo = app.buscarProducto(Long.parseLong((sc.nextLine())));
			} catch (Exception e) {
				System.out.println("Articulo no encontrado");
			}
			if (resultadoCodigo != null) {
				System.out.println("La información del producto es:\n" + "\n" + "Nombre: " + resultadoCodigo.getNombre()
						+ "\n" + "Categoria: " + resultadoCodigo.getCategoria() + "\n" + "Precio: $"
						+ resultadoCodigo.getPrecio() + "\n" + "Codigo: " + resultadoCodigo.getCodigo() + "\n");
			} else
				System.out.println("Articulo no encontrado");
			break;
		default:
			break;
		}

	}
	
	
	private static int ingresarNumero() {
		int entrada = 0;
		try {
			Scanner sc = new Scanner(System.in);
			entrada = Integer.parseInt(sc.nextLine());
			while ((entrada != 1) && (entrada != 2) && (entrada != 3) && (entrada != 4)) {
				entrada = Integer.parseInt(sc.nextLine());
			}
		} catch (NumberFormatException e) {
			System.out.println("Por favor, ingrese un numero valido");
			ingresarNumero();
		}
		return entrada;
	}

}
