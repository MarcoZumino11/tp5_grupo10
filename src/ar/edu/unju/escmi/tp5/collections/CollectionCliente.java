package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.Cliente;
import ar.edu.unju.escmi.tp5.dominio.ClienteMayorista;
import ar.edu.unju.escmi.tp5.dominio.ClienteMinorista;
import java.util.ArrayList;
import java.util.List;

// Colección estática para gestionar clientes
public class CollectionCliente {
    public static List<Cliente> clientes = new ArrayList<>();

    // Precarga inicial de clientes
    public static void precargarClientes() {
        ClienteMayorista cm = new ClienteMayorista(0, "Distribuidor SRL", "CABA 123", 5001);
        ClienteMinorista cmin = new ClienteMinorista(12345678, "Juana Perez", "Av Falsa 123", "PAMI", true);
        agregarCliente(cm);  
        agregarCliente(cmin);
    }
// Crea y agrega un cliente minorista
public static Cliente crearClienteMinorista(int dni, String nombre, String direccion, String obraSocial, boolean tieneDescuentoPami) {
    ClienteMinorista nuevo = new ClienteMinorista(dni, nombre, direccion, obraSocial, tieneDescuentoPami);
    agregarCliente(nuevo);
    return nuevo;
}
// Crea y agrega un cliente mayorista
public static Cliente crearClienteMayorista(String nombre) {
    ClienteMayorista nuevo = new ClienteMayorista(0, nombre, "Sin dirección", 9999); 
    agregarCliente(nuevo);
    return nuevo;
}


    public static void agregarCliente(Cliente c) {
        clientes.add(c); // agrega un cliente a la lista
    }

    // Busca un cliente por su DNI
    public static Cliente buscarClientePorDni(int dni) {
        for (Cliente c : clientes) {
            if (c.getDni() == dni) return c; // retorna el cliente si lo encuentra
        }
        return null;
    }
}
