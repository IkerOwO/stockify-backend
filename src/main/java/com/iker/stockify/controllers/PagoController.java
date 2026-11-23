package com.iker.stockify.controllers;

import com.iker.stockify.entities.Pago;
import com.iker.stockify.services.PagoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pago")
public class PagoController {
    private final PagoService service;

    public PagoController(PagoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Pago> getByPaymentType(@PathVariable String tipoDato) {
        return service.getByPaymentType(tipoDato);
    }
}
