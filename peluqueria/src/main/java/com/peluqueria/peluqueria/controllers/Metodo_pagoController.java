package com.peluqueria.peluqueria.controllers;

import java.util.List;

import javax.validation.Valid;

import com.peluqueria.peluqueria.dto.Metodo_pagoDTO;
import com.peluqueria.peluqueria.dto.NewMetodo_pagoDTO;
import com.peluqueria.peluqueria.services.Metodo_pagoService;

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
@RequestMapping("/metodo_pago")
public class Metodo_pagoController {
    
    private final Metodo_pagoService metodo_pago;

    @Autowired
    public Metodo_pagoController(Metodo_pagoService mtp){
        this.metodo_pago = mtp;
    }

    @PostMapping()
    public ResponseEntity<Metodo_pagoDTO> create(@Valid @RequestBody NewMetodo_pagoDTO metodo_pagoDTO){
        
        Metodo_pagoDTO result = metodo_pago.create(metodo_pagoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Metodo_pagoDTO> retrieve(@PathVariable("id") Long id){
        
        Metodo_pagoDTO result = metodo_pago.retrieve(id);
        return ResponseEntity.ok().body(result);
        
    }

    @GetMapping()
    public ResponseEntity<List<Metodo_pagoDTO>> list(){
        
        List<Metodo_pagoDTO> result = metodo_pago.list();
        return ResponseEntity.ok().body(result);
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Metodo_pagoDTO> update(@RequestBody Metodo_pagoDTO metodo_pagoDTO, @PathVariable("id") Long id){
        
        Metodo_pagoDTO result = metodo_pago.update(metodo_pagoDTO,id);
        return ResponseEntity.ok().body(result);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        
        metodo_pago.delete(id);
        return ResponseEntity.ok().body("metodo_pago Delete");
        
    }
}
