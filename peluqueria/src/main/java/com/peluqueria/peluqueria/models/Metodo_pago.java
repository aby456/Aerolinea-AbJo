package com.peluqueria.peluqueria.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_METODO_PAGO")
@Getter
@Setter
public class Metodo_pago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "METODO")
    private String metodo;

    @ManyToOne
    @JoinColumn(name="RESERVACION_ID", nullable=false)
    private Reservacion reservacion;

}
