package com.ejemplo.escuela.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ejemplo.escuela.iservice.AtaqueIService;
import com.ejemplo.escuela.entidades.Ataque;
import com.ejemplo.escuela.repository.AtaqueRepository;
@Service

public class AtaqueService {
@Autowired
    private AtaqueRepository ataqueRepository;

    public List<Ataque> findAllAtaques() {
        return ataqueRepository.findAll();
    }

    public Ataque saveAtaque(Ataque ataque) {
        return ataqueRepository.save(ataque);
    }
}
