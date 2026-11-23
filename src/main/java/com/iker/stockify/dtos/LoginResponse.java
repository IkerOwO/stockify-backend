package com.iker.stockify.dtos;

public record LoginResponse(
        String token,
        Long id,
        String username,
        String email,
        String role
) {}
