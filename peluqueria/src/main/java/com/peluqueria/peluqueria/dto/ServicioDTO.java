package com.peluqueria.peluqueria.dto;


import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ServicioDTO extends NewServicioDTO {
    private Long id;
    private List<CategoriaDTO> categoria;
}
