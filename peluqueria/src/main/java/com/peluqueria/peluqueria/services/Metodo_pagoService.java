package com.peluqueria.peluqueria.services;

import java.util.List;

import com.peluqueria.peluqueria.dto.Metodo_PagoReservacionDTO;
import com.peluqueria.peluqueria.dto.Metodo_PagoDTO;
import com.peluqueria.peluqueria.dto.NewMetodo_pagoDTO;

public interface Metodo_pagoService {
    
    public Metodo_PagoDTO create(Long idReservacion ,NewMetodo_pagoDTO metodo_pagoDTO);
    public Metodo_PagoReservacionDTO retrieve(Long idReservacion, Long id) ;
    public Metodo_PagoReservacionDTO update(Metodo_PagoDTO metodo_pagoDTO, Long idReservacion, Long id) ;
    public void delete(Long idReservacion, Long id) ;

    public List<Metodo_PagoDTO> list(Long idReservacion);




}
