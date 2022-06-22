package com.peluqueria.peluqueria.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewCategoriaDTO {
    @NotNull(message = "Name category width can't be null.")
    private String nombre_categoria;
}
