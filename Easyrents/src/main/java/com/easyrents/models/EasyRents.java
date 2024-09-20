import java.awt.EventQueue;

import javax.swing.JFrame;

public class EasyRents {
// porque hay un metodo main en una carpeta de modelos!!!?
// arreglar lo mas rapido posible
	private static JFrame frmEasyrents;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		frmEasyrents = new JFrame();
		frmEasyrents.setVisible(true);
		frmEasyrents.setTitle("EasyRents");
		frmEasyrents.setAlwaysOnTop(true);
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
