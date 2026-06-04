package com.ejemplo.escuela.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ejemplo.escuela.entidades.Arma;

public interface ArmaRepository extends JpaRepository<Arma, Integer> {
}