package com.peluqueria.peluqueria.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Metodo_PagoReservacionDTO extends Metodo_PagoDTO{
    private ReservacionDTO reservacion;
}
