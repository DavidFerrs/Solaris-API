package com.api.solaris.service;

import com.api.solaris.dto.ModuloDTO;
import com.api.solaris.exception.EntityAlreadyExistsException;
import com.api.solaris.exception.EntityNotFoundException;

import java.util.List;

public interface ModuloService {

    public void removerModuloCadastrado(Long id) throws EntityNotFoundException;


    public ModuloDTO addModulo(ModuloDTO moduloDTO)throws EntityAlreadyExistsException;

    public List<ModuloDTO> listarModulos();

   public ModuloDTO getModuloDTO(long id) throws EntityNotFoundException;

    public ModuloDTO atualizarModulo(long id, ModuloDTO moduloDTO) throws EntityNotFoundException;


}
