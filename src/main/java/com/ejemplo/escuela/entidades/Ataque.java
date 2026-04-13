package com.ejemplo.escuela.entidades;

public class Ataque {
    private int id;
    private String nombre;
    private int danioBase;
    private int costoEnergia;

    public Ataque(String nombre, int danioBase, int costoEnergia) {
        this.nombre = nombre;
        this.danioBase = danioBase;
        this.costoEnergia = costoEnergia;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getDanioBase() {
        return danioBase;
    }

    public int getCostoEnergia() {
        return costoEnergia;
    }
}
