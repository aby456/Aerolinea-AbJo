package com.peluqueria.peluqueria.controllers;

import java.util.List;

import javax.validation.Valid;

import com.peluqueria.peluqueria.dto.NewServicioDTO;
import com.peluqueria.peluqueria.dto.ServicioDTO;
import com.peluqueria.peluqueria.services.ServicioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicio")
public class ServicioController {
    
    private final ServicioService service;

    @Autowired
    public ServicioController(ServicioService srv){
        this.service = srv;
    }

    @PostMapping()
    public ResponseEntity<ServicioDTO> create(@Valid @RequestBody NewServicioDTO servicioDTO){
        
        ServicioDTO result = service.create(servicioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicioDTO> retrieve(@PathVariable("id") Long id){
        
        ServicioDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);
        
    }

    @GetMapping()
    public ResponseEntity<List<ServicioDTO>> list(){
        
        List<ServicioDTO> result = service.list();
        return ResponseEntity.ok().body(result);
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicioDTO> update(@RequestBody ServicioDTO servicioDTO, @PathVariable("id") Long id){
        
        ServicioDTO result = service.update(servicioDTO,id);
        return ResponseEntity.ok().body(result);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        
        service.delete(id);
        return ResponseEntity.ok().body("servicio Delete");
        
    }
}
