package ProductoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Producto.Factura;
import Producto.Producto;
import util.ConexionBD;

public class FacturaDAO implements GenericDAO<Factura> {

	@Override
	public boolean insertar(Factura objeto) {
		String sql = "INSERT INTO FACTURA (fecha,id_cliente,id_empleado,subtotal,iva,total) values (?,?,?,?,?,?)";
		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setObject(1, objeto.getFecha());
			ps.setInt(2, objeto.getId_cliente());
			ps.setInt(3, objeto.getId_empleado());
			ps.setDouble(4, objeto.getSubtotal());
			ps.setDouble(5, objeto.getIva());
			ps.setDouble(6, objeto.getTotal());
			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return false;

	}

	@Override
	public List<Factura> obtenerTodos() {
		ArrayList<Factura> fact = new ArrayList<Factura>();
		String sql = "SELECT * FROM FACTURA";
		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				fact.add(mapearFila(rs));
			}

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return fact;
	}

	@Override
	public Factura obtenerPorId(int id) {
		String sql = "SELECT * FROM FACTURA WHERE ID = ?";
		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return mapearFila(rs);
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return null;

	}

	@Override
	public boolean actualizar(Factura objeto) {
		String sql = "UPDATE FACTURA set fecha = ?, id_cliente = ?, id_empleado = ?, subtotal = ?, iva = ?, total = ? where id = ?";
		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setObject(1, objeto.getFecha());
			ps.setInt(2, objeto.getId_cliente());
			ps.setInt(3, objeto.getId_empleado());
			ps.setDouble(4, objeto.getSubtotal());
			ps.setDouble(5, objeto.getIva());
			ps.setDouble(6, objeto.getTotal());
			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return false;

	}

	@Override
	public boolean eliminar(int id) {
		String sql = "DELETE FROM FACTURA WHERE ID = ?";
		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return false;
	}

	private Factura mapearFila(ResultSet rs) throws SQLException {
		Factura f = new Factura();
		f.setId(rs.getInt("id"));
		f.setFecha(rs.getObject("fecha", LocalDate.class));
		f.setId_cliente(rs.getInt("id_cliente"));
		f.setId_empleado(rs.getInt("id_empleado"));
		f.setSubtotal(rs.getDouble("subtotal"));
		f.setIva(rs.getDouble("iva"));
		f.setTotal(rs.getDouble("total"));

		return f;
	}
}
