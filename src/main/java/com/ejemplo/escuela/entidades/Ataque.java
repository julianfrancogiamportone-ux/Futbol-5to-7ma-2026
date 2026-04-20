package com.ejemplo.escuela.entidades;
import java.util.List;
import jakarta.persistence.*; 

@Entity
@Table(name = "ataques")
public class Ataque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombre;
    private int costoEnergia;
    private int danioBase;

    // Lado dueño de la relación Uno a Muchos
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "peleador_id")
    private Peleador peleador;

    public Ataque() {
    }

    public Ataque(String nombre, int costoEnergia, int danioBase) {
        this.nombre = nombre;
        this.costoEnergia = costoEnergia;
        this.danioBase = danioBase;
    }

    // Getters y Setters
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

    public int getDanioBase() {
        return danioBase;
    }

    public void setDanioBase(int danioBase) {
        this.danioBase = danioBase;
    }

    public int getCostoEnergia() {
        return costoEnergia;
    }

    public void setCostoEnergia(int costoEnergia) {
        this.costoEnergia = costoEnergia;
    }

    public Peleador getPeleador() {
        return peleador;
    }

    public void setPeleador(Peleador peleador) {
        this.peleador = peleador;
    }
}
