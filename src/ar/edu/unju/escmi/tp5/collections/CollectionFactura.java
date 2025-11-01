package ar.edu.unju.escmi.tp5.collections;

import java.util.HashMap;
import java.util.Map;
import ar.edu.unju.escmi.tp5.dominio.Factura;

public class CollectionFactura {
    // La clave del map tiene que ser el numero de factura
    public static Map<Integer, Factura> facturas = new HashMap<>();

    public static void guardarFactura(Factura factura) {
        facturas.put(factura.getNumeroFactura(), factura);
    }

    public static Factura buscarFactura(int numeroFactura) {
        return facturas.get(numeroFactura);
    }

    public static Map<Integer, Factura> getFacturas() {
        return facturas;
    }
}