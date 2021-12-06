package com.pe.stmp.one.meetcongress.usermanagement.web.repository;

import com.pe.stmp.one.meetcongress.usermanagement.web.model.dao.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
