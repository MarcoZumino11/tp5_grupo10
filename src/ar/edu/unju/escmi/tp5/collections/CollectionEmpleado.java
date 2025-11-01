package ar.edu.unju.escmi.tp5.collections;

import java.util.HashMap;
import java.util.Map;
import ar.edu.unju.escmi.tp5.dominio.Empleado;
import ar.edu.unju.escmi.tp5.dominio.EncargadoDeVentas;
import ar.edu.unju.escmi.tp5.dominio.AgenteAdministrativo;

public class CollectionEmpleado {
    public static Map<Integer, Empleado> empleados = new HashMap<>();

    public static void guardarEmpleado(Empleado empleado) {
        empleados.put(empleado.getIdEmpleado(), empleado);
    }

    public static void precargarEmpleado() {
        empleados.put(1, new EncargadoDeVentas(1, "Juan", "Pérez", 12345678, "Jujuy"));
        empleados.put(2, new AgenteAdministrativo(2, "Laura", "Gómez", 87654321, "Salta"));
    }
}