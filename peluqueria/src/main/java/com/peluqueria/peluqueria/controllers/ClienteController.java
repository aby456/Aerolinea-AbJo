package com.peluqueria.peluqueria.controllers;

import com.peluqueria.peluqueria.dto.ClienteDTO;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService client;

    @Autowired
    public ClienteController(ClienteService clt){
        this.client = clt;
    }

    @PostMapping()
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody NewClienteDTO examDTO){
        
        ClienteDTO result = client.create(examDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> retrieve(@PathVariable("id") Long id){
        
        ClienteDTO result = client.retrieve(id);
        return ResponseEntity.ok().body(result);
        
    }

    @GetMapping()
    public ResponseEntity<List<ClienteDTO>> list(){
        
        List<ClienteDTO> result = client.list();
        return ResponseEntity.ok().body(result);
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO clienteDTO, @PathVariable("id") Long id){
        
        ClienteDTO result = client.update(clienteDTO,id);
        return ResponseEntity.ok().body(result);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        
        client.delete(id);
        return ResponseEntity.ok().body("Client Delete");
        
    }






}
