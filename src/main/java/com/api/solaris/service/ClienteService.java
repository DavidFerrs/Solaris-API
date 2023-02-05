package com.api.solaris.service;



import com.api.solaris.dto.ClienteDTO;
import com.api.solaris.exception.cliente.ClienteAlreadyCreatedException;
import com.api.solaris.exception.cliente.ClienteNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ClienteService {

	public ClienteDTO getClienteById(UUID id) throws ClienteNotFoundException;

	public ClienteDTO getClienteByCpf(Long cpf) throws ClienteNotFoundException;

	public void removerClienteCadastrado(UUID id) throws ClienteNotFoundException;

	public List<ClienteDTO> listarClientes();

	public ClienteDTO criaCliente(ClienteDTO clienteDTO) throws ClienteAlreadyCreatedException;

	public ClienteDTO atualizaCliente(UUID id, ClienteDTO clienteDTO) throws ClienteNotFoundException;

}
