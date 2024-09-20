import java.util.*;
import javax.swing.JFrame;

public class vistaBusquedaVehiculos {
    private JFrame frame; // Ventana principal

    // Constructor para inicializar la ventana
    public vistaBusquedaVehiculos() {
        frame = new JFrame("Búsqueda de Vehículos");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    }
    public void mostrarResultadosBusqueda(List<Vehiculo> vehiculos) {
        // Código para mostrar los resultados de la búsqueda de vehículos
    }
    public void mostrarDetallesVehiculo(Vehiculo vehiculo) {
        // Código para mostrar detalles de un vehículo específico
    }
}
