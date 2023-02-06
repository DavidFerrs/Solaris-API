package com.api.solaris.service;

import com.api.solaris.dto.ModuloDTO;
import com.api.solaris.dto.PedidoDTO;
import com.api.solaris.exception.EntityAlreadyExistsException;
import com.api.solaris.exception.EntityNotFoundException;
import com.api.solaris.model.Orcamento;

public interface PedidoService {

    public PedidoDTO criarPedido( PedidoDTO pedidoDTO) throws EntityAlreadyExistsException, EntityNotFoundException;
}
