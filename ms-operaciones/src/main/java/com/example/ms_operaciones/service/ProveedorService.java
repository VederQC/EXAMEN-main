package com.example.ms_operaciones.service;



import com.example.ms_operaciones.entity.Proveedor;
import com.example.ms_operaciones.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorService {

    private final ProveedorRepository repo;

    public Proveedor save(Proveedor proveedor) {
        if (repo.existsByRuc(proveedor.getRuc()))
            throw new RuntimeException("❌ El RUC ya existe en el sistema.");

        return repo.save(proveedor);
    }

    public Proveedor update(Long id, Proveedor proveedor) {
        Proveedor db = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("❌ Proveedor no encontrado."));

        db.setRuc(proveedor.getRuc());
        db.setRazonSocial(proveedor.getRazonSocial());
        db.setDireccion(proveedor.getDireccion());
        db.setTelefono(proveedor.getTelefono());
        db.setEmail(proveedor.getEmail());

        return repo.save(db);
    }

    public void delete(Long id) {
        if (!repo.existsById(id))
            throw new RuntimeException("❌ No existe el proveedor a eliminar.");

        repo.deleteById(id);
    }

    public Proveedor findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Proveedor> findAll() {
        return repo.findAll();
    }

    public List<Proveedor> search(String razonSocial) {
        return repo.findByRazonSocialContainingIgnoreCase(razonSocial);
    }
}
