package com.ejemplo.escuela.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ejemplo.escuela.iservice.ArmaIService;
import com.ejemplo.escuela.entidades.Arma;
import com.ejemplo.escuela.repository.ArmaRepository;

@Service
public class ArmaService implements ArmaIService {

    @Autowired
    private ArmaRepository armaRepository;

    public List<Arma> findAllArmas() {
        return armaRepository.findAll();
    }

    public Arma saveArma(Arma arma) {
        return armaRepository.save(arma);
    }
}