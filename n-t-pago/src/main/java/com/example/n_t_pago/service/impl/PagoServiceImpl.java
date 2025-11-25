package com.example.n_t_pago.service.impl;



import com.example.n_t_pago.entity.Pago;
import com.example.n_t_pago.repository.PagoRepository;
import com.example.n_t_pago.service.PagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;

    @Override
    public Pago create(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public Pago getById(Long id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado: " + id));
    }

    @Override
    public List<Pago> getAll() {
        return pagoRepository.findAll();
    }

    @Override
    public Pago update(Long id, Pago pago) {
        Pago existing = getById(id);

        existing.setMonto(pago.getMonto());
        existing.setFecha(pago.getFecha());

        return pagoRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        pagoRepository.deleteById(id);
    }
}
