package main.java.com.easyrents;

import javax.swing.JOptionPane;

public class vistaFacturacion {
    //opciones para la factura
    String[] opciones = {"Imprimir", "Cancelar"};
    //mostrar mensaje de error
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    //mostrar ventana de opciones para la factura
    public void mostrarFactura(String mensaje, int numFactura) {
        JOptionPane.showOptionDialog(null, mensaje, "Factura No. " + numFactura, 0, 3, null, opciones, mensaje);
    }
}
