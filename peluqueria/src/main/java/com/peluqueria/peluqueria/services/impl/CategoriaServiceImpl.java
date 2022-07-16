package com.peluqueria.peluqueria.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.peluqueria.peluqueria.dto.CategoriaDTO;
import com.peluqueria.peluqueria.dto.NewCategoriaDTO;
import com.peluqueria.peluqueria.exception.NoContentException;
import com.peluqueria.peluqueria.exception.ResourceNotFoundException;
import com.peluqueria.peluqueria.models.Categoria;
import com.peluqueria.peluqueria.models.Reservacion;
import com.peluqueria.peluqueria.models.Servicio;
import com.peluqueria.peluqueria.repositories.CategoriaRepository;
import com.peluqueria.peluqueria.repositories.ReservacionRepository;
import com.peluqueria.peluqueria.repositories.ServicioRepository;
import com.peluqueria.peluqueria.services.CategoriaService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    final ModelMapper modelMapper;
    final CategoriaRepository repository;
    final ServicioRepository servicioRepository;
    final ReservacionRepository reservacionRepository;

    public CategoriaServiceImpl(CategoriaRepository r, ServicioRepository qr, ReservacionRepository er, ModelMapper m)
    {
        this.modelMapper = m;
        this.repository = r;
        this.reservacionRepository = er;
        this.servicioRepository = qr;
    }

    @Override
    @Transactional
    public List<CategoriaDTO> create(Long idReservacion, Long idServicio, List<NewCategoriaDTO> categorias) {
        Reservacion reservacion = reservacionRepository.findById(idReservacion).orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        Servicio servicio = servicioRepository.findById(idServicio).orElseThrow(()-> new ResourceNotFoundException("Servicio not found"));
        servicio.setReservacion(reservacion);
        List<CategoriaDTO> result = new ArrayList<CategoriaDTO>();
        for(NewCategoriaDTO op : categorias){
            Categoria categoria = modelMapper.map(op, Categoria.class);
            categoria.setServicio(servicio);
            repository.save(categoria);
            result.add(modelMapper.map(categoria, CategoriaDTO.class));
        }
        /*Categorias.forEach(op -> {
        });        */
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoriaDTO> list(Long idReservacion, Long idServicio) {
        Reservacion reservacion = reservacionRepository.findById(idReservacion).orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        Servicio servicio = servicioRepository.findById(idServicio).orElseThrow(()-> new ResourceNotFoundException("Servicio not found"));
        servicio.setReservacion(reservacion);
        if(servicio.getCategoria().isEmpty()) throw new NoContentException("Categorias is empty");
        return servicio.getCategoria().stream().map(op -> modelMapper.map(op, CategoriaDTO.class))
        .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void remove(Long idReservacion, Long idServicio) {
        Reservacion reservacion = reservacionRepository.findById(idReservacion).orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        Servicio servicio = servicioRepository.findById(idServicio).orElseThrow(()-> new ResourceNotFoundException("Servicio not found"));
        servicio.setReservacion(reservacion);
        if(servicio.getCategoria().isEmpty()) throw new NoContentException("Categorias is empty");
        servicio.getCategoria().forEach(op -> {
            repository.delete(op);            
        });                      
    }
    
    
}
