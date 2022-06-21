/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arsan.model;

import com.arsan.db.DbConnection;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arsan
 */
public class Videogame {
    public static AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String nombre;
    private String genero;
    private double valoracion;
    private boolean jugado;

    public Videogame() {
    }    
       
    public Videogame(int id, String nombre, String genero, double valoracion, boolean jugado) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.valoracion = valoracion;
        this.jugado = jugado;
        count.getAndIncrement();
    }

    public Videogame(String nombre, String genero, double valoracion, boolean jugado) {
        this.nombre = nombre;
        this.genero = genero;
        this.valoracion = valoracion;
        this.jugado = jugado;
        count.getAndIncrement();
        /*int n = 0;
        int j = n++;//asignamos el valor y luego incrementamos; j=0, el valor es el dado en la variable, hasta que se pida un nuevo resultado de la variable
        int c = ++n;//incrementamos y luego asignamos el valor; c=2, el valor obtenido tiene el incremento en la variable con el resultado final
        n++;
        ++n;*/
        
    }
    
    
    //llamamos constructor anterior
    /*public Videogame(String nombre, String genero, boolean jugado) {
        this(nombre, genero, 0.0, jugado);
    }*/
    //generamos getters and setters de las diferentes constantes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    public boolean isJugado() {
        return jugado;
    }

    public void setJugado(boolean jugado) {
        this.jugado = jugado;
    }
    //constructor para visualizar los resultados obtenidos
    @Override
    public String toString() {
        return "Nombre del videojuego " + nombre + "id=" + id + ", genero=" + genero + ", valoracion=" + valoracion + ", jugado=" + jugado;
    }
    
    public String insertarDatos(){
        int val = 0;
        DbConnection dbconn = null;
        try {
            dbconn = new DbConnection();
            valoracion = (valoracion<0) ? 0.0:(valoracion>10) ? 10.0: valoracion; 
            val = dbconn.createVideogame(nombre, genero.toUpperCase(), valoracion, jugado);
        } catch (IOException ex) {
            Logger.getLogger(Videogame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Videogame.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            dbconn.closeConnection();
        }
        return (val==0)?"No se ha podido insertar":"Se ha insertado";
    } 
    
    public Set<Videogame> mostrarTodo(){
        DbConnection dbconn = null;
        Set<Videogame> lista = null;
        try {
            dbconn = new DbConnection();
            lista = (Set<Videogame>) dbconn.readAllVideogames();
        } catch (IOException ex) {
            Logger.getLogger(Videogame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Videogame.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            dbconn.closeConnection();
        }return lista;
    }
    
}
