package com.ejemplo.escuela.entidades;
import java.util.List;
import jakarta.persistence.*; 

@Entity
@Table(name = "armas")
public class Arma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombre;
    private int bonificadorDanio;
    private float peso;
    
    @ManyToMany(mappedBy = "inventario")
    private List<Peleador> peleadores;

    
    public Arma() {
    }

    public Arma(String nombre, int bonificadorDanio) {
        this.nombre = nombre;
        this.bonificadorDanio = bonificadorDanio;
    }

    public Arma(String nombre, int bonificadorDanio, float peso) {
        this.nombre = nombre;
        this.bonificadorDanio = bonificadorDanio;
        this.peso = peso;
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

    public int getBonificadorDanio() {
        return bonificadorDanio;
    }

    public void setBonificadorDanio(int bonificadorDanio) {
        this.bonificadorDanio = bonificadorDanio;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public List<Peleador> getPeleadores() {
        return peleadores;
    }

    public void setPeleadores(List<Peleador> peleadores) {
        this.peleadores = peleadores;
    }
}
