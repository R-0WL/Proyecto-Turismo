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
        // FALTA IMPLEMENTAR QUE GUARDE LA NEUVA RESERVA EN LA BASE DE DATOS: reserva.guardarReserva(nuevaReserva);
        vistaReservacion.mostrarConfirmacion("Reservación creada exitosamente.");
    }
}
