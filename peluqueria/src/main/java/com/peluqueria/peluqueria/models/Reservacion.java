package com.peluqueria.peluqueria.models;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_RESERVACION")
@Getter
@Setter
public class Reservacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "HORA")
    private String hora;
    @Column(name = "LUGAR")
    private String lugar;
    @Column(name = "FECHA")
    private String fecha;
    @Column(name = "DISPONIBILIDAD")
    private Boolean disponibilidad;


    @ManyToOne
    @JoinColumn(name="CLIENTE_ID", nullable=false)
    private Cliente cliente; 
    

    @ManyToOne
    @JoinColumn(name="METODO_PAGO_ID", nullable=false)
    private Metodo_pago metodopago; 

    
    @OneToMany(mappedBy = "servicio")
    private List<Servicio> servicio;  



}
