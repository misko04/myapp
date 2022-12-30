package com.example.demo.service;

import com.example.demo.model.Role;

import java.util.List;

public interface RolesService {
    List<Role> getAllRoles();

    void saveRole(Role role);

    Role getRoleById(long id);

    void deleteRoleById(long id);
}