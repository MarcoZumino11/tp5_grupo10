package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMinorista extends Cliente {
    private String obraSocial;

    public ClienteMinorista() {
        // constructor vacío
    }

    // Constructor parametrizado (usa los atributos de la superclase)
    public ClienteMinorista(int dni, String nombre, String apellido, String direccion, String obraSocial) {
        super(dni, nombre, apellido, direccion);
        this.obraSocial = obraSocial;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Cliente Minorista:");
        System.out.println("Nombre: " + getNombre() + " " + getApellido());
        System.out.println("DNI: " + getDni());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Obra Social: " + obraSocial);
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    @Override
    public String toString() {
        return "ClienteMinorista{" +
                "dni=" + getDni() +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", obraSocial='" + obraSocial + '\'' +
                '}';
    }

    // Aplica descuento según obra social (ejemplo: PAMI 10%)
    public double aplicarDescuento(double precio) {
        if (obraSocial != null && obraSocial.equalsIgnoreCase("PAMI")) {
            return precio * 0.9; // 10% de descuento
        }
        return precio; // sin descuento
    }
}
