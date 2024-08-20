import java.util.Date;

public class modeloReserva {
    private int id;
    private Usuario usuario;
    private Vehiculo vehiculo;
    private Date fechaInicio;
    private Date fechaFin;
    private double total;

    // Métodos: Getters, Setters, crearReserva, cancelarReserva, modificarReserva

    //METODO CONSTRUCTOR
    public modeloReserva(int id, Usuario usuario, Vehiculo vehiculo, Date fechaInicio, Date fechaFin, double total){
        this.id = id;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    //GETTERS
    //SETTERS
}
