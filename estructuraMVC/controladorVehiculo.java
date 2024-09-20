import java.util.ArrayList;

public class controladorVehiculo {
    private modeloVehiculo vehiculo;
    private vistaBusquedaVehiculos vistaBusquedaVehiculos;

    public controladorVehiculo(modeloVehiculo vehiculo, vistaBusquedaVehiculos vistaBusquedaVehiculos){
        this.vehiculo = vehiculo;
        this.vistaBusquedaVehiculos = vistaBusquedaVehiculos;
    }

    public void buscarVehiculos(String criteriosBusqueda) {
        if(criteriosBusqueda == null || criteriosBusqueda.isEmpty()){
            vistaBusquedaVehiculos.mostrarError("Por favor, ingrese todos los criterios de búsqueda.");
            return;
        }
        // FALTA IMPLEMENTAR LA LÓGICA PARA BUSCAR EN LA BASE DE DATOS LOS VEHÍCULOS QUE CUMPLAN CON LAS CARACTERÍSTICAS INGRESADAS: List<modeloVehiculo> resultados = vehiculo.buscarVehiculos(criteriosBusqueda);
        // SE DEJA UNA ARRAYLIST VACÍA PARA QUE EL CÓDIGO NO DE ERROR POR AHORA:
        ArrayList<modeloVehiculo> resultados = new ArrayList<modeloVehiculo>();
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
        // FALTA IMPLEMENTAR BUSCAR EN LA BASE DE DATOS Y RETORNAR EL VEHÍCULO CON ID: modeloVehiculo vehiculoEncontrado = vehiculo.obtenerVehiculoPorID(vehiculoId);
        // POR AHORA ESTÁ ASIGNADO A UN VEHÍCULO CUALQUIERA PARA QUE EL CÓDIGO NO TIRE ERRORES.
        modeloVehiculo vehiculoEncontrado = null;
        if(vehiculoEncontrado != null){
            vistaBusquedaVehiculos.mostrarDetallesVehiculo(vehiculoEncontrado);
        }
        else {
            vistaBusquedaVehiculos.mostrarError("No se encontraron vehículos disponibles.");
        }
    }
}
