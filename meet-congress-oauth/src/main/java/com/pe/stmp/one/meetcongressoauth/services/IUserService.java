package com.pe.stmp.one.meetcongressoauth.services;

import com.pe.stmp.one.meetcongressoauth.models.User;

public interface IUserService {

    User findByUsername(String username);

    User update( User user, Long id);

}
