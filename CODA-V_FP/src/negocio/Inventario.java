package negocio;

import modelo.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona la lista de productos en el inventario
 */
public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    /**
     * Agrega un nuevo producto al inventario
     * @param producto El producto a agregar
     * @return true si se agregó correctamente, false si ya existe un producto con el mismo ID
     */
    public boolean agregarProducto(Producto producto) {
        if (obtenerProductoPorId(producto.getId()) != null) {
            return false; // El producto ya existe
        }
        productos.add(producto);
        return true;
    }

    /**
     * Consulta todos los productos en el inventario
     * @return Una lista con todos los productos
     */
    public List<Producto> consultarInventario() {
        return new ArrayList<>(productos);
    }

    /**
     * Actualiza la información de un producto
     * @param id El ID del producto a actualizar
     * @param nuevoNombre El nuevo nombre del producto
     * @param nuevaCantidad La nueva cantidad del producto
     * @param nuevoPrecio El nuevo precio del producto
     * @return true si se actualizó correctamente, false si el producto no fue encontrado
     */
    public boolean actualizarProducto(String id, String nuevoNombre, int nuevaCantidad, double nuevoPrecio) {
        Producto producto = obtenerProductoPorId(id);
        if (producto == null) {
            return false;
        }
        producto.setNombre(nuevoNombre);
        producto.setCantidad(nuevaCantidad);
        producto.setPrecio(nuevoPrecio);
        return true;
    }

    /**
     * Elimina un producto del inventario
     * @param id El ID del producto a eliminar
     * @return true si se eliminó correctamente, false si el producto no fue encontrado
     */
    public boolean eliminarProducto(String id) {
        Producto producto = obtenerProductoPorId(id);
        if (producto == null) {
            return false;
        }
        productos.remove(producto);
        return true;
    }

    /**
     * Busca un producto por su ID
     * @param id El ID del producto a buscar
     * @return El producto si se encuentra, null en caso contrario
     */
    public Producto obtenerProductoPorId(String id) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    /**
     * Calcula el valor total del inventario
     * @return El valor total del inventario
     */
    public double calcularValorTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getCantidad() * producto.getPrecio();
        }
        return total;
    }
}
