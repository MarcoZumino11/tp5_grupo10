package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionFactura { // Colección estática para gestionar facturas
    public static List<Factura> facturas = new ArrayList<>();

    // Precarga de una factura de ejemplo
    public static void precargarFacturas() {
    Cliente c = CollectionCliente.buscarClientePorDni(12345678);
    Producto p = CollectionProducto.buscarProducto(1002);

    if (c != null && p != null) { // Verifica que el cliente y producto existan
        Detalle d = new Detalle(p, 2, p.aplicarDescuento());
        int nro = facturas.size() + 1; // Genera un número de factura secuencial
        Venta v = new Venta(c, nro); 
        v.agregarDetalle(d); //
        v.realizarVenta();
        Factura f = new Factura(v); // crea la factura
        agregarFactura(f);
    } else {
        System.out.println("Precarga de factura fallida: cliente o producto no encontrados.");
    }
}

    public static void agregarFactura(Factura f) { // Agrega una factura si no existe ya
    if (buscarFactura(f.getNumeroFactura()) == null) {
        facturas.add(f);
    } 
}


    public static Factura buscarFactura(int numero) { // Busca una factura por su número
        for (Factura f : facturas) {
            if (f.getNumeroFactura() == numero) return f; 
        }
        return null;
    }

    public static double totalVentas() { // Calcula el total de todas las ventas
        double suma = 0;
        for (Factura f : facturas) {
            suma += f.getTotalFactura(); // suma los totales de cada factura
        }
        return suma;
    }
}

