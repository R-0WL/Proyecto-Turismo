import java.util.ArrayList;
import java.util.List;

public class SistemaBusquedaVehiculos {

    // Método para buscar vehículos en función de varios criterios
    public static List<Vehiculo> buscarVehiculos(String marca, String modelo, String tipo, double precioMaximo, List<Vehiculo> listaVehiculos) {
        List<Vehiculo> resultados = new ArrayList<>();

        for (Vehiculo vehiculo : listaVehiculos) {
            boolean coincideMarca = (marca == null || marca.isEmpty()) || vehiculo.getMarca().equalsIgnoreCase(marca);
            boolean coincideModelo = (modelo == null || modelo.isEmpty()) || vehiculo.getModelo().equalsIgnoreCase(modelo);
            boolean coincideTipo = (tipo == null || tipo.isEmpty()) || vehiculo.getTipo().equalsIgnoreCase(tipo);
            boolean coincidePrecio = vehiculo.getPrecio() <= precioMaximo;

            if (coincideMarca && coincideModelo && coincideTipo && coincidePrecio && vehiculo.getDisponible()) {
                resultados.add(vehiculo);
            }
        }

        return resultados;
    }

    // Método para mostrar los resultados de búsqueda
    public static void mostrarResultados(List<Vehiculo> resultados) {
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron vehículos que coincidan con los criterios de búsqueda.");
        } else {
            System.out.println("Vehículos encontrados:");
            for (Vehiculo vehiculo : resultados) {
                System.out.println(vehiculo);
            }
        }
    }

    public static void main(String[] args) {
        // Lista de vehículos de ejemplo
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(new Vehiculo(1, "Toyota", "Corolla", 2020, "Sedán", 50.0, true));
        listaVehiculos.add(new Vehiculo(2, "Honda", "Civic", 2019, "Sedán", 45.0, true));
        listaVehiculos.add(new Vehiculo(3, "Ford", "Escape", 2021, "SUV", 60.0, true));
        listaVehiculos.add(new Vehiculo(4, "Chevrolet", "Traverse", 2022, "SUV", 75.0, false));

        // Parámetros de búsqueda
        String marca = "Toyota";
        String modelo = "";
        String tipo = "Sedán";
        double precioMaximo = 60.0;

        // Realizar búsqueda
        List<Vehiculo> resultados = buscarVehiculos(marca, modelo, tipo, precioMaximo, listaVehiculos);
        mostrarResultados(resultados);
    }
}
