import java.util.Date;
public class modeloPago {
    private int id;
    private modeloReserva reserva;
    private double monto;
    private Date fechaPago;
    private String metodoPago;

    // Métodos: Getters, Setters, procesarPago, generarFactura

    //METODO CONSTRUCTOR
    public modeloPago (int id, modeloReserva reserva, double monto, Date fechaPago, String metodoPago){
        this.id = id;
        this.reserva = reserva;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
    }

    //GETTERS
    public int getID(){return id;}
    public modeloReserva getReserva(){return reserva;}
    public double getMonto(){return monto;}
    public Date getFechaPago(){return fechaPago;}
    public String getMetodoPago(){return metodoPago;}

    //SETTERS
    public void setID(int id){this. id = id;}
    public void setReserva(modeloReserva reserva){this.reserva = reserva;}
    public void setMonto(double monto){this.monto = monto;}
    public void setFechaPago(Date fechaPago){this.fechaPago = fechaPago;}
    public void setMetodoPago(String metodoPago){this.metodoPago = metodoPago;}


}
