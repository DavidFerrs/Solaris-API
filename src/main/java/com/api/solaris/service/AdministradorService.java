package com.api.solaris.service;

import com.api.solaris.dto.AdministradorDTO;
import com.api.solaris.exception.AdministradorAlreadyCreatedException;
import com.api.solaris.exception.AdministradorNotFoundException;

import java.util.List;

public interface AdministradorService {

    public AdministradorDTO criaAdministrador(AdministradorDTO administradorDTO) throws AdministradorAlreadyCreatedException;

    public List<AdministradorDTO> listarAdministradores();

    public void removerAdministradorCadastrado(Long id) throws AdministradorNotFoundException;

    public AdministradorDTO getAdministradorById(Long id) throws AdministradorNotFoundException;

    public AdministradorDTO atualizaAdministrador(Long id, AdministradorDTO administradorDTO) throws AdministradorNotFoundException;

}
