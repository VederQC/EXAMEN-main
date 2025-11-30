package com.example.ms_operaciones.controller;

import com.example.ms_operaciones.entity.Proveedor;
import com.example.ms_operaciones.service.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/proveedores")
@RequiredArgsConstructor
public class ProveedorController {

    private final ProveedorService service;

    @PostMapping
    public Proveedor save(@RequestBody Proveedor proveedor) {
        return service.save(proveedor);
    }

    @PutMapping("/{id}")
    public Proveedor update(@PathVariable Long id, @RequestBody Proveedor proveedor) {
        return service.update(id, proveedor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Proveedor find(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Proveedor> all() {
        return service.findAll();
    }

    @GetMapping("/search")
    public List<Proveedor> search(@RequestParam String q) {
        return service.search(q);
    }
}
