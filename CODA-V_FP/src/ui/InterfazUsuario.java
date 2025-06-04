package ui;

import negocio.Inventario;
import modelo.Producto;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que maneja la interfaz de usuario del sistema de gestión de inventario
 */
public class InterfazUsuario {
    private Scanner scanner;
    private Inventario inventario;

    public InterfazUsuario() {
        scanner = new Scanner(System.in);
        inventario = new Inventario();
    }

    /**
     * Muestra el menú principal del sistema
     */
    public void mostrarMenu() {
        System.out.println("========================================");
        System.out.println("Sistema de Gestión de Inventario");
        System.out.println("========================================");
        System.out.println("1. Agregar producto");
        System.out.println("2. Consultar inventario");
        System.out.println("3. Actualizar producto");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Calcular valor total del inventario");
        System.out.println("6. Acerca de");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Ejecuta el bucle principal del programa
     */
    public void ejecutar() {
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    consultarInventario();
                    break;
                case 3:
                    actualizarProducto();
                    break;
                case 4:
                    eliminarProducto();
                    break;
                case 5:
                    calcularValorTotal();
                    break;
                case 6:
                    mostrarAcercaDe();
                    break;
                case 7:
                    salir = true;
                    System.out.println("Gracias por usar el Sistema de Gestión de Inventario.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }

            if (opcion != 7) {
                esperarEnter();
            }
        }
    }

    /**
     * Obtiene una opción seleccionada por el usuario
     * @return La opción seleccionada como entero
     */
    private int obtenerOpcion() {
        while (!scanner.hasNextInt()) {
            scanner.next(); // Descartar entrada no válida
            System.out.print("Por favor, ingrese un número válido: ");
        }
        return scanner.nextInt();
    }

    /**
     * Solicita al usuario los datos para agregar un nuevo producto
     */
    private void agregarProducto() {
        System.out.print("Ingrese el ID del producto: ");
        String id = scanner.next();

        if (inventario.obtenerProductoPorId(id) != null) {
            System.out.println("Error: Ya existe un producto con ese ID.");
            return;
        }

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.next();

        System.out.print("Ingrese la cantidad del producto: ");
        int cantidad = obtenerNumeroEntero();

        System.out.print("Ingrese el precio del producto: ");
        double precio = obtenerNumeroDouble();

        Producto producto = new Producto(id, nombre, cantidad, precio);

        if (inventario.agregarProducto(producto)) {
            System.out.println("Producto agregado exitosamente.");
        } else {
            System.out.println("Error al agregar el producto.");
        }
    }

    /**
     * Muestra todos los productos en el inventario
     */
    private void consultarInventario() {
        List<Producto> inventarioCompleto = inventario.consultarInventario();

        if (inventarioCompleto.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }

        System.out.println("Inventario:");
        for (Producto producto : inventarioCompleto) {
            System.out.println("ID: " + producto.getId() +
                    ", Nombre: " + producto.getNombre() +
                    ", Cantidad: " + producto.getCantidad() +
                    ", Precio: $" + producto.getPrecio());
        }
    }

    /**
     * Solicita al usuario los datos para actualizar un producto existente
     */
    private void actualizarProducto() {
        System.out.print("Ingrese el ID del producto a actualizar: ");
        String id = scanner.next();

        System.out.print("Ingrese el nuevo nombre del producto: ");
        String nombre = scanner.next();

        System.out.print("Ingrese la nueva cantidad del producto: ");
        int cantidad = obtenerNumeroEntero();

        System.out.print("Ingrese el nuevo precio del producto: ");
        double precio = obtenerNumeroDouble();

        if (inventario.actualizarProducto(id, nombre, cantidad, precio)) {
            System.out.println("Producto actualizado exitosamente.");
        } else {
            System.out.println("Error: No se encontró el producto con el ID especificado.");
        }
    }

    /**
     * Solicita al usuario el ID de un producto para eliminarlo
     */
    private void eliminarProducto() {
        System.out.print("Ingrese el ID del producto a eliminar: ");
        String id = scanner.next();

        if (inventario.eliminarProducto(id)) {
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("Error: No se encontró el producto con el ID especificado.");
        }
    }

    /**
     * Calcula y muestra el valor total del inventario
     */
    private void calcularValorTotal() {
        double valorTotal = inventario.calcularValorTotal();
        System.out.println("El valor total del inventario es: $" + valorTotal);
    }

    /**
     * Muestra información sobre el equipo desarrollador
     */
    private void mostrarAcercaDe() {
        System.out.println("========================================");
        System.out.println("Sistema de Gestión de Inventario");
        System.out.println("Versión 1.0");
        System.out.println("Desarrollado por:CODA-V");
        System.out.println("Miembros: Cristian Alberto Vargas (Product Owner).\n" +
                "Daniela Ximena Ortiz (Scrum Master).\n" +
                "Frank Sebastián Valderrama (Development Team).\n" +
                "Roberth Arley López (Development Team).");
        System.out.println("Fecha: 03 de Junio de 2025");
        System.out.println("Eslogan: \"Ordena, controla, evoluciona\"");
        System.out.println("========================================");
    }

    /**
     * Espera a que el usuario presione Enter para continuar
     */
    private void esperarEnter() {
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine(); // Limpiar el buffer
        scanner.nextLine(); // Esperar la pulsación de Enter
    }

    /**
     * Valida y obtiene un número entero del usuario
     * @return Un número entero válido
     */
    private int obtenerNumeroEntero() {
        while (!scanner.hasNextInt()) {
            scanner.next(); // Descartar entrada no válida
            System.out.print("Por favor, ingrese un número entero válido: ");
        }
        return scanner.nextInt();
    }

    /**
     * Valida y obtiene un número double del usuario
     * @return Un número double válido
     */
    private double obtenerNumeroDouble() {
        while (!scanner.hasNextDouble()) {
            scanner.next(); // Descartar entrada no válida
            System.out.print("Por favor, ingrese un número válido: ");
        }
        return scanner.nextDouble();
    }
}
