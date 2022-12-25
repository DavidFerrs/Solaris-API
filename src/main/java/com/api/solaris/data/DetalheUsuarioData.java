package com.api.solaris.data;

import com.api.solaris.model.Usuario;
import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Optional;


public class DetalheUsuarioData<T extends Usuario> implements UserDetails {

    private final Optional<T> usuario;

    public DetalheUsuarioData(Optional<T> usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Lists.newArrayList();
    }

    @Override
    public String getPassword() {
        return usuario.isPresent() ? usuario.get().getSenha() : "";
    }

    @Override
    public String getUsername() {
        return usuario.isPresent() ? usuario.get().getLogin() : "";
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