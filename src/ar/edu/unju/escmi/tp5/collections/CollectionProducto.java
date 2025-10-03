package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.Producto;
import java.util.ArrayList;
import java.util.List;

public class CollectionProducto { // Colección estática para gestionar productos
    public static List<Producto> productos = new ArrayList<>();

    // Precarga inicial de productos
    public static void precargarProductos() {
        Producto p1 = new Producto(1002, "Fideo Knorr Spaghetti x500gr", 1200.00, 0.0);
        Producto p2 = new Producto(1003, "Arroz Gallo 1kg", 900.00, 25.0);
        agregarProducto(p1);
        agregarProducto(p2);
    }

    public static void agregarProducto(Producto p) { // Agrega un producto a la lista
        productos.add(p);
    }

    public static Producto buscarProducto(int codigo) { // Busca un producto por su código
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) return p; 
        }
        return null;
    }
}
