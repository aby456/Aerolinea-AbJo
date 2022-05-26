package com.peluqueria.peluqueria.services;

import java.util.List;

import com.peluqueria.peluqueria.dto.ClienteDTO;
import com.peluqueria.peluqueria.dto.NewClienteDTO;

public interface ClienteService {
    public ClienteDTO create(NewClienteDTO clienteDTO);
    public ClienteDTO retrieve(Long id) throws Exception;
    public ClienteDTO update(ClienteDTO clienteDTO) throws Exception;
    public ClienteDTO delete(Long id) throws Exception;
    public List<ClienteDTO> list();
}
