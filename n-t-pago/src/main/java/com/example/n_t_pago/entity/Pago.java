package com.example.n_t_pago.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "nt_pagos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_t_id_pago")
    private Long idPago;

    @Column(name = "n_t_monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "n_t_fecha", nullable = false)
    private LocalDateTime fecha;
}
