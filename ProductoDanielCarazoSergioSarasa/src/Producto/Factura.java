package Producto;

import java.time.LocalDate;

/**
 * Representa una factura generada en el sistema de gestión comercial.
 *
 * <p>Almacena la información económica y relacional de una transacción,
 * vinculando un {@link Cliente} y un {@link Empleado} mediante sus
 * identificadores, junto con los importes desglosados de la operación.</p>
 *
 * @author [Tu nombre]
 * @version 1.0
 * @since 1.0
 * @see Cliente
 * @see Empleado
 */
public class Factura {

    /**
     * Identificador único de la factura en el sistema.
     */
    protected int id;

    /**
     * Fecha de emisión de la factura.
     */
    protected LocalDate fecha;

    /**
     * Identificador del cliente asociado a esta factura.
     * Referencia al {@code id} de un {@link Cliente}.
     */
    protected int id_cliente;

    /**
     * Identificador del empleado que gestionó esta factura.
     * Referencia al {@code id} de un {@link Empleado}.
     */
    protected int id_empleado;

    /**
     * Importe subtotal de la factura antes de aplicar el IVA.
     * Expresado en la moneda del sistema.
     */
    protected double subtotal;

    /**
     * Importe correspondiente al IVA aplicado sobre el {@code subtotal}.
     * Expresado en la moneda del sistema.
     */
    protected double iva;

    /**
     * Importe total de la factura, resultado de sumar {@code subtotal} e {@code iva}.
     * Expresado en la moneda del sistema.
     */
    protected double total;

    /**
     * Construye una nueva {@code Factura} con todos sus atributos definidos,
     * incluyendo el identificador de sistema.
     *
     * @param id          identificador único de la factura
     * @param fecha       fecha de emisión de la factura
     * @param id_cliente  identificador del cliente asociado
     * @param id_empleado identificador del empleado que gestiona la factura
     * @param subtotal    importe antes de aplicar el IVA; debe ser un valor positivo
     * @param iva         importe del IVA aplicado; debe ser un valor positivo
     * @param total       importe total de la factura (subtotal + IVA)
     */
    public Factura(int id, LocalDate fecha, int id_cliente, int id_empleado,
                   double subtotal, double iva, double total) {
        super();
        this.id = id;
        this.fecha = fecha;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    /**
     * Construye una nueva {@code Factura} sin identificador de sistema.
     * Útil cuando el {@code id} será asignado posteriormente, por ejemplo,
     * al persistir la entidad en una base de datos.
     *
     * @param fecha       fecha de emisión de la factura
     * @param id_cliente  identificador del cliente asociado
     * @param id_empleado identificador del empleado que gestiona la factura
     * @param subtotal    importe antes de aplicar el IVA; debe ser un valor positivo
     * @param iva         importe del IVA aplicado; debe ser un valor positivo
     * @param total       importe total de la factura (subtotal + IVA)
     */
    public Factura(LocalDate fecha, int id_cliente, int id_empleado,
                   double subtotal, double iva, double total) {
        super();
        this.fecha = fecha;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    /**
     * Construye una nueva {@code Factura} sin ningún atributo inicializado.
     * Todos los campos quedan con sus valores por defecto ({@code 0} para
     * tipos numéricos y {@code null} para objetos).
     */
    public Factura() {
        super();
    }

    /**
     * Devuelve el identificador único de la factura.
     *
     * @return el id de la factura
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único de la factura.
     *
     * @param id el nuevo id de la factura
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve la fecha de emisión de la factura.
     *
     * @return la fecha de emisión como {@link LocalDate}
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de emisión de la factura.
     *
     * @param fecha la nueva fecha de emisión; no debería ser {@code null}
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Devuelve el identificador del cliente asociado a la factura.
     *
     * @return el id del cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * Establece el identificador del cliente asociado a la factura.
     *
     * @param id_cliente el id del nuevo cliente asociado
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * Devuelve el identificador del empleado que gestionó la factura.
     *
     * @return el id del empleado
     */
    public int getId_empleado() {
        return id_empleado;
    }

    /**
     * Establece el identificador del empleado que gestiona la factura.
     *
     * @param id_empleado el id del nuevo empleado asociado
     */
    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    /**
     * Devuelve el importe subtotal de la factura antes de aplicar el IVA.
     *
     * @return el subtotal de la factura
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * Establece el importe subtotal de la factura.
     *
     * @param subtotal el nuevo subtotal; debe ser un valor positivo
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * Devuelve el importe de IVA aplicado sobre el subtotal.
     *
     * @return el importe del IVA
     */
    public double getIva() {
        return iva;
    }

    /**
     * Establece el importe de IVA de la factura.
     *
     * @param iva el nuevo importe de IVA; debe ser un valor positivo
     */
    public void setIva(double iva) {
        this.iva = iva;
    }

    /**
     * Devuelve el importe total de la factura, incluyendo el IVA.
     *
     * @return el total de la factura
     */
    public double getTotal() {
        return total;
    }

    /**
     * Establece el importe total de la factura.
     *
     * @param total el nuevo total; debe ser igual a {@code subtotal + iva}
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Devuelve una representación en cadena de texto de la factura, incluyendo
     * todos sus atributos.
     *
     * @return cadena con el formato:
     *         {@code Factura [id=X, fecha=Y, id_cliente=Z, id_empleado=W, subtotal=A, iva=B, total=C]}
     */
    @Override
    public String toString() {
        return "Factura [id=" + id + ", fecha=" + fecha + ", id_cliente=" + id_cliente
                + ", id_empleado=" + id_empleado + ", subtotal=" + subtotal
                + ", iva=" + iva + ", total=" + total + "]";
    }
}