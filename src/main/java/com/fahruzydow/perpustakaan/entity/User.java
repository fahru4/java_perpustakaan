package com.fahruzydow.perpustakaan.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity<User> {

    private static final long serialVersionUID = 1670796395265166315L;

    public enum Role{
        ROLE_USER,
        ROLE_ADMIN
    }
    @Column(name = "role", columnDefinition = "VARCHAR(50)")
    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;

    @Column(name = "profile_name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String profileName;

    @Column(name = "username", columnDefinition = "VARCHAR(50)", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "token")
    private String token;

    public User(String username) {
        this.username = username;
    }
}
