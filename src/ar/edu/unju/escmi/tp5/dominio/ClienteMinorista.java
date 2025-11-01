package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMinorista extends Cliente {
    private String obraSocial;

    public ClienteMinorista() {
        // Constructor vacio
    }

    // Constructor parametrizado(con los atributos de la superclase)
    public ClienteMinorista(int dni, String nombre, String apellido, String direccion, String obraSocial) {
        super(dni, nombre, direccion, apellido);
        this.obraSocial = obraSocial;
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
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", obraSocial='" + obraSocial + '\'' +
                '}';
    }

    public double aplicarDescuento(double precio) {
        if (this.dni != 0) {
            if (this.obraSocial.equalsIgnoreCase("PAMI")) {
                System.out.println("El cliente tiene un descuento del 10% en la compra.");
                return precio * 0.9; // Aplica 10% de descuento
            } else {
                System.out.println("El cliente no tiene descuento.");
                return precio; // No hay descuento
            }
        } else {
            System.out.println("El cliente no esta identificado.");
            return precio; // No hay descuento
        }
    }

}