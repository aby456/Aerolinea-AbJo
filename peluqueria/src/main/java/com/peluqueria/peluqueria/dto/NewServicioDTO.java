package com.peluqueria.peluqueria.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewServicioDTO {
    private String linea;
    private int numero_asientos;
    private int compartimientos;
}
