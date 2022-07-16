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
@Table(name="TBL_CATEGORIA")
@Getter
@Setter
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NOMBRE_CATEGORIA") 
    private String nombreCategoria;
    @Column(name = "CORRECT")
    private boolean correct;

    @ManyToOne
    @JoinColumn(name="SERVICIO_ID", nullable=false)
    private Servicio servicio;

}
