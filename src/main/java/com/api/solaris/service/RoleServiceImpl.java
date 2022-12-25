package com.api.solaris.service;

import com.api.solaris.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String role) {
        return roleRepository.findRoleByRole(role);
    }
}
