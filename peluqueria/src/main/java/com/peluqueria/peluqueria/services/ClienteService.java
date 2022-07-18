package com.peluqueria.peluqueria.services;

import java.util.List;

import com.peluqueria.peluqueria.dto.ClienteDTO;
import com.peluqueria.peluqueria.dto.ClienteReservacionDTO;
import com.peluqueria.peluqueria.dto.NewClienteDTO;

public interface ClienteService {

    public ClienteDTO create(Long idReservacion ,NewClienteDTO clienteDTO);
    public ClienteReservacionDTO retrieve(Long idReservacion, Long id) ;
    public ClienteReservacionDTO update(ClienteDTO servicioDTO, Long idReservacion, Long id) ;
    public void delete(Long idReservacion, Long id) ;
    public long count();
    public List<ClienteDTO> list(Long idReservacion);
}
