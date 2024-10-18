package com.easyrents;

//Requisitos a cumplir: 2.Reservacion de Vehiculos / 3.Revision y confirmacion de reservas
//separar tambien en clase por funcion
import java.time.LocalDate;
public class controladorReservacion {
    private Reserva reserva;
    private vistaReservacion vistaReservacion;

    //constructor
    public controladorReservacion(Reserva reserva, vistaReservacion vistaReservacion){
        this.reserva = reserva;
        this.vistaReservacion = vistaReservacion;
    }

    //crea una nueva reservacion 
    //falta guardarla en la base de datos
    public void crearReservacion(Usuario usuario, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
        if(usuario == null || vehiculo == null || fechaInicio == null || fechaFin == null){
            vistaReservacion.mostrarError("Por favor, complete todos los campos requeridos.");
            return;
        }

        //Validar y guardar datos en la base de datos
        try {
            //Reserva nuevaReserva = new Reserva(0, usuario, vehiculo, null, null, 0);
            //guardar en la base de datos
            vistaReservacion.mostrarConfirmacion("Reservación creada exitosamente.");
        } catch(IllegalArgumentException e){
            vistaReservacion.mostrarError("Error al crear la reservación:" + e.getMessage());
        }
    }
    
    //modigifar una reservacion existente 
    public void modificarReserva(LocalDate nuevaFechaInicio, LocalDate nuevaFechaFin, double nuevoTotal) {
        try {
            reserva.setFechaInicio(nuevaFechaInicio);
            reserva.setFechaFin(nuevaFechaFin);
            reserva.setMonto(nuevoTotal);
            vistaReservacion.mostrarError("La reservación ha sido modificada con éxito.");
        } catch (IllegalArgumentException e) {
            vistaReservacion.mostrarError("Error al modifiacr la reserva: " +  e.getMessage());
        }
        //falta guardar en la base de datos
    }

    //cancelar la reservación
    public void cancelarReserva() {
        reserva.setFechaInicio(null);
        reserva.setFechaFin(null);
        reserva.setMonto(0.0);
        vistaReservacion.mostrarError("La reservación ha sido cancelada exitosamente.");
    }
}