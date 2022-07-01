package com.peluqueria.peluqueria.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import javax.validation.Valid;
import com.peluqueria.peluqueria.dto.CategoriaDTO;
import com.peluqueria.peluqueria.dto.NewCategoriaDTO;
import com.peluqueria.peluqueria.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    private final CategoriaService categ;

    @Autowired
    public CategoriaController(CategoriaService cat){
        this.categ = cat;
    }

    @PostMapping()
    public ResponseEntity<CategoriaDTO> create(@Valid @RequestBody NewCategoriaDTO categoriaDTO){
        
        CategoriaDTO result = categ.create(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> retrieve(@PathVariable("id") Long id){
        
        CategoriaDTO result = categ.retrieve(id);
        return ResponseEntity.ok().body(result);
        
    }

    @GetMapping()
    public ResponseEntity<List<CategoriaDTO>> list(){
        
        List<CategoriaDTO> result = categ.list();
        return ResponseEntity.ok().body(result);
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> update(@RequestBody CategoriaDTO categoriaDTO, @PathVariable("id") Long id){
        
        CategoriaDTO result = categ.update(categoriaDTO,id);
        return ResponseEntity.ok().body(result);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        
        categ.delete(id);
        return ResponseEntity.ok().body("category Delete");
        
    }






}
