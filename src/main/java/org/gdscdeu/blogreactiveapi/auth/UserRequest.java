package org.gdscdeu.blogreactiveapi.auth;

public record UserRequest(
        String email,
        String password,
        String name
) {
}
