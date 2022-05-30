package com.peluqueria.peluqueria.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.peluqueria.peluqueria.dto.CategoriaDTO;
import com.peluqueria.peluqueria.dto.NewCategoriaDTO;
import com.peluqueria.peluqueria.models.Categoria;
import com.peluqueria.peluqueria.repositories.CategoriaRepository;
import com.peluqueria.peluqueria.services.CategoriaService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    final ModelMapper modelMapper;
    final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(@Autowired CategoriaRepository repository, ModelMapper mapper){
        this.categoriaRepository = repository;
        this.modelMapper = mapper;
    }
    
    @Override
    @Transactional
    public CategoriaDTO create(NewCategoriaDTO categoriaDTO) {
        Categoria categoria = modelMapper.map(categoriaDTO, Categoria.class);
        categoriaRepository.save(categoria);
        CategoriaDTO categoriaDTOCreated = modelMapper.map(categoria, CategoriaDTO.class);
        return categoriaDTOCreated;
    }

    @Override
    @Transactional(readOnly = true)
    public CategoriaDTO retrieve(Long id) throws Exception {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(()-> new Exception("Categoria not found"));
        return modelMapper.map(categoria, CategoriaDTO.class);
    }

    @Override
    @Transactional
    public CategoriaDTO update(CategoriaDTO categoriaDTO, Long id) throws Exception {
        Categoria categoria = categoriaRepository.findById(categoriaDTO.getId()).orElseThrow(()-> new Exception("Categoria not found"));
        categoria.setId(id);
        categoria = modelMapper.map(categoriaDTO, Categoria.class);
        categoriaRepository.save(categoria);
        return modelMapper.map(categoria, CategoriaDTO.class);
    }

    @Override
    @Transactional
    public void  delete(Long id) throws Exception {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(()-> new Exception("Categoria not found"));
        categoriaRepository.deleteById(categoria.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoriaDTO> list() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream().map(categoria-> modelMapper.map(categoria, CategoriaDTO.class)).collect(Collectors.toList());
    }
    
}
