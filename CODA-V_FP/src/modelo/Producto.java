package modelo;

public class Producto {
    private String id;
    private String nombre;
    private int cantidad;
    private double precio;

    /**
     * Constructor para inicializar un producto
     * @param id ID del producto
     * @param nombre Nombre del producto
     * @param cantidad Cantidad disponible
     * @param precio Precio del producto
     */
    public Producto(String id, String nombre, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y setters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public double getPrecio() { return precio; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setPrecio(double precio) { this.precio = precio; }
}
