package ar.edu.unju.escmi.tp5.dominio;

public class Producto {
    private int codigoProducto;
    private String descripcion;
    private double precioUnitario;
    private double descuento;
    private int stock;

    // Constructor por defecto
    public Producto() {
    }

    // Constructor parametrizado
    public Producto(int codigoProducto, String descripcion, double precioUnitario, double descuento) {
        this.codigoProducto = codigoProducto;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
        this.stock = 5000;
    }

    // Setters para modificar los atributos
    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;

    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    // Getters para obtener los valores de los atributos
    public int getCodigoProducto() {
        return codigoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public double getDescuento() {
        return descuento;
    }

}
