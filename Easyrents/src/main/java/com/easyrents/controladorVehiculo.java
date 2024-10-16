//Requisitos funcionales a cumplir: 7.Busqueda de Vehiculos
import java.util.List;

public class controladorVehiculo {
    private vistaBusquedaVehiculos vistaBusquedaVehiculos;
    private List<Vehiculo> listaVehiculos;

    public controladorVehiculo(vistaBusquedaVehiculos vistaBusquedaVehiculos, List<Vehiculo> listaVehiculos){
        this.vistaBusquedaVehiculos = vistaBusquedaVehiculos;
        this.listaVehiculos = listaVehiculos;
    }

    public void buscarVehiculos(String criteriosBusqueda) {
        if(criteriosBusqueda == null || criteriosBusqueda.isEmpty()){
            vistaBusquedaVehiculos.mostrarError("Por favor, ingrese todos los criterios de búsqueda.");
            return;
        }
        List<Vehiculo> resultados = Vehiculo.buscarVehiculos(criteriosBusqueda, listaVehiculos);
        if(resultados.isEmpty()){
            vistaBusquedaVehiculos.mostrarError("No se encontraron vehiculos disponibles.");
        }
        else {
            vistaBusquedaVehiculos.mostrarResultadosBusqueda(resultados);
        }
    }
    
    public void mostrarDetallesVehiculo(int vehiculoId) {
        if(vehiculoId <= 0){
            vistaBusquedaVehiculos.mostrarError("El ID del vehículo no es válido.");
            return;
        }
        Vehiculo vehiculoEncontrado = Vehiculo.obtenerVehiculoPorID(vehiculoId, listaVehiculos);
        if(vehiculoEncontrado != null){
            vistaBusquedaVehiculos.mostrarDetallesVehiculo(vehiculoEncontrado);
        }
        else {
            vistaBusquedaVehiculos.mostrarError("No se encontraron vehículos disponibles.");
        }
    }
}
