package com.peluqueria.peluqueria.controllers;

import java.util.List;

import com.peluqueria.peluqueria.dto.NewServicioDTO;
import com.peluqueria.peluqueria.dto.ServicioDTO;
import com.peluqueria.peluqueria.services.ServicioService;

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
    public ServicioController(ServicioService srv){
        this.service = srv;
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody NewServicioDTO servicioDTO){
        try{
            ServicioDTO result = service.create(servicioDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }catch(Exception e){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retrieve(@PathVariable("id") Long id){
        try {
            ServicioDTO result = service.retrieve(id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping()
    public ResponseEntity<?> list(){
        try {
            List<ServicioDTO> result = service.list();
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ServicioDTO servicioDTO, @PathVariable("id") Long id){
        try {
            ServicioDTO result = service.update(servicioDTO,id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        try {
            service.delete(id);
            return ResponseEntity.ok().body("servicio Delete");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
}
