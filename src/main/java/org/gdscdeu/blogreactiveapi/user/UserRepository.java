package org.gdscdeu.blogreactiveapi.user;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Long> {
    Mono<Boolean> existsByEmail(String email);
    Mono<User> findByEmail(String email);

    Mono<User> findByEmailAndPassword(String email, String password);
}
