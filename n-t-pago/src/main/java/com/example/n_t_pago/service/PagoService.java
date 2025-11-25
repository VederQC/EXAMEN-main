package com.example.n_t_pago.service;


import com.example.n_t_pago.entity.Pago;

import java.util.List;

public interface PagoService {

    Pago create(Pago pago);

    Pago getById(Long id);

    List<Pago> getAll();

    Pago update(Long id, Pago pago);

    void delete(Long id);
}
