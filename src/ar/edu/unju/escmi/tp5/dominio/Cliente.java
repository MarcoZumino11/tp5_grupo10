package ar.edu.unju.escmi.tp5.dominio;

public abstract class Cliente { // Clase base abstracta
// Atributos comunes
    private int dni;
    private String nombre;
    private String direccion;
// Constructor
    public Cliente(int dni, String nombre, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
    }
// Getters
    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
// Método abstracto para mostrar datos
    public void mostrarDatos() {
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
    }
}
