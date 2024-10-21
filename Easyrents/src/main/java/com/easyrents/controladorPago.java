package com.easyrents;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import main.java.com.easyrents.controladorFacturacion;

public class controladorPago {
    private Pago pago;
    private vistaPago vistaPago;
    private List<Reserva> listaReserva; // Esto debería conectarse a la base de datos
    private controladorFacturacion controladorFacturacion; // Nueva instancia de controladorFacturacion para generar facturas
    private List<String> metodosPagoValidos = Arrays.asList("tarjeta", "paypal", "transferencia");

    // Constructor
    public controladorPago(Pago pago, vistaPago vistaPago, controladorFacturacion controladorFacturacion){
        this.pago = pago;
        this.vistaPago = vistaPago;
        this.controladorFacturacion = controladorFacturacion; // Relacionar con facturación
        
    }

    // Método para realizar un pago
    public void realizarPago(int reservaId, String metodoPago) {
        if (reservaId <= 0 || metodoPago == null || metodoPago.isEmpty()) {
            vistaPago.mostrarError("El ID de la reserva y el método de pago son obligatorios.");
            return;
        }
        if (!metodosPagoValidos.contains(metodoPago.toLowerCase())) {
            vistaPago.mostrarError("Método de pago no válido. Los métodos permitidos son: " + metodosPagoValidos);
            return;
        }

        for (Reserva reserva : listaReserva) { // Obtener reserva de la base de datos
            if (reserva.getId() == reservaId) {
                // Crear el pago
                pago = new Pago(reservaId, reserva, reserva.getMonto(), new Date(), metodoPago);
                
                // Mostrar éxito en la vista
                vistaPago.mostrarMensajeExito("Pago procesado exitosamente para la reserva ID: " + reservaId);

                // Generar factura automáticamente tras el pago
                generarFactura(pago.getId());
                return;
            }
            // Si no se encuentra la reserva
            vistaPago.mostrarError("No se encontró la reserva con ID " + reservaId);
        }

        // Si no se encuentra la reserva
        vistaPago.mostrarError("No se encontró la reserva con ID: " + reservaId);
    }

    // Método para generar factura automáticamente después del pago
    private void generarFactura(int pagoId) {
        controladorFacturacion.generarFactura(pago); // Llama al controlador de facturación para mostrar la factura
    }
}
