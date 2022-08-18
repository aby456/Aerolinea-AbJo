package com.peluqueria.peluqueria.models;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_RESERVACIONES")
@Getter
@Setter
public class Reservacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "HORAS")
    private String hora;
    @Column(name = "LUGARES")
    private String lugar;
    @Column(name = "FECHAS")
    private String fecha;
    @Column(name = "DISPONIBILIDADES")
    private int disponibilidad;


    

    // @ManyToOne
    // @JoinColumn(name="METODO_PAGO_ID", nullable=false)
    // private Metodo_pago metodopago; 

    @Column(name = "CREATED_DATE")    
    private Calendar createdDate;
    @Column(name = "CREATED_BY")    
    private String createdBy;  

    @Column(name = "UPDATED_DATE")    
    private Calendar updatedDate;
    @Column(name = "UPDATED_BY")    
    private String updatedBy;  

    @PrePersist
    public void prePersist(){
        createdDate = Calendar.getInstance();
        createdBy = "user1";
    }

    @PreUpdate
    public void preUpdate(){
        updatedDate = Calendar.getInstance();
        updatedBy = "user2";
    }

    
    @OneToMany(mappedBy = "reservacion")
    private List<Servicio> servicio;  

    @OneToMany(mappedBy = "reservacion")
    private List<Cliente> cliente;

    //@OneToMany(mappeBy="reservacion", cascade=CascadeType);

    


}
