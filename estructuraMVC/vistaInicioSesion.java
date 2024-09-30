import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
		Image imgTwit = new ImageIcon(this.getClass().getResource("/img/twitter-icon.png")).getImage();
		imgTwitter.setIcon(new ImageIcon(imgTwit));
		imgTwitter.setBounds(180, 518, 50, 50);
		frame.getContentPane().add(imgTwitter);
		
		JLabel imgInsta = new JLabel("");
		Image imgIg = new ImageIcon(this.getClass().getResource("/img/insta-icon.png")).getImage();
		imgInsta.setIcon(new ImageIcon(imgIg));
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
                if((txtCorreoElectrnico.getText().replaceAll("\\s+","").equals("")) || (passwordField.getPassword().toString().replaceAll("\\s+","").equals(""))){
                    mostrarError("Debe de ingresar un correo y su contraseña respectiva.");
                    return;
                }else if(!credentialsValidated){
                    mostrarError("Las credenciales ingresadas no son correctas, vuelva a intentar.");
                    return;
                }else if(!txtCorreoElectrnico.getText().contains("@")){
                    mostrarError("Debe de ingresar una dirección de correo válida");
                    return;                    
                }else{
                    // USUARIO DE PRUEBA: (FALTA HACER LA LOGIN CON LA BASE DE DATOS Y VALIDAR)
                    modeloUsuario usuarioActual = new modeloUsuario(0000, "Santiago Cordero Quirós", "cor24472@uvg.edu.gt", "pepe123", "Turismo");
                    redireccionarDashboard(frame, usuarioActual);
                }
            }
        });
		frame.getContentPane().add(loginBtn_1);

        JLabel logoImageLabel = new JLabel();
		Image logoImage = new ImageIcon(this.getClass().getResource("/img/easyLogo95x95.png")).getImage();
		logoImageLabel.setIcon(new ImageIcon(logoImage));
		logoImageLabel.setBounds(116, 7, 115, 95);
		frame.getContentPane().add(logoImageLabel);
		
		JLabel logoNameImgLbl = new JLabel("");
		Image logoNameImg = new ImageIcon(this.getClass().getResource("/img/easyRents177x50.png")).getImage();
		logoNameImgLbl.setIcon(new ImageIcon(logoNameImg));
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

        JLabel instruccionesLbl = new JLabel("Llene los siguientes campos para crear su cuenta:");
		instruccionesLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		instruccionesLbl.setBounds(29, 47, 292, 29);
		frame.getContentPane().add(instruccionesLbl);
		
		JLabel nombreLbl = new JLabel("Nombre:");
		nombreLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		nombreLbl.setBounds(10, 109, 94, 29);
		frame.getContentPane().add(nombreLbl);
		
		JTextField nombreEntry = new JTextField();
		nombreEntry.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		nombreEntry.setBounds(98, 111, 236, 29);
		frame.getContentPane().add(nombreEntry);
		
		JLabel correoLbl = new JLabel("Correo:");
		correoLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		correoLbl.setBounds(10, 160, 52, 29);
		frame.getContentPane().add(correoLbl);
		
		JTextField correoEntry = new JTextField();
		correoEntry.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		correoEntry.setColumns(10);
		correoEntry.setBounds(98, 162, 236, 29);
		frame.getContentPane().add(correoEntry);
		
		JLabel contrasenaLabel = new JLabel("Contraseña:");
		contrasenaLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		contrasenaLabel.setBounds(10, 272, 94, 29);
		frame.getContentPane().add(contrasenaLabel);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		passwordField.setBounds(98, 214, 236, 26);
		frame.getContentPane().add(passwordField);
        entryList.add(passwordField);
		
		JPasswordField passwordFieldConfirmar = new JPasswordField();
		passwordFieldConfirmar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		passwordFieldConfirmar.setBounds(98, 265, 236, 26);
		frame.getContentPane().add(passwordFieldConfirmar);
		
		JLabel confirmarContLbl1 = new JLabel("Confirmar");
		confirmarContLbl1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		confirmarContLbl1.setBounds(10, 251, 94, 29);
		frame.getContentPane().add(confirmarContLbl1);
		
		JLabel confirmarContLbl2 = new JLabel("Contraseña:");
		confirmarContLbl2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		confirmarContLbl2.setBounds(10, 211, 94, 29);
		frame.getContentPane().add(confirmarContLbl2);
		
		JLabel motivoLbl1 = new JLabel("¿Cuál es su motivo para");
		motivoLbl1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		motivoLbl1.setBounds(10, 312, 172, 29);
		frame.getContentPane().add(motivoLbl1);
		
		JLabel motivoLbl2 = new JLabel("utilizar nuestra app?");
		motivoLbl2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		motivoLbl2.setBounds(10, 333, 172, 29);
		frame.getContentPane().add(motivoLbl2);

        JLabel razonExtraLbl = new JLabel("Especifique:");
		razonExtraLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		razonExtraLbl.setVisible(false);
		razonExtraLbl.setBounds(24, 372, 80, 20);
		frame.getContentPane().add(razonExtraLbl);
		
		JTextField razonExtra = new JTextField();
		razonExtra.setVisible(false);
		razonExtra.setBounds(105, 371, 217, 29);
		frame.getContentPane().add(razonExtra);
		
		@SuppressWarnings("rawtypes")
        JComboBox tipoUsuarioDropDown = new JComboBox();
		tipoUsuarioDropDown.setToolTipText("Escoja una de las opciones siguientes");
		tipoUsuarioDropDown.setModel(new DefaultComboBoxModel(new String[] {"Turismo (cualquier índole)", "Trabajo", "Estudios", "Visitas a Familiares", "Residencia Temporal", "Otro (Especifique)"}));
		tipoUsuarioDropDown.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
        tipoUsuarioDropDown.setBackground(Color.WHITE);
		tipoUsuarioDropDown.setBounds(162, 321, 170, 29);
        tipoUsuarioDropDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(tipoUsuarioDropDown.getSelectedItem().toString() == "Otro (Especifique)"){
                    razonExtra.setVisible(true);
                    razonExtraLbl.setVisible(true);
                }else{
                    razonExtra.setVisible(false);
                    razonExtraLbl.setVisible(false);
                }
            }
        });
		frame.getContentPane().add(tipoUsuarioDropDown);

        JButton crearCuentaBtn = new JButton("Crear Cuenta");
		crearCuentaBtn.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 22));
        crearCuentaBtn.setBackground(Color.WHITE);
		crearCuentaBtn.setBounds(91, 421, 165, 54);
        crearCuentaBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ArrayList<String> values = new ArrayList<>();
                values.add(nombreEntry.getText());
                values.add(correoEntry.getText());
                values.add(new String(passwordField.getPassword()));
                values.add(new String(passwordFieldConfirmar.getPassword()));
                values.add(tipoUsuarioDropDown.getSelectedItem().toString());

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

                if(razonExtra.isVisible()){
                    if (razonExtra.getText().replaceAll("\\s+","").equals("")){
                        mostrarError("Debe de llenar todos los campos solicitados.");
                        return;
                    }else{
                        values.add(razonExtra.getText());
                    }
                    // FALTA IMPLEMENTAR LÓGICA DE CREAR USUARIO Y GUARDARLO EN LA BASE DE DATOS.
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

    public void redireccionarDashboard(JFrame frame, modeloUsuario currentUsuario) {
        frame.getContentPane().removeAll();
        frame.repaint();
        
        JLabel cerrarSesionLbl = new JLabel("Cerrar Sesión");
		cerrarSesionLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		cerrarSesionLbl.setBounds(254, 11, 80, 14);
        cerrarSesionLbl.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarFormulario(frame);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cerrarSesionLbl.setForeground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cerrarSesionLbl.setForeground(Color.BLACK);
            }
        });
		frame.getContentPane().add(cerrarSesionLbl);

        frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel franjaLbl = new JLabel("");
		franjaLbl.setBackground(new Color(213, 0, 0));
        franjaLbl.setVisible(true);
        franjaLbl.setOpaque(true);
		franjaLbl.setBounds(0, 537, 344, 64);
		frame.getContentPane().add(franjaLbl);
		
		Image profileImg = new ImageIcon(this.getClass().getResource("/img/profileIconSmall.png")).getImage();
        Image profileImgHover = new ImageIcon(this.getClass().getResource("/img/profileIconSmallHover.png")).getImage();
		JButton perfilBtn = new JButton("");
		perfilBtn.setBounds(244, 545, 50, 50);
		perfilBtn.setBorderPainted(false);
		perfilBtn.setContentAreaFilled(false);
		perfilBtn.setIcon(new ImageIcon(profileImg));
        perfilBtn.setRolloverIcon(new ImageIcon(profileImgHover));
        perfilBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
                redireccionarPerfil(frame, currentUsuario);
            }
        });
		frame.getContentPane().add(perfilBtn);
		
		Image verReservasImg = new ImageIcon(this.getClass().getResource("/img/menuIcon.png")).getImage();
        Image verReservasImgHover = new ImageIcon(this.getClass().getResource("/img/menuIconHover.png")).getImage();
		JButton verReservasBtn = new JButton("");
		verReservasBtn.setBounds(41, 545, 50, 50);
		verReservasBtn.setBorderPainted(false);
		verReservasBtn.setContentAreaFilled(false);
		verReservasBtn.setIcon(new ImageIcon(verReservasImg));
		verReservasBtn.setRolloverIcon(new ImageIcon(verReservasImgHover));
        verReservasBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
                // IMPLEMENTAR PANTALLA DE VISTA DE RESERVAS ACTUALES
            }
        });
		frame.getContentPane().add(verReservasBtn);
		
		Image homeImg = new ImageIcon(this.getClass().getResource("/img/homeIcon.png")).getImage();
        Image homeImgHover = new ImageIcon(this.getClass().getResource("/img/homeIconHover.png")).getImage();
		JButton homeBtn = new JButton();
		homeBtn.setBounds(141, 545, 50, 50);
		homeBtn.setBorderPainted(false);
		homeBtn.setContentAreaFilled(false);
		homeBtn.setIcon(new ImageIcon(homeImg));
		homeBtn.setRolloverIcon(new ImageIcon(homeImgHover));
		frame.getContentPane().add(homeBtn);
		
		JLabel dashboardTitleLbl = new JLabel("Página Principal");
		dashboardTitleLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 23));
		dashboardTitleLbl.setBounds(91, 37, 166, 38);
		frame.getContentPane().add(dashboardTitleLbl);

        JLabel optionLbl = new JLabel("¿Qué tipo de vehículo desea reservar hoy?");
		optionLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
		optionLbl.setBounds(28, 86, 288, 38);
		frame.getContentPane().add(optionLbl);
		
        @SuppressWarnings("rawtypes")
		JComboBox vehiculoDropDown = new JComboBox();
		vehiculoDropDown.setModel(new DefaultComboBoxModel(new String[] {"Motocicleta", "Automóvil particular", "Bus particular"}));
        vehiculoDropDown.setBackground(Color.WHITE);
        vehiculoDropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(vehiculoDropDown.getSelectedItem().toString()){
                    case "Motocicleta":
                        break;
                    case "Automóvil particular":
                        break;
                    case "Bus particular":
                        break;
                    
                }
            }
        });
		vehiculoDropDown.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
		vehiculoDropDown.setBounds(74, 135, 191, 30);
		frame.getContentPane().add(vehiculoDropDown);

        // EN EL ESPACIO EN BLANCO DE ESTA PESTAÑA FALTA RETORNAR TODAVÍA TODOS LOS VEHÍCULOS QUE APLIQUEN DE LA BASE DE DATOS Y MOSTRAR CADA UNO CON
        // UN LABEL.

        frame.getContentPane().setComponentZOrder(franjaLbl, frame.getContentPane().getComponentCount() - 1);
    }

    public void redireccionarPerfil(JFrame frame, modeloUsuario currentUsuario){
        frame.getContentPane().removeAll();
        frame.repaint();

        JLabel cerrarSesionLbl = new JLabel("Cerrar Sesión");
		cerrarSesionLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		cerrarSesionLbl.setBounds(254, 11, 80, 14);
        cerrarSesionLbl.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarFormulario(frame);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cerrarSesionLbl.setForeground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cerrarSesionLbl.setForeground(Color.BLACK);
            }
        });
		frame.getContentPane().add(cerrarSesionLbl);

        JLabel franjaLbl = new JLabel("");
		franjaLbl.setBackground(new Color(213, 0, 0));
        franjaLbl.setVisible(true);
        franjaLbl.setOpaque(true);
		franjaLbl.setBounds(0, 537, 344, 64);
        
		frame.getContentPane().add(franjaLbl);

        Image profileImg = new ImageIcon(this.getClass().getResource("/img/profileIconSmall.png")).getImage();
        Image profileImgHover = new ImageIcon(this.getClass().getResource("/img/profileIconSmallHover.png")).getImage();
		JButton perfilBtn = new JButton("");
		perfilBtn.setBounds(244, 545, 50, 50);
		perfilBtn.setBorderPainted(false);
		perfilBtn.setContentAreaFilled(false);
		perfilBtn.setIcon(new ImageIcon(profileImg));
        perfilBtn.setRolloverIcon(new ImageIcon(profileImgHover));
		frame.getContentPane().add(perfilBtn);
		
		Image verReservasImg = new ImageIcon(this.getClass().getResource("/img/menuIcon.png")).getImage();
        Image verReservasImgHover = new ImageIcon(this.getClass().getResource("/img/menuIconHover.png")).getImage();
		JButton verReservasBtn = new JButton("");
		verReservasBtn.setBounds(41, 545, 50, 50);
		verReservasBtn.setBorderPainted(false);
		verReservasBtn.setContentAreaFilled(false);
		verReservasBtn.setIcon(new ImageIcon(verReservasImg));
		verReservasBtn.setRolloverIcon(new ImageIcon(verReservasImgHover));
		frame.getContentPane().add(verReservasBtn);
		
		Image homeImg = new ImageIcon(this.getClass().getResource("/img/homeIcon.png")).getImage();
        Image homeImgHover = new ImageIcon(this.getClass().getResource("/img/homeIconHover.png")).getImage();
		JButton homeBtn = new JButton();
		homeBtn.setBounds(141, 545, 50, 50);
		homeBtn.setBorderPainted(false);
		homeBtn.setContentAreaFilled(false);
		homeBtn.setIcon(new ImageIcon(homeImg));
		homeBtn.setRolloverIcon(new ImageIcon(homeImgHover));
        homeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                redireccionarDashboard(frame, currentUsuario);
            }
        });
		frame.getContentPane().add(homeBtn);

        String[] userInfo = currentUsuario.getNombre().split(" ");
        String userNameLblString = "<html> ";
        int userNameLblHeight = 0;
        int i = 1;
        for(String s : userInfo){
            userNameLblString += (s + "<br/>");
            userNameLblHeight += 18 * i;
            i++;
        }
        userNameLblString += "</html>";
		JLabel userNameLbl = new JLabel(userNameLblString);
		userNameLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		userNameLbl.setBounds(200, 37, 166, userNameLblHeight);
		frame.getContentPane().add(userNameLbl);

        JLabel largeProfileLbl = new JLabel();
        Image largeProfile = new ImageIcon(this.getClass().getResource("/img/profileIcon.png")).getImage();
        largeProfileLbl.setIcon(new ImageIcon(largeProfile));
		largeProfileLbl.setBounds(30,30,300,300);
        frame.getContentPane().add(largeProfileLbl);

        frame.getContentPane().setComponentZOrder(franjaLbl, frame.getContentPane().getComponentCount() - 1);
    }
}
