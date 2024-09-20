import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class vistaInicioSesion {

    public void mostrarFormulario(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();
        
        JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(32, 279, 280, 30);
		passwordField.setToolTipText("Contraseña");
		passwordField.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		passwordField.setBackground(Color.WHITE);
		frame.add(passwordField);
		
		JLabel welcomeLbl = new JLabel("¡Bienvenid@ a EasyRents!");
		welcomeLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 19));
		welcomeLbl.setLabelFor(frame);
		welcomeLbl.setBounds(68, 172, 211, 36);
		frame.getContentPane().add(welcomeLbl);
		
		JLabel visitanosLbl = new JLabel("¡Visítanos en redes sociales!");
		visitanosLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		visitanosLbl.setBounds(87, 481, 180, 36);
		frame.getContentPane().add(visitanosLbl);
		
		JLabel imgTwitter = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/img/twitter-icon.png")).getImage();
		imgTwitter.setIcon(new ImageIcon(img));
		imgTwitter.setBounds(180, 518, 50, 50);
		frame.getContentPane().add(imgTwitter);
		
		JLabel imgInsta = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/img/insta-icon.png")).getImage();
		imgInsta.setIcon(new ImageIcon(img2));
		imgInsta.setBounds(110, 518, 50, 50);
		frame.getContentPane().add(imgInsta);
		
		JTextField txtCorreoElectrnico = new JTextField();
		txtCorreoElectrnico.setToolTipText("Correo Electrónico");
		txtCorreoElectrnico.setBackground(Color.WHITE);
		txtCorreoElectrnico.setBounds(32, 230, 280, 30);
		frame.getContentPane().add(txtCorreoElectrnico);
		
		JLabel lbleasyrents = new JLabel("@EasyRents");
		lbleasyrents.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lbleasyrents.setBounds(130, 565, 85, 36);
		frame.getContentPane().add(lbleasyrents);
		
		JLabel visitanosLbl_1 = new JLabel("¿No tienes una cuenta?");
		visitanosLbl_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		visitanosLbl_1.setBounds(99, 377, 199, 36);
		frame.getContentPane().add(visitanosLbl_1);
		
		JButton createAccountBtn = new JButton("Crear Cuenta");
		createAccountBtn.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		createAccountBtn.setBounds(109, 413, 121, 30);
        createAccountBtn.setBackground(Color.WHITE);
		frame.getContentPane().add(createAccountBtn);
		
		JButton loginBtn_1 = new JButton("Iniciar Sesión");
		loginBtn_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		loginBtn_1.setBounds(109, 320, 121, 47);
        loginBtn_1.setBackground(Color.WHITE);
        loginBtn_1.addActionListener(new ActionListener() {
            // CONDICIONAL QUE VENDRÁ DE VALIDAR LOS DATOS DEL USUARIO, FALTA IMPLEMENTAR
            boolean credentialsValidated = true;
            @Override
            public void actionPerformed(ActionEvent e){
                if(credentialsValidated){
                    redireccionarCrearCuenta(frame);
                }
            }
        });
		frame.getContentPane().add(loginBtn_1);
    }
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Ha ocurrido un error.", JOptionPane.ERROR_MESSAGE);
        
    }

    public void redireccionarCrearCuenta(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();

        JButton backBtn = new JButton("Regresar");
		backBtn.setBackground(Color.WHITE);
		backBtn.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		backBtn.setBounds(257, 550, 87, 51);
        backBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                mostrarFormulario(frame);
            }
        });
		frame.add(backBtn);
		
		JLabel titleLbl = new JLabel("Creación de Cuenta");
		titleLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 22));
		titleLbl.setBounds(78, 11, 189, 45);
		frame.add(titleLbl);
    }

    public void redireccionarDashboard() {
        // Código para redirigir al dashboard después de iniciar sesión
    }
}
