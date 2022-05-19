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
@Table(name="TBL_SERVICIO")
@Getter
@Setter
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "LINEA")
    private String linea;
    @Column(name = "NUMERO_ASIENTOS")
    private int numero_asientos;
    @Column(name = "COMPARTIMIENTOS")
    private int compartimientos;

}
