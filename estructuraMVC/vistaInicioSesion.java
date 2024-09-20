import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class vistaInicioSesion {

    public void mostrarFormulario(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();
        
        Image iconImage = new ImageIcon(this.getClass().getResource("/img/easyLogo.png")).getImage();
        frame.setIconImage(iconImage);

        JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(32, 279, 280, 30);
		passwordField.setToolTipText("Contraseña");
		passwordField.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		passwordField.setBackground(Color.WHITE);
		frame.add(passwordField);
		
		JLabel welcomeLbl = new JLabel("¡Bienvenid@ a EasyRents!");
		welcomeLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 19));
		welcomeLbl.setLabelFor(frame);
		welcomeLbl.setBounds(68, 158, 211, 36);
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
		txtCorreoElectrnico.setBounds(32, 224, 280, 30);
		frame.getContentPane().add(txtCorreoElectrnico);
		
		JLabel lbleasyrents = new JLabel("@EasyRents");
		lbleasyrents.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lbleasyrents.setBounds(130, 565, 85, 36);
		frame.getContentPane().add(lbleasyrents);
		
		JLabel visitanosLbl_1 = new JLabel("¿No tienes una cuenta?");
		visitanosLbl_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		visitanosLbl_1.setBounds(99, 377, 199, 36);
		frame.getContentPane().add(visitanosLbl_1);

        JLabel lblCorreoElectrnico = new JLabel("Correo electrónico:");
		lblCorreoElectrnico.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblCorreoElectrnico.setBounds(115, 193, 105, 36);
		frame.getContentPane().add(lblCorreoElectrnico);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblContrasea.setBounds(137, 250, 64, 36);
		frame.getContentPane().add(lblContrasea);
		
		JButton createAccountBtn = new JButton("Crear Cuenta");
		createAccountBtn.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		createAccountBtn.setBounds(109, 413, 121, 30);
        createAccountBtn.setBackground(Color.WHITE);
        createAccountBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                redireccionarCrearCuenta(frame);
            }
        });
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
                    redireccionarDashboard(frame);
                }else{
                    mostrarError("Las credenciales ingresadas no son correctas, vuelva a intentar.");
                }
            }
        });
		frame.getContentPane().add(loginBtn_1);

        JLabel logoImageLabel = new JLabel();
		Image img4 = new ImageIcon(this.getClass().getResource("/img/easyLogo95x95.png")).getImage();
		logoImageLabel.setIcon(new ImageIcon(img4));
		logoImageLabel.setBounds(116, 7, 115, 95);
		frame.getContentPane().add(logoImageLabel);
		
		JLabel logoNameImgLbl = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/img/easyRents177x50.png")).getImage();
		logoNameImgLbl.setIcon(new ImageIcon(img5));
		logoNameImgLbl.setBounds(84, 106, 177, 50);
		frame.getContentPane().add(logoNameImgLbl);

    }
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Ha ocurrido un error.", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarExito(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    public void redireccionarCrearCuenta(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();

        ArrayList<Object> entryList = new ArrayList<>();

        JButton backBtn = new JButton("Regresar");
		backBtn.setBackground(Color.WHITE);
		backBtn.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		backBtn.setBounds(125, 535, 100, 51);
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

        JLabel lblNewLabel_1 = new JLabel("Llene los siguientes campos para crear su cuenta:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(29, 47, 292, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 109, 94, 29);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JTextField nombreEntry = new JTextField();
		nombreEntry.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		nombreEntry.setBounds(98, 111, 236, 29);
		frame.getContentPane().add(nombreEntry);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Correo:");
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(10, 160, 52, 29);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JTextField correoEntry = new JTextField();
		correoEntry.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		correoEntry.setColumns(10);
		correoEntry.setBounds(98, 162, 236, 29);
		frame.getContentPane().add(correoEntry);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Contraseña:");
		lblNewLabel_1_1_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(10, 272, 94, 29);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		passwordField.setBounds(98, 214, 236, 26);
		frame.getContentPane().add(passwordField);
        entryList.add(passwordField);
		
		JPasswordField passwordFieldConfirmar = new JPasswordField();
		passwordFieldConfirmar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		passwordFieldConfirmar.setBounds(98, 265, 236, 26);
		frame.getContentPane().add(passwordFieldConfirmar);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Confirmar");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(10, 251, 94, 29);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Contraseña:");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_2.setBounds(10, 211, 94, 29);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("¿Cuál es su motivo para");
		lblNewLabel_1_1_1_1_3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_3.setBounds(10, 312, 172, 29);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_3);
		
		JLabel lblNewLabel_1_1_1_1_3_1 = new JLabel("utilizar nuestra app?");
		lblNewLabel_1_1_1_1_3_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_3_1.setBounds(10, 333, 172, 29);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_3_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Escoja una de las opciones siguientes");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Turismo (cualquier índole)", "Trabajo", "Estudios", "Visitas a Familiares", "Residencia Temporal", "Otro (Especifique)"}));
		comboBox.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		comboBox.setBounds(170, 322, 164, 29);
		frame.getContentPane().add(comboBox);

		JLabel razonExtraLbl = new JLabel("Especifique:");
		razonExtraLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		razonExtraLbl.setVisible(false);
		razonExtraLbl.setBounds(24, 372, 80, 20);
		frame.getContentPane().add(razonExtraLbl);
		
		JTextField razonExtra = new JTextField();
		razonExtra.setVisible(false);
		razonExtra.setBounds(117, 371, 217, 29);
		frame.getContentPane().add(razonExtra);

        JButton crearCuentaBtn = new JButton("Crear Cuenta");
		crearCuentaBtn.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 22));
		crearCuentaBtn.setBounds(99, 421, 155, 54);
        crearCuentaBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ArrayList<String> values = new ArrayList<>();
                values.add(nombreEntry.getText());
                values.add(correoEntry.getText());
                values.add(new String(passwordField.getPassword()));
                values.add(new String(passwordFieldConfirmar.getPassword()));
                values.add(comboBox.getSelectedItem().toString());

                for(String s : values){
                    if (s.replaceAll("\\s+","").equals("")){
                        mostrarError("Debe de llenar todos los campos solicitados");
                        return;
                    }
                }

                // Verificar que el correo sea válido (que tenga una @ por lo menos):
                if(!values.get(1).contains("@")){
                    mostrarError("Debe de ingresar una dirección de correo válida");
                    return;
                }

                // Comparar si ambas contraseñas ingresadas son iguales
                if (!values.get(2).equals(values.get(3))){
                    mostrarError("Debe de ingresar la misma contraseña en ambos campos");
                    return;
                }

                boolean objetoOtroEscogido = (values.get(4) == "Otro (Especifique)");
                if(objetoOtroEscogido && !(razonExtra.isVisible() || razonExtraLbl.isVisible())){
                    JOptionPane.showMessageDialog(null, "Por favor llene el nuevo campo emergente.", "Atención", JOptionPane.INFORMATION_MESSAGE);
                    razonExtra.setVisible(true);
                    razonExtraLbl.setVisible(true);
                    return;
                }else if(objetoOtroEscogido && razonExtra.isVisible()){
                    if (razonExtra.getText().replaceAll("\\s+","").equals("")){
                        mostrarError("Debe de llenar el campo emergente.");
                        return;
                    }else{
                        values.add(razonExtra.getText());
                    }
                    // FALTA IMPLEMENTAR LÓGICA DE CREAR USUARIO.
                    mostrarExito("Se ha creado su cuenta exitosamente!");
                    return;
                }else{
                    values.add(razonExtra.getText());
                    mostrarExito("Se ha creado su cuenta exitosamente!");
                    return;
                }
            }
        });
		frame.getContentPane().add(crearCuentaBtn);
		
    }

    public void redireccionarDashboard(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();


    }
}
