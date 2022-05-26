package com.peluqueria.peluqueria.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewCategoriaDTO {
    private Long id_asiento;
    private String estado_asiento;
    private String compartimiento;
}
