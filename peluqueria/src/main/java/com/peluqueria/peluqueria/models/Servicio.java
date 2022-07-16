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
@Table(name="TBL_SERVICIO")
@Getter
@Setter
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NOMBRE_SERVICIO")
    private String nombreServicio;
    @Column(name = "PRECIO_SERVICIO")
    private double precioServicio;
    @Column(name = "TIEMPO_ESTIMADO_SERVICIO")
    private double tiempoEstimadoServicio;



    @ManyToOne
    @JoinColumn(name="RESERVACION_ID", nullable=false)
    private Reservacion reservacion;

    
    @OneToMany(mappedBy = "servicio")
    private List<Categoria> categoria;

}
