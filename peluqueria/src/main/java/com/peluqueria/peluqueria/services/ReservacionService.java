package com.peluqueria.peluqueria.services;

import java.util.List;

import com.peluqueria.peluqueria.dto.NewReservacionDTO;
import com.peluqueria.peluqueria.dto.ReservacionDTO;

public interface ReservacionService {
    
    public ReservacionDTO create(NewReservacionDTO reservacionDTO);
    public ReservacionDTO retrieve(Long id) ;
    public ReservacionDTO update(ReservacionDTO reservacionDTO, Long id) ;
    public void delete(Long id) ;

    public List<ReservacionDTO> list();

}
