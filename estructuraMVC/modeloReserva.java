import java.util.Date;

public class modeloReserva {
    private int id;
    private modeloUsuario usuario;
    private modeloVehiculo vehiculo;
    private Date fechaInicio;
    private Date fechaFin;
    private double total;

    // Métodos: Getters, Setters, crearReserva, cancelarReserva, modificarReserva

    //METODO CONSTRUCTOR
    public modeloReserva(int id, modeloUsuario usuario, modeloVehiculo vehiculo, Date fechaInicio, Date fechaFin, double total) {
        this.id = id;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.total = total;
    }
    
    // GETTERS
    public int getId() {return id;}
    public modeloUsuario getUsuario() {return usuario;}
    public modeloVehiculo getVehiculo() {return vehiculo;}
    public Date getFechaInicio() {return fechaInicio;}
    public Date getFechaFin() {return fechaFin;}
    public double getTotal() {return total;}
    
    //SETTERS
    public void setId(int id) {this.id = id;}    
    public void setUsuario(modeloUsuario usuario) {this.usuario = usuario;}
    public void setVehiculo(modeloVehiculo vehiculo) {this.vehiculo = vehiculo;}
    public void setFechaInicio(Date fechaInicio) {this.fechaInicio = fechaInicio;}
    public void setFechaFin(Date fechaFin) {this.fechaFin = fechaFin;}
    public void setTotal(double total) {this.total = total;}
    
    //METODO PARA CREAR UNA NUEVA RESERVA
    public static modeloReserva crearReserva(int id, modeloUsuario usuario, modeloVehiculo vehiculo, Date fechaInicio, Date fechaFin, double total) {
        return new modeloReserva(id, usuario, vehiculo, fechaInicio, fechaFin, total);
    }
    
    //METODO PARA CANCELAR UNA RESERVA
    public void cancelarReserva() {
        // Implementación para cancelar la reserva, podría implicar la anulación del objeto o cambios en su estado
        System.out.println("La reserva con ID " + this.id + " ha sido cancelada.");
        this.fechaInicio = null;
        this.fechaFin = null;
        this.total = 0.0;
    }
    
    //METODO PARA MODIFICAR UNA RESERVA
    public void modificarReserva(Date nuevaFechaInicio, Date nuevaFechaFin, double nuevoTotal) {
        this.fechaInicio = nuevaFechaInicio;
        this.fechaFin = nuevaFechaFin;
        this.total = nuevoTotal;
        System.out.println("La reserva con ID " + this.id + " ha sido modificada.");
    }
}

