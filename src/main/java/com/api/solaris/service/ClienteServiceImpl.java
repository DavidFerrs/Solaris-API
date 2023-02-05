package com.api.solaris.service;


import com.api.solaris.dto.ClienteDTO;
import com.api.solaris.exception.cliente.ClienteAlreadyCreatedException;
import com.api.solaris.exception.cliente.ClienteNotFoundException;
import com.api.solaris.model.Cliente;
import com.api.solaris.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	public ModelMapper modelMapper;

	public ClienteDTO getClienteById(Long id) throws ClienteNotFoundException {
		Cliente cliente = getClienteId(id);
		return modelMapper.map(cliente, ClienteDTO.class);
	}

	private Cliente getClienteId(Long id) throws ClienteNotFoundException {
		return (Cliente) clienteRepository.findById(id)
				.orElseThrow(() -> new ClienteNotFoundException());
	}

	public ClienteDTO getClienteByCpf(Long cpf) throws ClienteNotFoundException {
		Cliente cliente = clienteRepository.findByCpfCnpj(cpf)
				.orElseThrow(() -> new ClienteNotFoundException());
		return modelMapper.map(cliente, ClienteDTO.class);
	}

	public void removerClienteCadastrado(Long id) throws ClienteNotFoundException {
		Cliente cliente = getClienteId(id);
		clienteRepository.delete(cliente);
	}

	private void salvarClienteCadastrado(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	public List<ClienteDTO> listarClientes() {
		List<ClienteDTO> clientes = clienteRepository.findAll()
				.stream()
				.map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
				.collect(Collectors.toList());
		return clientes;
	}

	public ClienteDTO criaCliente(ClienteDTO clienteDTO) throws ClienteAlreadyCreatedException {

		if(isClienteCadastrado(clienteDTO.getCpfCnpj())) {
			throw new ClienteAlreadyCreatedException();
		}

//        this.nome = nome;
//        this.tipo = tipo;
//        this.cpfCnpj = cpfCnpj;
//        this.cep = cep;
//        this.endereco = endereco;
//        this.numero = numero;
//        this.cidade = cidade;
//        this.estado = estado;
//        this.email = email;
//        this.complemento = complemento;
//        this.senha = senha;
//        this.celular = celular;

		Cliente cliente = new Cliente(clienteDTO.getNome(), clienteDTO.getTipo(),clienteDTO.getCpfCnpj(), clienteDTO.getCep(),
                clienteDTO.getEndereco(), clienteDTO.getNumero(), clienteDTO.getCidade(), clienteDTO.getEstado(), clienteDTO.getEmail(),
                clienteDTO.getComplemento(), clienteDTO.getSenha(), clienteDTO.getCelular());

		salvarClienteCadastrado(cliente);


		return modelMapper.map(cliente, ClienteDTO.class);
	}

	public ClienteDTO atualizaCliente(Long id, ClienteDTO clienteDTO) throws ClienteNotFoundException {

		Cliente cliente = getClienteId(id);

//		cliente.setIdade(clienteDTO.getIdade());

		salvarClienteCadastrado(cliente);

		return modelMapper.map(cliente, ClienteDTO.class);
	}

	private boolean isClienteCadastrado(Long cpf) {
		try {
			getClienteByCpf(cpf);
			return true;
		} catch (ClienteNotFoundException e) {
			return false;
		}
	}
}
