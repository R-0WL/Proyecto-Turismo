import java.time.LocalDate;

public class Reserva {
    private int id;
    private Usuario usuario;
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double monto;

    //METODO CONSTRUCTOR
    public Reserva(int id, Usuario usuario, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin, double monto) {
        this.id = id;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        setFechaFin(fechaFin);
        this.monto = monto;
    }
    
    //GETTERS
    public int getId() {return id;}
    public Usuario getUsuario() {return usuario;}
    public Vehiculo getVehiculo() {return vehiculo;}
    public LocalDate getFechaInicio() {return fechaInicio;}
    public LocalDate getFechaFin() {return fechaFin;}
    public double getMonto() {return monto;}
    
    //SETTERS
    public void setId(int id) {this.id = id;}    
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}
    public void setVehiculo(Vehiculo vehiculo) {this.vehiculo = vehiculo;}
    public void setFechaInicio(LocalDate fechaInicio) {this.fechaInicio = fechaInicio;}
    public void setFechaFin(LocalDate fechaFin) {
        if (fechaFin.isAfter(fechaInicio)) {
            this.fechaFin = fechaFin;
        } else {
            throw new IllegalArgumentException("La fecha final debe ser posterior a la fecha de inicio");
        }
    }
    public void setMonto(double monto) {this.monto = monto;}
    
    //TOSTRING
    @Override
    public String toString() {
        return "Reserva [id=" + id + ", usuario=" + usuario + ", vehiculo=" + vehiculo + ", fechaInicio=" + fechaInicio
                + ", fechaFin=" + fechaFin + ", monto=" + monto + "]";
    }
}

