//Requisitos funcionales a cumplir: 7.Pago y Facturacion
//Separar Pago y Facturacion en diferentes clases?
package com.easyrents;

import java.util.Date;

public class controladorPago {
    private Pago pago;
    private vistaPago vistaPago;

    //CONSTRUCTOR
    public controladorPago(Pago pago, vistaPago vistaPago){
        this.pago = pago;
        this.vistaPago = vistaPago;
    }

    //para pagar la reserva se pide el ID de esta junto al metodo de pago
    public void realizarPago(int reservaId, String metodoPago) {
        if(reservaId <= 0 || metodoPago == null || metodoPago.isEmpty()){
        //mejor implementar devolver valores, que luego seran procesados en el main
        //que devolver texto. En mi opinion, Hector
        //devolver numeros o hacer un enum para chequear casos
        vistaPago.mostrarError("El ID de la reserva y el metodo de pago son obligatorios.");
        return;
        } else {
            for (Reserva reserva : listaReserva) {//listaReserva debe cambiarse por base de datos
                if (reserva.getId() == idReserva) {
                    pago = new Pago(reservaId,//id de la reserva o un contador de pagos??? 
                    reserva, reserva.getMonto(), new Date(), metodoPago);//fecha actual = new Date()
                    vistaPago.mostrarMensajeExito("Pago procesado exitosamente para la reserva ID: " + reservaId);
                    return;    
                } 
            }
            //si el for termina y no se encuentra la reserva
            vistaPago.mostrarError("No se encontró la reserva con ID " + reservaId);
            return;
        }
    }
    
    public void generarFactura(int pagoId) {
        if (pago == null){
            vistaPago.mostrarError("No se encontró el pago con ID " + pagoId);
            return;
        } else {
            for (Pago pago : listaPago) {//listaPago debe cambiarse por base de datos
                if (pago.getId() == pagoId) {
                    String factura ="Factura para el pago ID: " + pagoId + "\n" +
                                    "Reserva asociada: " + pago.getReserva().getId() + "\n" +
                                    "Método de pago: " + pago.getMetodoPago() + "\n" +
                                    "Monto: $" + pago.getMonto() + "\n" +
                                    "Fecha: " + pago.getFecha();
                    mostrarMensaje(factura);
                }
            }
        }  
    }
}