package com.pe.stmp.one.meetcongress.usermanagement.web.service;

import com.pe.stmp.one.meetcongress.usermanagement.web.model.dao.User;
import com.pe.stmp.one.meetcongress.usermanagement.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User updateUser(User user, Long id) {
        user.setId(id);
        return userRepository.save(user);
    }
}