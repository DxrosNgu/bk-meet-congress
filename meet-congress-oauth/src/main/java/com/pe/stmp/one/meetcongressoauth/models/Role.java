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
@Table(name="Roles")
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    private static final long serialVersionUID = 8002202019413072109L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 30)
    private String name;

}
