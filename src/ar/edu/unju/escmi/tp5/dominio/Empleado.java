package ar.edu.unju.escmi.tp5.dominio;

public abstract class Empleado {
    // Atributos de la clase Empleados
    protected int idEmpleado;
    protected String nombre;
    protected String apellido;
    protected int dni;
    protected String domicilio;

    // Constructor por defecto
    public Empleado() {
    }

    // Constructor parametrizado
    public Empleado(int idEmpleado, String nombre, String apellido, int dni, String domicilio) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
    }

    // Setters para modificar los atributos
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    // Getters para obtener los valores de los atributos
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDni() {
        return dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", domicilio='" + domicilio + '\'' +
                '}';
    }
}