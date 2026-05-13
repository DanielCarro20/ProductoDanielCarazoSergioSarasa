package Producto;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String direccion;
	
	public Cliente(int id, String direccion) {
		super();
		this.id = id;
		this.direccion = direccion;
	}
	public Cliente(String direccion) {
		super();
		this.direccion = direccion;
	}
	public Cliente() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", direccion=" + direccion + "]";
	}

}
