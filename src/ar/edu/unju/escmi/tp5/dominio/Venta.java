package ar.edu.unju.escmi.tp5.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp5.collections.CollectionStock; 
import ar.edu.unju.escmi.tp5.collections.CollectionFactura;

// Representa una venta realizada a un cliente
public class Venta { 
    private Cliente cliente;
    private LocalDate fecha;
    private int numeroFactura;
    private List<Detalle> detalle; // lista de detalles de la venta
    private double total;

// Constructor
    public Venta(Cliente cliente, int numeroFactura) {
        this.cliente = cliente;
        this.numeroFactura = numeroFactura;
        this.fecha = LocalDate.now();
        this.detalle = new ArrayList<>();
        this.total = 0.0;
    }
    
// Agrega un detalle a la venta
    public void agregarDetalle(Detalle d) {
        detalle.add(d);
    }

// Calcula el total de la venta, aplicando descuentos si corresponde
    public double calcularTotal() {
        double suma = 0.0; 
        for (Detalle d : detalle) suma += d.getImporte();  
        // si es ClienteMinorista con descuento por PAMI, aplicarlo sobre total
        if (cliente instanceof ClienteMinorista) { 
            double desc = ((ClienteMinorista) cliente).getDescuento();
            suma = suma * (1 - desc); 
        }
        this.total = suma;
        return suma;
    }

    // realiza la venta: actualiza stock y crea factura en collection
    public void realizarVenta() { 
        // restar las cantidades del stock
        for (Detalle d : detalle) {
            int cod = d.getProducto().getCodigo();
            // buscar stock
            Stock s = CollectionStock.buscarStockPorCodigo(cod);
            if (s != null) { // si se encuentra el stock, actualizar
                s.actualizarStock(-d.getCantidad());
            } else { 
                System.out.println("Stock no encontrado para producto " + cod);
            }
        }
        calcularTotal();
        // crear factura y guardarla en collection
        Factura f = new Factura(this);
        CollectionFactura.agregarFactura(f);
    }
// Muestra los datos de la venta
    public int getNumeroFactura() { return numeroFactura; }
    public List<Detalle> getDetalle() { return detalle; }
    public double getTotal() { return total; }
    public Cliente getCliente() { return cliente; }
    public LocalDate getFecha() { return fecha; }
}
