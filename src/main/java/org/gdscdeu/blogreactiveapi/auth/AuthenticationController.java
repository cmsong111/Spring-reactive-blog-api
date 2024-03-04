package org.gdscdeu.blogreactiveapi.auth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.gdscdeu.blogreactiveapi.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Authentication API")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    @Operation(summary = "Sign up a new user")
    public ResponseEntity<Mono<User>> signup(@Parameter(description = "User Request") @RequestBody UserRequest user) {
        return ResponseEntity.ok(authenticationService.save(user));
    }

    @PostMapping("/login")
    @Operation(summary = "Login a user")
    public ResponseEntity<Mono<User>> login(@Parameter(description = "User Request") @RequestBody LoginRequest user) {
        return ResponseEntity.ok(authenticationService.login(user));
    }
}
