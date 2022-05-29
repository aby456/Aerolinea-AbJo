package com.peluqueria.peluqueria.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.peluqueria.peluqueria.dto.ClienteDTO;
import com.peluqueria.peluqueria.dto.NewClienteDTO;
import com.peluqueria.peluqueria.models.Cliente;
import com.peluqueria.peluqueria.repositories.ClienteRepository;
import com.peluqueria.peluqueria.services.ClienteService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    final ModelMapper modelMapper;
    final ClienteRepository clienteRepository;

    public ClienteServiceImpl(@Autowired ClienteRepository repository, ModelMapper mapper){
        this.clienteRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public ClienteDTO create(NewClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        clienteRepository.save(cliente);
        ClienteDTO clienteDTOCreated = modelMapper.map(cliente, ClienteDTO.class);
        return clienteDTOCreated;
    }

    @Override
    public ClienteDTO retrieve(Long id) throws Exception {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new Exception("Categoria not found"));
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    @Override
    public ClienteDTO update(ClienteDTO clienteDTO) throws Exception {
        Cliente cliente = clienteRepository.findById(clienteDTO.getId()).orElseThrow(()-> new Exception("Categoria not found"));
        cliente = modelMapper.map(clienteDTO, Cliente.class);
        clienteRepository.save(cliente);
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    @Override
    public void delete(Long id) throws Exception {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new Exception("Categoria not found"));
        clienteRepository.deleteById(cliente.getId());
        
    }

    @Override
    public List<ClienteDTO> list() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(cliente-> modelMapper.map(cliente, ClienteDTO.class)).collect(Collectors.toList());
    }
    
}
