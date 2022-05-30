package com.peluqueria.peluqueria.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.peluqueria.peluqueria.dto.Metodo_pagoDTO;
import com.peluqueria.peluqueria.dto.NewMetodo_pagoDTO;
import com.peluqueria.peluqueria.models.Metodo_pago;
import com.peluqueria.peluqueria.repositories.Metodo_pagoRepository;
import com.peluqueria.peluqueria.services.Metodo_pagoService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Metodo_pagoServiceImpl implements Metodo_pagoService {

    final ModelMapper modelMapper;
    final Metodo_pagoRepository metodo_pagoRepository;

    public Metodo_pagoServiceImpl(@Autowired Metodo_pagoRepository repository, ModelMapper mapper){
        this.metodo_pagoRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public Metodo_pagoDTO create(NewMetodo_pagoDTO metodo_pagoDTO) {
        Metodo_pago metodo_pago = modelMapper.map(metodo_pagoDTO, Metodo_pago.class);
        metodo_pagoRepository.save(metodo_pago);
        Metodo_pagoDTO metodo_pagoDTOCreated = modelMapper.map(metodo_pago, Metodo_pagoDTO.class);
        return metodo_pagoDTOCreated;
    }

    @Override
    @Transactional
    public Metodo_pagoDTO retrieve(Long id) throws Exception {
        Metodo_pago metodo_pago = metodo_pagoRepository.findById(id).orElseThrow(()-> new Exception("Categoria not found"));
        return modelMapper.map(metodo_pago, Metodo_pagoDTO.class);
    }

    @Override
    @Transactional
    public Metodo_pagoDTO update(Metodo_pagoDTO metodo_pagoDTO, Long id) throws Exception {
        Metodo_pago metodo_pago = metodo_pagoRepository.findById(metodo_pagoDTO.getId()).orElseThrow(()-> new Exception("Categoria not found"));
        metodo_pago.setId(id);
        metodo_pago = modelMapper.map(metodo_pagoDTO, Metodo_pago.class);
        metodo_pagoRepository.save(metodo_pago);
        return modelMapper.map(metodo_pago, Metodo_pagoDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        Metodo_pago metodo_pago = metodo_pagoRepository.findById(id).orElseThrow(()-> new Exception("Categoria not found"));
        metodo_pagoRepository.deleteById(metodo_pago.getId());
    }

    @Override
    @Transactional
    public List<Metodo_pagoDTO> list() {
        List<Metodo_pago> metodo_pagos = metodo_pagoRepository.findAll();
        return metodo_pagos.stream().map(metodo_pago-> modelMapper.map(metodo_pago, Metodo_pagoDTO.class)).collect(Collectors.toList());
    }
    
}
