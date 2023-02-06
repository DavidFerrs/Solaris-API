package com.api.solaris.service;
import com.api.solaris.dto.OrcamentoDTO;
import com.api.solaris.exception.EntityAlreadyExistsException;
import com.api.solaris.exception.EntityNotFoundException;
import com.api.solaris.model.Orcamento;

import java.util.List;

public interface OrcamentoService {
    public void removerOrcamentoCadastrado(Long id) throws EntityNotFoundException;

//    public OrcamentoDTO addOrcamento(OrcamentoDTO orcamentoDTO)throws EntityAlreadyExistsException;
    public OrcamentoDTO calculaOrcamento(OrcamentoDTO orcamentoDTO)throws EntityAlreadyExistsException;

    public OrcamentoDTO addOrcamento(OrcamentoDTO orcamentoDTO);

    public List<OrcamentoDTO> listarOrcamentos();

    public OrcamentoDTO getOrcamentoDTO(long id) throws EntityNotFoundException;

    public OrcamentoDTO atualizarOrcamento(long id, OrcamentoDTO orcamentoDTO) throws EntityNotFoundException;

    public Orcamento getOrcamento(Long id) throws EntityNotFoundException;
}
