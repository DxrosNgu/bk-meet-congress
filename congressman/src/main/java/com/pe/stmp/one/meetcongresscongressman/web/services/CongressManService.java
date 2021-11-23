package com.pe.stmp.one.meetcongresscongressman.web.services;

import com.pe.stmp.one.meetcongresscongressman.web.model.Congressman;

import java.util.List;

public interface CongressManService {

    List<Congressman> getListCongressman();

    Congressman getCongressmanById(Integer memberId);

    String updateCongressmanById(Integer memberId);

    String deleteCongressmanById(Integer memberId);

    String insertCongressmanImageById(Integer memberId);
}
