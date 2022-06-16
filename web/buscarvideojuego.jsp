<%-- 
    Document   : buscarVideojuego
    Created on : 16 jun. 2022, 11:36:32
    Author     : arsan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%if (request.getParameter("nombre") != null) {%>
        <jsp:useBean id="v1" class="com.arsan.model.Videogame" scope="request"/>        
        <jsp:setProperty property="*" name="v1"/>
        <jsp:forward page="gestor?op=1"/>
        <%}%>
       	<form id="formulario" action="buscarvideojuego.jsp" name="formulario">	
            <label for="id">id</label><br/>
            <input type="id" name="id" id="id"><br/>
            
            <label for="titulo">Título</label><br/>
            <input type="text" name="titulo" id="titulo"><br/>
            
            <!--<label for="opcion">Opción</label><br/>
            <select type="text"  name="opcion" id="opcion"><br/>
                <option value="Aventuras">Aventuras</option>
                <option value="RPG">RPG</option>
                <option value="Puzzles">Puzzles</option>
                <option value="Plataformas">Plataformas</option>
                <option value="Shooter">Shooter</option>
                <option value="Carreras">Carreras</option>
                <option value="Lucha">Lucha</option>
                <option value="Estrategia">Estrategia</option>
            </select>-->
            
            <label for="genero">Género</label><br/>
            <select type="text"  name="genero" id="genero"><br/>
                <option value="Aventuras">Aventuras</option>
                <option value="RPG">RPG</option>
                <option value="Puzzles">Puzzles</option>
                <option value="Plataformas">Plataformas</option>
                <option value="Shooter">Shooter</option>
                <option value="Carreras">Carreras</option>
                <option value="Lucha">Lucha</option>
                <option value="Estrategia">Estrategia</option>
            </select>
            
            <label for="valoracion">Valoración</label><br/>
            <input type="valoracion"  name="valoracion" id="valoracion"><br/>

            <label for="jugado">Jugado</label><br/>
            <input type="jugado"  name="jugado" id="jugado"/><br/>          

            <br/>
            <button type="button" name="enviar" id="enviar">Enviar</button>
            <button type="reset" id="limpiar">Limpiar</button>
        </form> 









































































    </body>
</html>
