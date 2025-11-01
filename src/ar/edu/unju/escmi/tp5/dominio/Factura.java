package ar.edu.unju.escmi.tp5.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private LocalDate fecha;
    private Cliente cliente;
    private List<Detalle> detalles = new ArrayList<>();
    private static int contador = 1;
    private int numeroFactura;

    public Factura() {

    }

    public Factura(LocalDate fecha, Cliente cliente) {
        this.numeroFactura = contador ++;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    public void agregarDetalle(Detalle detalle) {
        detalles.add(detalle);
    }

    public double calcularTotal() {
        double total = 0;
        for (Detalle d : detalles) {
            total += d.calcularImporte();
        }
        return total;
    }

    public void mostrarFactura() {
        System.out.println("----- FACTURA -----");
        System.out.println("N°: " + getNumeroFactura());
        System.out.println("Fecha: " + fecha);
        System.out.println("Cliente: " + cliente.nombre + " " + cliente.apellido );
        System.out.println("DNI: " + cliente.dni);
        System.out.println("Dirección: " + cliente.direccion);
        System.out.println("-------------------");
        System.out.println("DETALLE:");
        for (Detalle d : detalles) {
            System.out.println("Cantidad: " + d.getCantidad() + "\n" +
                    "Descripción: " + d.getProducto().getDescripcion() + "\n" +
                    "Precio Unitario: " + d.getProducto().getPrecio() + "\n" +
                    "Precio Unitario con Descuento: " + d.getPrecioCalculadoConDescuento() + "\n" +
                    "Importe: " + d.calcularImporte());
            System.out.println("-------------------");
        }
        System.out.println("TOTAL: " + calcularTotal());
    }
}