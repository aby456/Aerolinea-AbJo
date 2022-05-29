package com.peluqueria.peluqueria.services;

import java.util.List;

import com.peluqueria.peluqueria.dto.NewServicioDTO;
import com.peluqueria.peluqueria.dto.ServicioDTO;

public interface ServicioService {
    public ServicioDTO create(NewServicioDTO servicioDTO);
    public ServicioDTO retrieve(Long id) throws Exception;
    public ServicioDTO update(ServicioDTO servicioDTO) throws Exception;
    public void delete(Long id) throws Exception;
    public List<ServicioDTO> list();
}
