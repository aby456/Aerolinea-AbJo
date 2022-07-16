package com.peluqueria.peluqueria.repositories;

import com.peluqueria.peluqueria.models.Reservacion;
import com.peluqueria.peluqueria.models.Servicio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio,Long> {
    public List<Servicio>  findByReservacion(Reservacion reservacion);
}
