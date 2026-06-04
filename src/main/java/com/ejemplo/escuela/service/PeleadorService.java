package com.ejemplo.escuela.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ejemplo.escuela.iservice.PeleadorIService;
import com.ejemplo.escuela.entidades.Peleador;
import com.ejemplo.escuela.repository.PeleadorRepository;

@Service
public class PeleadorService implements PeleadorIService {

    @Autowired
    private PeleadorRepository peleadorRepository;

    public List<Peleador> findAllPeleadores() {
        return peleadorRepository.findAll();
    }

    public Peleador savePeleador(Peleador peleador) {
        return peleadorRepository.save(peleador);
    }
}
