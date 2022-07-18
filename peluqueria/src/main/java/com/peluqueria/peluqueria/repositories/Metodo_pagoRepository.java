package com.peluqueria.peluqueria.repositories;

import com.peluqueria.peluqueria.models.Metodo_pago;
import com.peluqueria.peluqueria.models.Reservacion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Metodo_pagoRepository extends JpaRepository<Metodo_pago,Long>{
    public List<Metodo_pago>  findByReservacion(Reservacion reservacion);
}
