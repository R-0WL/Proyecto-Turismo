import java.util.Date;
public class controladorReservacion {
    private modeloReserva reserva;
    private vistaReservacion vistaReservacion;

    public controladorReservacion(modeloReserva reserva, vistaReservacion vistaReservacion){
        this.reserva = reserva;
        this.vistaReservacion = vistaReservacion;
    }

    public void crearReservacion(modeloUsuario usuario, modeloVehiculo vehiculo, Date fechaInicio, Date fechaFin) {
        if(usuario == null || vehiculo == null || fechaInicio == null || fechaFin == null){
            vistaReservacion.mostrarError("Por favor, complete todos los campos requeridos.");
            return;
        }

        modeloReserva nuevaReserva = new modeloReserva(0, null, null, null, null, 0);
        reserva.guardarReserva(nuevaReserva);
        vistaReservacion.mostrarMensajeExito("Reservación creada exitosamente.");
    }
}
