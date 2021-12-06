package com.pe.stmp.one.meetcongress.usermanagement.web.model.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="roles")
public class Role implements Serializable {

    private static final long serialVersionUID = 8002202019413072109L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 30)
    private String name;

   /* @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private List<User> users;*/
}
