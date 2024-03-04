package org.gdscdeu.blogreactiveapi.user;

import lombok.AllArgsConstructor;
import org.gdscdeu.blogreactiveapi.config.MapStructMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;


    public Mono<User> changePassword(String token, String password) {
        return userRepository.findByEmail(token)
                .map(user -> {
                    user.setPassword(password);
                    return user;
                })
                .flatMap(userRepository::save);
    }

    public Mono<Void> delete(String token) {
        return userRepository.findByEmail(token)
                .flatMap(userRepository::delete);
    }


    public Flux<User> findAll() {
        return userRepository.findAll();
    }
}
