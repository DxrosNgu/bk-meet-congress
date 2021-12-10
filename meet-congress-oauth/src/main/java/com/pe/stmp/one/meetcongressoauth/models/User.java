package com.pe.stmp.one.meetcongressoauth.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 4002221912401133094L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String username;

    @Column( length = 60)
    private String password;
    private Boolean enabled;
    private String firstName;
    private String lastName;

    @Column(unique = true, length = 100)
    private String email;

    private Integer intentos;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","role_id"})})
    private List<Role> roles;
}
