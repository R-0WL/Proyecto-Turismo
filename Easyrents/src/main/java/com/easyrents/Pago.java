package com.easyrents;

import java.util.LocalDate;

public class Pago {
    private int id;
    private Reserva reserva;
    private double monto;
    private LocalDate fechaPago;
    private String metodoPago;

    //METODO CONSTRUCTOR
    public Pago (int id, Reserva reserva, double monto, LocalDate fechaPago, String metodoPago){
        this.id = id;
        this.reserva = reserva;
        setMonto(monto);
        //ingreso por set para validacion
        setFechaPago(fechaPago);
        this.metodoPago = metodoPago;
    }

    //GETTERS
    public int getID(){return id;}
    public Reserva getReserva(){return reserva;}
    public double getMonto(){return monto;}
    public LocalDate getFechaPago(){return fechaPago;}
    public String getMetodoPago(){return metodoPago;}

    //SETTERS
    public void setID(int id){this. id = id;}
    public void setReserva(Reserva reserva){this.reserva = reserva;}
    //validar monto mayor 0
    public void setMonto(double monto){
        if (monto > 0) {
            this.monto = monto;
        } else {
            throw new IllegalArgumentException("El monto ingresado no es valido");
        }
    }
    //validar fecha no futura
    public void setFechaPago(java.time.LocalDate fechaPago){
        if ((fechaPago.isBefore(java.time.LocalDate.now())) || (fechaPago.equals(java.time.LocalDate.now()))) {
            this.fechaFin = fechaFin;
        } else {
            throw new IllegalArgumentException("La fecha de pago debe no puede ser futura");
        }
    }
    public void setMetodoPago(String metodoPago){this.metodoPago = metodoPago;}

    //TOSTRING
    @Override
    public String toString() {
        return "Pago [id=" + id + ", reserva=" + reserva + ", monto=" + monto + ", fechaPago=" + fechaPago
                + ", metodoPago=" + metodoPago + "]";
    }
}
//hola