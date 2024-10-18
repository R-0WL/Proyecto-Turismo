package com.easyrents;

import java.time.Year;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        //ingreso por set para validacion
        setAño(año);
        this.tipo = tipo;
        //ingreso por set para validacion
        setPrecio(precio);
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
    //valida que el año sea mayor a 1885 y menor o igual al actual
    public void setAño(int año){
        if (año <= Year.now().getValue() && año >= 1885) {
            this.año = año;
        } else {
            throw new IllegalArgumentException("El año que ingreso no es valido");
        }
    }
    public void setTipo(String tipo){this.tipo = tipo;}
    //valida precio mayor a 0
    public void setPrecio(double precio){
        if (precio > 0) {
            this.precio = precio;
        } else {
            throw new IllegalArgumentException("El precio ingresado no es valido");
        }
    }
    public void setDisponible(boolean disponible){this.disponible = disponible;}

    //TOSTRING
    @Override
    public String toString() {
        return "Vehiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", año=" + año + ", tipo=" + tipo
                + ", precio=" + precio + ", disponible=" + disponible + "]";
    }

    //compara los datos ingresados con los datos de los carros en el sistema y devuelve una lista con todos los carros que compartan datos
    //static hace que se pueda usar sin crear un nuevo objeto Vehiculo, los 2 metodos siguientes
    public static AbstractList<Vehiculo> buscarVehiculosStr(String marca, String modelo, String tipo, AbstractList<Vehiculo> listaVehiculos) {
        //metodo devuelve una lista de vehiculos
        AbstractList<Vehiculo> resultados = new ArrayList<Vehiculo>();
        //ArrayList implements AbstractList (implements List)
        //List<> te permite cambiar fácilmente entre diferentes implementaciones de la interfaz AbstractList sin afectar 
        //el código que usa la lista. Por ejemplo, puedes cambiar de ArrayList<> a LinkedList<> sin modificar demasiado el código
        for (Vehiculo vehiculo : listaVehiculos) {
            //Comprueba si el vehículo coincide con los criterios de búsqueda (marca, modelo, tipo)
            boolean coincideMarca = (marca == null || vehiculo.getMarca().equalsIgnoreCase(marca));
            boolean coincideModelo = (modelo == null || vehiculo.getModelo().equalsIgnoreCase(modelo));
            boolean coincideTipo = (tipo == null || vehiculo.getTipo().equalsIgnoreCase(tipo));

            //Si coincide con al menos un criterio, añadir a la lista de resultados
            if (coincideMarca && coincideModelo && coincideTipo) {
                resultados.add(vehiculo);
            }
        }
    return resultados;
    }

    //iterar listaVehiculo comparando IDs
    public static Optional<Vehiculo> buscarVehiculosID(int vehiculoId, AbstractList<Vehiculo> listaVehiculos) {
        for(Vehiculo vehiculo : listaVehiculos){
            if(vehiculo.getID() == vehiculoId){
                return Optional.of(vehiculo);
            }
        }
        return Optional.empty();
        //return null; => se cambio por el uso de la clase Optional para evitar un mal manejo y la NullPointerException    
    }
}