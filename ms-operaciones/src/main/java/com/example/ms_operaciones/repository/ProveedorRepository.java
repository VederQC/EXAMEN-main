package com.example.ms_operaciones.repository;

import com.example.ms_operaciones.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    List<Proveedor> findByRazonSocialContainingIgnoreCase(String razonSocial);
    boolean existsByRuc(String ruc);
}