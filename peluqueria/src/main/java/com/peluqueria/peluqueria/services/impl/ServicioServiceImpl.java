package com.peluqueria.peluqueria.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.peluqueria.peluqueria.dto.NewServicioDTO;
import com.peluqueria.peluqueria.dto.ServicioDTO;
import com.peluqueria.peluqueria.dto.ServicioReservacionDTO;
import com.peluqueria.peluqueria.exception.NoContentException;
import com.peluqueria.peluqueria.exception.ResourceNotFoundException;
import com.peluqueria.peluqueria.models.Reservacion;
import com.peluqueria.peluqueria.models.Servicio;
import com.peluqueria.peluqueria.repositories.ReservacionRepository;
import com.peluqueria.peluqueria.repositories.ServicioRepository;
import com.peluqueria.peluqueria.services.ServicioService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioServiceImpl implements ServicioService {


    final ModelMapper modelMapper;
    final ServicioRepository repository;
    final ReservacionRepository reservacionRepository;

    public ServicioServiceImpl(ServicioRepository r, ReservacionRepository er, ModelMapper m)
    {
        this.modelMapper = m;
        this.repository = r;
        this.reservacionRepository = er;
    }


    @Override
    @Transactional
    public ServicioDTO create(Long idReservacion, NewServicioDTO servicioDTO) {
        Reservacion reservacion = reservacionRepository.findById(idReservacion)
            .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        Servicio servicio = modelMapper.map(servicioDTO, Servicio.class);    
        servicio.setReservacion(reservacion);
        repository.save(servicio);
        return modelMapper.map(servicio, ServicioDTO.class); 
    }

    @Override
    @Transactional(readOnly=true)
    public ServicioReservacionDTO retrieve(Long idReservacion, Long id) {
        Reservacion reservacion = reservacionRepository.findById(idReservacion)
            .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        Servicio servicio = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Servicio not found"));
        servicio.setReservacion(reservacion);
        return modelMapper.map(servicio, ServicioReservacionDTO.class);
    }

    @Override
    @Transactional
    public ServicioReservacionDTO update(ServicioDTO servicioDTO, Long idReservacion, Long id) {
        Reservacion reservacion = reservacionRepository.findById(idReservacion)
        .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        Servicio servicio = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Servicio not found"));
        servicio = modelMapper.map(servicioDTO, Servicio.class);
        servicio.setReservacion(reservacion);
        repository.save(servicio);       
        return modelMapper.map(servicio, ServicioReservacionDTO.class);
    }


    @Override
    @Transactional
    public void delete(Long idReservacion, Long id) {
        Reservacion reservacion = reservacionRepository.findById(idReservacion)
        .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        Servicio servicio = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Servicio not found"));
        servicio.setReservacion(reservacion);
        repository.deleteById(servicio.getId());  
    }

    @Override
    @Transactional(readOnly=true)
    public List<ServicioDTO> list(Long idReservacion) {
        Reservacion reservacion = reservacionRepository.findById(idReservacion)
            .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        List<Servicio> servicios = repository.findByReservacion(reservacion);
        if(servicios.isEmpty()) throw new NoContentException("Servicios is empty");
        //Lambda ->
        return servicios.stream().map(q -> modelMapper.map(q, ServicioDTO.class) )
            .collect(Collectors.toList());
    }

    
}
