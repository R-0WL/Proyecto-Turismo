package com.easyrents;

import java.util.List;

//AGREGAR METODOS MOSTRAR A VISTABUSCARVEHICULO!!!

public class controladorVehiculo {
    private VistaBusquedaVehiculos vistaBusquedaVehiculos;
    private List<Vehiculo> listaVehiculos; // Cambiado a List para mayor flexibilidad

    // Constructor
    public controladorVehiculo(VistaBusquedaVehiculos vistaBusquedaVehiculos, List<Vehiculo> listaVehiculos) {
        this.vistaBusquedaVehiculos = vistaBusquedaVehiculos;
        this.listaVehiculos = listaVehiculos;
    }

    // Método para buscar vehículos
    public void buscarVehiculos(String marca, String modelo, String tipo) {
        if (marca.isEmpty() && modelo.isEmpty() && tipo.isEmpty()) {
            vistaBusquedaVehiculos.mostrarError("Por favor, ingrese todos los criterios de búsqueda.");
            return;
        }

        List<Vehiculo> resultados = Vehiculo.buscarVehiculos(marca, modelo, tipo, listaVehiculos);
        if (resultados.isEmpty()) {
            vistaBusquedaVehiculos.mostrarError("No se encontraron vehículos disponibles.");
        } else {
            vistaBusquedaVehiculos.mostrarResultadosBusqueda(resultados);
        }
    }

    // Método para mostrar detalles de un vehículo
    public void mostrarDetallesVehiculo(int vehiculoId) {
        if (vehiculoId <= 0) {
            vistaBusquedaVehiculos.mostrarError("El ID del vehículo no es válido.");
            return;
        }

        Vehiculo vehiculoEncontrado = Vehiculo.obtenerVehiculoPorID(vehiculoId, listaVehiculos);
        if (vehiculoEncontrado != null) {
            vistaBusquedaVehiculos.mostrarDetallesVehiculo(vehiculoEncontrado);
        } else {
            vistaBusquedaVehiculos.mostrarError("No se encontraron vehículos disponibles con el ID proporcionado.");
        }
    }
}