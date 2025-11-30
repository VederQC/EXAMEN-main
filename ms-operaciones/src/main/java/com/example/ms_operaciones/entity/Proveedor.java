package com.example.ms_operaciones.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "proveedor")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 11, unique = true)
    private String ruc;

    @Column(nullable = false, length = 150)
    private String razonSocial;

    @Column(length = 200)
    private String direccion;

    @Column(length = 50)
    private String telefono;

    @Column(length = 100)
    private String email;
}