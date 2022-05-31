package com.peluqueria.peluqueria.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.peluqueria.peluqueria.dto.NewReservacionDTO;
import com.peluqueria.peluqueria.dto.ReservacionDTO;
import com.peluqueria.peluqueria.exception.ResourceNotFoundException;
import com.peluqueria.peluqueria.models.Reservacion;
import com.peluqueria.peluqueria.repositories.ReservacionRepository;
import com.peluqueria.peluqueria.services.ReservacionService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservacionServiceImpl implements ReservacionService {

    final ModelMapper modelMapper;
    final ReservacionRepository reservacionRepository;

    @Autowired
    public ReservacionServiceImpl(@Autowired ReservacionRepository repository, ModelMapper mapper){
        this.reservacionRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public ReservacionDTO create(NewReservacionDTO reservacionDTO) {
        Reservacion reservacion = modelMapper.map(reservacionDTO, Reservacion.class);
        reservacionRepository.save(reservacion);
        ReservacionDTO reservacionDTOCreated = modelMapper.map(reservacion, ReservacionDTO.class);
        return reservacionDTOCreated;
    }

    @Override
    @Transactional(readOnly = true)
    public ReservacionDTO retrieve(Long id)  {
        Reservacion reservacion = reservacionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Categoria not found"));
        return modelMapper.map(reservacion, ReservacionDTO.class);
    }

    @Override
    @Transactional
    public ReservacionDTO update(ReservacionDTO reservacionDTO , Long id)  {
        Reservacion reservacion = reservacionRepository.findById(reservacionDTO.getId()).orElseThrow(()-> new ResourceNotFoundException("Categoria not found"));
        reservacion.setId(id);
        reservacion = modelMapper.map(reservacionDTO, Reservacion.class);
        reservacionRepository.save(reservacion);
        return modelMapper.map(reservacion, ReservacionDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id)  {
        Reservacion reservacion = reservacionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Categoria not found"));
        reservacionRepository.deleteById(reservacion.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservacionDTO> list() {
        List<Reservacion> reservacions = reservacionRepository.findAll();
        return reservacions.stream().map(reservacion-> modelMapper.map(reservacion, ReservacionDTO.class)).collect(Collectors.toList());
    }
    
}
