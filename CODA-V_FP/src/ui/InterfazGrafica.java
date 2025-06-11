<<<<<<< HEAD
package ui;

import modelo.Producto;
import negocio.Inventario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfazGrafica extends JFrame {
    private final Inventario inventario;
    private final JTable tabla;
    private final DefaultTableModel modeloTabla;

    public InterfazGrafica() {
        inventario = new Inventario();

        setTitle("Sistema de Gestión de Inventario");
        setSize(800, 500); // Se aumentó un poco el tamaño para mejor visualización
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // --- Panel de Título ---
        JLabel labelTitulo = new JLabel("Gestión de Inventario", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        labelTitulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(labelTitulo, BorderLayout.NORTH);

        // --- Tabla del Inventario ---
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Cantidad", "Precio"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla = new JTable(modeloTabla);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.setRowHeight(25);
        tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // --- Panel de Botones ---
        JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JButton botonAgregar = new JButton("📦 Agregar Producto");
        JButton botonActualizar = new JButton("✏️ Actualizar Producto");
        JButton botonEliminar = new JButton("❌ Eliminar Producto");
        JButton botonValorTotal = new JButton("💰 Valor Total");
        JButton botonAcerca = new JButton("ℹ️ Acerca de");

        // Asignar fuentes y estilos a los botones
        Font botonFont = new Font("Arial", Font.PLAIN, 14);
        botonAgregar.setFont(botonFont);
        botonActualizar.setFont(botonFont);
        botonEliminar.setFont(botonFont);
        botonValorTotal.setFont(botonFont);
        botonAcerca.setFont(botonFont);

        panelAcciones.add(botonAgregar);
        panelAcciones.add(botonActualizar);
        panelAcciones.add(botonEliminar);
        panelAcciones.add(botonValorTotal);
        panelAcciones.add(botonAcerca);
        add(panelAcciones, BorderLayout.SOUTH);

        // --- Listeners ---
        botonAgregar.addActionListener(e -> abrirDialogoAgregar());
        botonActualizar.addActionListener(e -> abrirDialogoActualizar());
        botonEliminar.addActionListener(e -> eliminarProducto());
        botonValorTotal.addActionListener(e -> mostrarValorTotal());
        botonAcerca.addActionListener(e -> mostrarAcercaDe());

        tabla.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2 && tabla.getSelectedRow() != -1) {
                    abrirDialogoActualizar();
                }
            }
        });
    }

    private void abrirDialogoAgregar() {
        DialogoAgregarProducto dialogo = new DialogoAgregarProducto(this, inventario);
        dialogo.setVisible(true);

        if (dialogo.isAgregado()) {
            Producto p = dialogo.getProducto();
            modeloTabla.addRow(new Object[]{p.getId(), p.getNombre(), p.getCantidad(), p.getPrecio()});
        }
    }

    private void abrirDialogoActualizar() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String id = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
        // CAMBIO: Se usa el método de tu clase Inventario
        Producto productoAActualizar = inventario.obtenerProductoPorId(id);

        if (productoAActualizar != null) {
            DialogoActualizarProducto dialogo = new DialogoActualizarProducto(this, inventario, productoAActualizar);
            dialogo.setVisible(true);

            if (dialogo.isActualizado()) {
                Producto p = dialogo.getProductoActualizado();
                modeloTabla.setValueAt(p.getNombre(), filaSeleccionada, 1);
                modeloTabla.setValueAt(p.getCantidad(), filaSeleccionada, 2);
                modeloTabla.setValueAt(p.getPrecio(), filaSeleccionada, 3);
            }
        }
    }

    private void eliminarProducto() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String id = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
        String nombre = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de que desea eliminar el producto \"" + nombre + "\" (ID: " + id + ")?",
                "Confirmar Eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmacion == JOptionPane.YES_OPTION) {
            if (inventario.eliminarProducto(id)) {
                modeloTabla.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(this, "Producto eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error: No se pudo encontrar el producto a eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void mostrarValorTotal() {
        double total = inventario.calcularValorTotal();
        JOptionPane.showMessageDialog(this, String.format("El valor total del inventario es: $%,.2f", total), "Valor Total del Inventario", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarAcercaDe() {
        JOptionPane.showMessageDialog(this,
                "Sistema de Gestión de Inventario v1.1\nDesarrollado para la materia de POO.",
                "Acerca de",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
=======
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
>>>>>>> 8eea39a1141aba6952176b02ec30f701a07b375f
