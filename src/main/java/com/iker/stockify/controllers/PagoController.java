package com.iker.stockify.controllers;

import com.iker.stockify.entities.Pago;
import com.iker.stockify.services.PagoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pago")
@CrossOrigin(origins = "*")
public class PagoController {
    private final PagoService service;

    public PagoController(PagoService service) {
        this.service = service;
    }

    @GetMapping("/{tipoPago}")
    public List<Pago> getByPaymentType(@PathVariable String tipoPago) {
        return service.getByPaymentType(tipoPago);
    }
}
