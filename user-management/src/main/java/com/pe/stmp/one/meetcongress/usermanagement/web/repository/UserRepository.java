package com.pe.stmp.one.meetcongress.usermanagement.web.repository;

import com.pe.stmp.one.meetcongress.usermanagement.web.model.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);


}
