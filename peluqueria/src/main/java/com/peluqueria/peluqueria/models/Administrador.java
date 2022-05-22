package com.peluqueria.peluqueria.models;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_METODO_PAGO")
@Getter
@Setter
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "ROL")
    private String rol;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;  

}
