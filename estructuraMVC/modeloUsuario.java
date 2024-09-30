public class modeloUsuario {
    private long id;
    private String nombre;
    private String correo;
    private String contraseña;
    private String tipoUsuario;

    // Métodos: Getters, Setters, registrar, iniciarSesion, actualizarPerfil, cambiarContraseña
    
    //METODO CONSTRUCTOR
    /**
     * 
     * @param id DPI del usuario
     * @param nombre Nombre completo del usuario
     * @param correo Correo electrónico del usuario
     * @param contraseña Contraseña del usuario
     * @param tipoUsuario Razón por la cual viaja el usuario.
     */
    public modeloUsuario (long id, String nombre, String correo, String contraseña, String tipoUsuario){
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }

    //GETTERS
    public long getID(){return this.id;}
    public String getNombre(){return this.nombre;}
    public String getCorreo(){return this.correo;}
    public String getContraseña(){return this.contraseña;}
    public String getTipoUsuario(){return this.tipoUsuario;}

    //SETTERS
    public void setID(long id){this.id = id;}
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setCorreo(String correo){this.correo = correo;}
    public void setContraseña(String contraseña){this.contraseña = contraseña;}
    public void setTipoUsuario(String tipoUsuario){this.tipoUsuario = tipoUsuario;}
    
}


