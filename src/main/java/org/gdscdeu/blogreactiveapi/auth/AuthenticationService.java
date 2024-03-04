package org.gdscdeu.blogreactiveapi.auth;

import lombok.AllArgsConstructor;
import org.gdscdeu.blogreactiveapi.config.MapStructMapper;
import org.gdscdeu.blogreactiveapi.user.User;
import org.gdscdeu.blogreactiveapi.user.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final MapStructMapper mapper;

    public Mono<User> save(UserRequest user) {
        return userRepository.existsByEmail(user.email())
                .filter(exists -> !exists)
                .switchIfEmpty(Mono.error(new RuntimeException("User already exists")))
                .flatMap(exists -> userRepository.save(mapper.toUser(user)));
    }

    public Mono<User> login(LoginRequest user) {
        return userRepository.existsByEmail(user.email())
                .filter(exists -> exists)
                .switchIfEmpty(Mono.error(new RuntimeException("User does not exist")))
                .flatMap(exists -> userRepository.findByEmailAndPassword(user.email(), user.password()));
    }
}
