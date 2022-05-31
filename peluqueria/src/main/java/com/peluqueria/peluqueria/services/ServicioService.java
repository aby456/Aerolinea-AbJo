package com.peluqueria.peluqueria.services;

import java.util.List;

import com.peluqueria.peluqueria.dto.NewServicioDTO;
import com.peluqueria.peluqueria.dto.ServicioDTO;

public interface ServicioService {

    public ServicioDTO create(NewServicioDTO servicioDTO);
    public ServicioDTO retrieve(Long id) ;
    public ServicioDTO update(ServicioDTO servicioDTO, Long id) ;
    public void delete(Long id) ;
    
    public List<ServicioDTO> list();
}
