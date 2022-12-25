package com.api.solaris.service;


import com.api.solaris.dto.ClienteDTO;
import com.api.solaris.exception.cliente.ClienteAlreadyCreatedException;
import com.api.solaris.exception.cliente.ClienteNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.UUID;

public interface ClienteService {

    public ClienteDTO getClienteById(Long id) throws ClienteNotFoundException;

    public ClienteDTO getClienteByCpf(Long cpf) throws ClienteNotFoundException;

    public void removerClienteCadastrado(Long id) throws ClienteNotFoundException;

    public List<ClienteDTO> listarClientes();

    public ClienteDTO criaCliente(ClienteDTO clienteDTO) throws ClienteAlreadyCreatedException;

    public ClienteDTO atualizaCliente(Long id, ClienteDTO clienteDTO) throws ClienteNotFoundException;

}
