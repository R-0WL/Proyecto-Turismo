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
import javax.swing.JScrollPane;
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
                    Usuario usuarioActual = new Usuario(999999999999l, "Santiago Cordero Quirós", "cor24472@uvg.edu.gt", "pepe123", "Turismo");
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

	public void drawMainButtons(JFrame frame, Usuario usuarioActual) {
		frame.getContentPane().removeAll();
		frame.repaint();
		JLabel cerrarSesionLbl = new JLabel("Cerrar Sesión");
		cerrarSesionLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		cerrarSesionLbl.setForeground(Color.DARK_GRAY);
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
				cerrarSesionLbl.setForeground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				cerrarSesionLbl.setForeground(Color.DARK_GRAY);
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
		perfilBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				redireccionarPerfil(frame, usuarioActual);
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
			public void actionPerformed(ActionEvent a) {
				redireccionarReservas(frame, usuarioActual);
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
		homeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a){
				redireccionarDashboard(frame, usuarioActual);
			}
		});
		frame.getContentPane().add(homeBtn);
		frame.getContentPane().setComponentZOrder(franjaLbl, frame.getContentPane().getComponentCount() - 1);
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

        ArrayList<Object> entryList = new ArrayList<>();//posible unchecked

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
		motivoLbl1.setBounds(10, 366, 172, 29);
		frame.getContentPane().add(motivoLbl1);
		
		JLabel motivoLbl2 = new JLabel("utilizar nuestra app?");
		motivoLbl2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		motivoLbl2.setBounds(10, 387, 172, 29);
		frame.getContentPane().add(motivoLbl2);

        JLabel dpiLabel = new JLabel("No. de DPI");
		dpiLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		dpiLabel.setBounds(10, 310, 94, 29);
		frame.getContentPane().add(dpiLabel);
		
		JTextField dpiEntry = new JTextField();
		dpiEntry.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		dpiEntry.setBounds(98, 318, 236, 26);
		frame.getContentPane().add(dpiEntry);
		
		JLabel lblsinGuiones = new JLabel("(sin guiones)");
		lblsinGuiones.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblsinGuiones.setBounds(10, 326, 94, 29);
		frame.getContentPane().add(lblsinGuiones);

        JLabel razonExtraLbl = new JLabel("Especifique:");
		razonExtraLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		razonExtraLbl.setVisible(false);
		razonExtraLbl.setBounds(24, 426, 80, 20);
		frame.getContentPane().add(razonExtraLbl);
		
		JTextField razonExtra = new JTextField();
		razonExtra.setVisible(false);
		razonExtra.setBounds(105, 425, 217, 29);
		frame.getContentPane().add(razonExtra);

        JButton crearCuentaBtn = new JButton("Crear Cuenta");

        @SuppressWarnings("rawtypes")
        JComboBox tipoUsuarioDropDown = new JComboBox();
		tipoUsuarioDropDown.setToolTipText("Escoja una de las opciones siguientes");
		tipoUsuarioDropDown.setModel(new DefaultComboBoxModel<String>(new String[] {"Turismo (cualquier índole)", "Trabajo", "Estudios", "Visitas a Familiares", "Residencia Temporal", "Otro (Especifique)"}));
		tipoUsuarioDropDown.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
        tipoUsuarioDropDown.setBackground(Color.WHITE);
		tipoUsuarioDropDown.setBounds(162, 376, 170, 29);
        tipoUsuarioDropDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(tipoUsuarioDropDown.getSelectedItem().toString() == "Otro (Especifique)"){
                    razonExtra.setVisible(true);
                    razonExtraLbl.setVisible(true);
                    crearCuentaBtn.setLocation(91, 470);
                    
                }else{
                    razonExtra.setVisible(false);
                    razonExtraLbl.setVisible(false);
                    crearCuentaBtn.setLocation(91, 435);
                }
            }
        });
		frame.getContentPane().add(tipoUsuarioDropDown);

		crearCuentaBtn.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 22));
        crearCuentaBtn.setBackground(Color.WHITE);
		crearCuentaBtn.setBounds(91, 435, 165, 52);
        crearCuentaBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ArrayList<String> values = new ArrayList<>();//posible unchecked
                values.add(nombreEntry.getText());
                values.add(correoEntry.getText());
                values.add(new String(passwordField.getPassword()));
                values.add(new String(passwordFieldConfirmar.getPassword()));
                values.add(tipoUsuarioDropDown.getSelectedItem().toString());
                values.add(String.valueOf(Long.parseLong(dpiEntry.getText())));

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
					// listaUsuarios.add(usuarioActual);
                    return;
                }else{
                    values.add(razonExtra.getText());
                    mostrarExito("Se ha creado su cuenta exitosamente!");
					// listaUsuarios.add(usuarioActual);
                    return;
                }
            }
        });
		frame.getContentPane().add(crearCuentaBtn);		
    }

    public void redireccionarDashboard(JFrame frame, Usuario currentUsuario) {
		drawMainButtons(frame, currentUsuario);
		
		JLabel dashboardTitleLbl = new JLabel("Página Principal");
		dashboardTitleLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 23));
		dashboardTitleLbl.setBounds(91, 37, 166, 38);
		frame.getContentPane().add(dashboardTitleLbl);

        JLabel optionLbl = new JLabel("¿Qué tipo de vehículo desea reservar hoy?");
		optionLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
		optionLbl.setBounds(28, 86, 288, 38);
		frame.getContentPane().add(optionLbl);

		// EN EL SCROLLPANE IRÁN TODOS LOS RESULTADOS DE BUSCAR EN LA BASE DE DATOS EL TIPO DE VEHÍCULO CON EL COMBOBOX
        @SuppressWarnings("rawtypes")
		JComboBox<String> tipoVehiculoDropDown = new JComboBox();
		tipoVehiculoDropDown.setModel(new DefaultComboBoxModel(new String[] {"Motocicleta", "Automóvil particular", "Bus particular"}));
        tipoVehiculoDropDown.setBackground(Color.WHITE);
        tipoVehiculoDropDown.addActionListener(e -> {
			String seleccionado = tipoVehiculoDropDown.getSelectedItem().toString();
			switch (seleccionado){
				case "Motocicleta":
					String[] datos = new String[2]; // Sacar de la base de datos todos los datos de los vehículos parseados como una lista de Strings
					// IMPLEMENTAR LÓGICA PARA FILTRAR DATOS
					String[] datosFiltrados = new String[2];
					JComboBox<String> vehiculoDropDown = new JComboBox<String>(datosFiltrados);
					JScrollPane resultsScrollPane = new JScrollPane(vehiculoDropDown);
					resultsScrollPane.setViewportBorder(null);
					resultsScrollPane.setBounds(10, 180, 324, 262);
					frame.getContentPane().add(resultsScrollPane);
					vehiculoDropDown.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String seleccionado = vehiculoDropDown.getSelectedItem().toString();
							for(int i = 0; i < datosFiltrados.length; i++){
								if(datosFiltrados[i].equals(seleccionado)){
									vehiculoDropDown.setSelectedIndex(i);
								}
							}
						}
					});
					break;
				case "Automóvil particular":
					// Hacer que muestre todos los automóviles en el vehiculoDropDown
					break;
				case "Bus particular":
					// Hacer que muestre todos los buses en el vehiculoDropDown
					break;
			}
		});
		tipoVehiculoDropDown.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
		tipoVehiculoDropDown.setBounds(74, 135, 191, 30);
		frame.getContentPane().add(tipoVehiculoDropDown);
		
		JButton reservarBtn = new JButton("Ver detalles");
		reservarBtn.setBackground(Color.WHITE);
		reservarBtn.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 25));
		reservarBtn.setBounds(90, 457, 156, 65);
		reservarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				// CREAR INSTANCIA DE VEHÍCULO CON LOS DATOS DEL DROPDOWN 
				/*
				Sring[] datosVehiculo = vehiculoDropDown.getSelectedItem().toString().split(" ");
				String nombreVehiculo = datosVehiculo[0];
				String tipoVehiculo = datosVehiculo[1];
				...
				Vehiculo vehiculo = new Vehiculo(nombreVehiculo, tipoVehiculo);
				 */

				// Vehiculo prueba:
				Vehiculo vehiculoSeleccionado = new Vehiculo(0001, "Ducati", "Panigale", 2016, "Motocicleta", 350, true);
				vistaReservacion vistaRes = new vistaReservacion();
				vistaRes.mostrarFormularioReservacion(vehiculoSeleccionado, frame, currentUsuario);
			}
		});
		frame.getContentPane().add(reservarBtn);

    }

    public void redireccionarPerfil(JFrame frame, Usuario currentUsuario){
		drawMainButtons(frame, currentUsuario);

        JLabel profileTitleLbl = new JLabel("Perfil de Usuario");
		profileTitleLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 23));
		profileTitleLbl.setBounds(95, 25, 166, 38);
		frame.getContentPane().add(profileTitleLbl);

        String[] userInfo = currentUsuario.getNombre().split(" ");
        String userNameLblString = "<html> ";
        int userNameLblHeight = 0;
        int i = 1;
        for(String s : userInfo){
            userNameLblString += (s + "<br/>");
            userNameLblHeight += 25 * i;
            i++;
        }
        userNameLblString += "</html>";
		JLabel userNameLbl = new JLabel(userNameLblString);
		userNameLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 30));
		userNameLbl.setBounds(180, 65, 166, userNameLblHeight);
		frame.getContentPane().add(userNameLbl);

        JLabel largeProfileLbl = new JLabel();
        Image largeProfile = new ImageIcon(this.getClass().getResource("/img/profileIcon.png")).getImage();
        largeProfileLbl.setIcon(new ImageIcon(largeProfile));
		largeProfileLbl.setBounds(15,0,300,300);
        frame.getContentPane().add(largeProfileLbl);

        // FALTA CREAR LA ITERACIÓN DE LAS LISTAS DEL USUARIO Y MOSTRARLAS COMO LISTA.
        /*
        String[] licencias = currentUsuario.getLicencias();
        String licenciasLblString = "<html> ";
        int licenciasLblHeight = 0;
        int j = 0;
        for(String l : licencias){
            licenciasLblString += (l + "<br/>");
            licenciasLblHeight += 18 * j;
            j++;
        }
        */

        JLabel licenciasListLabel = new JLabel("- ");
		licenciasListLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		licenciasListLabel.setBounds(46, 401, 139, 21);
		frame.getContentPane().add(licenciasListLabel);
		
		JLabel licenciaLbl = new JLabel("Licencias Asociadas:");
		licenciaLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 17));
		licenciaLbl.setBounds(10, 366, 150, 31);
		frame.getContentPane().add(licenciaLbl);
		
		JLabel telefonoTxtLabel = new JLabel("Teléfono:");
		telefonoTxtLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 17));
		telefonoTxtLabel.setBounds(10, 240, 71, 31);
		frame.getContentPane().add(telefonoTxtLabel);

        JLabel telefonoValueLbl = new JLabel("128951928"); // currentusuario.getTelefono() falta
		telefonoValueLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 17));
		telefonoValueLbl.setBounds(91, 240, 150, 31);
		frame.getContentPane().add(telefonoValueLbl);
		frame.setLocationRelativeTo(null);
		
		JLabel dpiTextLbl = new JLabel("No. de DPI asociado:");
		dpiTextLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 17));
		dpiTextLbl.setBounds(10, 282, 159, 31);
		frame.getContentPane().add(dpiTextLbl);
		
		JLabel dpiValueLbl = new JLabel(String.valueOf(currentUsuario.getID()));
		dpiValueLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 17));
		dpiValueLbl.setBounds(171, 282, 150, 31);
		frame.getContentPane().add(dpiValueLbl);

        JLabel correoLbl = new JLabel("Correo electrónico:");
		correoLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 17));
		correoLbl.setBounds(10, 324, 150, 31);
		frame.getContentPane().add(correoLbl);
		
		JLabel correoValueLbl = new JLabel(currentUsuario.getCorreo());
		correoValueLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 17));
		correoValueLbl.setBounds(159, 324, 175, 31);
		frame.getContentPane().add(correoValueLbl);
    }

	public void redireccionarReservas(JFrame frame, Usuario currentUsuario) {
		drawMainButtons(frame, currentUsuario);

		JLabel reservasTitleLbl = new JLabel("Reservas Actuales");
		reservasTitleLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 23));
		reservasTitleLbl.setBounds(85, 37, 175, 38);		
		frame.getContentPane().add(reservasTitleLbl);

		// FALTA IMPLEMENTAR LÓGICA DE OBTENER LOS DATOS DE LAS RESERVAS Y MOSTRARLAS COMO LISTA.
		/*
		String[] reservas = currentUsuario.getReservas();
        String reservasLblString = "<html> ";
        int reservasLblHeight = 0;
        for(String l : reservas){
            reservasLblString += (l + "<br/>");
        }
		*/
		
		// ESTA DECLARACIÓN DE SCROLLPANE SERÍA:
		// JScrollPane reservasPane = new JScrollPane(new JLabel(reservasLblString));
		JScrollPane reservasPane = new JScrollPane();
		reservasPane.setBounds(10, 85, 324, 445);
		reservasPane.setViewportView(new JLabel("Reservas"));
		reservasPane.setBorder(null);
		reservasPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		reservasPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		frame.getContentPane().add(reservasPane);
	}

	public void redireccionarReservacion(JFrame frame, Usuario currentUsuario) {
		// Implementar lógica de crear una nueva pestaña donde se pueda ver los detalles del vehículo seleccionado y confirmar el pago con la clase vistaReservacion.
	}
}