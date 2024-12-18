package TiedaSebastianRodriguez.demo.impl;



import TiedaSebastianRodriguez.demo.service.CorreoService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class CorreoServiceImpl implements CorreoService {

    @Autowired
    private JavaMailSender mailSender;

    // Método original para enviar correo con contenido HTML
    @Override
    public void enviarCorreoHtml(
            String para, 
            String asunto, 
            String contenidoHtml) 
            throws MessagingException {
          
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(para);
        helper.setSubject(asunto);
        helper.setText(contenidoHtml, true);
        mailSender.send(message);
    }

    // Nuevo reporte de ventas por fecha
    public void enviarReporteVentasPorFecha(
            String para, 
            String asunto, 
            String contenidoHtml, 
            String fechaInicio, 
            String fechaFin) throws MessagingException {

        // Aquí iría la lógica para obtener las ventas entre las fechas proporcionadas
        // Simularemos con un contenido HTML basado en los parámetros.

        String reporteVentas = "<h1>Reporte de Ventas</h1>";
        reporteVentas += "<p>Desde: " + fechaInicio + " Hasta: " + fechaFin + "</p>";
        reporteVentas += "<table border='1'><tr><th>Producto</th><th>Cantidad</th><th>Total</th></tr>";
        reporteVentas += "<tr><td>Producto A</td><td>10</td><td>$100</td></tr>";
        reporteVentas += "<tr><td>Producto B</td><td>5</td><td>$50</td></tr>";
        reporteVentas += "</table>";

        // Enviar el correo con el reporte de ventas
        enviarCorreoHtml(para, asunto, reporteVentas);
    }

    // Nuevo reporte de productos
    public void enviarReporteProductos(
            String para, 
            String asunto) throws MessagingException {

        String reporteProductos = "<h1>Reporte de Productos</h1>";
        reporteProductos += "<table border='1'><tr><th>Producto</th><th>Precio</th><th>Categoría</th></tr>";
        reporteProductos += "<tr><td>Producto X</td><td>$20</td><td>Electrónica</td></tr>";
        reporteProductos += "<tr><td>Producto Y</td><td>$30</td><td>Ropa</td></tr>";
        reporteProductos += "</table>";

        enviarCorreoHtml(para, asunto, reporteProductos);
    }
}
