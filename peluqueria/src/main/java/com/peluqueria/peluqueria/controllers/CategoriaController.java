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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    final CategoriaService service;

    public CategoriaController(CategoriaService srv){
        this.service = srv;
    }

    /* ================ CREATE ================ */
    @PostMapping("/{id}/Servicio/{idServicio}/Categorias")
    public ResponseEntity<List<CategoriaDTO>> create(@PathVariable("id") Long id, @PathVariable("idServicio") Long idServicio, @Valid @RequestBody List<NewCategoriaDTO> categoriaDTO){
        List<CategoriaDTO> categoriaDTOs = service.create(id, idServicio, categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaDTOs);        
    }

    /* ================ DELETE ================ */
    @DeleteMapping("/{id}/Servicio/{idServicio}/Categorias")
    public ResponseEntity<List<CategoriaDTO>> delete(@PathVariable("id") Long id, @PathVariable("idServicio") Long idServicio){
        service.remove(id, idServicio);
        return ResponseEntity.noContent().build();
    }

    /* ================ LIST ================ */
    @GetMapping("/{id}/Servicio/{idServicio}/Categorias")
    public ResponseEntity<List<CategoriaDTO>> list(@PathVariable("id") Long id, @PathVariable("idServicio") Long idServicio){
        List<CategoriaDTO> categoriaDTO = service.list(id, idServicio);
        return ResponseEntity.status(HttpStatus.OK).body(categoriaDTO);        
    }



}
