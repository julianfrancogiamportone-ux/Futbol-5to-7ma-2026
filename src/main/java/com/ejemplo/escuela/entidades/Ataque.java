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
    private int danioBase;
    private int costoEnergia;

    // Lado dueño de la relación Uno a Muchos
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "peleador_id")
    private Peleador peleador;

    public Ataque() {
    }

    public Ataque(String nombre, int danioBase, int costoEnergia) {
        this.nombre = nombre;
        this.danioBase = danioBase;
        this.costoEnergia = costoEnergia;
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
