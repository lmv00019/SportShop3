package es.ujaen.daw.tiendadeporte;

import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre = request.getParameter("nombre");
        String dni = request.getParameter("dni");

        String html="<html><body><h1>Datos del usuario (servlet)</h1>";
        html+="<div>Nombre: "+ nombre + "</div>";
        html+="<div>DNI: "+ dni + "</div>";
        html+="</body></html>";
        response.getWriter().println(html);	    }

    public void destroy() {
    }
}