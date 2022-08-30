package com.peluqueria.peluqueria.controllers;

import java.util.List;

import javax.validation.Valid;

import com.peluqueria.peluqueria.dto.NewServicioDTO;
import com.peluqueria.peluqueria.dto.ServicioDTO;
import com.peluqueria.peluqueria.dto.ServicioReservacionDTO;
import com.peluqueria.peluqueria.services.ServicioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/reservacion")
public class ServicioController {
    
    
    final ServicioService srvo;

    public ServicioController(ServicioService srv){
        this.srvo = srv;
    }

    /* ================ CREATE ================ */
    @Secured({"ROLE_ADMINISTRADOR", "ROLE_USUARIO"})
    @PostMapping("/{id}/servicio")
    public ResponseEntity<ServicioDTO> create(@PathVariable("id") Long id, @Valid @RequestBody NewServicioDTO servicioDTO){
        ServicioDTO servicioDTOs = srvo.create(id, servicioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioDTOs);        
    }

    /* ================ RETRIEVE ================ */
    @Secured({"ROLE_ADMINISTRADOR"})
    @GetMapping("/{idReservacion}/servicio/{id}")
    public ResponseEntity<ServicioReservacionDTO> retrive(@PathVariable("idReservacion") Long idReservacion, @PathVariable("id") Long id){
        ServicioReservacionDTO result = srvo.retrieve(idReservacion, id);
        return ResponseEntity.ok().body(result);        
    }

    /* ================ UPDATE ================ */
    @Secured({"ROLE_ADMINISTRADOR", "ROLE_USUARIO"})
    @PutMapping("/{idReservacion}/servicio/{id}")
    public ResponseEntity<ServicioReservacionDTO> update(@RequestBody ServicioDTO servicioDTO, @PathVariable("idReservacion") Long idReservacion, @PathVariable("id") Long id){
        ServicioReservacionDTO result = srvo.update(servicioDTO, idReservacion, id);
        return ResponseEntity.ok().body(result);
    }

    /* ================ DELETE ================ */
    @Secured({"ROLE_ADMINISTRADOR", "ROLE_USUARIO"})
    @DeleteMapping("/{idReservacion}/servicio/{id}")
    public ResponseEntity<Void> delete(@PathVariable("idReservacion") Long idReservacion, @PathVariable("id") Long id){
        srvo.delete(idReservacion, id);
        return ResponseEntity.noContent().build();
    }

    /* ================ LIST ================ */
    @Secured({"ROLE_ADMINISTRADOR", "ROLE_USUARIO"})
    @GetMapping("/{id}/servicio")
    public ResponseEntity<List<ServicioDTO>> list(@PathVariable("id") Long id){
        List<ServicioDTO> servicios = srvo.list(id);
        return ResponseEntity.ok().body(servicios);        
    }
}
