package Producto;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String direccion;

	public Cliente(int id, String dni, String nombre, String direccion) {
		super(id, dni, nombre);
		this.direccion = direccion;
	}

	public Cliente(String dni, String nombre, String direccion) {
		super( dni, nombre);
		this.direccion = direccion;
	}

	public Cliente() {
		super();
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Cliente [direccion=" + direccion + ", getId()=" + getId() + ", getDni()=" + getDni() + ", getNombre()="
				+ getNombre() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
}
