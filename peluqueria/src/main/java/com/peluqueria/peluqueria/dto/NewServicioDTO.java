package com.peluqueria.peluqueria.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewServicioDTO {
    @NotNull(message = "Nombre Servicio width can't be null.")
    private String nombreServicio;
    private double precioServicio;
    private double tiempoEstimadoServicio;
}
