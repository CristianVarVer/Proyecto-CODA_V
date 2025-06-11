
package ui;

import modelo.Producto;
import negocio.Inventario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import negocio.Inventario;
import negocio.ManejadorDatos;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InterfazGrafica extends JFrame {
    private final Inventario inventario;
    private final JTable tabla;
    private final DefaultTableModel modeloTabla;

    public InterfazGrafica(Inventario inventario) {
        this.inventario =  inventario;

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
        JButton botonAgregar = new JButton(" Agregar Producto");
        JButton botonActualizar = new JButton(" Actualizar Producto");
        JButton botonEliminar = new JButton(" Eliminar Producto");
        JButton botonValorTotal = new JButton(" Valor Total");
        JButton botonAcerca = new JButton("ℹ Acerca de");

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
        refrescarTabla();
        tabla.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2 && tabla.getSelectedRow() != -1) {
                    abrirDialogoActualizar();
                }
            }
        });


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ManejadorDatos.guardarInventario(inventario);
                // El setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) se encargará de cerrar
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
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto para actualizar.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String id = (String) modeloTabla.getValueAt(filaSeleccionada, 0);


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
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto para eliminar.", "Error",
                    JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(this, "Producto eliminado exitosamente.", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error: No se pudo encontrar el producto a eliminar.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void mostrarValorTotal() {
        double total = inventario.calcularValorTotal();
        JOptionPane.showMessageDialog(this, String.format("El valor total del inventario es: $%,.2f", total),
                "Valor Total del Inventario", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarAcercaDe() {
        JOptionPane.showMessageDialog(this,
                "Sistema de Gestión de Inventario v1.1\n Desarrollado por:CODA-V \n" +
                        "Miembros: Cristian Alberto Vargas (Product Owner).\n" +
                        "Daniela Ximena Ortiz (Scrum Master).\n" +
                        "Frank Sebastián Valderrama (Development Team).\n" +
                        "Roberth Arley López (Development Team).\n \n" +
                        "Fecha: 03 de Junio de 2025 \n" +
                        "Eslogan: Ordena, controla, evoluciona",
                "Acerca de",
                JOptionPane.INFORMATION_MESSAGE);
    }
    private void refrescarTabla() {
        // Limpia la tabla existente
        modeloTabla.setRowCount(0);
        // Vuelve a llenar la tabla con los productos del inventario
        for (Producto p : inventario.consultarInventario()) {
            modeloTabla.addRow(new Object[]{p.getId(), p.getNombre(), p.getCantidad(), p.getPrecio()});
        }
    }
}