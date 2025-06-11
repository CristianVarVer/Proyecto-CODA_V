package ui;

import modelo.Usuario;
import negocio.ManejadorDatos;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class DialogoLogin extends JDialog {
    private JTextField campoUsuario;
    private JPasswordField campoContrasena;
    private Map<String, Usuario> usuarios;
    private Usuario usuarioAutenticado = null;

    public DialogoLogin(Frame owner) {
        super(owner, "Inicio de Sesión", true);
        this.usuarios = ManejadorDatos.cargarUsuarios();

        setLayout(new BorderLayout(15, 15));
        setSize(350, 200);
        setLocationRelativeTo(owner);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel panelCampos = new JPanel(new GridLayout(2, 2, 5, 5));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        campoUsuario = new JTextField();
        campoContrasena = new JPasswordField();
        panelCampos.add(new JLabel("Usuario:"));
        panelCampos.add(campoUsuario);
        panelCampos.add(new JLabel("Contraseña:"));
        panelCampos.add(campoContrasena);
        add(panelCampos, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton botonLogin = new JButton("Iniciar Sesión");
        JButton botonRegistro = new JButton("Registrar");
        panelBotones.add(botonLogin);
        panelBotones.add(botonRegistro);
        add(panelBotones, BorderLayout.SOUTH);

        botonLogin.addActionListener(e -> intentarLogin());
        botonRegistro.addActionListener(e -> abrirRegistro());

        getRootPane().setDefaultButton(botonLogin);
    }

    private void intentarLogin() {
        String nombreUsuario = campoUsuario.getText();
        String contrasena = new String(campoContrasena.getPassword());
        Usuario usuario = usuarios.get(nombreUsuario);

        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            usuarioAutenticado = usuario;
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error de Autenticación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirRegistro() {
        DialogoRegistro dialogo = new DialogoRegistro(this, usuarios);
        dialogo.setVisible(true);

        if (dialogo.isRegistrado()) {
            // Actualizar el mapa de usuarios y guardarlo en el archivo
            this.usuarios = dialogo.getUsuariosActualizados();
            ManejadorDatos.guardarUsuarios(this.usuarios);

            // --- CAMBIO: Autenticar automáticamente y cerrar el login ---
            this.usuarioAutenticado = dialogo.getUsuarioNuevo();
            dispose(); // Cierra la ventana de Login, indicando que la autenticación fue exitosa.
        }
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }
}