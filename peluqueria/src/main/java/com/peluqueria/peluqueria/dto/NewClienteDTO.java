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
    @Min(message = "Password limit can't be lower 6 minutes", value = 6)
    @Max(message = "Password limit can't be more 18 minutes",value = 18)
    private String password;
}
