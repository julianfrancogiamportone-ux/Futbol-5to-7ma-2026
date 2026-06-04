package com.ejemplo.escuela.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ejemplo.escuela.entidades.Peleador;

public interface PeleadorRepository extends JpaRepository<Peleador, Integer> {
}
