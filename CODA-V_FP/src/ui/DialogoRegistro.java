package ui;

import modelo.Usuario;
import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class DialogoRegistro extends JDialog {
    private JTextField campoUsuario;
    private JPasswordField campoContrasena;
    private JPasswordField campoConfirmarContrasena;
    private Map<String, Usuario> usuarios;
    private boolean registrado = false;
    private Usuario usuarioNuevo = null; // --- CAMBIO 1: Añadir campo para el nuevo usuario

    public DialogoRegistro(Dialog owner, Map<String, Usuario> usuarios) {
        super(owner, "Registro de Nuevo Usuario", true);
        this.usuarios = usuarios;
        // ... El resto del constructor no cambia ...
        setLayout(new BorderLayout(15, 15));
        setSize(400, 250);
        setLocationRelativeTo(owner);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        campoUsuario = new JTextField();
        campoContrasena = new JPasswordField();
        campoConfirmarContrasena = new JPasswordField();

        panel.add(new JLabel("Nuevo Usuario:"));
        panel.add(campoUsuario);
        panel.add(new JLabel("Contraseña:"));
        panel.add(campoContrasena);
        panel.add(new JLabel("Confirmar Contraseña:"));
        panel.add(campoConfirmarContrasena);
        add(panel, BorderLayout.CENTER);

        JButton botonRegistrar = new JButton("Registrar");
        add(botonRegistrar, BorderLayout.SOUTH);

        botonRegistrar.addActionListener(e -> registrarUsuario());
    }

    private void registrarUsuario() {
        // ... Las validaciones iniciales no cambian ...
        String nombreUsuario = campoUsuario.getText().trim();
        String contrasena = new String(campoContrasena.getPassword());
        String confirmarContrasena = new String(campoConfirmarContrasena.getPassword());

        if (nombreUsuario.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre de usuario y la contraseña no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (usuarios.containsKey(nombreUsuario)) {
            JOptionPane.showMessageDialog(this, "El nombre de usuario ya existe. Por favor, elija otro.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!contrasena.equals(confirmarContrasena)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasena);
        usuarios.put(nombreUsuario, nuevoUsuario);

        this.usuarioNuevo = nuevoUsuario; // --- CAMBIO 2: Guardar el usuario recién creado
        registrado = true;

        JOptionPane.showMessageDialog(this, "¡Usuario registrado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    public boolean isRegistrado() {
        return registrado;
    }

    public Map<String, Usuario> getUsuariosActualizados() {
        return usuarios;
    }

    // --- CAMBIO 3: Nuevo método para obtener el usuario creado ---
    public Usuario getUsuarioNuevo() {
        return usuarioNuevo;
    }
}