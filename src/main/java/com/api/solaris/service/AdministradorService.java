package com.api.solaris.service;

import com.api.solaris.dto.AdministradorDTO;
import com.api.solaris.exception.EntityAlreadyExistsException;
import com.api.solaris.exception.EntityNotFoundException;

import java.util.List;

public interface AdministradorService {

    public AdministradorDTO criaAdministrador(AdministradorDTO administradorDTO) throws EntityAlreadyExistsException;

    public List<AdministradorDTO> listarAdministradores();

    public void removerAdministradorCadastrado(Long id) throws EntityNotFoundException;

    public AdministradorDTO getAdministradorById(Long id) throws EntityNotFoundException;

    public AdministradorDTO atualizaAdministrador(Long id, AdministradorDTO administradorDTO) throws EntityNotFoundException;

}
