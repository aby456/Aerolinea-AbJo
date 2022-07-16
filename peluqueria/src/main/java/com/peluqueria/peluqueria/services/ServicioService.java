package com.peluqueria.peluqueria.services;

import java.util.List;

import com.peluqueria.peluqueria.dto.NewServicioDTO;
import com.peluqueria.peluqueria.dto.ServicioDTO;
import com.peluqueria.peluqueria.dto.ServicioReservacionDTO;

public interface ServicioService {

    public ServicioDTO create(Long idReservacion, NewServicioDTO servicioDTO);
    public ServicioDTO retrieve(Long idReservacion, Long id) ;
    public ServicioDTO update(ServicioDTO servicioDTO, Long idReservacion, Long id) ;
    public void delete(Long idReservacion, Long id) ;
    
    public List<ServicioDTO> list(Long idReservacion);
}
