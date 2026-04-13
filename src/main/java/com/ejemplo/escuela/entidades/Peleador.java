package com.ejemplo.escuela.entidades;
import java.util.List;
public class Peleador {
    private int id;
    private String nombre;
    private int puntosVida;
    private int energia;    
    private float defensaBase;
    private Arma armaEquipada;
    private List<Arma> inventario;
    private List<Ataque> habilidades;

    public Peleador(String nombre, int puntosVida, int energia, float defensaBase) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.energia = energia;
        this.defensaBase = defensaBase;
    }
}
