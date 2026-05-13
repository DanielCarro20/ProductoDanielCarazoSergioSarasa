package ProductoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Producto.Cliente;
import Producto.Empleado;
import util.ConexionBD;

public class EmpleadoDAO implements GenericDAO<Empleado> {

	@Override
	public boolean insertar(Empleado objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Empleado> obtenerTodos() {
		ArrayList<Empleado> lista = new ArrayList<Empleado>();
		String sql = "SELECT * FROM EMPLEADO";
		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(mapear(rs));
			}

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return lista;

	}

	@Override
	public Empleado obtenerPorId(int id) {
		String sql = "SELECT * FROM CLIENTE WHERE ID = ?";
		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);
			;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mapear(rs);
			}

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return null;
	}

	@Override
	public boolean actualizar(Empleado objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	private Empleado mapear(ResultSet rs) throws SQLException {
		Empleado e = new Empleado();
		e.setId(rs.getInt("id"));
		e.setPuesto(rs.getString("puesto"));
		e.setSalario(rs.getDouble("salario"));
		return e;
	}

}
