package com.peluqueria.peluqueria.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String telefono; 
    private String direccion;   
    private String email;
    private String password;
}
