package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMinorista extends Cliente {
    private String obraSocial;
    private double descuento; // 0.10 si aplica

    // Constructor
    public ClienteMinorista(int dni, String nombre, String direccion, String obraSocial, boolean presentaDni) { 
        super(dni, nombre, direccion);
        this.obraSocial = obraSocial;
        this.descuento = (presentaDni && "PAMI".equalsIgnoreCase(obraSocial)) ? 0.10 : 0.0; // 10% de descuento si presenta DNI y obra social es PAMI
    }
    // Getters
    public String getObraSocial() { return obraSocial; } 
    public double getDescuento() { return descuento; }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Obra Social: " + obraSocial + " - Descuento aplicado: " + (descuento * 100) + "%");
    }
}
