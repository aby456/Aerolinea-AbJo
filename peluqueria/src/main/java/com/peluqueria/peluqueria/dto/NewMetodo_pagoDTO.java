package com.peluqueria.peluqueria.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewMetodo_pagoDTO {
    @NotNull(message = "Metodo width can't be null.")
    private String metodo;
}
