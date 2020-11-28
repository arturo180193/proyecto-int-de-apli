package com.example.demo.persistense.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tbl_client")
@Entity
public class Cliente {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Column(length = 50)
    private String nombre;
    @Column(length = 50)
    private String direccion;
    @Column(length = 50)
    private String correo;
    @Column
    private String contrasena;
    @Column(length = 16)
    private String tarjeta;
    @Column(length = 9)
    private String telefono;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reporte> reportes;

}
