<%@page import="java.util.Set"%>
<%@page import="com.arsan.model.Videogame"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : mostarr
    Created on : 17 jun. 2022, 10:46:18
    Author     : arsan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>Mostrar</title>
    </head>
    <body>
        <h1 align="center">Mostrar</h1>
        <jsp:useBean id="videojuego" scope="session" class="com.arsan.model.Videogame" />
        <jsp:setProperty name="videojuego" property="nombre"/>
        <jsp:setProperty name="videojuego" property="genero"/>
        <jsp:setProperty name="videojuego" property="valoracion"/>
        <jsp:setProperty name="videojuego" property="jugado"/>
        <table border="1" align="center">
            <thead>
                <tr>
                    <th>Datos del videojuego</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><jsp:getProperty name="videojuego" property="nombre" /></td>
                </tr>
                <tr>
                    <td><jsp:getProperty name="videojuego" property="genero" /></td>
                </tr>
                <tr>
                    <td><jsp:getProperty name="videojuego" property="valoracion" /></td>
                </tr>
                <tr>
                    <td><jsp:getProperty name="videojuego" property="jugado" /></td>
                </tr>
                <tr>
                    <td>
                        <a text-align="center" href="index.html" value="Inicio" class="btn btn-success">Inicio</a>
                    </td>
                </tr>
            </tbody>
        </table>
        <%
            out.println(videojuego.insertarDatos());
            Set<Videogame> lista = videojuego.mostrarTodo();
        %>
        <div align="center">
        
                <c:forEach var="juego" items="${lista}">
                    Videogame : <c:out value="${juego}"/> 
                </c:forEach>                
        </div>
    </body>
</html>
