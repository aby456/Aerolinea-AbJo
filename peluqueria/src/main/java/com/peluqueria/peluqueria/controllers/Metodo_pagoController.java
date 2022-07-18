package com.peluqueria.peluqueria.controllers;

import java.util.List;

import javax.validation.Valid;

import com.peluqueria.peluqueria.dto.Metodo_PagoReservacionDTO;
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
@RequestMapping("/reservacion")
public class Metodo_pagoController {
    
    private final Metodo_pagoService srvo;

    @Autowired
    public Metodo_pagoController(Metodo_pagoService srv){
        this.srvo = srv;
    }

    /* ================ CREATE ================ */
    @PostMapping("/{id}/metodo")
    public ResponseEntity<Metodo_pagoDTO> create(@PathVariable("id") Long id, @Valid @RequestBody NewMetodo_pagoDTO clienteDTO){
        Metodo_pagoDTO servicioDTOs = srvo.create(id, clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioDTOs);        
    }

       /* ================ RETRIEVE ================ */
       @GetMapping("/{idReservacion}/metodo/{id}")
       public ResponseEntity<Metodo_PagoReservacionDTO> retrive(@PathVariable("idReservacion") Long idReservacion, @PathVariable("id") Long id){
        Metodo_PagoReservacionDTO result = srvo.retrieve(idReservacion, id);
           return ResponseEntity.ok().body(result);        
       }
   

  /* ================ UPDATE ================ */
    @PutMapping("/{idReservacion}/metodo/{id}")
    public ResponseEntity<Metodo_PagoReservacionDTO> update(@RequestBody Metodo_pagoDTO servicioDTO, @PathVariable("idReservacion") Long idReservacion, @PathVariable("id") Long id){
        Metodo_PagoReservacionDTO result = srvo.update(servicioDTO, idReservacion, id);
        return ResponseEntity.ok().body(result);
    }
    
          /* ================ DELETE ================ */
    @DeleteMapping("/{idReservacion}/metodo/{id}")
    public ResponseEntity<Void> delete(@PathVariable("idReservacion") Long idReservacion, @PathVariable("id") Long id){
        srvo.delete(idReservacion, id);
        return ResponseEntity.noContent().build();
    }



       /* ================ LIST ================ */
    @GetMapping("/{id}/metodo")
    public ResponseEntity<List<Metodo_pagoDTO>> list(@PathVariable("id") Long id){
        List<Metodo_pagoDTO> servicios = srvo.list(id);
        return ResponseEntity.ok().body(servicios);        
    }
}
