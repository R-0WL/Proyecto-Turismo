public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String contraseña;
    private String tipoUsuario;
    
    //METODO CONSTRUCTOR
    public Usuario ( int id, String nombre, String correo, String contraseña, String tipoUsuario){
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

    //TOSTRING
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", contraseña=" + contraseña
                + ", tipoUsuario=" + tipoUsuario + "]";
    }
}