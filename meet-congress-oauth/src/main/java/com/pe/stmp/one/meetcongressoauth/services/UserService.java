package com.pe.stmp.one.meetcongressoauth.services;

import com.pe.stmp.one.meetcongressoauth.models.Role;
import com.pe.stmp.one.meetcongressoauth.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService, UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = findByUsername(userName);

        List<GrantedAuthority> grantedAuthorities = user.getRoles().stream()
                .peek(authority -> log.info("Role: " + authority.getName()))
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.getEnabled(), true, true, true, grantedAuthorities);

    }

//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        try {
//            User user = client.findByUsername(userName);
//
//            List<GrantedAuthority> grantedAuthorities = user.getRoles().stream()
//                    .peek(authority -> log.info("Role: " + authority.getName()))
//                    .map(role -> new SimpleGrantedAuthority(role.getName()))
//                    .collect(Collectors.toList());
//            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//                    user.getEnabled(), true, true, true, grantedAuthorities);
//        } catch (FeignException e) {
//            String error = "Error en el login, no existe el usuario'" + userName + "' en el sistema";
//
//            tracer.currentSpan().tag("error.mensaje", error + ":" + e.getMessage());
//            throw new UsernameNotFoundException(error);
//        }
//    }

    @Override
    public User update(User user, Long id) {
        user.setId(id);

        user.setUsername("andres");
        user.setPassword("$2a$10$PE2A7t7Dr/ezEOpw.Io5r.tqSYPy2heTrWB3x/jnDghSKgr1UMHfC");
        user.setEnabled(true);
        user.setFirstName("Andres");
        user.setLastName("Guzman");
        user.setEmail("profesor@bolsadeideas.com");
        Role role1 = new Role();
        role1.setName("ROLE_USER");
        role1.setId(1L);
        Role role2 = new Role();
        role2.setName("ROLE_ADMIN");
        role2.setId(1L);
        List<Role> roleList = new ArrayList<>();
        roleList.add(role1);
        roleList.add(role2);
        user.setRoles(roleList);
        return user;
    }

//    @Override
//    public User update(User user, Long id) {
//        return client.update(user, id);
//    }

    @Override
    public User findByUsername(String username) {
        User user = new User();
        user.setId(1L);
        user.setUsername("andres");
        user.setPassword("$2a$10$PE2A7t7Dr/ezEOpw.Io5r.tqSYPy2heTrWB3x/jnDghSKgr1UMHfC");
        user.setEnabled(true);
        user.setFirstName("Andres");
        user.setLastName("Guzman");
        user.setEmail("profesor@bolsadeideas.com");
        Role role1 = new Role();
        role1.setName("ROLE_USER");
        role1.setId(1L);
        Role role2 = new Role();
        role2.setName("ROLE_ADMIN");
        role2.setId(1L);
        List<Role> roleList = new ArrayList<>();
        roleList.add(role1);
        roleList.add(role2);
        user.setRoles(roleList);
        return user;
    }

//    @Override
//    public User findByUsername(String username) {
//        return client.findByUsername(username);
//    }



}
