package com.peluqueria.peluqueria.repositories;

import com.peluqueria.peluqueria.models.Reservacion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservacionRepository extends JpaRepository<Reservacion,Long> {
    public List<Reservacion> findByHorario(String dia);
}
