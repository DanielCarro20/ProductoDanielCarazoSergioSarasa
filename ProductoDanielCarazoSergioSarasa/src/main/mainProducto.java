package main;

import java.time.LocalDate;
import java.util.Scanner;

import Producto.Cliente;
import Producto.Empleado;
import Producto.Factura;
import Producto.LineaFactura;
import Producto.Persona;
import Producto.Producto;
import ProductoDAO.ClienteDAO;
import ProductoDAO.EmpleadoDAO;
import ProductoDAO.FacturaDAO;
import ProductoDAO.LineaFacturaDAO;
import ProductoDAO.ProductoDAO;

public class mainProducto {

	public static void main(String[] args) {
		FacturaDAO facturaDAO = new FacturaDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		LineaFacturaDAO lineafactDAO = new LineaFacturaDAO();
		ProductoDAO prodDAO = new ProductoDAO();
		EmpleadoDAO empDAO = new EmpleadoDAO();

		// 1. Muestra todos los clientes.
		System.out.println("todos los clientes");
		for (Cliente todosclientes : clienteDAO.obtenerTodos()) {
			System.out.println(todosclientes);
		}

		// selecciona uno escribiendo el id y muestra sus datos.
		Scanner sc = new Scanner(System.in);
		// System.out.println("dime id");
		// int miEntero = Integer.parseInt(sc.nextLine());

		// System.out.println(clienteDAO.obtenerPorId(miEntero));

		// muestra sus facturas.
		// System.out.println(facturaDAO.obtenerPorId(miEntero));

		// 2. Muestra todos los empleados
		System.out.println("empleados, todos:");
		for (Empleado empleados : empDAO.obtenerTodos()) {
			System.out.println(empleados);
		}
		// y seleccionando un id muestra las facturas que ha emitido.
		System.out.println("Facturas del id:");
		System.out.println(facturaDAO.obtenerPorIdEmpleado(5));

		// 3. Muestra una factura por id junto con todas sus líneas de factura.
		System.out.println("factura por id");
		System.out.println(facturaDAO.obtenerPorIdFactura(2));
		System.out.println("lineas por el id de factura:");
		for (LineaFactura lineafacturas : lineafactDAO.obtenerLineaPorIdFactura(2)) {
			System.out.println(lineafacturas);
		}

		// 4. Muestra todas las facturas de un mes, pide el número del mes y calcula el
		// total facturado ese mes.

		// System.out.println("dime mes");
		// int numeroMes = Integer.parseInt(sc.nextLine());

		double totalfacturado = 0;
		/*
		 * for (Factura factsmes : facturaDAO.obtenerPorMes(numeroMes)) {
		 * System.out.println(factsmes); totalfacturado=factsmes.getTotal() +
		 * totalfacturado; System.out.println("total facturado: " + totalfacturado) ;
		 * 
		 * 
		 * }
		 */

		// 5. Muestra todas las facturas de una fecha concreta, por ejemplo 05-05-2026
		LocalDate fecha = LocalDate.of(2026, 05, 05);
		for (Factura facturass : facturaDAO.obtenerPorFecha(fecha)) {
			System.out.println("facturas fecha: " + facturass);
		}

		// 6. Añade un cliente: 12345678Z, Pepe Carrera, Plaza Mozart 3
		System.out.println("cliente insertado");
		clienteDAO.insertar(new Cliente("12345678Z", "Pepe Carrera", "Plaza Mozart 3"));

		// 7. Añadir nuevo producto: pide los datos por teclado e inserta un producto
		// nuevo si no existe un
		// producto con ese nombre.

		boolean existe = false;

		/*
		 * System.out.println("dime un nombre"); String nombre = sc.nextLine();
		 * System.out.println("dime un precio"); double precio =
		 * Double.parseDouble(sc.nextLine()); System.out.println("dime el stock"); int
		 * stock = Integer.parseInt(sc.nextLine());
		 * 
		 * for (Producto productos : prodDAO.obtenerTodos()) { if
		 * (productos.getNombre().equalsIgnoreCase(nombre)) { existe = true; }
		 * 
		 * }
		 * 
		 * if (!existe) { prodDAO.insertar(new Producto(nombre, precio, stock));
		 * System.out.println("se ha añadido el producto, no existia ninguno asi"); }
		 */
		// 8.Actualizar producto: muestra los productos, selecciona uno por id y
		// actualiza su precio.
		System.out.println("Todos los productos");
		for (Producto productos : prodDAO.obtenerTodos()) {
			System.out.println(productos);
		}

		Producto p = prodDAO.obtenerPorId(4);
		p.setPrecio(10);
		prodDAO.actualizar(p);

		/*
		 * 9. Crear factura: muestra todos los clientes, selecciona uno. Muestra todos
		 * los empleados, selecciona uno. Muestra los productos disponibles y ves
		 * añadiendo productos seleccionando su id hasta introducir 0. Crea una factura
		 * y ves creando líneas de factura con los productos seleccionados. Al final
		 * muestra la factura con todos sus datos y todas sus líneas.
		 */
		System.out.println("clientes");
		for (Cliente cc : clienteDAO.obtenerTodos()) {
			System.out.println(cc);
		}

		System.out.println("empleados");
		for (Empleado empleados : empDAO.obtenerTodos()) {
			System.out.println(empleados);
		}

		// 10. Muestra todos los productos y selecciona uno. Muestras las facturas en
		// las que aparece.
		System.out.println("Todos los productos");
		for (Producto productos : prodDAO.obtenerTodos()) {
			System.out.println(productos);
		}

		System.out.println("facturas producto 4");
		for (Factura facturillas : facturaDAO.verfacturasprod(4)) {
			System.out.println(facturillas);
		}

		// 11.
		System.out.println("Elimina producto por id");
		
		// 12.
		

	}

}
