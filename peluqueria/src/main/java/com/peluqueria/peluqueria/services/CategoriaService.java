package com.peluqueria.peluqueria.services;

import java.util.List;

import com.peluqueria.peluqueria.dto.CategoriaDTO;
import com.peluqueria.peluqueria.dto.NewCategoriaDTO;

public interface CategoriaService {

    public CategoriaDTO create(NewCategoriaDTO categoriaDTO);
    public CategoriaDTO retrieve(Long id) ;
    public CategoriaDTO update(CategoriaDTO categoriaDTO, Long id) ;
    public void delete(Long id) ;
    
    public List<CategoriaDTO> list();
}
