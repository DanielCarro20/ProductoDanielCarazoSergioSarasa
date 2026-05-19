package Producto;

import java.io.Serializable;

/**
 * Representa un empleado de la empresa, extendiendo la información básica de
 * {@link Persona} con datos laborales como el puesto y el salario.
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
public class Empleado extends Persona implements Serializable {

	/**
	 * Identificador de versión para la serialización. Necesario para garantizar la
	 * compatibilidad entre versiones serializadas.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Puesto o cargo que ocupa el empleado dentro de la empresa.
	 */
	protected String puesto;

	/**
	 * Salario bruto del empleado expresado en la moneda del sistema.
	 */
	protected double salario;

	/**
	 * Construye un nuevo {@code Empleado} con todos sus atributos definidos,
	 * incluyendo el identificador de sistema heredado de {@link Persona}.
	 *
	 * @param id      identificador único del empleado en el sistema
	 * @param dni     documento nacional de identidad del empleado
	 * @param nombre  nombre completo del empleado
	 * @param puesto  cargo o puesto que ocupa el empleado
	 * @param salario salario bruto del empleado
	 */
	public Empleado(int id, String dni, String nombre, String puesto, double salario) {
		super(id, dni, nombre);
		this.puesto = puesto;
		this.salario = salario;
	}

	/**
	 * Construye un nuevo {@code Empleado} sin identificador de sistema. Útil cuando
	 * el {@code id} será asignado posteriormente, por ejemplo, al persistir la
	 * entidad en una base de datos.
	 *
	 * @param dni     documento nacional de identidad del empleado
	 * @param nombre  nombre completo del empleado
	 * @param puesto  cargo o puesto que ocupa el empleado
	 * @param salario salario bruto del empleado
	 */
	public Empleado(String dni, String nombre, String puesto, double salario) {
		super(dni, nombre);
		this.puesto = puesto;
		this.salario = salario;
	}

	/**
	 * Construye un nuevo {@code Empleado} sin ningún atributo inicializado. Todos
	 * los campos quedan con sus valores por defecto ({@code 0} para tipos numéricos
	 * y {@code null} para {@code String}).
	 */
	public Empleado() {
		super();
	}

	/**
	 * Devuelve el puesto o cargo del empleado.
	 *
	 * @return el puesto que ocupa el empleado dentro de la empresa
	 */
	public String getPuesto() {
		return puesto;
	}

	/**
	 * Establece el puesto o cargo del empleado.
	 *
	 * @param puesto el nuevo cargo o puesto del empleado
	 */
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	/**
	 * Devuelve el salario bruto del empleado.
	 *
	 * @return el salario del empleado expresado en la moneda del sistema
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * Establece el salario bruto del empleado.
	 *
	 * @param salario el nuevo salario del empleado; debe ser un valor positivo
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * Devuelve una representación en cadena de texto del empleado, incluyendo su
	 * {@code puesto}, {@code salario} y los atributos heredados de {@link Persona}.
	 *
	 * @return cadena con el formato:
	 *         {@code Empleado [puesto=X, salario=Y, getId()=Z, getDni()=W, getNombre()=V, toString()=...]}
	 */
	@Override
	public String toString() {
		return "Empleado [puesto=" + puesto + ", salario=" + salario + ", getId()=" + getId() + ", getDni()=" + getDni()
				+ ", getNombre()=" + getNombre() + ", toString()=" + super.toString() + "]";
	}
}