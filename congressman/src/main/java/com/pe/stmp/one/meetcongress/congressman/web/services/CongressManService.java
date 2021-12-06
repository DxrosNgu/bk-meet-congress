package com.pe.stmp.one.meetcongress.congressman.web.services;

import com.pe.stmp.one.meetcongress.congressman.web.model.dao.Congressman;

import java.util.List;

public interface CongressManService {

    List<Congressman> getListCongressman();

    Congressman getCongressmanById(Integer memberId);

    String updateCongressmanById(Integer memberId);

    String deleteCongressmanById(Integer memberId);

    String insertCongressmanImageById(Integer memberId);
}