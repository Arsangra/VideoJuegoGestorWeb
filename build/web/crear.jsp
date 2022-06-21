<%-- 
    Document   : crear
    Created on : 17 jun. 2022, 9:30:21
    Author     : arsan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Videojuego</title>
    </head>
    <body>
        <h1 align="center">Crea tu videojuego</h1>        
        <form action="mostrar.jsp" method="POST">            
            <table align="center" border="1">                    
                <tbody>
                    <tr>
                        <td>Título:</td>
                        <td><input type="text" name="nombre" value="" required/></td>
                    </tr>
                    <tr>
                        <td>Género:</td>
                        <td><select name="genero">
                                <option value="aventuras">Aventuras</option>
                                <option value="rpg">RPG</option>
                                <option value="shooter">Shooter</option>
                                <option value="estrategia">Estrategia</option>
                                <option value="plataformas">Plataformas</option>
                                <option value="puzzle">Puzzle</option>
                                <option value="carreras">Carreras</option>
                                <option value="lucha">Lucha</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Valoración</td>
                        <td><input type="number" name="valoracion" value="" required/></td>
                    </tr>
                    <tr>
                        <td>Jugado</td>
                        <td><input type="checkbox" name="jugado" value="true"/> </td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Enviar" name="enviar"/></td>                       
                    </tr>
                </tbody>
            </table>  
        </form>
    </body>
</html>
