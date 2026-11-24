package com.iker.stockify.services;

import com.iker.stockify.dtos.EmpleadoRegisterRequest;
import com.iker.stockify.dtos.LoginRequest;
import com.iker.stockify.dtos.LoginResponse;
import com.iker.stockify.entities.Empleado;
import com.iker.stockify.exceptions.PasswordsDontMatchException;
import com.iker.stockify.exceptions.UserAlreadyExistsException;
import com.iker.stockify.exceptions.UserDontExistsException;
import com.iker.stockify.repositories.EmpleadoRepository;
import com.iker.stockify.security.JwtService;
import com.iker.stockify.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmpleadoService implements UserDetailsService {
    private final EmpleadoRepository repository;
    private final JwtService jwtService;
    private final PasswordEncoder encoder;

    public EmpleadoService(EmpleadoRepository repository, JwtService jwtService, PasswordEncoder encoder) {
        this.repository = repository;
        this.jwtService = jwtService;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsuario(username)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }

    public void createUser(EmpleadoRegisterRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("Email associated with another account");
        }
        Empleado empleado = new Empleado();
        empleado.setNombre(request.getNombre());
        empleado.setApellidos(request.getApellidos());
        empleado.setUsuario(request.getUsername());
        empleado.setEmail(request.getEmail());
        empleado.setPassword(encoder.encode(request.getPassword()));
        empleado.setRole(request.getRole());
        empleado.setCuenta_activa(true); // Valor por defecto al crear una cuenta de empleado
        empleado.setFecha_incorporacion(request.getFecha_incorporacion());
        repository.save(empleado);
    }

    public LoginResponse loginUser(LoginRequest request) {
        Empleado empleado = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UserDontExistsException("The user doesn't exists!"));

        if (!encoder.matches(request.getPassword(), empleado.getPassword())) {
            throw new PasswordsDontMatchException("Login incorrect!");
        }

        return new LoginResponse(
                jwtService.generateToken(empleado),
                empleado.getId_empleado(),
                empleado.getUsuario(),
                empleado.getEmail(),
                empleado.getRole().toString()
        );
    }

    @Transactional
    public void updateAccountActiva(Long id, boolean isActive) {
        Optional<Empleado> opEmpleado = repository.findById(id);
        if (opEmpleado.isPresent()) {
            Empleado empleado = opEmpleado.get();
            empleado.setCuenta_activa(isActive);
            repository.save(empleado);
        }
    }
}
