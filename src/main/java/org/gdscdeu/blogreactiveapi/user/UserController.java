package org.gdscdeu.blogreactiveapi.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.gdscdeu.blogreactiveapi.auth.LoginRequest;
import org.gdscdeu.blogreactiveapi.auth.UserRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
@Tag(name = "User", description = "User API")
public class UserController {

    UserService userService;

    @PostMapping("/changePassword")
    @Operation(summary = "Change password")
    public ResponseEntity<Mono<User>> update(
            @Parameter(description = "Email") @RequestHeader("Authorization") String token,
            @Parameter(description = "new password") @RequestBody String password) {
        return ResponseEntity.ok(userService.changePassword(token,password));
    }

    @DeleteMapping
    @Operation(summary = "withdraw a user")
    public ResponseEntity<Mono<Void>> delete(
            @Parameter(description = "Email") @RequestHeader("Authorization") String token
    ) {
        return ResponseEntity.ok(userService.delete(token));
    }


    @GetMapping(value = "/findAll", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @Operation(summary = "Get all users")
    public Flux<User> findAll() {
        return userService.findAll();
    }


}
