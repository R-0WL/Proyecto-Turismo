import java.awt.EventQueue;
import java.util.ArrayList;
import main.java.com.easyrents.views.vistaInicioSesion;

import javax.swing.JFrame;

public class EasyRents {

	private static JFrame frmEasyrents;
	// private static ArrayList<Reserva> listaReservas;
	// private static ArrayList<Pago> listaPagos;
	// private static ArrayList<Usuario> listaUsuarios;
	// private static ArrayList<Vehiculo> listaVehiculos;
	public vistaInicioSesion listaa; 

	public static void main(String[] args) {
		frmEasyrents = new JFrame();
		frmEasyrents.setVisible(true);
		frmEasyrents.setTitle("EasyRents");
		frmEasyrents.setSize(360, 640);
		frmEasyrents.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEasyrents.setLocationRelativeTo(null);
        frmEasyrents.setLayout(null);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaInicioSesion window = new vistaInicioSesion();
					window.mostrarFormulario(frmEasyrents);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}