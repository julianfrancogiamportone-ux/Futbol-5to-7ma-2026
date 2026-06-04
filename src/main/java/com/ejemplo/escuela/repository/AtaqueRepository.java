package com.ejemplo.escuela.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ejemplo.escuela.entidades.Ataque;

public interface AtaqueRepository extends JpaRepository<Ataque, Integer> {

}