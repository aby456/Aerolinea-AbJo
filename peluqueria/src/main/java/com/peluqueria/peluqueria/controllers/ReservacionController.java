package com.peluqueria.peluqueria.controllers;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.validation.Valid;

import com.peluqueria.peluqueria.dto.NewReservacionDTO;
import com.peluqueria.peluqueria.dto.ReservacionDTO;
import com.peluqueria.peluqueria.services.ReservacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/reservacion")
public class ReservacionController {
    private final ReservacionService reserv;

    @Autowired
    public ReservacionController(ReservacionService rsvr){
        this.reserv = rsvr;
    }

    @PostMapping()
    public ResponseEntity<ReservacionDTO> create(@Valid @RequestBody NewReservacionDTO examDTO){
        
        ReservacionDTO result = reserv.create(examDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservacionDTO> retrieve(@PathVariable("id") Long id){
        
        ReservacionDTO result = reserv.retrieve(id);
        return ResponseEntity.ok().body(result);
        
    }

    @GetMapping()
    public ResponseEntity<List<ReservacionDTO>> list(){
        
        List<ReservacionDTO> result = reserv.list();
        return ResponseEntity.ok().body(result);
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservacionDTO> update(@RequestBody ReservacionDTO reservacionDTO, @PathVariable("id") Long id){
        
        ReservacionDTO result = reserv.update(reservacionDTO,id);
        return ResponseEntity.ok().body(result);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        
        reserv.delete(id);
        return ResponseEntity.ok().body("reservory Delete");
        
    }






}
