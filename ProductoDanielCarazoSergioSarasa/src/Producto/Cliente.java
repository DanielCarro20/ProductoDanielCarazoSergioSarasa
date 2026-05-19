package Producto;

import java.io.Serializable;

/**
 * Representa un cliente del sistema, extendiendo la información básica de
 * {@link Persona} con datos propios de un cliente, como su dirección.
 *
 * <p>
 * Hereda los atributos {@code id}, {@code dni} y {@code nombre} de
 * {@link Persona} e implementa {@link Serializable} para permitir la
 * serialización de sus instancias.
 * </p>
 *
 * @author [Tu nombre]
 * @version 1.0
 * @since 1.0
 * @see Persona
 */
public class Cliente extends Persona implements Serializable {

	/**
	 * Identificador de versión para la serialización. Necesario para garantizar la
	 * compatibilidad entre versiones serializadas.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Dirección postal o de residencia del cliente.
	 */
	protected String direccion;

	/**
	 * Construye un nuevo {@code Cliente} con todos sus atributos definidos,
	 * incluyendo el identificador de sistema heredado de {@link Persona}.
	 *
	 * @param id        identificador único del cliente en el sistema
	 * @param dni       documento nacional de identidad del cliente
	 * @param nombre    nombre completo del cliente
	 * @param direccion dirección postal o de residencia del cliente
	 */
	public Cliente(int id, String dni, String nombre, String direccion) {
		super(id, dni, nombre);
		this.direccion = direccion;
	}

	/**
	 * Construye un nuevo {@code Cliente} sin identificador de sistema. Útil cuando
	 * el {@code id} será asignado posteriormente, por ejemplo, al persistir la
	 * entidad en una base de datos.
	 *
	 * @param dni       documento nacional de identidad del cliente
	 * @param nombre    nombre completo del cliente
	 * @param direccion dirección postal o de residencia del cliente
	 */
	public Cliente(String dni, String nombre, String direccion) {
		super(dni, nombre);
		this.direccion = direccion;
	}

	/**
	 * Construye un nuevo {@code Cliente} sin ningún atributo inicializado. Todos
	 * los campos quedan con sus valores por defecto ({@code 0} para {@code int} y
	 * {@code null} para {@code String}).
	 */
	public Cliente() {
		super();
	}

	/**
	 * Devuelve la dirección del cliente.
	 *
	 * @return la dirección postal o de residencia del cliente
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Establece la dirección del cliente.
	 *
	 * @param direccion la nueva dirección postal o de residencia del cliente
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Devuelve el identificador de versión de serialización de la clase.
	 *
	 * @return el valor de {@code serialVersionUID}
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Devuelve una representación en cadena de texto del cliente, incluyendo su
	 * {@code direccion} y los atributos heredados de {@link Persona}.
	 *
	 * @return cadena con el formato:
	 *         {@code Cliente [direccion=X, getId()=Y, getDni()=Z, getNombre()=W, toString()=...]}
	 */
	@Override
	public String toString() {
		return "Cliente [direccion=" + direccion + ", getId()=" + getId() + ", getDni()=" + getDni() + ", getNombre()="
				+ getNombre() + ", toString()=" + super.toString() + "]";
	}
}
