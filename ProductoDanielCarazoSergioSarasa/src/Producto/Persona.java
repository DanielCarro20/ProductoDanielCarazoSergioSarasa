package Producto;

import java.io.Serializable;

/**
 * Representa una persona con información básica de identificación.
 *
 * <p>
 * Esta clase implementa {@link Serializable} para permitir la serialización de
 * sus instancias, facilitando su almacenamiento o transmisión.
 * </p>
 *
 * @author [Tu nombre]
 * @version 1.0
 * @since 1.0
 */
public class Persona implements Serializable {

	/**
	 * Identificador de versión para la serialización. Necesario para garantizar la
	 * compatibilidad entre versiones serializadas.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Identificador único de la persona en el sistema.
	 */
	protected int id;

	/**
	 * Documento Nacional de Identidad de la persona.
	 */
	protected String dni;

	/**
	 * Nombre completo de la persona.
	 */
	protected String nombre;

	/**
	 * Construye una nueva {@code Persona} con todos sus atributos definidos.
	 *
	 * @param id     identificador único de la persona
	 * @param dni    documento nacional de identidad
	 * @param nombre nombre completo de la persona
	 */
	public Persona(int id, String dni, String nombre) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
	}

	/**
	 * Construye una nueva {@code Persona} sin identificador de sistema. Útil cuando
	 * el {@code id} es asignado posteriormente, por ejemplo, al persistir la
	 * entidad en una base de datos.
	 *
	 * @param dni    documento nacional de identidad
	 * @param nombre nombre completo de la persona
	 */
	public Persona(String dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}

	/**
	 * Construye una nueva {@code Persona} sin ningún atributo inicializado. Todos
	 * los campos quedan con sus valores por defecto ({@code 0} para {@code int} y
	 * {@code null} para {@code String}).
	 */
	public Persona() {
		super();
	}

	/**
	 * Devuelve el identificador único de la persona.
	 *
	 * @return el id de la persona
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador único de la persona.
	 *
	 * @param id el nuevo id de la persona
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Devuelve el DNI de la persona.
	 *
	 * @return el documento nacional de identidad
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Establece el DNI de la persona.
	 *
	 * @param dni el nuevo documento nacional de identidad
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Devuelve el nombre completo de la persona.
	 *
	 * @return el nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre completo de la persona.
	 *
	 * @param nombre el nuevo nombre de la persona
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve una representación en cadena de texto de la persona, incluyendo su
	 * {@code id}, {@code dni} y {@code nombre}.
	 *
	 * @return cadena con el formato: {@code Persona [id=X, dni=Y, nombre=Z]}
	 */
	@Override
	public String toString() {
		return "Persona [id=" + id + ", dni=" + dni + ", nombre=" + nombre + "]";
	}
}