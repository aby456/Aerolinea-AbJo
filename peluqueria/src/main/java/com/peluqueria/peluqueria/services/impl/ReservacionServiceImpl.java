package com.peluqueria.peluqueria.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.peluqueria.peluqueria.dto.NewReservacionDTO;
import com.peluqueria.peluqueria.dto.ReservacionDTO;
import com.peluqueria.peluqueria.dto.ReservacionListDTO;
import com.peluqueria.peluqueria.exception.NoContentException;
import com.peluqueria.peluqueria.exception.ResourceNotFoundException;
import com.peluqueria.peluqueria.models.Reservacion;
import com.peluqueria.peluqueria.repositories.ReservacionRepository;
import com.peluqueria.peluqueria.services.ReservacionService;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservacionServiceImpl implements ReservacionService {

    final ModelMapper modelMapper;
    final ReservacionRepository reservacionRepository;

    public ReservacionServiceImpl(ReservacionRepository repository, ModelMapper mapper){
        this.reservacionRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public ReservacionDTO create(NewReservacionDTO reservacionDTO) {
        Reservacion reservacion = modelMapper.map(reservacionDTO, Reservacion.class);
        reservacionRepository.save(reservacion);        
        return modelMapper.map(reservacion, ReservacionDTO.class); 
    }

    @Override
    @Transactional(readOnly = true)
    public ReservacionDTO retrieve(Long id) {
        Reservacion reservacion = reservacionRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        return modelMapper.map(reservacion, ReservacionDTO.class);
    }

    @Override
    @Transactional
    public ReservacionDTO update(ReservacionDTO reservacionDTO, Long id) {
        Reservacion Reservacion = reservacionRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));        
              
        Reservacion reservacionUpdated = modelMapper.map(reservacionDTO, Reservacion.class);
        //Keeping values
        reservacionUpdated.setCreatedBy(Reservacion.getCreatedBy());
        reservacionUpdated.setCreatedDate(Reservacion.getCreatedDate());
        reservacionRepository.save(reservacionUpdated);   
        return modelMapper.map(reservacionUpdated, ReservacionDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Reservacion reservacion = reservacionRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));        
        reservacionRepository.deleteById(reservacion.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservacionListDTO> list(int page, int size, String sort) {
        Pageable pageable = sort == null || sort.isEmpty() ? 
                    PageRequest.of(page, size) 
                :   PageRequest.of(page, size,  Sort.by(sort));

        Page<Reservacion> reservacions = reservacionRepository.findAll(pageable);
        if(reservacions.isEmpty()) throw new NoContentException("Reservacions is empty");
        return reservacions.stream().map(reservacion -> modelMapper.map(reservacion, ReservacionListDTO.class))
            .collect(Collectors.toList());        
    }

    @Override
    public long count() {        
        return reservacionRepository.count();
    }

    
    
}
