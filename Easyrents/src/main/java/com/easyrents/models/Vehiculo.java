import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

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

    //compara los datos ingresados con los datos de los carros en el sistema y devuelve una lista con todos los carros que compartan datos
    //static hace que se pueda usar sin crear un nuevo objeto Vehiculo, los 2 metodos siguientes
    public static AbstractList<Vehiculo> buscarVehiculos(String marca, String modelo, String tipo, AbstractList<Vehiculo> listaVehiculos) {
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

    public static Vehiculo obtenerVehiculoPorID(int vehiculoId, AbstractList<Vehiculo> listaVehiculos) {
        for(Vehiculo vehiculo : listaVehiculos){
            if(vehiculo.getID() == vehiculoId){
                return vehiculo;
            }
        }
        return null;         
    }
}
