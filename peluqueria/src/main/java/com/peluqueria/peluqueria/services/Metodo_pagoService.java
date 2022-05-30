package com.peluqueria.peluqueria.services;

import java.util.List;

import com.peluqueria.peluqueria.dto.Metodo_pagoDTO;
import com.peluqueria.peluqueria.dto.NewMetodo_pagoDTO;

public interface Metodo_pagoService {
    public Metodo_pagoDTO create(NewMetodo_pagoDTO metodo_pagoDTO);
    public Metodo_pagoDTO retrieve(Long id) throws Exception;
    public Metodo_pagoDTO update(Metodo_pagoDTO metodo_pagoDTO, Long id) throws Exception;
    public void delete(Long id) throws Exception;
    public List<Metodo_pagoDTO> list();
}
