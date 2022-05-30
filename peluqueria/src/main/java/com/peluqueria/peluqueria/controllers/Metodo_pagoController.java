package com.peluqueria.peluqueria.controllers;

import java.util.List;

import com.peluqueria.peluqueria.dto.Metodo_pagoDTO;
import com.peluqueria.peluqueria.dto.NewMetodo_pagoDTO;
import com.peluqueria.peluqueria.services.Metodo_pagoService;

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
    public Metodo_pagoController(Metodo_pagoService mtp){
        this.metodo_pago = mtp;
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody NewMetodo_pagoDTO metodo_pagoDTO){
        try{
            Metodo_pagoDTO result = metodo_pago.create(metodo_pagoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }catch(Exception e){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retrieve(@PathVariable("id") Long id){
        try {
            Metodo_pagoDTO result = metodo_pago.retrieve(id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping()
    public ResponseEntity<?> list(){
        try {
            List<Metodo_pagoDTO> result = metodo_pago.list();
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Metodo_pagoDTO metodo_pagoDTO, @PathVariable("id") Long id){
        try {
            Metodo_pagoDTO result = metodo_pago.update(metodo_pagoDTO,id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        try {
            metodo_pago.delete(id);
            return ResponseEntity.ok().body("metodo_pago Delete");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
}
