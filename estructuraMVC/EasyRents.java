import java.awt.EventQueue;

import javax.swing.JFrame;

public class EasyRents {

	private static JFrame frmEasyrents;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		frmEasyrents = new JFrame();
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
