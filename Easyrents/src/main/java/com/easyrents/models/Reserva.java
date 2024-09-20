import java.util.Date;

public class Reserva {
    private int id;
    private Usuario usuario;
    private Vehiculo vehiculo;
    private Date fechaInicio;
    private Date fechaFin;
    private double total;

    //METODO CONSTRUCTOR
    public Reserva(int id, Usuario usuario, Vehiculo vehiculo, Date fechaInicio, Date fechaFin, double total) {
        this.id = id;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.total = total;
    }
    
    //GETTERS
    public int getId() {return id;}
    public Usuario getUsuario() {return usuario;}
    public Vehiculo getVehiculo() {return vehiculo;}
    public Date getFechaInicio() {return fechaInicio;}
    public Date getFechaFin() {return fechaFin;}
    public double getTotal() {return total;}
    
    //SETTERS
    public void setId(int id) {this.id = id;}    
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}
    public void setVehiculo(Vehiculo vehiculo) {this.vehiculo = vehiculo;}
    public void setFechaInicio(Date fechaInicio) {this.fechaInicio = fechaInicio;}
    public void setFechaFin(Date fechaFin) {this.fechaFin = fechaFin;}
    public void setTotal(double total) {this.total = total;}
    
    
    //METODO PARA CREAR UNA NUEVA RESERVA
    //metodo totalmente redundante!!!! procedo a comentarlo por el momento
    // public static Reserva crearReserva(int id, Usuario usuario, Vehiculo vehiculo, Date fechaInicio, Date fechaFin, double total) {
    //     return new Reserva(id, usuario, vehiculo, fechaInicio, fechaFin, total);
    // }
    
    //TOSTRING
    @Override
    public String toString() {
        return "Reserva [id=" + id + ", usuario=" + usuario + ", vehiculo=" + vehiculo + ", fechaInicio=" + fechaInicio
                + ", fechaFin=" + fechaFin + ", total=" + total + "]";
    }

    //METODO PARA CANCELAR UNA RESERVA
    //acorde a la estructura MVC, esto es logica y no deberia estar en un modelo?
    //mover a un controlador o borrar?
    public void cancelarReserva() {
        // Implementación para cancelar la reserva, podría implicar la anulación del objeto o cambios en su estado
        System.out.println("La reserva con ID " + this.id + " ha sido cancelada.");
        this.fechaInicio = null;
        this.fechaFin = null;
        this.total = 0.0;
    }
    
    //METODO PARA MODIFICAR UNA RESERVA
    //acorde a la estructura MVC, esto es logica y no deberia estar en un modelo?
    //mover a un controlador o borrar?
    public void modificarReserva(Date nuevaFechaInicio, Date nuevaFechaFin, double nuevoTotal) {
        this.fechaInicio = nuevaFechaInicio;
        this.fechaFin = nuevaFechaFin;
        this.total = nuevoTotal;
        System.out.println("La reserva con ID " + this.id + " ha sido modificada.");
    }
}

