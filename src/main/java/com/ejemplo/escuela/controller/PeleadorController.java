package com.ejemplo.escuela.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ejemplo.escuela.iservice.PeleadorIService;
import com.ejemplo.escuela.entidades.Peleador;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/characters")
public class PeleadorController {

    @Autowired
    private PeleadorIService peleadorIService;

    @GetMapping
    public List<Peleador> getAllPeleadores() {
        return peleadorIService.findAllPeleadores();
    }

    @PostMapping
    public Peleador createPeleador(@RequestBody Peleador peleador) {
        return peleadorIService.savePeleador(peleador);
    }
}
