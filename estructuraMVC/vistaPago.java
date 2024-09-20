import javax.swing.JOptionPane;

public class vistaPago {
    public void mostrarFormularioPago(modeloReserva reserva) {
        // Código para mostrar el formulario de pago
    }
    public void mostrarConfirmacionPago(String message) {
        // Código para mostrar la confirmación del pago
        JOptionPane.showMessageDialog(null, message, "Pago exitoso!", JOptionPane.INFORMATION_MESSAGE);
    }
    public void mostrarError(String mensaje) {
        // Código para mostrar errores durante el proceso de pago
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
