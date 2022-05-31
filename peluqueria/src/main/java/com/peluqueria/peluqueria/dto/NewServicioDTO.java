package com.peluqueria.peluqueria.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewServicioDTO {
    @NotNull(message = "Linea width can't be null.")
    private String linea;
    private int numero_asientos;
    private int compartimientos;
}
