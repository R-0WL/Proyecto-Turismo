public class modeloUsuario {
    private int id;
    private String nombre;
    private String correo;
    private String contraseña;
    private String tipoUsuario;

    // Métodos: Getters, Setters, registrar, iniciarSesion, actualizarPerfil, cambiarContraseña
    
    //METODO CONSTRUCTOR
    public modeloUsuario ( int id, String nombre, String correo, String contraseña, String tipoUsuario){
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }

    //GETTERS
    public int getID(){return id;}
    public String getNombre(){return nombre;}
    public String getCorreo(){return correo;}
    public String getContraseña(){return contraseña;}
    public String getTipoUsuario(){return tipoUsuario;}

    //SETTERS
    public void setID(int id){this.id = id;}
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setCorreo(String correo){this.correo = correo;}
    public void setContraseña(String contraseña){this.contraseña = contraseña;}
    public void setTipoUsuario(String tipoUsuario){this.tipoUsuario = tipoUsuario;}

    //REGISTRAR USUARIO
    public void registrar(String nombre, String correo, String contraseña){
        //Lógica para registrar al usuario y guardar en base de datos
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correo = correo;
        System.out.println("Usuario registrado con éxito. Bienvenido");
    }

    //INICIAR SESION
    public boolean iniciarSesion(String correo, String contraseña){
        if(this.correo.equals(correo) && this.contraseña.equals(contraseña)){
            System.out.println("Inicio de sesión exitoso. Bienvenido");
            return true;
        } else {
            System.out.println("Correo o contraseña incorrectos.");
            return false;
        }
    }
}
