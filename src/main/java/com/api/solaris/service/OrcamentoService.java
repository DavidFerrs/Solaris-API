package com.api.solaris.service;
import com.api.solaris.dto.CalculoOrcamentoDTO;
import com.api.solaris.dto.OrcamentoDTO;
import com.api.solaris.exception.EntityAlreadyExistsException;
import com.api.solaris.exception.EntityNotFoundException;

import java.util.List;

public interface OrcamentoService {
    public void removerOrcamentoCadastrado(Long id) throws EntityNotFoundException;

//    public OrcamentoDTO addOrcamento(OrcamentoDTO orcamentoDTO)throws EntityAlreadyExistsException;
    public CalculoOrcamentoDTO calculaOrcamento(OrcamentoDTO orcamentoDTO)throws EntityAlreadyExistsException;

    public List<OrcamentoDTO> listarOrcamentos();

    public OrcamentoDTO getOrcamentoDTO(long id) throws EntityNotFoundException;

    public OrcamentoDTO atualizarOrcamento(long id, OrcamentoDTO orcamentoDTO) throws EntityNotFoundException;

}
