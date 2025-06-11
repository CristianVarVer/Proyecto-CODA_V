package ui;

import modelo.Producto;
import negocio.Inventario;

import javax.swing.*;
import java.awt.*;

public class DialogoAgregarProducto extends JDialog {
    private JTextField campoId, campoNombre, campoCantidad, campoPrecio;
    private final Inventario inventario;
    private boolean agregado = false;
    private Producto nuevoProducto;

    public DialogoAgregarProducto(Frame owner, Inventario inventario) {
        super(owner, "Agregar Nuevo Producto", true);
        this.inventario = inventario;
        // ... el resto del constructor no cambia ...
        setLayout(new BorderLayout(10, 10));
        setSize(400, 250);
        setLocationRelativeTo(owner);

        JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        campoId = new JTextField();
        campoNombre = new JTextField();
        campoCantidad = new JTextField();
        campoPrecio = new JTextField();

        panelFormulario.add(new JLabel("ID:"));
        panelFormulario.add(campoId);
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(campoNombre);
        panelFormulario.add(new JLabel("Cantidad:"));
        panelFormulario.add(campoCantidad);
        panelFormulario.add(new JLabel("Precio:"));
        panelFormulario.add(campoPrecio);

        add(panelFormulario, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botonAceptar = new JButton("Aceptar");
        JButton botonCancelar = new JButton("Cancelar");
        panelBotones.add(botonAceptar);
        panelBotones.add(botonCancelar);

        add(panelBotones, BorderLayout.SOUTH);

        botonAceptar.addActionListener(e -> agregarProducto());
        botonCancelar.addActionListener(e -> dispose());
    }

    private void agregarProducto() {
        try {
            String id = campoId.getText().trim();
            String nombre = campoNombre.getText().trim();
            String cantidadStr = campoCantidad.getText().trim();
            String precioStr = campoPrecio.getText().trim();

            if (id.isEmpty() || nombre.isEmpty() || cantidadStr.isEmpty() || precioStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int cantidad = Integer.parseInt(cantidadStr);
            double precio = Double.parseDouble(precioStr);

            // --- NUEVA VALIDACIÓN ---
            // Comprueba si los valores numéricos son negativos.
            if (cantidad < 0 || precio < 0) {
                // Lanza una excepción específica si la validación falla.
                throw new IllegalArgumentException("La cantidad y el precio no pueden ser negativos.");
            }

            nuevoProducto = new Producto(id, nombre, cantidad, precio);

            if (inventario.agregarProducto(nuevoProducto)) {
                agregado = true;
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Ya existe un producto con el ID ingresado.", "Error de Duplicado", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos para Cantidad y Precio.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            // --- NUEVO CATCH ---
            // Captura la excepción de validación y muestra el mensaje al usuario.
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean isAgregado() {
        return agregado;
    }

    public Producto getProducto() {
        return nuevoProducto;
    }
}