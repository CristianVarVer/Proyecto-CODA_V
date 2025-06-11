package InventarioClases;

public class Producto {
    private String id;
    private String nombre;
    private int cantidad;
    private double precio;
//Creación de objetos
    public Producto(String id, String nombre, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
//Funciones para el programa
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
//Aún sin utilizar
    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Cantidad: " + cantidad + ", Precio: $" + precio;
    }
}


