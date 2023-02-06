package com.api.solaris.service;

import com.api.solaris.dto.InversorDTO;
import com.api.solaris.exception.EntityAlreadyExistsException;
import com.api.solaris.exception.EntityNotFoundException;

import java.util.List;

public interface InversorService {

    public void removerInversorCadastrado(Long id) throws EntityNotFoundException;


    public InversorDTO addInversor(InversorDTO moduloDTO)throws EntityAlreadyExistsException;

    public List<InversorDTO> listarInversors();

    public InversorDTO getInversorDTO(long id) throws EntityNotFoundException;

    public InversorDTO atualizarInversor(long id, InversorDTO moduloDTO) throws EntityNotFoundException;


}
