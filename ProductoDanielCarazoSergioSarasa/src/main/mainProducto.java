package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Producto.Cliente;
import Producto.Empleado;
import Producto.Factura;
import Producto.LineaFactura;
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

		Scanner sc = new Scanner(System.in);
		int opcion = -1;

		while (opcion != 0) {
			System.out.println("\n===== MENÚ PRINCIPAL =====");
			System.out.println("1.  Ver todos los clientes y consultar por ID");
			System.out.println("2.  Ver empleados y sus facturas por ID");
			System.out.println("3.  Ver factura por ID con sus líneas");
			System.out.println("4.  Ver facturas de un mes y total facturado");
			System.out.println("5.  Ver facturas de una fecha concreta");
			System.out.println("6.  Añadir cliente");
			System.out.println("7.  Añadir nuevo producto");
			System.out.println("8.  Actualizar precio de producto");
			System.out.println("9.  Crear factura");
			System.out.println("10. Ver facturas de un producto");
			System.out.println("11. Eliminar producto");
			System.out.println("12. Guardar y leer clientes en fichero");
			System.out.println("13. Duplicar factura");
			System.out.println("14. Eliminar línea de factura y recalcular");
			System.out.println("15. Resumen mensual por empleado");
			System.out.println("0.  Salir");
			System.out.print("Elige una opción: ");

			opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {

			case 1:
				// Muestra todos los clientes, selecciona uno por ID y muestra sus facturas
				System.out.println("Todos los clientes:");
				for (Cliente c : clienteDAO.obtenerTodos()) {
					System.out.println(c);
				}
				System.out.print("Dime el id del cliente: ");
				int idCliente = Integer.parseInt(sc.nextLine());
				System.out.println(clienteDAO.obtenerPorId(idCliente));
				System.out.println("Facturas del cliente:");
				System.out.println(facturaDAO.obtenerPorId(idCliente));
				break;

			case 2:
				// Muestra todos los empleados y por ID muestra sus facturas
				System.out.println("Todos los empleados:");
				for (Empleado empleado : empDAO.obtenerTodos()) {
					System.out.println(empleado);
				}
				System.out.print("Dime el id del empleado: ");
				int idEmpleado = Integer.parseInt(sc.nextLine());
				System.out.println("Facturas del empleado:");
				System.out.println(facturaDAO.obtenerPorIdEmpleado(idEmpleado));
				break;

			case 3:
				// Muestra una factura por ID con todas sus líneas
				System.out.print("Dime el id de la factura: ");
				int idFactura = Integer.parseInt(sc.nextLine());
				System.out.println(facturaDAO.obtenerPorIdFactura(idFactura));
				System.out.println("Líneas de la factura:");
				for (LineaFactura lf : lineafactDAO.obtenerLineaPorIdFactura(idFactura)) {
					System.out.println(lf);
				}
				break;

			case 4:
				// Muestra facturas de un mes y calcula el total facturado
				System.out.print("Dime el número de mes: ");
				int numeroMes = Integer.parseInt(sc.nextLine());
				double totalfacturado = 0;
				for (Factura factsmes : facturaDAO.obtenerPorMes(numeroMes)) {
					System.out.println(factsmes);
					totalfacturado += factsmes.getTotal();
				}
				System.out.println("Total facturado en el mes: " + totalfacturado);
				break;

			case 5:
				// Muestra facturas de la fecha 05-05-2026
				LocalDate fecha = LocalDate.of(2026, 5, 5);
				System.out.println("Facturas del " + fecha + ":");
				for (Factura f : facturaDAO.obtenerPorFecha(fecha)) {
					System.out.println(f);
				}
				break;

			case 6:
				// Añade un cliente predefinido
				clienteDAO.insertar(new Cliente("12345678Z", "Pepe Carrera", "Plaza Mozart 3"));
				System.out.println("Cliente insertado correctamente.");
				break;

			case 7:
				// Añadir nuevo producto si no existe uno con el mismo nombre
				System.out.print("Dime el nombre del producto: ");
				String nombre = sc.nextLine();
				System.out.print("Dime el precio: ");
				double precio = Double.parseDouble(sc.nextLine());
				System.out.print("Dime el stock: ");
				int stock = Integer.parseInt(sc.nextLine());

				boolean existe = false;
				for (Producto p : prodDAO.obtenerTodos()) {
					if (p.getNombre().equalsIgnoreCase(nombre)) {
						existe = true;
						break;
					}
				}

				if (!existe) {
					prodDAO.insertar(new Producto(nombre, precio, stock));
					System.out.println("Producto añadido correctamente.");
				} else {
					System.out.println("Ya existe un producto con ese nombre.");
				}
				break;

			case 8:
				// Muestra productos y actualiza el precio de uno por ID
				System.out.println("Todos los productos:");
				for (Producto p : prodDAO.obtenerTodos()) {
					System.out.println(p);
				}
				System.out.print("Dime el id del producto a actualizar: ");
				int idProdActualizar = Integer.parseInt(sc.nextLine());
				System.out.print("Dime el nuevo precio: ");
				double nuevoPrecio = Double.parseDouble(sc.nextLine());
				Producto prodActualizar = prodDAO.obtenerPorId(idProdActualizar);
				prodActualizar.setPrecio(nuevoPrecio);
				prodDAO.actualizar(prodActualizar);
				System.out.println("Precio actualizado correctamente.");
				break;

			case 9:
				// Crear una factura seleccionando cliente, empleado y productos
				System.out.println("Clientes:");
				for (Cliente cc : clienteDAO.obtenerTodos()) {
					System.out.println(cc);
				}
				System.out.print("Selecciona id de cliente: ");
				int idClienteFactura = Integer.parseInt(sc.nextLine());

				System.out.println("Empleados:");
				for (Empleado emp : empDAO.obtenerTodos()) {
					System.out.println(emp);
				}
				System.out.print("Selecciona id de empleado: ");
				int idEmpleadoFactura = Integer.parseInt(sc.nextLine());

				Factura nuevaFactura = new Factura();
				nuevaFactura.setFecha(LocalDate.now());
				nuevaFactura.setId_cliente(idClienteFactura);
				nuevaFactura.setId_empleado(idEmpleadoFactura);
				nuevaFactura.setIva(0);
				nuevaFactura.setSubtotal(0);
				nuevaFactura.setTotal(0);
				facturaDAO.insertar(nuevaFactura);

				System.out.println("Productos disponibles:");
				for (Producto prodd : prodDAO.obtenerTodos()) {
					System.out.println(prodd);
				}

				int idProducto;
				do {
					System.out.print("Dime id de producto (0 para terminar): ");
					idProducto = Integer.parseInt(sc.nextLine());
					if (idProducto != 0) {
						System.out.print("Dime la cantidad: ");
						int cantidad = Integer.parseInt(sc.nextLine());
						Producto prod = prodDAO.obtenerPorId(idProducto);
						double precioUnitario = prod.getPrecio();
						double importe = precioUnitario * cantidad;
						LineaFactura lfNueva = new LineaFactura(nuevaFactura.getId(), idProducto, cantidad, precioUnitario, importe);
						lineafactDAO.insertar(lfNueva);
					}
				} while (idProducto != 0);

				System.out.println("Factura creada:");
				System.out.println(nuevaFactura);
				for (LineaFactura lf : lineafactDAO.obtenerLineaPorIdFactura(nuevaFactura.getId())) {
					System.out.println(lf);
				}
				break;

			case 10:
				// Muestra todos los productos y las facturas en las que aparece el seleccionado
				System.out.println("Todos los productos:");
				for (Producto p : prodDAO.obtenerTodos()) {
					System.out.println(p);
				}
				System.out.print("Dime el id del producto: ");
				int idProdFacturas = Integer.parseInt(sc.nextLine());
				System.out.println("Facturas en las que aparece el producto:");
				for (Factura f : facturaDAO.verfacturasprod(idProdFacturas)) {
					System.out.println(f);
				}
				break;

			case 11:
				// Eliminar un producto si no aparece en ninguna línea de factura
				System.out.println("Todos los productos:");
				for (Producto p : prodDAO.obtenerTodos()) {
					System.out.println(p);
				}
				System.out.print("Introduce el id del producto a eliminar: ");
				int idProductoEliminar = Integer.parseInt(sc.nextLine());

				if (lineafactDAO.existeProductoEnLineas(idProductoEliminar)) {
					System.out.println("No se puede eliminar: el producto aparece en líneas de factura.");
				} else {
					if (prodDAO.eliminar(idProductoEliminar)) {
						System.out.println("Producto eliminado correctamente.");
					} else {
						System.out.println("No se pudo eliminar el producto.");
					}
				}
				break;

			case 12:
				// Guardar clientes en fichero y leerlos
				List<Cliente> listaClientes = clienteDAO.obtenerTodos();

				try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
					oos.writeObject(listaClientes);
					System.out.println("Clientes guardados en clientes.dat.");
				} catch (IOException e) {
					e.printStackTrace();
				}

				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
					List<Cliente> clientesLeidos = (List<Cliente>) ois.readObject();
					System.out.println("Clientes leídos del fichero:");
					for (Cliente c : clientesLeidos) {
						System.out.println(c);
					}
				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				break;

			case 13:
				// Duplicar una factura existente con la fecha actual
				System.out.print("Introduce el id de la factura a duplicar: ");
				int idFacturaDuplicar = Integer.parseInt(sc.nextLine());

				Factura facturaOriginal = facturaDAO.obtenerPorId(idFacturaDuplicar);
				if (facturaOriginal != null) {
					List<LineaFactura> lineasOriginales = lineafactDAO.obtenerLineaPorIdFactura(idFacturaDuplicar);

					Factura facturaDuplicada = new Factura();
					facturaDuplicada.setFecha(LocalDate.now());
					facturaDuplicada.setId_cliente(facturaOriginal.getId_cliente());
					facturaDuplicada.setId_empleado(facturaOriginal.getId_empleado());
					facturaDuplicada.setSubtotal(facturaOriginal.getSubtotal());
					facturaDuplicada.setIva(facturaOriginal.getIva());
					facturaDuplicada.setTotal(facturaOriginal.getTotal());
					facturaDAO.insertar(facturaDuplicada);

					for (LineaFactura lf : lineasOriginales) {
						LineaFactura nuevaLinea = new LineaFactura();
						nuevaLinea.setId_factura(facturaDuplicada.getId());
						nuevaLinea.setId_producto(lf.getId_producto());
						nuevaLinea.setCantidad(lf.getCantidad());
						nuevaLinea.setPrecio_unitario(lf.getPrecio_unitario());
						nuevaLinea.setImporte(lf.getImporte());
						lineafactDAO.insertar(nuevaLinea);
					}

					System.out.println("Factura duplicada:");
					System.out.println(facturaDuplicada);
					for (LineaFactura lf : lineafactDAO.obtenerLineaPorIdFactura(facturaDuplicada.getId())) {
						System.out.println(lf);
					}
				} else {
					System.out.println("Factura no encontrada.");
				}
				break;

			case 14:
				// Eliminar una línea de factura y recalcular totales
				System.out.print("Introduce el id de la factura: ");
				int idFacturaModificar = Integer.parseInt(sc.nextLine());

				Factura facturaModificar = facturaDAO.obtenerPorId(idFacturaModificar);
				if (facturaModificar != null) {
					System.out.println("Líneas de la factura:");
					for (LineaFactura lf : lineafactDAO.obtenerLineaPorIdFactura(idFacturaModificar)) {
						System.out.println(lf);
					}

					System.out.print("Introduce el id de la línea a eliminar: ");
					int idLineaEliminar = Integer.parseInt(sc.nextLine());

					if (lineafactDAO.eliminar(idLineaEliminar)) {
						List<LineaFactura> lineasActualizadas = lineafactDAO.obtenerLineaPorIdFactura(idFacturaModificar);
						double subtotal = 0;
						for (LineaFactura lf : lineasActualizadas) {
							subtotal += lf.getImporte();
						}
						double iva = subtotal * 0.21;
						double total = subtotal + iva;

						facturaModificar.setSubtotal(subtotal);
						facturaModificar.setIva(iva);
						facturaModificar.setTotal(total);
						facturaDAO.actualizar(facturaModificar);

						System.out.println("Factura actualizada:");
						System.out.println(facturaModificar);
						for (LineaFactura lf : lineasActualizadas) {
							System.out.println(lf);
						}
					} else {
						System.out.println("No se pudo eliminar la línea.");
					}
				} else {
					System.out.println("Factura no encontrada.");
				}
				break;

			case 15:
				// Resumen mensual por empleado
				System.out.print("Introduce el número de mes: ");
				int mesResumen = Integer.parseInt(sc.nextLine());

				Map<Empleado, List<Factura>> resumen = facturaDAO.obtenerFacturasPorEmpleadoYMes(mesResumen);
				for (Map.Entry<Empleado, List<Factura>> entry : resumen.entrySet()) {
					Empleado emp = entry.getKey();
					List<Factura> facturasEmp = entry.getValue();
					double totalFacturado = 0;
					for (Factura f : facturasEmp) {
						totalFacturado += f.getTotal();
					}
					System.out.println("\nEmpleado: " + emp.getNombre());
					System.out.println("Facturas emitidas: " + facturasEmp.size());
					System.out.println("Total facturado: " + totalFacturado + " €");
				}
				break;

			case 0:
				System.out.println("Saliendo...");
				break;

			default:
				System.out.println("Opción no válida. Elige entre 0 y 15.");
				break;
			}
		}

		sc.close();
	}
}