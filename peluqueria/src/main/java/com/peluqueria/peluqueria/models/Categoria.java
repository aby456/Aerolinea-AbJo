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
@Table(name="TBL_CATEGORIA")
@Getter
@Setter
public class Categoria {
    private Long id_asiento;
    private String estado_asiento;
    private String compartimiento;
}
