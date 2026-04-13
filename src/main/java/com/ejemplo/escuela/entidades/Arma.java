package com.ejemplo.escuela.entidades;
import java.util.List;
public class Arma {
    private int id;
    private String nombre;
    private int BonificadorDanio;
    private float peso;
    public Arma(String nombre, int BonificadorDanio) {
        this.nombre = nombre;
        this.BonificadorDanio = BonificadorDanio;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getBonificadorDanio() {
        return BonificadorDanio;
    }
}
