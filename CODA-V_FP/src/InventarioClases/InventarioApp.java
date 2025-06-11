package InventarioClases;
import java.util.ArrayList;
import java.util.Scanner;
// Variante del proyecto no utilizada, borrador de funcionalidades
// (No tendrá actualizaciones)
public class InventarioApp {
    private static ArrayList<Producto> inventario = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE INVENTARIO ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto por ID");
            System.out.println("3. Mostrar todos los productos");
            System.out.println("4. Salir");
            System.out.println("5. Buscar producto");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarProducto(scanner);
                    break;
                case 2:
                    eliminarProducto(scanner);
                    break;
                case 3:
                    mostrarInventario();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                case 5:
                    buscarProducto(scanner);
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        } while (opcion != 4);
    }

    private static void agregarProducto(Scanner scanner) {
        System.out.print("Ingrese ID del producto: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese cantidad: ");
        int cantidad = scanner.nextInt();
        System.out.print("Ingrese precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // limpiar buffer

        Producto nuevo = new Producto(id, nombre, cantidad, precio);
        inventario.add(nuevo);
        System.out.println("InventarioClases.Producto agregado exitosamente.");
    }
//eliminar un producto por su id (se puede agregar opción por nombre también)
    private static void eliminarProducto(Scanner scanner) {
        System.out.print("Ingrese el ID del producto a eliminar: ");
        String id = scanner.nextLine();
        boolean eliminado = false;

        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getId().equalsIgnoreCase(id)) {
                inventario.remove(i);
                eliminado = true;
                System.out.println("InventarioClases.Producto eliminado.");
                break;
            }
        }

        if (!eliminado) {
            System.out.println("No se encontró un producto con ese ID.");
        }
    }

    private static void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        } else {
            System.out.println("\n--- Productos en inventario ---");
            for (Producto p : inventario) {
                System.out.println(p);
            }
        }
    }

    private static void buscarProducto(Scanner scanner) {
        System.out.println("\n--- BÚSQUEDA DE PRODUCTO ---");
        System.out.print("Buscar por (1) ID o (2) Nombre: ");
        int tipoBusqueda = scanner.nextInt();
        scanner.nextLine();
//Se elige si se quiere buscar el producto por su id o nombre según se requiera
        boolean encontrado = false;

        if (tipoBusqueda == 1) {
            System.out.print("Ingrese el ID del producto: ");
            String id = scanner.nextLine();

            for (Producto p : inventario) {
                if (p.getId().equalsIgnoreCase(id)) {
                    System.out.println("InventarioClases.Producto encontrado:\n" + p);
                    encontrado = true;
                    break;
                }
            }

        } else if (tipoBusqueda == 2) {
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();

            for (Producto p : inventario) {
                if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                    System.out.println("InventarioClases.Producto encontrado:\n" + p);
                    encontrado = true;
                }
            }

        } else {
            System.out.println("Opción no válida.");
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún producto con esos datos.");
        }
    }
}



