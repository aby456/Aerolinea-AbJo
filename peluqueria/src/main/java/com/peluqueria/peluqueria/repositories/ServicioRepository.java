package com.peluqueria.peluqueria.repositories;

import com.peluqueria.peluqueria.models.Servicio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio,Long> {
    
}
