package ar.edu.unju.escmi.tp5.collections;

import java.util.HashMap;
import java.util.Map;
import ar.edu.unju.escmi.tp5.dominio.Factura;

public class CollectionFactura {
    public static Map<Integer, Factura> facturas = new HashMap<>();

    public static void agregarFactura(Factura factura) {
        facturas.put(factura.getNumeroFactura(), factura);
    }

    public static Factura buscarFactura(int numeroFactura) {
        return facturas.get(numeroFactura);
    }

    public static Map<Integer, Factura> getFacturas() {
        return facturas;
    }

    public static double totalVentas() {
        double total = 0;
        for (Factura factura : facturas.values()) {
            total += factura.calcularTotal();
        }
        return total;
    }
}