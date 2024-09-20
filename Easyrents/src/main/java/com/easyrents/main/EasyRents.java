import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class EasyRents {

    private static JFrame frmEasyrents;

    private static void crearVentanaPrincipal() {
        frmEasyrents = new JFrame();
        frmEasyrents.setTitle("EasyRents");
        frmEasyrents.setAlwaysOnTop(true);
        frmEasyrents.setSize(360, 640);
        frmEasyrents.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmEasyrents.setLocationRelativeTo(null);
        frmEasyrents.setLayout(null);
        frmEasyrents.setVisible(true);
    }

    private static void mostrarVistaInicioSesion() {
        try {
            vistaInicioSesion window = new vistaInicioSesion();
            window.mostrarFormulario(frmEasyrents);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) {
        // Inicializar la GUI en el hilo de eventos con lambda y SwingUtilities
        SwingUtilities.invokeLater(() -> {
            crearVentanaPrincipal();
            mostrarVistaInicioSesion();
        });
    }
}
