//Requisitos funcionales a cumplir: 4.Registro y autenticacion de Usuarios / 5.Perfil Usuario
public class controladorUsuario {
    private Usuario usuario;
    private vistaInicioSesion vistaInicioSesion;

    //CONSTRUCTOR
    public controladorUsuario(vistaInicioSesion vista){
        this.vistaInicioSesion = vista;
    }

    //CAMBIAR TODOS LOS MENSAJES EN CONSOLA POR MENSAJES EN VENTANAS EMERGENTES O ALGO. 
    //SE HIZO ASI POR QUE NO TENGO CONFIGURADO JAVASWING :v

    public void iniciarSesion(String correo, String contraseña) {
        //consultar a la base de datos o lista de usuarios
        //esta simulando que ya hay alguien registrado
        if (usuario!= null && usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(contraseña)){
            System.out.print("Inicio de sesión exitoso para: " + usuario.getNombre());
            //agregar un pequeño mensaje de bienvenida
        } else{
            System.out.print("Correo contraseña incorrectos, por favor intente de nuevo.");
        }
    }
    
    public void registrarUsuario(Usuario nuevoUsuario) {
        if (usuario == null){//validacion simple de momento
            this.usuario = nuevoUsuario;
            System.out.println("Usuario registrado exitosamente: " + nuevoUsuario);
        } else {
            System.out.println("Error: El usuario ya existe.");
        }
    }

    public void actualizarPerfil(Usuario usuarioActualizado) {
        //Actualiza los dados del usuario
        if (usuario != null && usuario.getID() == usuarioActualizado.getID()){
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setCorreo(usuarioActualizado.getCorreo());
            usuario.setContraseña(usuarioActualizado.getContraseña());
            usuario.setTipoUsuario(usuarioActualizado.getTipoUsuario());
            System.out.println("Perfil actualizado exitosamente: "+ usuarioActualizado);
        } else {
            System.out.println("Error: Usuario no encontrado.");
        }
    }
}
