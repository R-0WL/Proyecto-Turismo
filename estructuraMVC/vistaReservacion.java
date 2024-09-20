import javax.swing.JOptionPane;

public class vistaReservacion {
    public void mostrarFormularioReservacion(modeloVehiculo vehiculo) {
        // Código para mostrar el formulario de reservación
    }
    public void mostrarConfirmacion(String message) {
        JOptionPane.showConfirmDialog(null, message, "Creación exitosa", JOptionPane.INFORMATION_MESSAGE);
    }
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
