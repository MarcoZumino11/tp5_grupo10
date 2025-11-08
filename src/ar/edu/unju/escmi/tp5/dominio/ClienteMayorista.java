package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMayorista extends Cliente {
    private int codigo;

    public ClienteMayorista() {
        // constructor vacío
    }

    // Constructor parametrizado (usa los atributos de la superclase)
    public ClienteMayorista(int dni, String nombre, String apellido, String direccion, int codigo) {
        super(dni, nombre, apellido, direccion);
        this.codigo = codigo;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Cliente Mayorista:");
        System.out.println("Nombre: " + getNombre() + " " + getApellido());
        System.out.println("DNI: " + getDni());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Código: " + codigo);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "ClienteMayorista{" +
                "dni=" + getDni() +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}
