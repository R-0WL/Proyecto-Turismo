import java.util.Date;
public class controladorReservacion {
    private Reserva reserva;
    private vistaReservacion vistaReservacion;

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
}
