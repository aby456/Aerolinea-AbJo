package com.peluqueria.peluqueria.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewReservacionDTO {
    @NotNull(message = "Hora width can't be null.")
    private String hora;
    @NotNull(message = "Lugar width can't be null.")
    private String lugar;
    @NotNull(message = "Fecha width can't be null.")
    private String fecha;
    private int disponibilidad;
}
