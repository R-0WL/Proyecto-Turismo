package com.easyrents;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class vistaPago {
    private JFrame frame; // Ventana principal

    // Constructor para inicializar la ventana
    public vistaPago() {
        frame = new JFrame("Pago");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    }

    // Método para mostrar mensajes en ventanas emergentes
	public static mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void mostrarFormularioPago(Reserva reserva) {
        // Código para mostrar el formulario de pago
    }
    public void mostrarConfirmacionPago(Pago pago) {
        // Código para mostrar la confirmación del pago
    }
    public void mostrarError(String mensaje) {
        // Código para mostrar errores durante el proceso de pago
    }
}
