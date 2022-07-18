package com.peluqueria.peluqueria.controllers;

import com.peluqueria.peluqueria.dto.ClienteDTO;
import com.peluqueria.peluqueria.dto.ClienteReservacionDTO;
import com.peluqueria.peluqueria.dto.NewClienteDTO;
import com.peluqueria.peluqueria.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/reservacion")
public class ClienteController {
    private final ClienteService srvo;

    @Autowired
    public ClienteController(ClienteService srv){
        this.srvo = srv;
    }

    /* ================ CREATE ================ */
    @PostMapping("/{id}/cliente")
    public ResponseEntity<ClienteDTO> create(@PathVariable("id") Long id, @Valid @RequestBody NewClienteDTO clienteDTO){
        ClienteDTO servicioDTOs = srvo.create(id, clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioDTOs);        
    }

       /* ================ RETRIEVE ================ */
       @GetMapping("/{idReservacion}/cliente/{id}")
       public ResponseEntity<ClienteReservacionDTO> retrive(@PathVariable("idReservacion") Long idReservacion, @PathVariable("id") Long id){
           ClienteReservacionDTO result = srvo.retrieve(idReservacion, id);
           return ResponseEntity.ok().body(result);        
       }
   

  /* ================ UPDATE ================ */
    @PutMapping("/{idReservacion}/cliente/{id}")
    public ResponseEntity<ClienteReservacionDTO> update(@RequestBody ClienteDTO servicioDTO, @PathVariable("idReservacion") Long idReservacion, @PathVariable("id") Long id){
        ClienteReservacionDTO result = srvo.update(servicioDTO, idReservacion, id);
        return ResponseEntity.ok().body(result);
    }
    
          /* ================ DELETE ================ */
    @DeleteMapping("/{idReservacion}/cliente/{id}")
    public ResponseEntity<Void> delete(@PathVariable("idReservacion") Long idReservacion, @PathVariable("id") Long id){
        srvo.delete(idReservacion, id);
        return ResponseEntity.noContent().build();
    }



       /* ================ LIST ================ */
    @GetMapping("/{id}/cliente")
    public ResponseEntity<List<ClienteDTO>> list(@PathVariable("id") Long id){
        List<ClienteDTO> servicios = srvo.list(id);
        return ResponseEntity.ok().body(servicios);        
    }
}
