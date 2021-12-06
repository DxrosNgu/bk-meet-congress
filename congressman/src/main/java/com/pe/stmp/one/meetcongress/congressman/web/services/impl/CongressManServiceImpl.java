package com.pe.stmp.one.meetcongress.congressman.web.services.impl;

import com.pe.stmp.one.meetcongress.congressman.web.model.dao.Congressman;
import com.pe.stmp.one.meetcongress.congressman.web.repository.CongressmanRepository;
import com.pe.stmp.one.meetcongress.congressman.web.services.CongressManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongressManServiceImpl implements CongressManService {

    @Autowired
    CongressmanRepository repository;

    @Override
    public List<Congressman> getListCongressman() {
        return repository.findAll();
    }

    @Override
    public Congressman getCongressmanById(Integer memberId) {
        return null;
    }

    @Override
    public String updateCongressmanById(Integer memberId) {
        return null;
    }

    @Override
    public String deleteCongressmanById(Integer memberId) {
        return null;
    }

    @Override
    public String insertCongressmanImageById(Integer memberId) {
        return null;
    }
}