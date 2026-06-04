package com.ejemplo.escuela.iservice;

import java.util.List;
import com.ejemplo.escuela.entidades.Ataque;

public interface AtaqueIService {
    public List<Ataque> findAllAtaques();

    public Ataque saveAtaque(Ataque ataque);
}