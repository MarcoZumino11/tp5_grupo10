package ar.edu.unju.escmi.tp5.dominio;

import ar.edu.unju.escmi.tp5.collections.CollectionFactura;

public abstract class Cliente {
    // Atributos protegidos
    protected int dni;
    protected String nombre;
    protected String apellido;
    protected String direccion;

    public Cliente() {
        // Constructor vacio
    }

    // Constructor parametrizado
    public Cliente(int dni, String nombre, String direccion, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.apellido = apellido;
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

    public String getdireccion() {
        return direccion;
    }

    public void setdireccion(String direccion) {
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