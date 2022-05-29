package com.peluqueria.peluqueria.services;

import java.util.List;

import com.peluqueria.peluqueria.dto.NewReservacionDTO;
import com.peluqueria.peluqueria.dto.ReservacionDTO;

public interface ReservacionService {
    
    public ReservacionDTO create(NewReservacionDTO reservacionDTO);
    public ReservacionDTO retrieve(Long id) throws Exception;
    public ReservacionDTO update(ReservacionDTO reservacionDTO) throws Exception;
    public void delete(Long id) throws Exception;
    public List<ReservacionDTO> list();

}
