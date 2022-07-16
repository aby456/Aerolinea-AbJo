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
    final ReservacionRepository ReservacionRepository;


    public ReservacionServiceImpl(ReservacionRepository repository, ModelMapper mapper){
        this.ReservacionRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public ReservacionDTO create(NewReservacionDTO ReservacionDTO) {
        Reservacion Reservacion = modelMapper.map(ReservacionDTO, Reservacion.class);
        ReservacionRepository.save(Reservacion);
        return modelMapper.map(Reservacion, ReservacionDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public ReservacionDTO retrieve(Long id)  {
        Reservacion Reservacion = ReservacionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Categoria not found"));
        return modelMapper.map(Reservacion, ReservacionDTO.class);
    }


    @Override
    @Transactional
    public ReservacionDTO update(ReservacionDTO ReservacionDTO, Long id) {
        Reservacion Reservacion = ReservacionRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Exam not found"));        
              
        Reservacion ReservacionUpdated = modelMapper.map(ReservacionDTO, Reservacion.class);
        //Keeping values
        ReservacionUpdated.setCreatedBy(Reservacion.getCreatedBy());
        ReservacionUpdated.setCreatedDate(Reservacion.getCreatedDate());
        ReservacionRepository.save(ReservacionUpdated);   
        return modelMapper.map(ReservacionUpdated, ReservacionDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id)  {
        Reservacion Reservacion = ReservacionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Categoria not found"));
        ReservacionRepository.deleteById(Reservacion.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservacionListDTO> list(int page, int size, String sort) {
        Pageable pageable = sort == null || sort.isEmpty() ? 
                    PageRequest.of(page, size) 
                :   PageRequest.of(page, size,  Sort.by(sort));

        Page<Reservacion> exams = ReservacionRepository.findAll(pageable);
        if(exams.isEmpty()) throw new NoContentException("Exams is empty");
        return exams.stream().map(exam -> modelMapper.map(exam, ReservacionListDTO.class))
            .collect(Collectors.toList()); 
    }

    @Override
    public long count() {
        return ReservacionRepository.count();
    }

    
    
}
