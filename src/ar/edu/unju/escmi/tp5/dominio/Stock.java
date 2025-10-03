package ar.edu.unju.escmi.tp5.dominio;

public class Stock {
    private Producto producto; 
    private int cantidadTotal; // Cantidad disponible en stock
// Constructor
    public Stock(Producto producto, int cantidadTotal) {
        this.producto = producto;
        this.cantidadTotal = cantidadTotal;
    }
// Getters
    public Producto getProducto() { return producto; }
    public int getCantidadTotal() { return cantidadTotal; } 

    public void actualizarStock(int delta) { 
        this.cantidadTotal += delta; // delta puede ser negativo (venta) o positivo (alta)
    }

    // Verifica si el producto con código codProd está en stock y devuelve la cantidad disponible sino devuelve -1 
    public int verificarStock(int codProd) {
        if (producto.getCodigo() != codProd) return -1; 
        return cantidadTotal; 
    }

    @Override
    public String toString() { 
        return producto.toString() + " - Cantidad en stock: " + cantidadTotal; // Muestra el stock
    }
}
