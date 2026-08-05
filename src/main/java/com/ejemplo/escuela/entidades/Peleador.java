package com.ejemplo.escuela.entidades;
import java.util.List;
import jakarta.persistence.*; 

@Entity
@Table(name = "peleadores")
public class Peleador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int puntosVida;
    private int energia;    
    private float defensaBase;
    private String club;
    private String url_Imagen;
    private String nivelDePoder;
    
    @ManyToMany
    @JoinTable(
        name = "peleador_arma",
        joinColumns = @JoinColumn(name = "peleador_id"),
        inverseJoinColumns = @JoinColumn(name = "arma_id")
    )
    private List<Arma> inventario;

    @ManyToMany
    @JoinTable(
        name = "peleador_ataque",
        joinColumns = @JoinColumn(name = "peleador_id"),
        inverseJoinColumns = @JoinColumn(name = "ataque_id")
    )
    private List<Ataque> habilidades;

    public Peleador() {
    }

    public Peleador(String nombre, int puntosVida, int energia, float defensaBase, Arma armaEquipada, List<Ataque> habilidades, List<Arma> inventario) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.energia = energia;
        this.defensaBase = defensaBase;
        this.habilidades = habilidades;
        this.inventario = inventario;
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

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public float getDefensaBase() {
        return defensaBase;
    }

    public void setDefensaBase(float defensaBase) {
        this.defensaBase = defensaBase;
    }

    

    public List<Arma> getInventario() {
        return inventario;
    }

    public void setInventario(List<Arma> inventario) {
        this.inventario = inventario;
    }

    public List<Ataque> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Ataque> habilidades) {
        this.habilidades = habilidades;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getUrl_Imagen() {
        return url_Imagen;
    }

    public void setUrl_Imagen(String url_Imagen) {
        this.url_Imagen = url_Imagen;
    }

    public String getNivelDePoder() {
        return nivelDePoder;
    }

    public void setNivelDePoder(String nivelDePoder) {
        this.nivelDePoder = nivelDePoder;
    }
}
