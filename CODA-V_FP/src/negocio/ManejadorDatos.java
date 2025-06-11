package negocio;

import modelo.Usuario;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ManejadorDatos {
    private static final String ARCHIVO_INVENTARIO = "inventario.dat";
    private static final String ARCHIVO_USUARIOS = "usuarios.dat";

    // --- MÉTODOS PARA EL INVENTARIO ---

    public static void guardarInventario(Inventario inventario) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_INVENTARIO))) {
            oos.writeObject(inventario);
        } catch (IOException e) {
            System.err.println("Error al guardar el inventario: " + e.getMessage());
        }
    }

    public static Inventario cargarInventario() {
        File archivo = new File(ARCHIVO_INVENTARIO);
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                return (Inventario) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error al cargar el inventario: " + e.getMessage());
            }
        }
        // Si no existe el archivo o hay un error, devuelve un inventario nuevo.
        return new Inventario();
    }

    // --- MÉTODOS PARA LOS USUARIOS ---

    public static void guardarUsuarios(Map<String, Usuario> usuarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_USUARIOS))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            System.err.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Usuario> cargarUsuarios() {
        File archivo = new File(ARCHIVO_USUARIOS);
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                return (Map<String, Usuario>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error al cargar usuarios: " + e.getMessage());
            }
        }
        // Si no hay usuarios, devuelve un mapa vacío.
        return new HashMap<>();
    }
}