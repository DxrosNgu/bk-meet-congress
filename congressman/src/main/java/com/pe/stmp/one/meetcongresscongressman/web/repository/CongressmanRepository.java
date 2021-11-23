package com.pe.stmp.one.meetcongresscongressman.web.repository;

import com.pe.stmp.one.meetcongresscongressman.web.model.Congressman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CongressmanRepository extends JpaRepository<Congressman, Integer> {

    @Query("SELECT c FROM Congressman c")
    List<Congressman> findAll();

}
