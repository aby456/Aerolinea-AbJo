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
    final ReservacionRepository ReservacionRepository;

    public ServicioServiceImpl(ServicioRepository r, ReservacionRepository er, ModelMapper m)
    {
        this.modelMapper = m;
        this.repository = r;
        this.ReservacionRepository = er;
    }


    @Override
    @Transactional
    public ServicioDTO create(Long idReservacion, NewServicioDTO ServicioDTO) {
        Reservacion reservacion = ReservacionRepository.findById(idReservacion)
            .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        Servicio Servicio = modelMapper.map(ServicioDTO, Servicio.class);    
        Servicio.setReservacion(reservacion);
        repository.save(Servicio);
        return modelMapper.map(Servicio, ServicioDTO.class); 
    }

    @Override
    @Transactional(readOnly=true)
    public ServicioReservacionDTO retrieve(Long idReservacion, Long id) {
        Reservacion Reservacion = ReservacionRepository.findById(idReservacion)
            .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        Servicio Servicio = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Servicio not found"));
        Servicio.setReservacion(Reservacion);
        return modelMapper.map(Servicio, ServicioReservacionDTO.class);
    }

    @Override
    @Transactional
    public ServicioReservacionDTO update(ServicioDTO ServicioDTO, Long idReservacion, Long id) {
        Reservacion Reservacion = ReservacionRepository.findById(idReservacion)
        .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        Servicio Servicio = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Servicio not found"));
        Servicio = modelMapper.map(ServicioDTO, Servicio.class);
        Servicio.setReservacion(Reservacion);
        repository.save(Servicio);       
        return modelMapper.map(Servicio, ServicioReservacionDTO.class);
    }


    @Override
    @Transactional
    public void delete(Long idReservacion, Long id) {
        Reservacion Reservacion = ReservacionRepository.findById(idReservacion)
        .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        Servicio Servicio = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Servicio not found"));
        Servicio.setReservacion(Reservacion);
        repository.deleteById(Servicio.getId());  
    }

    @Override
    @Transactional(readOnly=true)
    public List<ServicioDTO> list(Long idReservacion) {
        Reservacion Reservacion = ReservacionRepository.findById(idReservacion)
            .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        List<Servicio> Servicios = repository.findByReservacion(Reservacion);
        if(Servicios.isEmpty()) throw new NoContentException("Servicios is empty");
        //Lambda ->
        return Servicios.stream().map(q -> modelMapper.map(q, ServicioDTO.class) )
            .collect(Collectors.toList());
    }

    
}
