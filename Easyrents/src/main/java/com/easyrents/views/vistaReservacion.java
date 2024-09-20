import javax.swing.JFrame;

public class vistaReservacion {
    private JFrame frame; // Ventana principal

    // Constructor para inicializar la ventana
    public vistaReservacion() {
        frame = new JFrame("Reservacion");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    }
    public void mostrarFormularioReservacion(Vehiculo vehiculo) {
        // Código para mostrar el formulario de reservación
    }
    public void mostrarConfirmacion(Reserva reserva) {
        // Código para mostrar la confirmación de la reservación
    }
    public void mostrarError(String mensaje) {
        // Código para mostrar errores durante la reservación
    }
}
