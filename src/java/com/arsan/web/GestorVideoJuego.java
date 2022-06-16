/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arsan.web;

import com.arsan.db.DbConnection;
import com.arsan.model.Videogame;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arsan
 */
@WebServlet("/gestor")//redireccion al servlet gestor
public class GestorVideoJuego extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getParameter("op")) {
            case "1":
            {
                try {
                    buscarVideoJuego(req, resp);
                } catch (SQLException ex) {
                    Logger.getLogger(GestorVideoJuego.class.getName()).log(Level.SEVERE, "Error de sql", ex);
                }
            }
                break;

            default:
                throw new AssertionError();
        }
    }
    private void buscarVideoJuego(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, ServletException {
        Videogame v1 = (Videogame) req.getAttribute("v1");
        DbConnection dbconn = new DbConnection();
        Videogame v2 = dbconn.findVideogame(v1.getNombre());
        req.setAttribute("v1", v2);
        RequestDispatcher rd = req.getRequestDispatcher("/mostrar.jsp");
        rd.forward(req, resp);
}
    
    
    
    
    
    
    
    
}
