package ProductoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Producto.Cliente;
import Producto.Persona;
import util.ConexionBD;

public class ClienteDAO implements GenericDAO<Cliente> {

	@Override
	public boolean insertar(Cliente cliente) {
		String sql = "INSERT INTO persona (dni,nombre) values (?,?)";
	    try (Connection con = ConexionBD.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	    	ps.setString(1, cliente.getDni());
	    	ps.setString(2, cliente.getNombre());
	          int filas = ps.executeUpdate();
	          if (filas > 0) {
	                ResultSet rs = ps.getGeneratedKeys();
	                if (rs.next()) {
	                    cliente.setId(rs.getInt(1));
	                     sql = "INSERT INTO CLIENTE (id,direccion) values (?,?)";
	            	    try (PreparedStatement ps1 = con.prepareStatement(sql)) {
	            	    	ps1.setInt(1, cliente.getId());
	            	    	ps1.setString(2, cliente.getDireccion());
	            	    
	            	          return ps1.executeUpdate() > 0;
	            	          
	            	        
	                }
	                
	            }
	      }} catch (SQLException e) {
	            System.out.println("Error al insertar: " + e.getMessage());
	      }
	        return false;
	        
		
		
	}


	
	@Override
	public List<Cliente> obtenerTodos() {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		String sql = "SELECT * FROM CLIENTE C INNER JOIN PERSONA P ON C.ID=P.ID";
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
		String sql = "SELECT * FROM CLIENTE C INNER JOIN PERSONA P ON P.ID=C.ID WHERE C.ID = ?";
		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return mapear(rs);
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
		Persona p = new Persona();
		c.setId(rs.getInt("id"));
		c.setDireccion(rs.getString("direccion"));
		p.setDni(rs.getString("dni"));
		p.setNombre(rs.getString("nombre"));
		return c;
	}

}
