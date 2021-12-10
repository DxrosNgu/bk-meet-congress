package com.pe.stmp.one.meetcongressoauth.services;

import com.pe.stmp.one.meetcongressoauth.models.User;
import com.pe.stmp.one.meetcongressoauth.models.UserResponse;

public interface UserService {

    UserResponse findByUsername(String username);

    UserResponse update( User user, Long id);

}
