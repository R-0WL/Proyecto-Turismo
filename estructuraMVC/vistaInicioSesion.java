import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class vistaInicioSesion {

    public void mostrarFormulario(JFrame frame) {
        if(!frame.isShowing()){
            frame.setVisible(true);
        }
        frame.getContentPane().removeAll();
        
        frame.setTitle("EasyRents");
		frame.setAlwaysOnTop(true);
		frame.setSize(360, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(32, 279, 280, 30);
		passwordField.setToolTipText("Contraseña");
		passwordField.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		passwordField.setBackground(Color.WHITE);
		frame.add(passwordField);
		
		JLabel welcomeLbl = new JLabel("Bienvenid@, usuario");
		welcomeLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 19));
		welcomeLbl.setLabelFor(frame);
		welcomeLbl.setBounds(87, 171, 199, 36);
		frame.add(welcomeLbl);
		
		JLabel visitanosLbl = new JLabel("¡Visítanos en redes sociales!");
		visitanosLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		visitanosLbl.setBounds(87, 320, 199, 36);
		frame.add(visitanosLbl);
		
		JLabel imgTwitter = new JLabel("");
		Image img = new ImageIcon(getClass().getResource("/img/twitter-icon.png")).getImage();
		imgTwitter.setIcon(new ImageIcon(img));
		imgTwitter.setBounds(180, 356, 50, 50);
		frame.add(imgTwitter);
		
		JLabel imgInsta = new JLabel("");
		Image img2 = new ImageIcon(getClass().getResource("/img/insta-icon.png")).getImage();
		imgInsta.setIcon(new ImageIcon(img2));
		imgInsta.setBounds(110, 356, 50, 50);
		frame.add(imgInsta);
		
		JTextField textField = new JTextField();
		textField.setToolTipText("Correo Electrónico");
		textField.setBackground(Color.WHITE);
		textField.setBounds(32, 230, 280, 30);
		frame.add(textField);
    }
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Ha ocurrido un error.", JOptionPane.ERROR_MESSAGE);
        
    }
    public void redireccionarDashboard() {
        // Código para redirigir al dashboard después de iniciar sesión
    }
}
