package ui;

import modelo.Producto;
import negocio.Inventario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InterfazGrafica extends JFrame {
    private Inventario inventario;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    private JTextField campoId, campoNombre, campoCantidad, campoPrecio;

    public InterfazGrafica() {
        inventario = new Inventario();

        setTitle("Sistema de Gestión de Inventario");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior con formularios
        JPanel panelFormulario = new JPanel(new GridLayout(2, 5));
        campoId = new JTextField();
        campoNombre = new JTextField();
        campoCantidad = new JTextField();
        campoPrecio = new JTextField();

        panelFormulario.add(new JLabel("ID:"));
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(new JLabel("Cantidad:"));
        panelFormulario.add(new JLabel("Precio:"));
        panelFormulario.add(new JLabel(""));

        panelFormulario.add(campoId);
        panelFormulario.add(campoNombre);
        panelFormulario.add(campoCantidad);
        panelFormulario.add(campoPrecio);

        JButton botonAgregar = new JButton("Agregar");
        panelFormulario.add(botonAgregar);

        add(panelFormulario, BorderLayout.NORTH);

        // Tabla del inventario
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Cantidad", "Precio"}, 0);
        tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        // Panel inferior con botones de acciones
        JPanel panelAcciones = new JPanel();
        JButton botonActualizar = new JButton("Actualizar");
        JButton botonEliminar = new JButton("Eliminar");
        JButton botonValorTotal = new JButton("Valor Total");
        JButton botonAcerca = new JButton("Acerca de");

        panelAcciones.add(botonActualizar);
        panelAcciones.add(botonEliminar);
        panelAcciones.add(botonValorTotal);
        panelAcciones.add(botonAcerca);

        add(panelAcciones, BorderLayout.SOUTH);

        // Acciones
        botonAgregar.addActionListener(e -> agregarProducto());
        botonActualizar.addActionListener(e -> actualizarProducto());
        botonEliminar.addActionListener(e -> eliminarProducto());
        botonValorTotal.addActionListener(e -> mostrarValorTotal());
        botonAcerca.addActionListener(e -> mostrarAcercaDe());
    }

    private void agregarProducto() {
        String id = campoId.getText();
        String nombre = campoNombre.getText();
        int cantidad = Integer.parseInt(campoCantidad.getText());
        double precio = Double.parseDouble(campoPrecio.getText());

        Producto producto = new Producto(id, nombre, cantidad, precio);
        if (inventario.agregarProducto(producto)) {
            modeloTabla.addRow(new Object[]{id, nombre, cantidad, precio});
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Producto con ese ID ya existe.");
        }
    }

    private void actualizarProducto() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para actualizar.");
            return;
        }
        String id = modeloTabla.getValueAt(fila, 0).toString();
        String nuevoNombre = campoNombre.getText();
        int nuevaCantidad = Integer.parseInt(campoCantidad.getText());
        double nuevoPrecio = Double.parseDouble(campoPrecio.getText());

        if (inventario.actualizarProducto(id, nuevoNombre, nuevaCantidad, nuevoPrecio)) {
            modeloTabla.setValueAt(nuevoNombre, fila, 1);
            modeloTabla.setValueAt(nuevaCantidad, fila, 2);
            modeloTabla.setValueAt(nuevoPrecio, fila, 3);
            limpiarCampos();
        }
    }

    private void eliminarProducto() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para eliminar.");
            return;
        }
        String id = modeloTabla.getValueAt(fila, 0).toString();
        if (inventario.eliminarProducto(id)) {
            modeloTabla.removeRow(fila);
        }
    }

    private void mostrarValorTotal() {
        double total = inventario.calcularValorTotal();
        JOptionPane.showMessageDialog(this, "Valor total del inventario: $" + total);
    }

    private void mostrarAcercaDe() {
        JOptionPane.showMessageDialog(this,
                "Sistema de Gestión de Inventario\nVersión 1.0\nDesarrollado por: CODA-V\nDaniela Ortiz, Cristian Vargas, Arley Lopéz, Frank Valderrama\nEslogan: Ordena, Controla, Evoluciona");
    }

    private void limpiarCampos() {
        campoId.setText("");
        campoNombre.setText("");
        campoCantidad.setText("");
        campoPrecio.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazGrafica().setVisible(true));
    }
}
