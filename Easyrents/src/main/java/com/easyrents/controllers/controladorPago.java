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
        modeloReserva reserva = pago.obtenerReservaporId(reservaId);
        if(reserva == null){
            vistaPago.mostrarError("No se encontró la reserva con ID" +  reservaId);
            return;
        }
        modeloPago nuevoPago = new modeloPago(reservaId, reserva, reservaId, null, metodoPago);
        pago.guardarPago(nuevoPago);
        vistaPago.mostrarMensajeExito("Pago procesado exitosamente para la reserva ID: " + reservaId);
    }
    
    public void generarFactura(int pagoId) {
        
    }
}
