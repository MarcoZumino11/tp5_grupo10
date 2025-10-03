package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMayorista extends Cliente {
    private int codigo; // Código único para cada cliente mayorista

    // Constructor
    public ClienteMayorista(int dni, String nombre, String direccion, int codigo) {
        super(dni, nombre, direccion); // Llamada al constructor de la clase base
        this.codigo = codigo;
    }
    // Getter
    public int getCodigo() {
        return codigo;
    }

    @Override // Implementación del método abstracto
    public void mostrarDatos() { 
        super.mostrarDatos();
        System.out.println("Código Cliente Mayorista: " + codigo);
    }
}
