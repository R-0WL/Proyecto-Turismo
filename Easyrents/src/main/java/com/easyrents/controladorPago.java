package com.easyrents;

//Requisitos funcionales a cumplir: 7.Pago y Facturacion
//Separar Pago y Facturacion en diferentes clases?

import java.util.Date;

public class controladorPago {
    private Pago pago;
    private vistaPago vistaPago;

    //CONSTRUCTOR
    public controladorPago(Pago pago, vistaPago vistaPago){
        this.pago = pago;
        this.vistaPago = vistaPago;
    }

    //para cancelar la reserva se pide el ID de esta junto al metodo de pago
    public void realizarPago(int reservaId, String metodoPago) {
        if(reservaId <= 0 || metodoPago == null || metodoPago.isEmpty()){
            //mejor implementar devolver valores, que luego seran procesados en el main
            //que devolver texto. En mi opinion, Hector
            //devolver numeros o hacer un enum para chequear casos
            vistaPago.mostrarError("El ID de la reserva y el metodo de pago son obligatorios.");
            return;
         } else {
            Pago pay = new Pago(/**contador de las reservas guardadas en la bd */4, 
            /** iterar bd buscando la reserva que TRUE = reserva.getID == reservaId */null, 
            /** de la reserva apuntada, reserva.getMonto() */4, new Date(), metodoPago);
            if(reserva == null){
                //mejor implementar devolver valores, que luego seran procesados en el main
                //que devolver texto. En mi opinion, Hector
                vistaPago.mostrarError("No se encontró la reserva con ID" +  reservaId);
                return;
            }
            //obtencion de datos de la reserva y crear con ellos un pago
            Pago nuevoPago = new Pago(reservaId, reserva, reserva.getMonto, reserva.getFechaPago, metodoPago);
            pago.guardarPago(nuevoPago);
            vistaPago.mostrarMensajeExito("Pago procesado exitosamente para la reserva ID: " + reservaId);
         }
    }
    
    public void generarFactura(int pagoId) {
        Pago pago = pago.obtenerPagoPorID(pagoId);
        if (pago == null){
            vistaPago.mostrarError("No se encontró el pago con ID " + pagoId);
            return;
        }

        //GENERAR FACTURA AQUÍ COMO UN TXT O ALGO
        String factura = "Factura para el pago ID: " + pagoId + "\n" +
                             "Reserva asociada: " + pago.getReserva().getId() + "\n" +
                             "Método de pago: " + pago.getMetodoPago() + "\n" +
                             "Monto: $" + pago.getMonto() + "\n" +
                             "Fecha: " + pago.getFecha();
        //MENSAJE DE EXITO DE LA GENERACION DE LA FACTURA E IMPRESION DE LA MISMA   
    }
}