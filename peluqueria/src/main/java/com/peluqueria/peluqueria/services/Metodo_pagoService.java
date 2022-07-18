package com.peluqueria.peluqueria.services;

import java.util.List;

import com.peluqueria.peluqueria.dto.Metodo_PagoReservacionDTO;
import com.peluqueria.peluqueria.dto.Metodo_pagoDTO;
import com.peluqueria.peluqueria.dto.NewMetodo_pagoDTO;

public interface Metodo_pagoService {
    
    public Metodo_pagoDTO create(Long idReservacion ,NewMetodo_pagoDTO metodo_pagoDTO);
    public Metodo_PagoReservacionDTO retrieve(Long idReservacion, Long id) ;
    public Metodo_PagoReservacionDTO update(Metodo_pagoDTO metodo_pagoDTO, Long idReservacion, Long id) ;
    public void delete(Long idReservacion, Long id) ;

    public List<Metodo_pagoDTO> list(Long idReservacion);




}
