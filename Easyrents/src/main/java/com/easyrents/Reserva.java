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
    
    //TOSTRING
    @Override
    public String toString() {
        return "Reserva [id=" + id + ", usuario=" + usuario + ", vehiculo=" + vehiculo + ", fechaInicio=" + fechaInicio
                + ", fechaFin=" + fechaFin + ", total=" + total + "]";
    }
}
