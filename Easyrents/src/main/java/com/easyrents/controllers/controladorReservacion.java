import java.util.Date;
public class controladorReservacion {
    private Reserva reserva;
    private vistaReservacion vistaReservacion;

    //CORREGIR TODOS LOS ERRRORES QUE HAYA

    public controladorReservacion(Reserva reserva, vistaReservacion vistaReservacion){
        this.reserva = reserva;
        this.vistaReservacion = vistaReservacion;
    }

    public void crearReservacion(Usuario usuario, Vehiculo vehiculo, Date fechaInicio, Date fechaFin) {
        if(usuario == null || vehiculo == null || fechaInicio == null || fechaFin == null){
            vistaReservacion.mostrarError("Por favor, complete todos los campos requeridos.");
            return;
        }

        Reserva nuevaReserva = new Reserva(0, null, null, null, null, 0);
        reserva.guardarReserva(nuevaReserva);
        vistaReservacion.mostrarMensajeExito("Reservación creada exitosamente.");
    }


    public void modificarReserva(Date nuevaFechaInicio, Date nuevaFechaFin, double nuevoTotal) {
        this.fechaInicio = nuevaFechaInicio;
        this.fechaFin = nuevaFechaFin;
        this.total = nuevoTotal;
        System.out.println("La reserva con ID " + this.id + " ha sido modificada.");
    }

    public void cancelarReserva() {
        // Implementación para cancelar la reserva, podría implicar la anulación del objeto o cambios en su estado
        System.out.println("La reserva con ID " + this.id + " ha sido cancelada.");
        this.fechaInicio = null;
        this.fechaFin = null;
        this.total = 0.0;
    }
}
