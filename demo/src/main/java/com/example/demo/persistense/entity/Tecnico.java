package com.example.demo.persistense.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tbl_technical")
@Entity
public class Tecnico {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tecnico")
    private Integer idTecnico;
    @Column(length = 50)
    private String nombre;
    @Column
    private String tipo;
    @Column(length = 9)
    private String telefono;
    @Column(length = 50)
    private String correo;
    @Column(length = 50)
    private String direccion;


    @OneToMany(mappedBy = "tecnico", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reporte> reportes;
}
