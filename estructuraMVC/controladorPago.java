public class controladorPago {
    private modeloPago pago;
    private vistaPago vistaPago;

    public controladorPago(modeloPago pago, vistaPago vistaPago){
        this.pago = pago;
        this.vistaPago = vistaPago;
    }

    public void procesarPago(int reservaId, String metodoPago) {
        if(reservaId <= 0 || metodoPago == null || metodoPago.isEmpty()){
            vistaPago.mostrarError("El ID de la reserva y el metodo de pago son obligatorios.");
            return;
        }
        // FALTA IMPLEMENTAR LA BÚSQUEDA EN LA BASE DE DATOS DE LA RESERVA: modeloReserva reserva = pago.obtenerReservaporId(reservaId);
        // POR AHORA SE DEJA QUE ÚNICAMENTE RETORNE LA RESERVA DEL PAGO DADO.
        modeloReserva reserva = pago.getReserva();
        if(reserva == null){
            vistaPago.mostrarError("No se encontró la reserva con ID" +  reservaId);
            return;
        }
        modeloPago nuevoPago = new modeloPago(reservaId, reserva, reservaId, null, metodoPago);
        // FALTA IMPLEMENTAR (ESTO ACTUALIZARÍA LA BASE DE DATOS): pago.guardarPago(nuevoPago);
        vistaPago.mostrarConfirmacionPago("Pago procesado exitosamente para la reserva ID: " + reservaId);
    }
    
    public void generarFactura(int pagoId) {
        
    }
}
