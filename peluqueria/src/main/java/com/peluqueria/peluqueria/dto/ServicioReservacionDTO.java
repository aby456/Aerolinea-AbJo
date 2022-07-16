package com.peluqueria.peluqueria.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ServicioReservacionDTO extends ServicioDTO{
    private ReservacionDTO reservacion;
}
