package com.easyrents;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.pdf.PdfDocument;

public class controladorFacturacion {
    private vistaFacturacion vistaFacturacion;

    // CONSTRUCTOR
    public controladorFacturacion(vistaFacturacion vistaFacturacion) {
        this.vistaFacturacion = vistaFacturacion;
    }

    // Generar factura para un pago específico
    public void generarFactura(Pago pago) {
        if (pago == null) {
            vistaFacturacion.mostrarError("No se encontró el pago.");
            return;
        }

        // Creación de la factura
        String factura = "Factura para el pago ID: " + pago.getId() + "\n" +
                         "Reserva asociada: " + pago.getReserva().getId() + "\n" +
                         "Método de pago: " + pago.getMetodoPago() + "\n" +
                         "Monto: $" + pago.getMonto() + "\n" +
                         "Fecha: " + pago.getFecha();

        // Mostrar la factura en la vista de facturación
        if (vistaFacturacion.mostrarFactura(factura, pago.getId()) == 0) {
            imprimirFactura(factura);
        } else {
            vistaFacturacion.mostrarError("Error al imprimir la factura.");
        }
    }

    //imprimir factura en un pdf
    public void imprimirFactura(String factura) {
        //metodos y objetos de la dependencia itextpdf
        //la dependencia es cargada en el pom.xml, por maven
        PdfWriter writer = new PdfWriter("factura" + pago.getId() + ".pdf");
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        document.add(new Paragraph(factura));
        document.close();
    }
}
