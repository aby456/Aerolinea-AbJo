package com.peluqueria.peluqueria.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoriaDTO {
    private Long id;
    private String estado;
    private String compartimiento;
}
