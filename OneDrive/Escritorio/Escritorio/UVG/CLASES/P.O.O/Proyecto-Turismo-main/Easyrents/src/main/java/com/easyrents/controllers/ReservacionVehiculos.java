import java.util.Date;
import java.util.List;

public class ReservacionVehiculos {
    private Vehiculo vehiculo;
    private String cliente;
    private Date fechaInicio;
    private Date fechaFin;
    private double totalPagar;

    // Constructor de la reservación
    public ReservacionVehiculos(Vehiculo vehiculo, String cliente, Date fechaInicio, Date fechaFin) {
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.totalPagar = calcularTotal();
    }

    // Método para calcular el total a pagar basado en los días de renta
    private double calcularTotal() {
        long diferenciaDias = (fechaFin.getTime() - fechaInicio.getTime()) / (1000 * 60 * 60 * 24);
        return vehiculo.getPrecio() * (diferenciaDias + 1);  // Se suma 1 para contar el primer día completo
    }

    // Método para realizar la reservación
    public static ReservacionVehiculos reservarVehiculo(int idVehiculo, List<Vehiculo> listaVehiculos, String cliente, Date fechaInicio, Date fechaFin) {
        Vehiculo vehiculo = Vehiculo.obtenerVehiculoPorID(idVehiculo, listaVehiculos);
        if (vehiculo != null && vehiculo.getDisponible()) {
            vehiculo.setDisponible(false); // Marca el vehículo como no disponible
            ReservacionVehiculos reservacion = new ReservacionVehiculos(vehiculo, cliente, fechaInicio, fechaFin);
            System.out.println("Reservación confirmada: " + reservacion);
            return reservacion;
        } else {
            System.out.println("Vehículo no disponible o ID no válido.");
            return null;
        }
    }

    @Override
    public String toString() {
        return "ReservacionVehiculos [Vehiculo=" + vehiculo + ", Cliente=" + cliente + ", Fecha Inicio=" + fechaInicio + ", Fecha Fin=" + fechaFin
                + ", Total a Pagar=" + totalPagar + "]";
    }

    // Getters
    public Vehiculo getVehiculo() { return vehiculo; }
    public String getCliente() { return cliente; }
    public Date getFechaInicio() { return fechaInicio; }
    public Date getFechaFin() { return fechaFin; }
    public double getTotalPagar() { return totalPagar; }
}
