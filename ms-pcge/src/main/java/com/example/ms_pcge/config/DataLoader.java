package com.example.ms_pcge.config;


import com.example.ms_pcge.entity.PcgeAccount;
import com.example.ms_pcge.service.PcgeAccountService;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final PcgeAccountService service;

    @Override
    public void run(String... args) throws Exception {

        if (service.findAll().isEmpty()) {
            List<PcgeAccount> accounts = List.of(
                    PcgeAccount.builder().code("10").name("EFECTIVO Y EQUIVALENTES").classNumber(1).level(1).nature("D").type("ACTIVO").build(),
                    PcgeAccount.builder().code("101").name("Caja").classNumber(1).level(2).parentCode("10").nature("D").type("ACTIVO").build(),
                    PcgeAccount.builder().code("104").name("Cuentas Bancarias").classNumber(1).level(2).parentCode("10").nature("D").type("ACTIVO").build(),

                    PcgeAccount.builder().code("40").name("TRIBUTOS POR PAGAR").classNumber(2).level(1).nature("H").type("PASIVO").build(),
                    PcgeAccount.builder().code("4011").name("IGV").classNumber(2).level(2).parentCode("40").nature("H").type("PASIVO").build(),
                    PcgeAccount.builder().code("40111").name("IGV por pagar").classNumber(2).level(3).parentCode("4011").nature("H").type("PASIVO").build(),

                    PcgeAccount.builder().code("70").name("VENTAS").classNumber(4).level(1).nature("H").type("INGRESO").build(),
                    PcgeAccount.builder().code("701").name("Mercaderías").classNumber(4).level(2).parentCode("70").nature("H").type("INGRESO").build()
            );

            service.saveAll(accounts);
            System.out.println("✔ PCGE básico cargado correctamente");
        }
    }
}
