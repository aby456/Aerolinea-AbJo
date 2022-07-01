package com.peluqueria.peluqueria.repositories;

import com.peluqueria.peluqueria.models.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public List<Cliente> findByNombre(String criteria);
}
