package com.iker.stockify.services;

import com.iker.stockify.dtos.RegisterClientRequest;
import com.iker.stockify.entities.Clientes;
import com.iker.stockify.exceptions.ClientAlreadyExistsException;
import com.iker.stockify.repositories.ClientesRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ClientesService {
    private final ClientesRepository repository;
    private final PasswordEncoder encoder;

    public ClientesService(ClientesRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public void createClientAccount(RegisterClientRequest request) {
        Optional<Clientes> opCliente = repository.findByemail(request.getEmail());

        if (opCliente.isPresent()) {
            throw new ClientAlreadyExistsException("Cliente ya registrado!");
        }
        Clientes cliente = new Clientes();
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
