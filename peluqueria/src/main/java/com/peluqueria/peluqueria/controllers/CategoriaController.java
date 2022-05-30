package com.peluqueria.peluqueria.controllers;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.peluqueria.peluqueria.dto.CategoriaDTO;
import com.peluqueria.peluqueria.dto.NewCategoriaDTO;
import com.peluqueria.peluqueria.services.CategoriaService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    private final CategoriaService categ;
    public CategoriaController(CategoriaService cat){
        this.categ = cat;
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody NewCategoriaDTO examDTO){
        try{
            CategoriaDTO result = categ.create(examDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }catch(Exception e){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retrieve(@PathVariable("id") Long id){
        try {
            CategoriaDTO result = categ.retrieve(id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping()
    public ResponseEntity<?> list(){
        try {
            List<CategoriaDTO> result = categ.list();
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CategoriaDTO categoriaDTO, @PathVariable("id") Long id){
        try {
            CategoriaDTO result = categ.update(categoriaDTO,id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        try {
            categ.delete(id);
            return ResponseEntity.ok().body("category Delete");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }






}
