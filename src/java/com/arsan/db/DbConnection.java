/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arsan.db;


import com.arsan.model.Videogame;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arsan
 */
public class DbConnection {

    private Properties prop = new Properties();
    private Connection conn = null;
    public Set<Videogame> setVideogames = new HashSet<>();

    public DbConnection() throws IOException, SQLException {
        //try con recursos, no evita colocar cath o finaly que no haría desarrollar mucho código
        Path ruta = Paths.get(".\\src\\com\\arsan\\model\\credentials.properties");
        //try ( FileInputStream fis = new FileInputStream(new File(ruta.toAbsolutePath().toString()));) {
           // prop.load(fis);
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/videogamedb;create=true");
            setVideogames.addAll(readAllVideogames());
        //}//llama a close() para liberar espacio en memoria
    }

    public void closeConnection() {
        try {
            if(!conn.isClosed())
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //método para implementar las constatntes en la base de datos
    public int createVideogame(String nombre, String genero, double valoracion, boolean jugado) throws SQLException {
        String sql = "INSERT INTO VIDEOGAMES (titulo, genero, valoracion, jugado) VALUES (?,?,?,?)";
        //try para la conexión a la base de datos, se realiza siempre con DriverManager        
        try ( PreparedStatement stm = conn.prepareStatement(sql);) {

            stm.setString(1, nombre.trim());
            stm.setString(2, genero);
            valoracion = (jugado) ? valoracion : 0.0;
            stm.setDouble(3, valoracion);
            stm.setBoolean(4, jugado);
            Set<String> videogamesNames = new HashSet<>();
            setVideogames.forEach((Videogame m) -> {
                String name = m.getNombre();
                videogamesNames.add(name);
            });

            if (!videogamesNames.contains(nombre)) {
                setVideogames.add(new Videogame(Videogame.count.incrementAndGet(), nombre, genero, valoracion, jugado));                
                return stm.executeUpdate();
            }
            return 0;

        }

    }

    public Set<Videogame> readAllVideogames() throws SQLException {

        String sql = "SELECT * FROM VIDEOGAMES";
        try ( Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            setVideogames.clear();
            while (rs.next()) {
                setVideogames.add(new Videogame(rs.getInt(1), rs.getString(2), String.valueOf(rs.getString(3)), rs.getDouble(4), rs.getBoolean(5)));
            }

        }
        return setVideogames;

    }

    public Videogame findVideogame(int id) throws SQLException {
        String sql = "SELECT * FROM Videogames WHERE ID = ?";
        try ( PreparedStatement stm = conn.prepareStatement(sql);) {
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Videogame.count.getAndDecrement();
                return new Videogame(rs.getInt(1), rs.getString(2), String.valueOf(rs.getString(3)), rs.getDouble(4), rs.getBoolean(5));
            }

        }
        return new Videogame();
    }

    public Videogame findVideogame(String name) throws SQLException {
        String sql = "SELECT * FROM Videogames WHERE titulo = ?";
        try ( PreparedStatement stm = conn.prepareStatement(sql);) {
            stm.setString(1, name.trim());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Videogame.count.getAndDecrement();
                return new Videogame(rs.getInt(1), rs.getString(2), String.valueOf(rs.getString(3)), rs.getDouble(4), rs.getBoolean(5));
            }

        }
        return new Videogame();
    }

    public String updateVideogame(int id, String titulo, String genero, double valoracion, boolean jugado) throws SQLException {
        String sql = "UPDATE Videogames SET titulo=?, genero=?, valoracion=?, jugado=? WHERE ID = ?";
        String mensaje = "Registro modificado con éxito";
        boolean isSet = setVideogames.stream().filter(v -> v.getId() == id).count() == 1;
        if (isSet && !titulo.isEmpty()) {
            try ( PreparedStatement stm = conn.prepareStatement(sql);) {
                stm.setString(1, titulo.trim());
                stm.setString(2, genero);
                stm.setDouble(3, valoracion);
                stm.setBoolean(4, jugado);
                stm.setInt(5, id);
                stm.execute();
            }
            setVideogames = (Set<Videogame>) readAllVideogames();
        } else {
            mensaje = isSet ? "Debe introducir un nombre de registro válido" : "No hay ningún registro con el id especificado";

        }
        return mensaje;

    }

    public boolean deleteVideogame(int id) throws SQLException {
        String sql = "DELETE FROM Videogames WHERE ID = ?";
        boolean isSet = setVideogames.stream().filter(v -> v.getId() == id).count() == 1;
        if (isSet) {
            try ( PreparedStatement stm = conn.prepareStatement(sql);) {
                stm.setInt(1, id);
                stm.execute();
                setVideogames = (Set<Videogame>) readAllVideogames();
                return true;
            }            
        }
        return false;
    }
}
