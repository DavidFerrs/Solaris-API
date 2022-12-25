package com.api.solaris.service;

import com.api.solaris.model.Role;

public interface RoleService {
    Role findByName(String role);
}