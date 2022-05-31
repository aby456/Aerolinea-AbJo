package com.peluqueria.peluqueria.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewCategoriaDTO {
    @NotNull(message = "Estado width can't be null.")
    private String estado;
    @NotNull(message = "Compartimiento width can't be null.")
    private String compartimiento;
}
