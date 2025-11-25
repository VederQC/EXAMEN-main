package com.example.n_t_pago.controller;



import com.example.n_t_pago.entity.Pago;
import com.example.n_t_pago.service.PagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pago")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService pagoService;

    @PostMapping
    public Pago create(@RequestBody Pago pago) {
        return pagoService.create(pago);
    }

    @GetMapping("/{id}")
    public Pago getById(@PathVariable Long id) {
        return pagoService.getById(id);
    }

    @GetMapping
    public List<Pago> getAll() {
        return pagoService.getAll();
    }

    @PutMapping("/{id}")
    public Pago update(@PathVariable Long id, @RequestBody Pago pago) {
        return pagoService.update(id, pago);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        pagoService.delete(id);
        return "Pago eliminado correctamente";
    }
}
