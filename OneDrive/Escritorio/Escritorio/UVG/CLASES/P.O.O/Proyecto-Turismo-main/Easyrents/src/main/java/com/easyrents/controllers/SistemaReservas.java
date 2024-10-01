import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SistemaReservas {
    private List<ReservacionVehiculos> historialReservas;

    // Constructor que inicializa el historial de reservas
    public SistemaReservas() {
        this.historialReservas = new ArrayList<>();
    }

    // Método para agregar una nueva reserva al historial
    public void agregarReserva(ReservacionVehiculos reserva) {
        historialReservas.add(reserva);
        System.out.println("Reserva añadida al historial: " + reserva);
    }

    // Método para visualizar el historial de reservas
    public void mostrarHistorialReservas() {
        if (historialReservas.isEmpty()) {
            System.out.println("No hay reservas en el historial.");
        } else {
            System.out.println("Historial de Reservas:");
            for (ReservacionVehiculos reserva : historialReservas) {
                System.out.println(reserva);
            }
        }
    }

    // Método para obtener una reserva por ID de vehículo
    public ReservacionVehiculos obtenerReservaPorID(int vehiculoId) {
        for (ReservacionVehiculos reserva : historialReservas) {
            if (reserva.getVehiculo().getID() == vehiculoId) {
                return reserva;
            }
        }
        return null;
    }

    // Método para modificar una reserva existente
    public boolean modificarReserva(int vehiculoId, Date nuevaFechaInicio, Date nuevaFechaFin) {
        ReservacionVehiculos reserva = obtenerReservaPorID(vehiculoId);
        if (reserva != null) {
            reserva = new ReservacionVehiculos(reserva.getVehiculo(), reserva.getCliente(), nuevaFechaInicio, nuevaFechaFin);
            System.out.println("Reserva modificada: " + reserva);
            return true;
        } else {
            System.out.println("No se encontró la reserva para el vehículo con ID: " + vehiculoId);
            return false;
        }
    }

    // Método para cancelar una reserva existente
    public boolean cancelarReserva(int vehiculoId) {
        ReservacionVehiculos reserva = obtenerReservaPorID(vehiculoId);
        if (reserva != null) {
            historialReservas.remove(reserva);
            reserva.getVehiculo().setDisponible(true); // Marca el vehículo como disponible nuevamente
            System.out.println("Reserva cancelada para el vehículo con ID: " + vehiculoId);
            return true;
        } else {
            System.out.println("No se encontró la reserva para el vehículo con ID: " + vehiculoId);
            return false;
        }
    }

    public static void main(String[] args) {
        SistemaReservas sistema = new SistemaReservas();
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(new Vehiculo(1, "Toyota", "Corolla", 2020, "Sedán", 50.0, true));

        // Fechas para la reserva
        Date fechaInicio = new Date(2024 - 1900, 10, 10);
        Date fechaFin = new Date(2024 - 1900, 10, 15); 

        // Reservar vehículo
        ReservacionVehiculos reserva1 = ReservacionVehiculos.reservarVehiculo(1, listaVehiculos, "Juan Pérez", fechaInicio, fechaFin);
        sistema.agregarReserva(reserva1);

        // Mostrar historial de reservas
        sistema.mostrarHistorialReservas();

        // Modificar la reserva
        Date nuevaFechaInicio = new Date(2024 - 1900, 10, 12);
        Date nuevaFechaFin = new Date(2024 - 1900, 10, 18);  
        sistema.modificarReserva(1, nuevaFechaInicio, nuevaFechaFin);

        // Cancelar la reserva
        sistema.cancelarReserva(1);
    }
}
