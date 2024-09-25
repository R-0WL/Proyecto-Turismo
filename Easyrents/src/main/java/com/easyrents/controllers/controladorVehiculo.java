import java.util.List;

public class controladorVehiculo {
    private Vehiculo vehiculo;
    private vistaBusquedaVehiculos vistaBusquedaVehiculos;

    public controladorVehiculo(Vehiculo vehiculo, vistaBusquedaVehiculos vistaBusquedaVehiculos){
        this.vehiculo = vehiculo;
        this.vistaBusquedaVehiculos = vistaBusquedaVehiculos;
    }

    public void buscarVehiculos(String criteriosBusqueda) {
        if(criteriosBusqueda == null || criteriosBusqueda.isEmpty()){
            vistaBusquedaVehiculos.mostrarError("Por favor, ingrese todos los criterios de búsqueda.");
            return;
        }
        List<Vehiculo> resultados = vehiculo.buscarVehiculos(criteriosBusqueda);
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
        Vehiculo vehiculoEncontrado = vehiculo.obtenerVehiculoPorID(vehiculoId);
        if(vehiculoEncontrado != null){
            vistaBusquedaVehiculos.mostrarDetallesVehiculo(vehiculoEncontrado);
        }
        else {
            vistaBusquedaVehiculos.mostrarError("No se encontraron vehículos disponibles.");
        }
    }
}
