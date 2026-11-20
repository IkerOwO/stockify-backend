package com.iker.stockify;

import com.iker.stockify.dtos.EmpleadoRegisterRequest;
import com.iker.stockify.dtos.LoginRequest;
import com.iker.stockify.dtos.LoginResponse;
import com.iker.stockify.services.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class EmpleadoController {
    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody EmpleadoRegisterRequest request) {
        service.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(service.loginUser(request));
    }
}
