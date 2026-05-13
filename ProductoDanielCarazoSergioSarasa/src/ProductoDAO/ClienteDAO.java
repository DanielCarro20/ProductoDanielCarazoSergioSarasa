package ProductoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Producto.Cliente;
import util.ConexionBD;

public class ClienteDAO implements GenericDAO<Cliente> {

	@Override
	public boolean insertar(Cliente objeto) {
		String sql = "INSERT INTO CLIENTE (direccion) values (?,?)";

		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, objeto.getDireccion());
			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return false;

	}

	@Override
	public List<Cliente> obtenerTodos() {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		String sql = "SELECT * FROM CLIENTE";
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
	public Cliente obtenerPorId(int id) {
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
	public boolean actualizar(Cliente objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	private Cliente mapear(ResultSet rs) throws SQLException {
		Cliente c = new Cliente();
		c.setId(rs.getInt("id"));
		c.setDireccion(rs.getString("direccion"));
		return c;
	}

}
