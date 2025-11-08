package ar.edu.unju.escmi.tp5.collections;

import java.util.HashMap;
import java.util.Map;
import ar.edu.unju.escmi.tp5.dominio.Cliente;
import ar.edu.unju.escmi.tp5.dominio.ClienteMayorista;
import ar.edu.unju.escmi.tp5.dominio.ClienteMinorista;

public class CollectionCliente {
    public static Map<Integer, Cliente> clientes = new HashMap<>();

    public static void agregarCliente(Cliente cliente) {
        clientes.put(cliente.getDni(), cliente);
    }

    public static Cliente buscarCliente(int dni) {
        return clientes.get(dni);
    }

    public static void precargarCliente() {
        clientes.put(123, new ClienteMayorista(123, "Carlos", "Suarez", "Av. Siempre Viva", 1001));
        clientes.put(456, new ClienteMinorista(456, "Ana", "Ramirez", "Calle Belgrano", "PAMI"));
    }
}