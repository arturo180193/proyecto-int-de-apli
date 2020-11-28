package com.example.demo.persistense.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tbl_report")
@Entity
public class Reporte {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_reporte")
    private Integer idReporte;

    @Column
    private String descripcion;

    @Column(length = 20)
    private String localizacion;

    @Column
    private Boolean estado;

    @CreationTimestamp
    @Column
    private LocalDate fecha;

    @Column(name = "id_cliente")
    private int idCliente;

    @Column(name = "id_tecnico")
    private int idTecnico;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tecnico", insertable = false, updatable = false)
    private Tecnico tecnico;

}
