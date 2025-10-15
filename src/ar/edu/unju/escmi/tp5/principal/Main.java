package ar.edu.unju.escmi.tp5.principal;

import ar.edu.unju.escmi.tp5.collections.*;
import ar.edu.unju.escmi.tp5.dominio.*;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in); 
    private static int nroFacturaSeq = 1; // Secuencia para números de factura

    public static void main(String[] args) { 
        precargaDatos();
        menuPrincipal();
    }

    // ===========================
    // Precarga inicial de datos
    // ===========================
    private static void precargaDatos() { 
        CollectionProducto.precargarProductos();
        CollectionStock.precargarStock();
        CollectionCliente.precargarClientes();
        CollectionFactura.precargarFacturas(); 
        nroFacturaSeq = CollectionFactura.facturas.size() + 1;
    }

    // ===========================
    // Menú Principal
    // ===========================
    private static void menuPrincipal() { 
        boolean salir = false; 
        while (!salir) { 
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Encargado de Ventas");
            System.out.println("2. Cliente");
            System.out.println("3. Agente Administrativo");
            System.out.println("4. Salir");
            System.out.print("Elegir: ");
            int op = Integer.parseInt(sc.nextLine()); 
            switch (op) { 
                case 1: menuEncargado(); break;
                case 2: menuCliente(); break;
                case 3: menuAgente(); break;
                case 4: salir = true; break;
                default: System.out.println("Opción inválida");
            }
        }
    }

    // ===========================
    // Menú Encargado de Ventas
    // ===========================
    private static void menuEncargado() { 
        System.out.println("\n--- ENCARGADO ---");
        System.out.println("1. Mostrar facturas");
        System.out.println("2. Mostrar total de todas las ventas");
        System.out.println("3. Verificar stock por producto");
        System.out.print("Elegir: ");
        int op = Integer.parseInt(sc.nextLine());
        switch (op) {
            case 1:
                System.out.println("Cantidad de facturas: " + CollectionFactura.facturas.size());
                for (Factura f : CollectionFactura.facturas) {
                    f.mostrarEncabezado(); 
                    f.mostrarDetalle();
                }
                break;
            case 2:
                double total = CollectionFactura.totalVentas();
                System.out.println("Total ventas: $" + total);
                break;
            case 3:
                System.out.print("Ingrese código de producto: ");
                int cod = Integer.parseInt(sc.nextLine());
                System.out.println("Stock: " + CollectionStock.verificarStock(cod));
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    // ===========================
    // Menú Cliente
    // ===========================
    private static void menuCliente() { 
        System.out.println("\n--- CLIENTE ---");
        System.out.print("Ingrese número de factura: ");
        int nro = Integer.parseInt(sc.nextLine());
        Factura f = CollectionFactura.buscarFactura(nro);
        if (f == null) System.out.println("Factura no encontrada.");
        else {
            f.mostrarEncabezado();
            f.mostrarDetalle();
        }
    }

    // ===========================
    // Menú Agente Administrativo
    // ===========================
    private static void menuAgente() { 
        System.out.println("\n--- AGENTE ---");
        System.out.println("1. Alta de producto");
        System.out.println("2. Realizar factura (venta)");
        System.out.print("Elegir: ");
        int op = Integer.parseInt(sc.nextLine());
        switch (op) {
            case 1: 
                altaProducto();
                break;
            case 2:
                realizarFacturaInteractiva();
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    // ===========================
    // Alta de producto
    // ===========================
    private static void altaProducto() {
        System.out.print("Código: ");
        int cod = Integer.parseInt(sc.nextLine());
        if (CollectionProducto.buscarProducto(cod) != null) {
            System.out.println("Producto ya existe.");
            return;
        }
        System.out.print("Descripción: ");
        String desc = sc.nextLine();
        System.out.print("Precio unitario: ");
        double pu = Double.parseDouble(sc.nextLine());
        System.out.print("Descuento (0,25,30): ");
        double d = Double.parseDouble(sc.nextLine());
        Producto p = new Producto(cod, desc, pu, d);
        CollectionProducto.agregarProducto(p);
        System.out.print("Cantidad inicial en stock: ");
        int cant = Integer.parseInt(sc.nextLine());
        CollectionStock.agregarStock(new Stock(p, cant));
        System.out.println("Producto agregado correctamente.");
    }

    // ===========================
    // Realizar factura / venta
    // ===========================
    private static void realizarFacturaInteractiva() {
        System.out.println("\n--- REALIZAR FACTURA ---");
        System.out.print("DNI cliente (0 para mayorista sin DNI): ");
        int dni = Integer.parseInt(sc.nextLine());
        Cliente c = CollectionCliente.buscarClientePorDni(dni);

        if (dni == 0) { 
            System.out.print("Nombre mayorista: ");
            String nombre = sc.nextLine();
            c = CollectionCliente.crearClienteMayorista(nombre);
        } else if (c == null) { 
            System.out.println("Cliente no encontrado. Registrando nuevo cliente...");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Dirección: ");
            String direccion = sc.nextLine();
            System.out.print("Obra social: ");
            String obraSocial = sc.nextLine();
            System.out.print("¿Tiene descuento PAMI? (true/false): ");
            boolean pami = Boolean.parseBoolean(sc.nextLine());
            c = CollectionCliente.crearClienteMinorista(dni, nombre, direccion, obraSocial, pami);
        }

        Factura f = new Factura(c, nroFacturaSeq++);
        boolean seguir = true;
        while (seguir) {
            System.out.print("Código producto: ");
            int codP = Integer.parseInt(sc.nextLine());
            Producto prod = CollectionProducto.buscarProducto(codP);
            if (prod == null) {
                System.out.println("Producto no existe.");
                System.out.print("¿Desea continuar agregando? (s/n): ");
                if (!sc.nextLine().equalsIgnoreCase("s")) seguir = false;
                continue;
            }

            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(sc.nextLine());

            double precioUnitarioUsado;
            if (c instanceof ClienteMayorista) {
                if (cantidad % 10 != 0) {
                    System.out.println("Mayorista debe comprar en bultos de 10 unidades. Ajustando a múltiplo inferior.");
                    cantidad = (cantidad / 10) * 10;
                }
                precioUnitarioUsado = prod.aplicarDescuento() / 2.0;
            } else {
                precioUnitarioUsado = prod.aplicarDescuento();
            }

            Stock s = CollectionStock.buscarStockPorCodigo(codP);
            if (s == null || s.getCantidadTotal() < cantidad) {
                System.out.println("Stock insuficiente o producto sin stock.");
            } else {
                Detalle det = new Detalle(prod, cantidad, precioUnitarioUsado);
                f.agregarDetalle(det);
                s.actualizarStock(-cantidad);
            }

            System.out.print("¿Agregar otro producto? (s/n): ");
            if (!sc.nextLine().equalsIgnoreCase("s")) seguir = false;
        }

        f.calcularTotal();
        CollectionFactura.agregarFactura(f);

        System.out.println("Factura generada. Total: $" + f.getTotal());
        System.out.println("Número de factura: " + f.getNumeroFactura());
    }
}