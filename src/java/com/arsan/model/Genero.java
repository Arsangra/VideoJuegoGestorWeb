/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.arsan.model;

/**
 *
 * @author arsan
 */
public enum Genero {
    //creamos constantes para obligar a qué lo seleccionado este dentro de estas posibilidades dadas
    AVENTURAS("aventuras"),
    RPG("rpg"),
    SHOOTER("shooter"),
    ESTRATEGIA("estrategia"),
    PLATAFORMAS("plataformas"),
    PUZZLES("puzzle"),
    CARRERAS("carreras"),
    LUCHA ("lucha");
    
    String titulo;
    //contructor que añade los valores anteriores a título
    private Genero(String titulo) {
        this.titulo = titulo;
    }
    
    

}
