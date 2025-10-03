package ar.edu.unju.escmi.tp5.dominio;

public class Producto {
    private int codigo;
    private String descripcion;
    private double precioUnitario;
    private double descuento; // 0.0, 25.0 o 30.0 (porcentaje)
    // Constructor
    public Producto(int codigo, String descripcion, double precioUnitario, double descuento) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento; 
    }
    // Getters
    public int getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }
    public double getPrecioUnitario() { return precioUnitario; }
    public double getDescuento() { return descuento; }

    // precio por unidad considerando descuento del producto
    public double aplicarDescuento() {
        if (descuento <= 0) return precioUnitario; // Sin descuento
        return precioUnitario * (1 - descuento / 100.0); // Precio con descuento
    }

    @Override
    public String toString() {
        return codigo + " - " + descripcion + " - $" + precioUnitario + " - Desc: " + descuento + "%"; // Muestra el producto
    }
}
