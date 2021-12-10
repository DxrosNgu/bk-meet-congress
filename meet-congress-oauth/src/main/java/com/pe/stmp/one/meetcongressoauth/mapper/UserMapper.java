package com.pe.stmp.one.meetcongressoauth.mapper;

import com.pe.stmp.one.meetcongressoauth.models.Role;
import com.pe.stmp.one.meetcongressoauth.models.RoleResponse;
import com.pe.stmp.one.meetcongressoauth.models.User;
import com.pe.stmp.one.meetcongressoauth.models.UserResponse;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {

    @Mapping(source = "user.roles", target = "roleResponses")
    UserResponse toUserResponse(User user);

    @Mapping(source = "userResponse.roleResponses", target = "roles")
    User toUser(UserResponse userResponse);

}
