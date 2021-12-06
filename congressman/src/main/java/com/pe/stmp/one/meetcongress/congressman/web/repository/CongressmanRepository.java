package com.pe.stmp.one.meetcongress.congressman.web.repository;

import com.pe.stmp.one.meetcongress.congressman.web.model.dao.Congressman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CongressmanRepository extends JpaRepository<Congressman, Integer> {

    @Query("SELECT c FROM Congressman c")
    List<Congressman> findAll();

}