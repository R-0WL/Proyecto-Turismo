package com.easyrents;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.pdf.PdfDocument;

public class controladorFacturacion {
    private vistaFacturacion vistaFactura;

    // CONSTRUCTOR
    public controladorFacturacion(vistaFacturacion vistaFactura) {
        this.vistaFactura = vistaFactura;
    }

    // Generar factura para un pago específico
    public void generarFactura(Pago pay) {
        if (pay == null) {
            vistaFacturacion.mostrarError("No se encontró el pay.");
            return;
        }
        // Creación del texto de la factura
        String factura = "Factura para el pay ID: " + pay.getId() + "\n" +
                         "Reserva asociada: " + pay.getReserva().getId() + "\n" +
                         "Método de pay: " + pay.getMetodoPago() + "\n" +
                         "Monto: $" + pay.getMonto() + "\n" +
                         "Fecha: " + pay.getFecha();
        // Mostrar la factura en la vista de facturación
        if (vistaFacturacion.mostrarFactura(factura, pay.getId()) == 0) {
            imprimirFactura(factura);
        } else {
            vistaFacturacion.mostrarError("Error al imprimir la factura.");
        }
    }

    //imprimir factura en un pdf
    public void imprimirFactura(String factura) {
        //metodos y objetos de la dependencia itextpdf
        //la dependencia es cargada en el pom.xml, por maven
        PdfWriter writer = new PdfWriter("factura" + pay.getId() + ".pdf");
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        document.add(new Paragraph(factura));
        document.close();
    }
}
