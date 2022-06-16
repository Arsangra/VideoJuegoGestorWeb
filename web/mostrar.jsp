<%-- 
    Document   : mostrar
    Created on : 16 jun. 2022, 12:46:26
    Author     : arsan
--%>

<%@page import="com.arsan.model.Videogame"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

        <title>Mostrar</title>
    </head>
    <body>
        <jsp:useBean id = "v2" class="com.arsan.model.Videogame" scope="request"/>
        <jsp:scriptlet>
            Videogame v1 = (Videogame) request.getAttribute("v1");
        </jsp:scriptlet>
        <h1>Tabla</h1>
        <div class="col-md-8">
            <table class="table">
                <thead class="table-success table-striped">
                    <tr>
                        <th>Id</th>
                        <th>Título</th>
                        <th>Genéro</th>
                        <th>Valoración</th>
                        <th>Jugado</th>
                        <th></th>                        
                    </tr>
                </thead>
                <tbody>                  
                        <tr>                                                 
                            <th><jsp:expression>v1.getId()</jsp:expression></th>
                            <th><jsp:expression>v1.getNombre()</jsp:expression></th>
                            <th><jsp:expression>v1.getGenero()</jsp:expression></th>
                            <th><jsp:expression>v1.getValoracion()</jsp:expression></th>
                            <th><jsp:expression>v1.isJugado()</jsp:expression></th>
                            <th><a href="eliminar.php?id=<?php echo $row['id'] ?>" class="btn btn-danger">Eliminar</a></th>
                        </tr>                    
                </tbody>
            </table>
        
    </body>
</html>
