package com.peluqueria.peluqueria.services;

import java.util.List;

import com.peluqueria.peluqueria.dto.CategoriaDTO;
import com.peluqueria.peluqueria.dto.NewCategoriaDTO;

public interface CategoriaService {

    public List<CategoriaDTO> create(Long idReservacion, Long idServicio, List<NewCategoriaDTO> list);
    public List<CategoriaDTO> list(Long idReservacion, Long idServicio);
    public void remove(Long idReservacion, Long idServicio);
}
