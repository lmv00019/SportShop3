<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Camisetas Deportivas
</h1>
<strong>Caisetas </strong>
<div><div/>
    Texto explicativo
    <%String[] servicios={"Curso de paddle","Alquiler de pistas","Piscina"};
 String nombre=request.getParameter("nombre");
 String apellidos=request.getParameter("apellidos");
 if (nombre==null || nombre.trim().equals("")) nombre="Desconocido";
 if (apellidos!=null) apellidos.trim();
 boolean esSocio=(request.getParameter("esSocio")!=null?true:false); %>
<div></div>
<a href="article.jsp">volver</a>

<ul>

    <li><a href="Camisetas.jsp">Link a otras prendas</a> </li></ul>
</body>
</html>