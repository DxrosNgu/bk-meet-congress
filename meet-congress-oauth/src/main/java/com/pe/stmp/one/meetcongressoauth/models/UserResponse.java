package com.pe.stmp.one.meetcongressoauth.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse implements Serializable {

    private Long id;

    private String username;

    private String password;
    private Boolean enabled;
    private String firstName;
    private String lastName;

    private String email;

    private Integer intentos;

    private List<RoleResponse> roleResponses;

}
