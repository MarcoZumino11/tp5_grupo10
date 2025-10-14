package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.Stock;
import ar.edu.unju.escmi.tp5.dominio.Producto;
import java.util.ArrayList;
import java.util.List;

public class CollectionStock { // Colección estática para gestionar stocks
    public static List<Stock> stocks = new ArrayList<>();

    // Precarga inicial de stock
    public static void precargarStock() {
        Producto p1 = CollectionProducto.buscarProducto(1002);
        Producto p2 = CollectionProducto.buscarProducto(1003);

        if (p1 != null) agregarStock(new Stock(p1, 5000)); 
        if (p2 != null) agregarStock(new Stock(p2, 2000));
    }

    public static void agregarStock(Stock s) { // Agrega un stock a la lista
        stocks.add(s); 
    }

    public static Stock buscarStockPorCodigo(int codigo) { // Busca un stock por el código del producto
        for (Stock s : stocks) {
            if (s.getProducto().getCodigo() == codigo) return s;
        }
        return null;
    }

    public static void actualizarStock(int codigo, int delta) { // Actualiza el stock de un producto
        Stock s = buscarStockPorCodigo(codigo);
        if (s != null) s.actualizarStock(delta); 
    }

    public static int verificarStock(int codigo) { // Verifica el stock de un producto por su código
        Stock s = buscarStockPorCodigo(codigo);
        if (s == null) return -1;
        return s.getCantidadTotal(); // Retorna la cantidad disponible
    }
}
