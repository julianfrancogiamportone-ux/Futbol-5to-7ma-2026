package com.ejemplo.escuela.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ejemplo.escuela.iservice.AtaqueIService;
import com.ejemplo.escuela.entidades.Ataque;

@RestController
@RequestMapping("/api/ataques")

public class AtaqueController {
    @Autowired
    private AtaqueIService ataqueIService;

    @GetMapping
    public List<Ataque> getAllAtaques() {
        return ataqueIService.findAllAtaques();
    }

    @PostMapping
    public Ataque createAtaque(@RequestBody Ataque ataque) {
        return ataqueIService.saveAtaque(ataque);
    }
}