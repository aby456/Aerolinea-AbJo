package com.peluqueria.peluqueria.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReservacionDTO {
    private long id;
    private String hora;
    private String lugar;
    private String fecha;
    private Boolean disponibilidad;
    private double costo_pasaje;
}
