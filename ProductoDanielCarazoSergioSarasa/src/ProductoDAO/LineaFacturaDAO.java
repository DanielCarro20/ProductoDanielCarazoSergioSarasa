package ProductoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Producto.Factura;
import Producto.LineaFactura;
import Producto.Producto;
import util.ConexionBD;

public class LineaFacturaDAO implements GenericDAO<LineaFactura> {

	@Override
	public boolean insertar(LineaFactura objeto) {

		   String sql = "INSERT INTO LINEAFACTURA (id_factura,id_producto,cantidad,precio_unitario,importe) VALUES (?,?,?,?,?) ";
		    try (Connection con = ConexionBD.getConnection();
		         PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
		    	ps.setInt(1, objeto.getId_factura());
		          ps.setInt(2, objeto.getId_producto());
		          ps.setInt(3, objeto.getCantidad());
		          ps.setDouble(4, objeto.getPrecio_unitario());
		          ps.setDouble(5, objeto.getImporte());
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
	public List<LineaFactura> obtenerTodos() {
		ArrayList<LineaFactura> lf = new ArrayList<LineaFactura>();
		 String sql = "SELECT * FROM LINEAFACTURA";
		   try (Connection con = ConexionBD.getConnection();
		        PreparedStatement ps = con.prepareStatement(sql)) {
		          ResultSet rs = ps.executeQuery();
		          while (rs.next()) {
		                lf.add(mapearFila(rs));
		          }

		    
		    } catch (SQLException e) {
		            System.out.println("Error: " + e.getMessage());
		    }
		   		return lf;
	}

	public ArrayList<LineaFactura> obtenerLineaPorIdFactura(int id_factura) {
		ArrayList<LineaFactura> lfact = new ArrayList<LineaFactura>();
		String sql = "SELECT * FROM LINEAFACTURA WHERE id_factura = ?";
		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id_factura);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lfact.add(mapearFila(rs));
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return lfact;

	}

	@Override
	public boolean actualizar(LineaFactura objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int idproducto) {
		
		  String sql = "DELETE FROM LINEAFACTURA WHERE (SELECT count(*) FROM LINEAFACTURA LF JOIN PRODUCTO P ON P.ID=LF.ID_PRODUCTO WHERE LF.ID_PRODUCTO = ?)>0";
		   try (Connection con = ConexionBD.getConnection();
		        PreparedStatement ps = con.prepareStatement(sql)) {
		          ps.setInt(1, idproducto);
		          return ps.executeUpdate() > 0;
		    
		    } catch (SQLException e) {
		            System.out.println("Error: " + e.getMessage());
		    }

		return false;
		
	}

	private LineaFactura mapearFila(ResultSet rs) throws SQLException {
        LineaFactura a = new LineaFactura();
	 	a.setId(rs.getInt("id"));
	 	a.setId_factura(rs.getInt("id_factura"));
	 	a.setId_producto(rs.getInt("id_factura"));
	 	a.setCantidad(rs.getInt("cantidad"));
	 	a.setPrecio_unitario(rs.getDouble("precio_unitario"));
	 	a.setImporte(rs.getDouble("importe"));
	  return a;
    }





	@Override
	public LineaFactura obtenerPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
