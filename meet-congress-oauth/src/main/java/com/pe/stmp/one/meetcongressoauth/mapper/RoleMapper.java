package com.pe.stmp.one.meetcongressoauth.mapper;

import com.pe.stmp.one.meetcongressoauth.models.Role;
import com.pe.stmp.one.meetcongressoauth.models.RoleResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleResponse toRoleResponse(Role role);

    Role toRole(RoleResponse roleResponse);
}
