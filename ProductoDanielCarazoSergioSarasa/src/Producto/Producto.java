package Producto;

/**
 * Representa un producto disponible en el catálogo del sistema.
 *
 * <p>Almacena la información comercial básica de un producto: su nombre,
 * precio de venta y las unidades disponibles en stock. Los productos se
 * referencian desde {@link LineaFactura} mediante su identificador.</p>
 *
 * @author [Tu nombre]
 * @version 1.0
 * @since 1.0
 * @see LineaFactura
 */
public class Producto {

    /**
     * Identificador único del producto en el sistema.
     */
    protected int id;

    /**
     * Nombre descriptivo del producto.
     */
    protected String nombre;

    /**
     * Precio de venta unitario del producto.
     * Expresado en la moneda del sistema.
     */
    protected double precio;

    /**
     * Número de unidades disponibles del producto en el inventario.
     * Un valor de {@code 0} indica que el producto está agotado.
     */
    protected int stock;

    /**
     * Construye un nuevo {@code Producto} con todos sus atributos definidos,
     * incluyendo el identificador de sistema.
     *
     * @param id     identificador único del producto
     * @param nombre nombre descriptivo del producto; no debería ser {@code null}
     * @param precio precio de venta unitario; debe ser un valor positivo
     * @param stock  unidades disponibles en inventario; debe ser un valor no negativo
     */
    public Producto(int id, String nombre, double precio, int stock) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Construye un nuevo {@code Producto} sin identificador de sistema.
     * Útil cuando el {@code id} será asignado posteriormente, por ejemplo,
     * al persistir la entidad en una base de datos.
     *
     * @param nombre nombre descriptivo del producto; no debería ser {@code null}
     * @param precio precio de venta unitario; debe ser un valor positivo
     * @param stock  unidades disponibles en inventario; debe ser un valor no negativo
     */
    public Producto(String nombre, double precio, int stock) {
        super();
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Construye un nuevo {@code Producto} sin ningún atributo inicializado.
     * Todos los campos quedan con sus valores por defecto ({@code 0} para
     * tipos numéricos y {@code null} para {@code String}).
     */
    public Producto() {
        super();
    }

    /**
     * Devuelve el identificador único del producto.
     *
     * @return el id del producto
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del producto.
     *
     * @param id el nuevo id del producto
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre descriptivo del producto.
     *
     * @return el nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre descriptivo del producto.
     *
     * @param nombre el nuevo nombre del producto; no debería ser {@code null}
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el precio de venta unitario del producto.
     *
     * @return el precio unitario del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio de venta unitario del producto.
     *
     * @param precio el nuevo precio unitario; debe ser un valor positivo
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Devuelve el número de unidades disponibles del producto en el inventario.
     *
     * @return las unidades en stock; {@code 0} indica producto agotado
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece el número de unidades disponibles del producto en el inventario.
     *
     * @param stock las nuevas unidades en stock; debe ser un valor no negativo
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Devuelve una representación en cadena de texto del producto,
     * incluyendo todos sus atributos.
     *
     * @return cadena con el formato:
     *         {@code Producto [id=X, nombre=Y, precio=Z, stock=W]}
     */
    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre
                + ", precio=" + precio + ", stock=" + stock + "]";
    }
}