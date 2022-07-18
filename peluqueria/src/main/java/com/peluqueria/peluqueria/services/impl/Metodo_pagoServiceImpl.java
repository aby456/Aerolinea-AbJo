package com.peluqueria.peluqueria.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.peluqueria.peluqueria.dto.Metodo_PagoReservacionDTO;
import com.peluqueria.peluqueria.dto.Metodo_pagoDTO;
import com.peluqueria.peluqueria.dto.NewMetodo_pagoDTO;
import com.peluqueria.peluqueria.exception.NoContentException;
import com.peluqueria.peluqueria.exception.ResourceNotFoundException;
import com.peluqueria.peluqueria.models.Metodo_pago;
import com.peluqueria.peluqueria.models.Reservacion;
import com.peluqueria.peluqueria.repositories.Metodo_pagoRepository;
import com.peluqueria.peluqueria.repositories.ReservacionRepository;
import com.peluqueria.peluqueria.services.Metodo_pagoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Metodo_pagoServiceImpl implements Metodo_pagoService {

    final ModelMapper modelMapper;
    final Metodo_pagoRepository repository;
    final ReservacionRepository reservacionRepository;

    public Metodo_pagoServiceImpl(Metodo_pagoRepository r, ReservacionRepository er, ModelMapper m)
    {
        this.modelMapper = m;
        this.repository = r;
        this.reservacionRepository = er;
    }


    @Override
    @Transactional
    public Metodo_pagoDTO create(Long idReservacion, NewMetodo_pagoDTO metodo_pagoDTO) {
        Reservacion reservacion = reservacionRepository.findById(idReservacion)
            .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        Metodo_pago metodo = modelMapper.map(metodo_pagoDTO, Metodo_pago.class);    
        metodo.setReservacion(reservacion);
        repository.save(metodo);
        return modelMapper.map(metodo, Metodo_pagoDTO.class); 
    }

    @Override
    @Transactional(readOnly=true)
    public Metodo_PagoReservacionDTO retrieve(Long idReservacion, Long id) {
        Reservacion reservacion = reservacionRepository.findById(idReservacion)
            .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        Metodo_pago metodo = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Servicio not found"));
        metodo.setReservacion(reservacion);
        return modelMapper.map(metodo, Metodo_PagoReservacionDTO.class);
    }

    @Override
    @Transactional
    public Metodo_PagoReservacionDTO update(Metodo_pagoDTO metodoDTO, Long idReservacion, Long id) {
        Reservacion reservacion = reservacionRepository.findById(idReservacion)
        .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        Metodo_pago metodo = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Servicio not found"));
        metodo = modelMapper.map(metodoDTO, Metodo_pago.class);
        metodo.setReservacion(reservacion);
        repository.save(metodo);       
        return modelMapper.map(metodo, Metodo_PagoReservacionDTO.class);
    }


    @Override
    @Transactional
    public void delete(Long idReservacion, Long id) {
        Reservacion reservacion = reservacionRepository.findById(idReservacion)
        .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        Metodo_pago metodo = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Servicio not found"));
        metodo.setReservacion(reservacion);
        repository.deleteById(reservacion.getId());  
    }

    @Override
    @Transactional(readOnly=true)
    public List<Metodo_pagoDTO> list(Long idReservacion) {
        Reservacion reservacion = reservacionRepository.findById(idReservacion)
            .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        List<Metodo_pago> metodos = repository.findByReservacion(reservacion);
        if(metodos.isEmpty()) throw new NoContentException("Servicios is empty");
        //Lambda ->
        return metodos.stream().map(q -> modelMapper.map(q, Metodo_pagoDTO.class) )
            .collect(Collectors.toList());
    }
    
}
