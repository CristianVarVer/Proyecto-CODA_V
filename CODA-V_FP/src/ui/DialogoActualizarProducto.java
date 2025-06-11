package ui;

import modelo.Producto;
import negocio.Inventario;

import javax.swing.*;
import java.awt.*;

public class DialogoActualizarProducto extends JDialog {
    private JTextField campoNombre, campoCantidad, campoPrecio;
    private final Inventario inventario;
    private final Producto productoOriginal;
    private boolean actualizado = false;
    private Producto productoActualizado;

    public DialogoActualizarProducto(Frame owner, Inventario inventario, Producto productoAActualizar) {
        super(owner, "Actualizar Producto", true);
        this.inventario = inventario;
        this.productoOriginal = productoAActualizar;
        // ... el resto del constructor no cambia ...
        setLayout(new BorderLayout(10, 10));
        setSize(400, 250);
        setLocationRelativeTo(owner);

        JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField campoId = new JTextField(productoOriginal.getId());
        campoId.setEditable(false);
        campoId.setBackground(Color.LIGHT_GRAY);

        campoNombre = new JTextField(productoOriginal.getNombre());
        campoCantidad = new JTextField(String.valueOf(productoOriginal.getCantidad()));
        campoPrecio = new JTextField(String.valueOf(productoOriginal.getPrecio()));

        panelFormulario.add(new JLabel("ID (no editable):"));
        panelFormulario.add(campoId);
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(campoNombre);
        panelFormulario.add(new JLabel("Cantidad:"));
        panelFormulario.add(campoCantidad);
        panelFormulario.add(new JLabel("Precio:"));
        panelFormulario.add(campoPrecio);

        add(panelFormulario, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botonAceptar = new JButton("Actualizar");
        JButton botonCancelar = new JButton("Cancelar");
        panelBotones.add(botonAceptar);
        panelBotones.add(botonCancelar);

        add(panelBotones, BorderLayout.SOUTH);

        botonAceptar.addActionListener(e -> actualizarProducto());
        botonCancelar.addActionListener(e -> dispose());
    }

    private void actualizarProducto() {
        try {
            String nombre = campoNombre.getText().trim();
            String cantidadStr = campoCantidad.getText().trim();
            String precioStr = campoPrecio.getText().trim();

            if (nombre.isEmpty() || cantidadStr.isEmpty() || precioStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int nuevaCantidad = Integer.parseInt(cantidadStr);
            double nuevoPrecio = Double.parseDouble(precioStr);

            // --- NUEVA VALIDACIÓN ---
            // Comprueba si los valores numéricos son negativos.
            if (nuevaCantidad < 0 || nuevoPrecio < 0) {
                // Lanza una excepción específica si la validación falla.
                throw new IllegalArgumentException("La cantidad y el precio no pueden ser negativos.");
            }

            if (inventario.actualizarProducto(productoOriginal.getId(), nombre, nuevaCantidad, nuevoPrecio)) {
                productoActualizado = new Producto(productoOriginal.getId(), nombre, nuevaCantidad, nuevoPrecio);
                actualizado = true;
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos para Cantidad y Precio.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            // --- NUEVO CATCH ---
            // Captura la excepción de validación y muestra el mensaje al usuario.
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean isActualizado() {
        return actualizado;
    }

    public Producto getProductoActualizado() {
        return productoActualizado;
    }
}