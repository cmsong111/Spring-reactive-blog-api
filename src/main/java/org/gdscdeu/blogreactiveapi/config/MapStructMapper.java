package org.gdscdeu.blogreactiveapi.config;

import org.gdscdeu.blogreactiveapi.auth.LoginRequest;
import org.gdscdeu.blogreactiveapi.user.User;
import org.gdscdeu.blogreactiveapi.auth.UserRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    User toUser(UserRequest userRequest);
    User toUser(LoginRequest loginRequest);
}
