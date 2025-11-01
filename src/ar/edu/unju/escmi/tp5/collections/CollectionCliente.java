package ar.edu.unju.escmi.tp5.collections;

import java.util.HashMap;
import java.util.Map;
import ar.edu.unju.escmi.tp5.dominio.Cliente;
import ar.edu.unju.escmi.tp5.dominio.ClienteMayorista;
import ar.edu.unju.escmi.tp5.dominio.ClienteMinorista;

public class CollectionCliente {
    // La clave del map tiene que ser el DNI
    public static Map<Integer, Cliente> clientes = new HashMap<>();

    public static void guardarCliente(Cliente cliente) {
        clientes.put(cliente.getDni(), cliente);
    }

    public static Cliente buscarCliente(int dni) {
        return clientes.get(dni);
    }

    public static void precargarCliente() {
        clientes.put(123, new ClienteMayorista(123, "Carlos", "Av. Siempre Viva", "Suarez", 1001));
        clientes.put(456, new ClienteMinorista(456, "Ana", "Calle Belgrano", "Ramirez", "PAMI"));
    }
}