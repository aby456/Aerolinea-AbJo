package com.peluqueria.peluqueria.services;

import java.util.List;

import com.peluqueria.peluqueria.dto.NewReservacionDTO;
import com.peluqueria.peluqueria.dto.ReservacionDTO;
import com.peluqueria.peluqueria.dto.ReservacionListDTO;

public interface ReservacionService {
    
    public ReservacionDTO create(NewReservacionDTO reservacionDTO);
    public ReservacionDTO retrieve(Long id) ;
    public ReservacionDTO update(ReservacionDTO reservacionDTO, Long id) ;
    public void delete(Long id) ;
    public long count();

    public List<ReservacionListDTO> list(int page, int size, String sort);

}
