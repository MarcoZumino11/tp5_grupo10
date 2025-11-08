package ar.edu.unju.escmi.tp5.dominio;

import java.util.Scanner;
import ar.edu.unju.escmi.tp5.collections.CollectionCliente;
import ar.edu.unju.escmi.tp5.collections.CollectionProducto;
import ar.edu.unju.escmi.tp5.collections.CollectionFactura;

public class AgenteAdministrativo extends Empleado {
    private static Scanner scanner = new Scanner(System.in);

    // Constructor por defecto
    public AgenteAdministrativo() {
    }

    // Constructor parametrizado
    public AgenteAdministrativo(int idEmpleado, String nombre, String apellido, int dni, String domicilio) {
        super(idEmpleado, nombre, apellido, dni, domicilio);
    }

    // Métodos
    public static void altaProducto(Producto producto) {
        CollectionProducto.agregarProducto(producto);
    }

    public static Cliente identificarCliente() {
        System.out.print("Ingrese DNI del cliente: ");
        int dni = scanner.nextInt();
        return CollectionCliente.buscarCliente(dni);
    }

    public static void realizarVenta(Factura factura) {
        factura.calcularTotal();
        CollectionFactura.agregarFactura(factura);
        System.out.println("Factura generada exitosamente:\n");
        factura.mostrarFactura();
    }

    @Override
    public String toString() {
        return "AgenteAdministrativo{" +
                "idEmpleado=" + getIdEmpleado() +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", dni=" + getDni() +
                ", domicilio='" + getDomicilio() + '\'' +
                '}';
    }
}