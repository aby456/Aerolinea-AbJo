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
    private String nombre_servicio;
    @NotNull(message = "Precio Servicio width can't be null.")
    private double precio_servicio;
    @NotNull(message = "Tiempo Estimado Servicio width can't be null.")
    private double tiempo_estimado_servicio;
}
