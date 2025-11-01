package ar.edu.unju.escmi.tp5.dominio;

public class Detalle {
    private int cantidad;
    private Producto producto;
    private double precioCalculadoConDescuento;

    public Detalle() {
    }

    public Detalle(Producto producto, int cantidad, double precioCalculadoConDescuento) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.precioCalculadoConDescuento = precioCalculadoConDescuento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(byte cantidad) {
        this.cantidad = cantidad;
    }

    public double calcularImporte() {
        return cantidad * precioCalculadoConDescuento;
    }
    
    public double getPrecioCalculadoConDescuento() {
        return precioCalculadoConDescuento;
    }

}