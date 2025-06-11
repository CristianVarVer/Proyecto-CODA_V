import modelo.Usuario;
import negocio.Inventario;
import negocio.ManejadorDatos;
import ui.DialogoLogin;
import ui.InterfazGrafica;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.err.println("No se pudo establecer el Look and Feel del sistema.");
            }

            // 1. Mostrar el diálogo de login primero
            DialogoLogin dialogoLogin = new DialogoLogin(null);
            dialogoLogin.setVisible(true);

            // 2. Comprobar si el login fue exitoso
            Usuario usuario = dialogoLogin.getUsuarioAutenticado();
            if (usuario != null) {
                // 3. Si fue exitoso, cargar el inventario y mostrar la ventana principal
                System.out.println("Login exitoso para: " + usuario.getNombreUsuario());
                Inventario inventario = ManejadorDatos.cargarInventario();
                InterfazGrafica interfaz = new InterfazGrafica(inventario);
                interfaz.setVisible(true);
            } else {
                // 4. Si el usuario cerró el diálogo o falló, la aplicación termina.
                System.out.println("Login cancelado o fallido. Saliendo de la aplicación.");
                System.exit(0);
            }
        });
    }
}