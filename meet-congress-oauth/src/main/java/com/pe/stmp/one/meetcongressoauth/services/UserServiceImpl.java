package com.pe.stmp.one.meetcongressoauth.services;

import com.pe.stmp.one.meetcongressoauth.mapper.UserMapper;
import com.pe.stmp.one.meetcongressoauth.models.Role;
import com.pe.stmp.one.meetcongressoauth.models.User;
import com.pe.stmp.one.meetcongressoauth.models.UserResponse;
import com.pe.stmp.one.meetcongressoauth.proxy.UserManagementClient;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final String BASE_URL = "http://localhost:8190/api/users/";

//    @Autowired
//    private UserManagementClient client;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserResponse userResponse = null;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserManagementClient client = retrofit.create(UserManagementClient.class);

        Call<User> user =  client.findByUsername(userName);
        try {
        userResponse = userMapper.toUserResponse(user.execute().body()) ;
        } catch (IOException e){
            System.out.println(e);
        }
            List<GrantedAuthority> grantedAuthorities = userResponse.getRoleResponses().stream()
                    .peek(authority -> log.info("Role: " + authority.getName()))
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList());
            return new org.springframework.security.core.userdetails.User(userResponse.getUsername(), userResponse.getPassword(),
                    userResponse.getEnabled(), true, true, true, grantedAuthorities);
    }

    @Override
    public UserResponse update(User user, Long id) {
        UserResponse userResponse = null;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserManagementClient client = retrofit.create(UserManagementClient.class);

        Call<User> userCall =  client.update(user, id);
        try {
            userResponse = userMapper.toUserResponse(userCall.execute().body()) ;
        } catch (IOException e){
            System.out.println(e);
        }

        return userResponse;
    }

    @Override
    public UserResponse findByUsername(String username) {
        UserResponse userResponse = null;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserManagementClient client = retrofit.create(UserManagementClient.class);

        Call<User> user =  client.findByUsername(username);
        try {
            userResponse = userMapper.toUserResponse(user.execute().body()) ;
            System.out.println(userResponse);
        } catch (IOException e){
            System.out.println(e);
        }
         return userResponse;

    }



}
