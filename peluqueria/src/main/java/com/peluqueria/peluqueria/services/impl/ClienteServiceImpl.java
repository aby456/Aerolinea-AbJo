package com.peluqueria.peluqueria.services.impl;
import java.util.List;
import java.util.stream.Collectors;
import com.peluqueria.peluqueria.dto.ClienteDTO;
import com.peluqueria.peluqueria.dto.ClienteReservacionDTO;
import com.peluqueria.peluqueria.dto.NewClienteDTO;
import com.peluqueria.peluqueria.exception.NoContentException;
import com.peluqueria.peluqueria.exception.ResourceNotFoundException;
import com.peluqueria.peluqueria.models.Cliente;
import com.peluqueria.peluqueria.models.Reservacion;
import com.peluqueria.peluqueria.repositories.ClienteRepository;
import com.peluqueria.peluqueria.repositories.ReservacionRepository;
import com.peluqueria.peluqueria.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    final ModelMapper modelMapper;
    final ClienteRepository repository;
    final ReservacionRepository reservacionRepository;

    public ClienteServiceImpl(ClienteRepository r, ReservacionRepository er, ModelMapper m)
    {
        this.modelMapper = m;
        this.repository = r;
        this.reservacionRepository = er;
    }


    @Override
    @Transactional
    public ClienteDTO create(Long idReservacion, NewClienteDTO clienteDTO) {
        Reservacion reservacion = reservacionRepository.findById(idReservacion)
            .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);    
        cliente.setReservacion(reservacion);
        repository.save(cliente);
        return modelMapper.map(cliente, ClienteDTO.class); 
    }

    @Override
    @Transactional(readOnly=true)
    public ClienteReservacionDTO retrieve(Long idReservacion, Long id) {
        Reservacion reservacion = reservacionRepository.findById(idReservacion)
            .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        Cliente cliente = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Servicio not found"));
        cliente.setReservacion(reservacion);
        return modelMapper.map(cliente, ClienteReservacionDTO.class);
    }

    @Override
    @Transactional
    public ClienteReservacionDTO update(ClienteDTO clienteDTO, Long idReservacion, Long id) {
        Reservacion reservacion = reservacionRepository.findById(idReservacion)
        .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        Cliente cliente = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Servicio not found"));
        cliente = modelMapper.map(clienteDTO, Cliente.class);
        cliente.setReservacion(reservacion);
        repository.save(cliente);       
        return modelMapper.map(cliente, ClienteReservacionDTO.class);
    }


    @Override
    @Transactional
    public void delete(Long idReservacion, Long id) {
        Reservacion reservacion = reservacionRepository.findById(idReservacion)
        .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        Cliente cliente = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Servicio not found"));
        cliente.setReservacion(reservacion);
        repository.deleteById(reservacion.getId());  
    }

    @Override
    @Transactional(readOnly=true)
    public List<ClienteDTO> list(Long idReservacion) {
        Reservacion reservacion = reservacionRepository.findById(idReservacion)
            .orElseThrow(()-> new ResourceNotFoundException("Reservacion not found"));
        List<Cliente> clientes = repository.findByReservacion(reservacion);
        if(clientes.isEmpty()) throw new NoContentException("Servicios is empty");
        //Lambda ->
        return clientes.stream().map(q -> modelMapper.map(q, ClienteDTO.class) )
            .collect(Collectors.toList());
    }


    @Override
    public long count() {        
        return reservacionRepository.count();
    }





}
