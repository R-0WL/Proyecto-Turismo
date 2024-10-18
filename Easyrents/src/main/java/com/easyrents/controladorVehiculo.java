package com.easyrents;

import java.util.ArrayList;
import java.util.List;

// Clase controladorVehiculo que maneja la lógica de búsqueda de vehículos
// y la interacción con la vista de búsqueda de vehículos.
public class controladorVehiculo {
    private vistaBusquedaVehiculos vistaBusquedaVehiculos; // Vista para la búsqueda de vehículos
    private List<Vehiculo> listaVehiculos; // Lista de vehículos disponibles para la búsqueda

    // Constructor de la clase controladorVehiculo
    public controladorVehiculo(vistaBusquedaVehiculos vistaBusquedaVehiculos, List<Vehiculo> listaVehiculos) {
        this.vistaBusquedaVehiculos = vistaBusquedaVehiculos; // Inicializa la vista de búsqueda
        // Inicializa la lista de vehículos, utilizando una lista vacía si se pasa un valor nulo
        this.listaVehiculos = listaVehiculos != null ? listaVehiculos : new ArrayList<>();
    }

    // Método para buscar vehículos en la lista según los criterios proporcionados
    public void buscarVehiculos(String criteriosBusqueda) {
        // Verifica si se han proporcionado criterios de búsqueda
        if (criteriosBusqueda == null || criteriosBusqueda.isEmpty()) {
            // Muestra un mensaje de error si los criterios no son válidos
            vistaBusquedaVehiculos.mostrarError("Por favor, ingrese todos los criterios de búsqueda.");
            return; // Sale del método si no hay criterios válidos
        }
        
        // Busca vehículos que coincidan con los criterios en la lista de vehículos
        List<Vehiculo> resultados = Vehiculo.buscarVehiculos(criteriosBusqueda, listaVehiculos);
        
        // Verifica si se encontraron resultados
        if (resultados.isEmpty()) {
            // Muestra un mensaje de error si no hay vehículos disponibles
            vistaBusquedaVehiculos.mostrarError("No se encontraron vehiculos disponibles.");
        } else {
            // Muestra los resultados de búsqueda en la vista
            vistaBusquedaVehiculos.mostrarResultadosBusqueda(resultados);
        }
    }

    // Método para mostrar los detalles de un vehículo específico
    public void mostrarDetallesVehiculo(int vehiculoId) {
        // Verifica que el ID del vehículo sea válido
        if (vehiculoId <= 0) {
            // Muestra un mensaje de error si el ID no es válido
            vistaBusquedaVehiculos.mostrarError("El ID del vehículo no es válido.");
            return; // Sale del método si el ID no es válido
        }
        
        // Busca el vehículo correspondiente al ID proporcionado
        Vehiculo vehiculoEncontrado = Vehiculo.obtenerVehiculoPorID(vehiculoId, listaVehiculos);
        
        // Verifica si se encontró el vehículo
        if (vehiculoEncontrado != null) {
            // Muestra los detalles del vehículo en la vista
            vistaBusquedaVehiculos.mostrarDetallesVehiculo(vehiculoEncontrado);
        } else {
            // Muestra un mensaje de error si no se encontró el vehículo
            vistaBusquedaVehiculos.mostrarError("No se encontraron vehículos disponibles.");
        }
    }
}
