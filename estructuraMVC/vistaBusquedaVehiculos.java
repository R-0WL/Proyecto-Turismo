import java.util.List;

import javax.swing.JOptionPane;

public class vistaBusquedaVehiculos {
    public void mostrarResultadosBusqueda(List<modeloVehiculo> vehiculos) {
        // Código para mostrar los resultados de la búsqueda de vehículos
    }
    public void mostrarDetallesVehiculo(modeloVehiculo vehiculo) {
        // Código para mostrar detalles de un vehículo específico
    }

    public void mostrarError(String message){
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
