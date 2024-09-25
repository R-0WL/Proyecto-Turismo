import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
        modeloListaVehiculos.clear(); // Limpiar la lista antes de mostrar nuevos resultados
        for (Vehiculo vehiculo : vehiculos) {
            modeloListaVehiculos.addElement(vehiculo.getModelo()); // Mostrar el modelo del vehículo
        }
    }
    public void mostrarDetallesVehiculo(Vehiculo vehiculo) {
        // Limpiar el panel de detalles antes de mostrar nueva información
        panelDetalles.removeAll();

        // Agregar información del vehículo al panel
        panelDetalles.add(new JLabel("Marca: " + vehiculo.getMarca()));
        panelDetalles.add(new JLabel("Modelo: " + vehiculo.getModelo()));
        panelDetalles.add(new JLabel("Año: " + vehiculo.getAño()));
        panelDetalles.add(new JLabel("Precio: $" + vehiculo.getPrecio()));

        // Refrescar el panel para mostrar los nuevos datos
        panelDetalles.revalidate();
        panelDetalles.repaint();
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(frame, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrar() {
        frame.setVisible(true);
    }
    }
    public void mostrarError(String string) {
        JOptionPane.showMessageDialog(frame, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
