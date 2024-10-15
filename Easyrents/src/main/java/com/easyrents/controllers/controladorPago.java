public class controladorPago {
    private Pago pago;
    private vistaPago vistaPago;

    public controladorPago(Pago pago, vistaPago vistaPago){
        this.pago = pago;
        this.vistaPago = vistaPago;
    }

    public void procesarPago(int reservaId, String metodoPago) {
        if(reservaId <= 0 || metodoPago == null || metodoPago.isEmpty()){
            vistaPago.mostrarError("El ID de la reserva y el metodo de pago son obligatorios.");
            return;
        }
        Reserva reserva = pago.obtenerReservaporId(reservaId);
        if(reserva == null){
            vistaPago.mostrarError("No se encontró la reserva con ID" +  reservaId);
            return;
        }
        Pago nuevoPago = new Pago(reservaId, reserva, reservaId, null, metodoPago);
        pago.guardarPago(nuevoPago);
        vistaPago.mostrarMensajeExito("Pago procesado exitosamente para la reserva ID: " + reservaId);
    }
    
    public void generarFactura(int pagoId) {
        Pago pago = pago.obtenerPagoPorID(pagoId);
        if (pago == null){
            //MOSTRAR MENSAJE DE ERROR (NO SE ENCONTRO EL PAGO CON ID: -----)
            return;
        }

        //GENERAR FACTURA AQUÍ COMO UN TXT O ALGO

        //MENSAJE DE EXITO DE LA GENERACION DE LA FACTURA E IMPRESION DE LA MISMA   
    }
}