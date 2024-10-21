package com.easyrents;

public class controladorFacturacion {
    private vistaFacturacion vistaFacturacion;

    // Constructor
    public controladorFacturacion(vistaFacturacion vistaFacturacion) {
        this.vistaFacturacion = vistaFacturacion;
    }

    // Método para generar factura
    public void generarFactura(Pago pago) {
        if (pago == null) {
            vistaFacturacion.mostrarError("No se encontró el pago.");
            return;
        }

        String factura = "Factura para el pago ID: " + pago.getId() + "\n" +
                         "Reserva asociada: " + pago.getReserva().getId() + "\n" +
                         "Método de pago: " + pago.getMetodoPago() + "\n" +
                         "Monto: $" + pago.getMonto() + "\n" +
                         "Fecha: " + pago.getFecha();
                         
        vistaFacturacion.mostrarFactura(factura); // Muestra la factura en la vista de facturación
    }
}
