package com.pe.stmp.one.meetcongress.usermanagement.web.service;

import com.pe.stmp.one.meetcongress.usermanagement.web.model.dao.User;

public interface UserService {
    User findByUsername(String username);

    User updateUser (User user, Long id);
}
