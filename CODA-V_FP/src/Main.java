import ui.InterfazGrafica;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Clase principal que inicia la aplicación de gestión de inventario.
 */
public class Main {
    public static void main(String[] args) {
        // Ejecuta la creación de la GUI en el hilo de despacho de eventos de Swing para seguridad.
        SwingUtilities.invokeLater(() -> {
            try {
                // Opcional: Establece un look and feel más moderno que el default de Java.
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                // Si no se puede establecer el look and feel del sistema, no es un error crítico.
                System.err.println("No se pudo establecer el Look and Feel del sistema.");
            }
            // Crea y muestra la ventana principal.
            new InterfazGrafica().setVisible(true);
        });
    }
}