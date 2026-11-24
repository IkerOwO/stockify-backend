package com.iker.stockify.services;

import com.iker.stockify.dtos.RegisterClientRequest;
import com.iker.stockify.entities.Cliente;
import com.iker.stockify.exceptions.ClientAlreadyExistsException;
import com.iker.stockify.repositories.ClienteRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository repository;
    private final PasswordEncoder encoder;

    public ClienteService(ClienteRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public void createClientAccount(RegisterClientRequest request) {
        Optional<Cliente> opCliente = repository.findByemail(request.getEmail());

        if (opCliente.isPresent()) {
            throw new ClientAlreadyExistsException("Cliente ya registrado!");
        }
        Cliente cliente = new Cliente();
        cliente.setNombre(request.getNombre());
        cliente.setApellidos(request.getApellidos());
        cliente.setDomicilio(request.getDomicilio());
        cliente.setNombre_usuario(request.getNombre_usuario());
        cliente.setEmail(request.getEmail());
        cliente.setContrasenya(encoder.encode(request.getContrasenya()));
        cliente.setCuenta_activa(true);
        cliente.setFecha_creacion_cuenta(LocalDate.now());
        repository.save(cliente);
    }

    // TODO: Posiblemente un metodo de login

}
