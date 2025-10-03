package ar.edu.unju.escmi.tp5.dominio;

public class Detalle {
    private Producto producto;
    private int cantidad;
    private double precioUnitario; // precio por unidad usado en la venta (ya con descuento de producto/mayorista)
    private double importe; 

    // Constructor
    public Detalle(Producto producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.importe = cantidad * precioUnitario;
    }
    // Getters
    public double getImporte() { return importe; } 
    public int getCantidad() { return cantidad; } 
    public Producto getProducto() { return producto; }

    public void mostrarDetalle() { // Muestra el detalle de la venta
        System.out.println(producto.getDescripcion() + " | Cant: " + cantidad + " | P.unit: $" + precioUnitario + " | Importe: $" + importe);
    }
}
