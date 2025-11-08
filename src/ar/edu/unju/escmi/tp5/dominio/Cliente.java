package ar.edu.unju.escmi.tp5.dominio;

import ar.edu.unju.escmi.tp5.collections.CollectionFactura;

public abstract class Cliente {
    // Atributos privados según diagrama
    private int dni;
    private String nombre;
    private String apellido;
    private String direccion;

    public Cliente() {
        // Constructor vacio
    }

    // Constructor parametrizado
    public Cliente(int dni, String nombre, String apellido, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    // Getters y Setters
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Método para buscar factura
    public static void buscarFactura(int numeroFactura) {
        Factura factura = CollectionFactura.buscarFactura(numeroFactura);
        if (factura != null) {
            System.out.println("Factura encontrada: ");
            factura.mostrarFactura();
        } else {
            System.out.println("No se encontró la factura con número: " + numeroFactura);
        }
    }

    // Método abstracto mostrarDatos
    public abstract void mostrarDatos();

    @Override
    public String toString() {
        return "Cliente{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

}