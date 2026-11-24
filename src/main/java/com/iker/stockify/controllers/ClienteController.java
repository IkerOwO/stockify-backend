package com.iker.stockify.controllers;

import com.iker.stockify.dtos.RegisterClientRequest;
import com.iker.stockify.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping("/registerClient")
    public ResponseEntity<?> registerClient(RegisterClientRequest request) {
        service.createClientAccount(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
