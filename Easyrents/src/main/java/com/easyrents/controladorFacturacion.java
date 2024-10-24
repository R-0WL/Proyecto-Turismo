package com.easyrents;

public class controladorFacturacion {
    private vistaFacturacion vistaFacturacion;

    // CONSTRUCTOR
    public controladorFacturacion(vistaFacturacion vistaFacturacion) {
        this.vistaFacturacion = vistaFacturacion;
    }

    // Generar factura para un pago específico
    public void generarFactura(Pago pago) {
        if (pago == null) {
            vistaFacturacion.mostrarError("No se encontró el pago.");
            return;
        }

        // Creación de la factura
        String factura = "Factura para el pago ID: " + pago.getId() + "\n" +
                         "Reserva asociada: " + pago.getReserva().getId() + "\n" +
                         "Método de pago: " + pago.getMetodoPago() + "\n" +
                         "Monto: $" + pago.getMonto() + "\n" +
                         "Fecha: " + pago.getFecha();

        // Mostrar la factura en la vista de facturación
        vistaFacturacion.mostrarFactura(factura, pago.getId());
    }
}
