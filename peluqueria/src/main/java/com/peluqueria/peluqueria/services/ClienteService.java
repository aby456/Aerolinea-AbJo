package com.peluqueria.peluqueria.services;

import java.util.List;

import com.peluqueria.peluqueria.dto.ClienteDTO;
import com.peluqueria.peluqueria.dto.NewClienteDTO;

public interface ClienteService {

    public ClienteDTO create(NewClienteDTO clienteDTO);
    public ClienteDTO retrieve(Long id) ;
    public ClienteDTO update(ClienteDTO clienteDTO ,Long id) ;
    public void delete(Long id) ;
    
    public List<ClienteDTO> list();
}
