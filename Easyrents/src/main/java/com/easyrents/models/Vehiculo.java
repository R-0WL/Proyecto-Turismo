public class Vehiculo {
    private int id;
    private String marca;
    private String modelo;
    private int año;
    private String tipo;
    private double precio;
    private boolean disponible;

    //METODO CONSTRUCTOR
    public Vehiculo(int id, String marca, String modelo, int año, String tipo, double precio, boolean disponible) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.tipo = tipo;
        this.precio = precio;
        this.disponible = disponible;
    }
    
    //GETTERS
    public int getID(){return id;}
    public String getMarca(){return marca;}
    public String getModelo(){return modelo;}
    public int getAño(){return año;}
    public String getTipo(){return tipo;}
    public double getPrecio(){return precio;}
    public boolean getDisponible(){return disponible;}

    //SETTERS
    public void setID(int id){this.id = id;}
    public void setMarca(String marca){this.marca = marca;}
    public void setModelo(String modelo){this.modelo = modelo;}
    public void setAño(int año){this.año = año;}
    public void setTipo(String tipo){this.tipo = tipo;}
    public void setPrecio(double precio){this.precio = precio;}
    public void setDisponible(boolean disponible){this.disponible = disponible;}

    //TOSTRING
    @Override
    public String toString() {
        return "Vehiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", año=" + año + ", tipo=" + tipo
                + ", precio=" + precio + ", disponible=" + disponible + "]";
    }
}
