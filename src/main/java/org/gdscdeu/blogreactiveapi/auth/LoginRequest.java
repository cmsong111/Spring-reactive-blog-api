package org.gdscdeu.blogreactiveapi.auth;

public record LoginRequest(
        String email,
        String password
) {
}
