package Producto;

/**
 * Representa una línea de detalle dentro de una {@link Factura}.
 *
 * <p>Cada instancia corresponde a un producto concreto incluido en una factura,
 * almacenando la cantidad adquirida, el precio unitario en el momento de la
 * compra y el importe resultante. Una factura puede contener múltiples
 * líneas, una por cada producto diferente.</p>
 *
 * @author [Tu nombre]
 * @version 1.0
 * @since 1.0
 * @see Factura
 */
public class LineaFactura {

    /**
     * Identificador único de la línea de factura en el sistema.
     */
    protected int id;

    /**
     * Identificador de la {@link Factura} a la que pertenece esta línea.
     */
    protected int id_factura;

    /**
     * Identificador del producto asociado a esta línea de factura.
     */
    protected int id_producto;

    /**
     * Cantidad de unidades del producto incluidas en esta línea.
     */
    protected int cantidad;

    /**
     * Precio por unidad del producto en el momento de la facturación.
     * Expresado en la moneda del sistema.
     */
    protected double precio_unitario;

    /**
     * Importe total de la línea, resultado de multiplicar {@code cantidad}
     * por {@code precio_unitario}. Expresado en la moneda del sistema.
     */
    protected double importe;

    /**
     * Construye una nueva {@code LineaFactura} con todos sus atributos definidos,
     * incluyendo el identificador de sistema.
     *
     * @param id              identificador único de la línea de factura
     * @param id_factura      identificador de la factura a la que pertenece
     * @param id_producto     identificador del producto asociado
     * @param cantidad        número de unidades del producto; debe ser un valor positivo
     * @param precio_unitario precio por unidad del producto; debe ser un valor positivo
     * @param importe         importe total de la línea (cantidad × precio_unitario)
     */
    public LineaFactura(int id, int id_factura, int id_producto, int cantidad,
                        double precio_unitario, double importe) {
        super();
        this.id = id;
        this.id_factura = id_factura;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.importe = importe;
    }

    /**
     * Construye una nueva {@code LineaFactura} sin identificador de sistema.
     * Útil cuando el {@code id} será asignado posteriormente, por ejemplo,
     * al persistir la entidad en una base de datos.
     *
     * @param id_factura      identificador de la factura a la que pertenece
     * @param id_producto     identificador del producto asociado
     * @param cantidad        número de unidades del producto; debe ser un valor positivo
     * @param precio_unitario precio por unidad del producto; debe ser un valor positivo
     * @param importe         importe total de la línea (cantidad × precio_unitario)
     */
    public LineaFactura(int id_factura, int id_producto, int cantidad,
                        double precio_unitario, double importe) {
        super();
        this.id_factura = id_factura;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.importe = importe;
    }

    /**
     * Construye una nueva {@code LineaFactura} sin ningún atributo inicializado.
     * Todos los campos quedan con sus valores por defecto ({@code 0} para
     * tipos numéricos).
     */
    public LineaFactura() {
        super();
    }

    /**
     * Devuelve el identificador único de la línea de factura.
     *
     * @return el id de la línea de factura
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único de la línea de factura.
     *
     * @param id el nuevo id de la línea de factura
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el identificador de la factura a la que pertenece esta línea.
     *
     * @return el id de la factura asociada
     */
    public int getId_factura() {
        return id_factura;
    }

    /**
     * Establece el identificador de la factura asociada a esta línea.
     *
     * @param id_factura el id de la nueva factura asociada
     */
    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    /**
     * Devuelve el identificador del producto asociado a esta línea.
     *
     * @return el id del producto
     */
    public int getId_producto() {
        return id_producto;
    }

    /**
     * Establece el identificador del producto asociado a esta línea.
     *
     * @param id_producto el id del nuevo producto asociado
     */
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    /**
     * Devuelve la cantidad de unidades del producto en esta línea.
     *
     * @return el número de unidades
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de unidades del producto en esta línea.
     *
     * @param cantidad el nuevo número de unidades; debe ser un valor positivo
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Devuelve el precio unitario del producto en el momento de la facturación.
     *
     * @return el precio por unidad del producto
     */
    public double getPrecio_unitario() {
        return precio_unitario;
    }

    /**
     * Establece el precio unitario del producto.
     *
     * @param precio_unitario el nuevo precio por unidad; debe ser un valor positivo
     */
    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    /**
     * Devuelve el importe total de la línea de factura.
     *
     * @return el importe resultante de {@code cantidad × precio_unitario}
     */
    public double getImporte() {
        return importe;
    }

    /**
     * Establece el importe total de la línea de factura.
     *
     * @param importe el nuevo importe; debe ser igual a {@code cantidad × precio_unitario}
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }

    /**
     * Devuelve una representación en cadena de texto de la línea de factura,
     * incluyendo todos sus atributos.
     *
     * @return cadena con el formato:
     *         {@code LineaFactura [id=X, id_factura=Y, id_producto=Z, cantidad=W, precio_unitario=A, importe=B]}
     */
    @Override
    public String toString() {
        return "LineaFactura [id=" + id + ", id_factura=" + id_factura
                + ", id_producto=" + id_producto + ", cantidad=" + cantidad
                + ", precio_unitario=" + precio_unitario + ", importe=" + importe + "]";
    }
}