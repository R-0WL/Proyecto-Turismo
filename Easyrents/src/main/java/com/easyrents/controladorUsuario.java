//Requisitos funcionales a cumplir: 4.Registro y autenticacion de Usuarios / 5.Perfil Usuario
package com.easyrents;

import javax.swing.JOptionPane;

public class controladorUsuario {
    private Usuario usuario;
    //private vistaInicioSesion vistaInicioSesion;

    //CONSTRUCTOR
    public controladorUsuario(vistaInicioSesion vista){
        this.vistaInicioSesion = vista;
    }

    // Método para mostrar mensajes en ventanas emergentes
	private static mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void iniciarSesion(String correo, String contraseña) {
        //consultar a la base de datos o lista de usuarios
        //esta simulando que ya hay alguien registrado
        if (usuario != null && usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(contraseña)) {
            mostrarMensaje("Inicio de sesión exitoso para: " + usuario.getNombre());
            //abajo redirigir al usuario a su perfil o a la página principal
        } else {
            mostrarMensaje("Correo o contraseña incorrectos, por favor intente de nuevo.");
        }
    }
    
    public void registrarUsuario(Usuario nuevoUsuario) {
        if (usuario == null) { // Validación de momento
            this.usuario = nuevoUsuario;
            mostrarMensaje("Usuario registrado exitosamente: " + nuevoUsuario);
        } else {
            mostrarMensaje("Error: El usuario ya existe.");
        }
    }

    public void actualizarPerfil(Usuario usuarioActualizado) {
        //Actualiza los datos del usuario
        if (usuario != null && usuario.getID() == usuarioActualizado.getID()) {
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setCorreo(usuarioActualizado.getCorreo());
            usuario.setContraseña(usuarioActualizado.getContraseña());
            usuario.setTipoUsuario(usuarioActualizado.getTipoUsuario());
            mostrarMensaje("Perfil actualizado exitosamente: " + usuarioActualizado);
        } else {
            mostrarMensaje("Error: Usuario no encontrado.");
        }
    }
}
