package ar.edu.unju.escmi.tp5.dominio;

public class Factura { 
    private Venta venta; 

    public Factura(Venta venta) { // Constructor
        this.venta = venta;
    }

    public int getNumeroFactura() { // Devuelve el número de factura de la venta asociada
        return venta.getNumeroFactura();
    }

    public double getTotalFactura() { // Devuelve el total de la venta asociada
        return venta.getTotal();
    }

    public Venta getVenta() { // Devuelve la venta asociada
        return venta;
    }

    public void mostrarEncabezado() { 
        System.out.println("Factura N°: " + getNumeroFactura() + " Fecha: " + venta.getFecha()); // Muestra el encabezado de la factura
        System.out.println("Cliente:");
        venta.getCliente().mostrarDatos();
        System.out.println("Total: $" + getTotalFactura()); // Muestra el total de la factura
    }

    public void mostrarDetalle() { // Muestra el detalle completo de la factura 
        System.out.println("Detalle:");
        for (Detalle d : venta.getDetalle()) {
            d.mostrarDetalle(); 
        }
    }
}
