//Requisitos a cumplir: 2.Reservacion de Vehiculos / 3.Revision y confirmacion de reservas
//separar tambien en clase por funcion
package com.easyrents;

import java.time.LocalDate;
import java.util.Optional;

public class controladorReservacion {
    private Reserva reserva;
    private vistaReservacion vistaReservacion;
    private int idReserva = 0;

    //CONSTRUCTOR
    public controladorReservacion(Reserva reserva, vistaReservacion vistaReservacion){
        this.reserva = reserva;
        this.vistaReservacion = vistaReservacion;
    }

    //crea una nueva reservacion 
    //falta guardarla en la base de datos
    public Optional<Reserva> crearReservacion(Usuario usuario, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin, double monto) {
        if(usuario == null || vehiculo == null || fechaInicio == null || fechaFin == null) {
            vistaReservacion.mostrarError("Por favor, complete todos los campos requeridos.");
            return Optional.empty();
        } else {
            //id es la cantidad de reservas creadas
            idReserva++;
            reserva = new Reserva(idReserva, usuario, vehiculo, fechaInicio, fechaFin, monto);
            vistaReservacion.mostrarConfirmacion("Reservación creada exitosamente.");
            return reserva;
        }

        //Validar y guardar datos en la base de datos
        try {
            //Reserva nuevaReserva = new Reserva(0, usuario, vehiculo, null, null, 0);
            //guardar en la base de datos
        } catch(IllegalArgumentException e){
            vistaReservacion.mostrarError("Error al crear la reservación:" + e.getMessage());
        }
    }
    
    //modificar una reservacion existente
    //falta guardar en la base de datos
    public void modificarReserva(int idReserva, Vehiculo nuevoVehiculo, LocalDate nuevaFechaInicio, LocalDate nuevaFechaFin, double nuevoMonto) {
        try {
            //itera reservas para encontrar la que se quiere modificar
            if (fechaInicio != null || fechaFin != null || nuevoMonto >= 0 || nuevoVehiculo != null || idReserva > 0) {
                for (Reserva reserva : listaReserva) {//listaReserva debe cambiarse por base de datos
                    if (reserva.getId() == idReserva) {
                        reserva.setVehiculo(nuevoVehiculo);
                        reserva.setFechaInicio(nuevaFechaInicio);
                        reserva.setFechaFin(nuevaFechaFin);
                        reserva.setMonto(nuevoMonto);
                        vistaReservacion.mostrarConfirmacion(null, "La reservación ha sido modificada con éxito.");
                        return;
                    }
                }   
            } else {
                vistaReservacion.mostrarError("A ingresado un valor invalido o no ha ingresado un valor, intente de nuevo.");
            }
        } catch (IllegalArgumentException e) {
            vistaReservacion.mostrarError("Error al modificar la reserva: " +  e.getMessage());
        }
    }

    //cancelar la reservación
    public void cancelarReserva(int idReserva) {
        try {    
            if (idReserva > 0) {
                for (Reserva reserva : listaReserva) {//listaReserva debe cambiarse por base de datos
                    if (reserva.getId() == idReserva) {
                        reserva = null;
                        vistaReservacion.mostrarError("La reservación ha sido cancelada exitosamente.");
                        return;
                    }
                }   
            } else {
                vistaReservacion.mostrarError("A ingresado un valor invalido o no ha ingresado un valor, intente de nuevo.");
            }
        } catch (IllegalArgumentException e) {
            vistaReservacion.mostrarError("Error al eliminar la reserva: " +  e.getMessage());
        }
    }
}