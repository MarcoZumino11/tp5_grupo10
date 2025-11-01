package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMayorista extends Cliente {
    private int codigo;

    public ClienteMayorista() {
        // Constructor vacio
    }

    // Constructor parametrizado(con los atributos de la superclase)
    public ClienteMayorista(int dni, String nombre, String direccion, String apellido, int codigo) {
        super(dni, nombre, direccion, apellido);
        this.codigo = codigo;
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
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}