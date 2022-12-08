package com.api.solaris.service;

import com.api.solaris.dto.AdministradorDTO;
import com.api.solaris.exception.AdministradorAlreadyCreatedException;
import com.api.solaris.exception.AdministradorNotFoundException;
import com.api.solaris.model.Administrador;
import com.api.solaris.repository.AdministradorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdministradorServiceImpl implements AdministradorService{

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    public ModelMapper modelMapper;


    public AdministradorDTO criaAdministrador(AdministradorDTO administradorDTO) throws AdministradorAlreadyCreatedException {
        if(isAdministradorCadastrado(administradorDTO.getLogin())) {
            throw new AdministradorAlreadyCreatedException();
        }

        Administrador administrador = new Administrador(administradorDTO.getNome(), administradorDTO.getLogin(), administradorDTO.getSenha());
        salvarAdministradorCadastrado(administrador);
        return modelMapper.map(administrador, AdministradorDTO.class);
    }

    private boolean isAdministradorCadastrado(String login) {
        try {
            getAdministradorByLogin(login);
            return true;
        } catch (AdministradorNotFoundException e) {
            return false;
        }
    }

    public AdministradorDTO getAdministradorByLogin(String login) throws AdministradorNotFoundException {
        Administrador administrador = administradorRepository.findByLogin(login)
                .orElseThrow(() -> new AdministradorNotFoundException());
        return modelMapper.map(administrador, AdministradorDTO.class);
    }

    private void salvarAdministradorCadastrado(Administrador administrador) {
        administradorRepository.save(administrador);
    }

    public List<AdministradorDTO> listarAdministradores() {
        List<AdministradorDTO> administradores = administradorRepository.findAll()
                .stream()
                .map(administrador -> modelMapper.map(administrador, AdministradorDTO.class))
                .collect(Collectors.toList());
        return administradores;
    }

    @Override
    public void removerAdministradorCadastrado(Long id) throws AdministradorNotFoundException {
        Administrador administrador = getAdministradorId(id);
        administradorRepository.delete(administrador);
    }

    private Administrador getAdministradorId(Long id) throws AdministradorNotFoundException {
        return administradorRepository.findById(id)
                .orElseThrow(() -> new AdministradorNotFoundException());
    }

    @Override
    public AdministradorDTO getAdministradorById(Long id) throws AdministradorNotFoundException {
        Administrador administrador = getAdministradorId(id);
        return modelMapper.map(administrador, AdministradorDTO.class);
    }

    @Override
    public AdministradorDTO atualizaAdministrador(Long id, AdministradorDTO administradorDTO) throws AdministradorNotFoundException {
        Administrador administrador = getAdministradorId(id);
        administrador.setNome(administradorDTO.getNome());
        administrador.setLogin(administrador.getLogin());
        administrador.setSenha(administrador.getSenha());
        salvarAdministradorCadastrado(administrador);

        return modelMapper.map(administrador, AdministradorDTO.class);
    }
}
