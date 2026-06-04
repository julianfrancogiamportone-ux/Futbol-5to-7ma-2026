package com.ejemplo.escuela.iservice;

import java.util.List;
import com.ejemplo.escuela.entidades.Arma;

public interface ArmaIService {
    public List<Arma> findAllArmas();
    public Arma saveArma(Arma arma);
}
