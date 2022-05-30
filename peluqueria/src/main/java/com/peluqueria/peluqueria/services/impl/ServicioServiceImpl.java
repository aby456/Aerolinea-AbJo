package com.peluqueria.peluqueria.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.peluqueria.peluqueria.dto.NewServicioDTO;
import com.peluqueria.peluqueria.dto.ServicioDTO;
import com.peluqueria.peluqueria.models.Servicio;
import com.peluqueria.peluqueria.repositories.ServicioRepository;
import com.peluqueria.peluqueria.services.ServicioService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioServiceImpl implements ServicioService {


    final ModelMapper modelMapper;
    final ServicioRepository servicioRepository;

    public ServicioServiceImpl(@Autowired ServicioRepository repository, ModelMapper mapper){
        this.servicioRepository = repository;
        this.modelMapper =mapper;

    }


    @Override
    @Transactional
    public ServicioDTO create(NewServicioDTO servicioDTO) {
        Servicio servicio = modelMapper.map(servicioDTO, Servicio.class);
        servicioRepository.save(servicio);
        ServicioDTO servicioDTOCreated = modelMapper.map(servicio, ServicioDTO.class);
        return servicioDTOCreated;
    }

    @Override
    @Transactional
    public ServicioDTO retrieve(Long id) throws Exception {
        Servicio servicio = servicioRepository.findById(id).orElseThrow(()-> new Exception("Categoria not found"));
        return modelMapper.map(servicio, ServicioDTO.class);
        
    }

    @Override
    @Transactional
    public ServicioDTO update(ServicioDTO servicioDTO , Long id) throws Exception {
        Servicio servicio = servicioRepository.findById(servicioDTO.getId()).orElseThrow(()-> new Exception("Categoria not found"));
        servicio.setId(id);
        servicio = modelMapper.map(servicioDTO, Servicio.class);
        servicioRepository.save(servicio);
        return modelMapper.map(servicio, ServicioDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        Servicio servicio = servicioRepository.findById(id).orElseThrow(()-> new Exception("Categoria not found"));
        servicioRepository.deleteById(servicio.getId());
       
    }

    @Override
    @Transactional
    public List<ServicioDTO> list() {
        List<Servicio> categorias = servicioRepository.findAll();
        return categorias.stream().map(servicio-> modelMapper.map(servicio, ServicioDTO.class)).collect(Collectors.toList());
    }
    
}
