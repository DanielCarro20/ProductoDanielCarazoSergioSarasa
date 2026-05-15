package ProductoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Producto.Producto;
import util.ConexionBD;

public class ProductoDAO implements GenericDAO<Producto>{

	@Override
	public boolean insertar(Producto objeto) {

		
		 String sql = "INSERT INTO PRODUCTO (nombre,precio,stock) values (?,?,?)";
		    try (Connection con = ConexionBD.getConnection();
		         PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
		    	ps.setString(1, objeto.getNombre());
				ps.setDouble(2, objeto.getPrecio());
				ps.setDouble(3, objeto.getStock());
		          int filas = ps.executeUpdate();
		          if (filas > 0) {
		                ResultSet rs = ps.getGeneratedKeys();
		                if (rs.next()) {
		                    objeto.setId(rs.getInt(1));
		                }
		                return true;
		            }
		      } catch (SQLException e) {
		            System.out.println("Error al insertar: " + e.getMessage());
		      }
		        return false;
		    }
	

	@Override
	public List<Producto> obtenerTodos() {
		ArrayList<Producto> prod = new ArrayList<Producto>();
		 String sql = "SELECT * FROM PRODUCTO";
		   try (Connection con = ConexionBD.getConnection();
		        PreparedStatement ps = con.prepareStatement(sql)) {
		          
		          ResultSet rs = ps.executeQuery();
		          while (rs.next()) {
		           prod.add(mapearFila(rs));    
		          }
		          
		    
		    } catch (SQLException e) {
		            System.out.println("Error: " + e.getMessage());
		    }
		   return prod;
	}

	@Override
	public Producto obtenerPorId(int id) {
		  String sql = "SELECT * FROM PRODUCTO WHERE ID = ?";
		   try (Connection con = ConexionBD.getConnection();
		        PreparedStatement ps = con.prepareStatement(sql)) {
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
	public boolean actualizar(Producto objeto) {
		 String sql = "UPDATE PRODUCTO set precio = ? where id = ?";
		   try (Connection con = ConexionBD.getConnection();
		        PreparedStatement ps = con.prepareStatement(sql)) {
		          ps.setDouble(1, objeto.getPrecio());
		          ps.setInt(2, objeto.getId());
		          return ps.executeUpdate() > 0;
		    
		    } catch (SQLException e) {
		            System.out.println("Error: " + e.getMessage());
		    }
		   return false;

	}

	@Override
	public boolean eliminar(int id) {
		String sql = "DELETE FROM PRODUCTO WHERE ID = ?";
		   try (Connection con = ConexionBD.getConnection();
		        PreparedStatement ps = con.prepareStatement(sql)) {
			   ps.setInt(1, id);
			   return ps.executeUpdate() > 0;
			  
		    } catch (SQLException e) {
		            System.out.println("Error: " + e.getMessage());
		    }
		   return false;
	}
	private Producto mapearFila(ResultSet rs) throws SQLException {
        Producto a = new Producto();
        a.setId(rs.getInt("id"));
        a.setNombre(rs.getString("nombre"));
        a.setPrecio(rs.getDouble("precio"));
        a.setStock(rs.getInt("stock"));
	  return a;
    }
}
