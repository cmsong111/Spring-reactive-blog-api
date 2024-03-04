package org.gdscdeu.blogreactiveapi.user;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.gdscdeu.blogreactiveapi.common.BaseEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("users")
@Builder
@Getter
@Setter
public class User extends BaseEntity {
    @Id
    private Long id;
    private String email;
    private String password;
    private String name;
}
