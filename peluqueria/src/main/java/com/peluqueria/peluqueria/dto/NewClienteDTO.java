package com.peluqueria.peluqueria.dto;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class NewClienteDTO {
    @NotNull(message = "Nombre width can't be null.")
    private String nombre;
    private String telefono;
    @NotNull(message = "Direccion width can't be null.") 
    private String direccion;
    @NotNull(message = "Email width can't be null.")   
    private String email;
    @NotNull(message = "password width can't be null.")   
    private String password;
}
