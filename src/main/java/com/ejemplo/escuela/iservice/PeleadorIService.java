package com.ejemplo.escuela.iservice;

import java.util.List;
import com.ejemplo.escuela.entidades.Peleador;

public interface PeleadorIService {
    public List<Peleador> findAllPeleadores();
    public Peleador savePeleador(Peleador peleador);
}
