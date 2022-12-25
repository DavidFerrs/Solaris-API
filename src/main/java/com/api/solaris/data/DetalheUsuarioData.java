package com.api.solaris.data;

import antlr.StringUtils;
import com.api.solaris.model.Role;
import com.api.solaris.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;


public class DetalheUsuarioData<T extends Usuario> implements UserDetails {

    private final Optional<T> usuario;

    public DetalheUsuarioData(Optional<T> usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return usuario.isPresent() ? usuario.get().getSenha() : "";
    }

    @Override
    public String getUsername() {
        return usuario.isPresent() ? usuario.get().getLogin() : "";
    }

    public String getRoleUsuario() {
        return usuario.map(t -> t.getRoles()
                        .stream()
                        .map(Role::getRole)
                        .collect(Collectors.joining(",")))
                .orElse("");
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}