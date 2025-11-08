package ar.edu.unju.escmi.tp5.principal;

import java.time.LocalDate;
import java.util.Scanner;

import ar.edu.unju.escmi.tp5.collections.CollectionCliente;
import ar.edu.unju.escmi.tp5.collections.CollectionEmpleado;
import ar.edu.unju.escmi.tp5.collections.CollectionProducto;
import ar.edu.unju.escmi.tp5.dominio.AgenteAdministrativo;
import ar.edu.unju.escmi.tp5.dominio.EncargadoDeVentas;
import ar.edu.unju.escmi.tp5.dominio.Factura;
import ar.edu.unju.escmi.tp5.dominio.Producto;
import ar.edu.unju.escmi.tp5.dominio.Cliente;
import ar.edu.unju.escmi.tp5.dominio.ClienteMayorista;
import ar.edu.unju.escmi.tp5.dominio.ClienteMinorista;
import ar.edu.unju.escmi.tp5.dominio.Detalle;

public class MenuPrincipal {

    static void menuCliente(Scanner sc) {
        byte op;
        do {
            System.out.println("\n **** Menu de Cliente ****");
            System.out.println("1 - Buscar Factura");
            System.out.println("2 - Salir");
            System.out.print("Ingrese una opcion: ");
            op = sc.nextByte();
            sc.nextLine(); // Para limpiar el buffer del scanner

            switch (op) {
                case 1:
                    System.out.println("Buscar Factura");
                    System.out.print("Ingrese el numero de factura a buscar: ");
                    byte numeroFactura = sc.nextByte();
                    sc.nextLine(); // Para limpiar el buffer del scanner
                    Cliente.buscarFactura(numeroFactura); // muestra por consola la factura solicitada
                    delay(3000); // pausa 3 segundos
                    break;
                case 2:
                    System.out.println("Saliendo del Menu de Clientes...");
                    delay(1000); // pausa 1 segundo
                    break;
                default:
                    System.out.println("Opcion incorrecta. Intente nuevamente.");
            }
        } while (op != 2);

    }

    static void menuEmpleado(Scanner sc) {
        byte op;
        byte op2;
        byte op3;
        do {
            System.out.println("\n **** Menu de Empleados ****");
            System.out.println("1 - Menu Encargado de Ventas");
            System.out.println("2 - Menu Agente Administrativo");
            System.out.println("3 - Salir");
            System.out.print("Ingrese una opcion: ");
            op = sc.nextByte();
            sc.nextLine(); // Para limpiar el buffer del scanner

            switch (op) {
                case 1:
                    System.out.println("\nMenu Encargado de Ventas");
                    do {
                        System.out.println("1 - Mostrar Ventas");
                        System.out.println("2 - Verificar Stock");
                        System.out.println("3 - Mostrar Total de ventas");
                        System.out.println("4 - Salir");
                        System.out.print("Ingrese una opcion: ");
                        op2 = sc.nextByte();
                        sc.nextLine(); // Para limpiar el buffer del scanner

                        switch (op2) {
                            case 1:
                                System.out.println("Mostrar ventas");
                                EncargadoDeVentas.mostrarVentas(); // Muestra todas las ventas enumeradas
                                delay(3000); // pausa 3 segundos
                                break;
                            case 2:
                                System.out.println("Verificar Stock");
                                System.out.print("Ingrese el código del producto: ");
                                int codigoProducto = sc.nextInt();
                                EncargadoDeVentas.verificarStock(codigoProducto); // Pasa el código como argumento
                                sc.nextLine(); // Limpiar el buffer
                                delay(2000); // pausa 2 segundos
                                break;
                            case 3:
                                System.out.println("Mostrar Total de ventas");
                                EncargadoDeVentas.mostrarTotalVentas(); // suma el total de todas la facturas
                                delay(2000); // pausa 2 segundos
                                break;
                            case 4:
                                System.out.println("Saliendo del Menu Encargado de Ventas...");
                                delay(1000); // pausa 1 segundo
                                break;
                            default:
                                System.out.println("Opcion incorrecta. Intente nuevamente.");
                        }
                    } while (op2 != 4);
                    break;

                case 2:
                    System.out.println("\nMenu Agente Administrativo");
                    do {
                        System.out.println("1 - Dar Alta de Producto");
                        System.out.println("2 - Realizar Venta");
                        System.out.println("3 - Salir");
                        System.out.print("Ingrese una opcion: ");
                        op3 = sc.nextByte();
                        sc.nextLine(); // Para limpiar el buffer del scanner

                        switch (op3) {
                            case 1:
                                System.out.println("Dar Alta de Producto");
                                System.out.print("Ingrese código de producto: ");
                                int codigoProducto = sc.nextInt();
                                sc.nextLine(); // Limpiar buffer

                                System.out.print("Ingrese descripción: ");
                                String descripcion = sc.nextLine();

                                System.out.print("Ingrese precio unitario: ");
                                double precioUnitarioNuevo = sc.nextDouble();

                                int descuento;
                                do {
                                    System.out.print("Ingrese descuento (0, 25 o 30): ");
                                    descuento = sc.nextInt();
                                    if (descuento != 0 && descuento != 25 && descuento != 30) {
                                        System.out.println("Valor inválido. Solo se permite 0, 25 o 30.");
                                    }
                                } while (descuento != 0 && descuento != 25 && descuento != 30);

                                Producto productoNuevo = new Producto(codigoProducto, descripcion, precioUnitarioNuevo, descuento); //se crea el nuevo producto con los datos proporcionados

                                AgenteAdministrativo.altaProducto(productoNuevo);

                                System.out.println("Producto dado de alta correctamente.");
                                delay(2000); // pausa 2 segundos
                                break;
                            case 2:
                                System.out.println("Realizar Venta");
                                // Paso 1: Identificar cliente

                                Cliente cliente = AgenteAdministrativo.identificarCliente(); // Llama al metodo de Agente administrativo para identificar a que cliente se realiza la venta
                                if (cliente == null) {
                                    System.out.println("Cliente no encontrado. No se puede continuar con la venta.");
                                    return;
                                }

                                // Paso 2: Crear factura
                                LocalDate fecha = LocalDate.now();
                                Factura factura = new Factura(fecha, cliente);
                                boolean seguirComprando = true;
                                while (seguirComprando) {
                                    // Paso 3: Selección de producto
                                    System.out.print("Ingrese el código del producto: ");
                                    int codigoProductoVenta = sc.nextInt();

                                    Producto producto = CollectionProducto.buscarProducto(codigoProductoVenta);
                                    if (producto == null) {
                                        System.out.println("Producto no encontrado.");
                                        continue;
                                    }

                                    System.out.print("Ingrese la cantidad (de paquetes si es mayorista, de unidades si es minorista): ");
                                    int cantidad = sc.nextInt();
                                    sc.nextLine(); // Para limpiar el buffer del scanner

                                    double precioUnitario = producto.getPrecioUnitario();

                                    if (producto.getStock() < cantidad) {
                                        System.out.println("Stock insuficiente. Stock disponible: " + producto.getStock());
                                    } else {
                                        // Paso 4: Calcular precio según tipo de cliente y descuento de producto
                                        if (producto.getDescuento() == 25) {
                                            precioUnitario = precioUnitario * 0.75;
                                        } else if (producto.getDescuento() == 30) {
                                            precioUnitario = precioUnitario * 0.70;
                                        }

                                        if (cliente instanceof ClienteMayorista) {
                                            precioUnitario = precioUnitario / 2; // precio mayorista
                                        } else if (cliente instanceof ClienteMinorista) {
                                            ClienteMinorista cm = (ClienteMinorista) cliente;// Se convierte la referencia de tipo Cliente a tipo ClienteMinorista para usar todos los métodos y atributos de ClienteMinorista
                                            precioUnitario = cm.aplicarDescuento(precioUnitario);// Verifica si el cliente minorista recibe descuento del 10%
                                            }
                                        }

                                        // Crear detalle
                                        Detalle detalle = new Detalle(producto, cantidad, precioUnitario);
                                        factura.agregarDetalle(detalle);

                                        // Actualizar stock
                                        producto.setStock(producto.getStock() - cantidad);

                                        System.out.println("Detalle agregado con exito ");
                                        // Paso 5: Preguntar si sigue comprando
                                        System.out.print("¿Desea agregar otro producto? (s/n): ");
                                        String opcion = sc.next();
                                        seguirComprando = opcion.equalsIgnoreCase("s");
                                    }
                            
                                // Paso 6: Guardar factura
                                AgenteAdministrativo.realizarVenta(factura);
                                delay(3000); // pausa 3 segundos
                                break;
                            case 3:
                                System.out.println("Saliendo del Menu Agente Administrativo...");
                                delay(1000); // pausa 1 segundos
                                break;
                            default:
                                System.out.println("Opcion incorrecta. Intente nuevamente.");
                        }
                    } while (op3 != 3);
                    break;
                case 3:
                    System.out.println("Saliendo del Menu de Empleados...");
                    delay(1000);
                    break;
                default:
                    System.out.println("Opcion incorrecta. Intente nuevamente.");
            }
        } while (op != 3);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte op;
        CollectionCliente.precargarCliente();
        CollectionEmpleado.precargarEmpleado();
        CollectionProducto.precargarProducto();

        do {

            System.out.println("\n **** Menu de Opciones ****");
            System.out.println("1 - Menu de Clientes");
            System.out.println("2 - Menu de Empleados");
            System.out.println("3 - Salir");
            System.out.print("Ingrese una opcion: ");
            op = sc.nextByte();
            sc.nextLine(); // Para limpiar el buffer del scanner

            switch (op) {
                case 1:
                    menuCliente(sc); // Llama al menu de clientes
                    break;
                case 2:
                    menuEmpleado(sc); // Llama al menu de empleados
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion incorrecta. Intente nuevamente.");
            }

        } while (op != 3);

        sc.close();
    }

    
    //metodo para agregar una pausa luego de ejecutar cada opcion del menú (mejor visibilidad)
    public static void delay(int milisegundos) {
    try {
        Thread.sleep(milisegundos);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}
}