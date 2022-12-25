package com.api.solaris.service;

import com.api.solaris.dto.ClienteDTO;
import com.api.solaris.exception.cliente.ClienteAlreadyCreatedException;
import com.api.solaris.exception.cliente.ClienteNotFoundException;
import com.api.solaris.model.Cliente;
import com.api.solaris.model.Role;
import com.api.solaris.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private RoleServiceImpl roleService;

    public ClienteDTO getClienteById(Long id) throws ClienteNotFoundException {
        Cliente cliente = getClienteId(id);
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    private Cliente getClienteId(Long id) throws ClienteNotFoundException {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException());
    }

    public ClienteDTO getClienteByCpf(Long cpf) throws ClienteNotFoundException {
        Cliente cliente = clienteRepository.findByCpf(cpf)
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

        if (isClienteCadastrado(clienteDTO.getCpf())) {
            throw new ClienteAlreadyCreatedException();
        }

        Set<Role> roles = new HashSet<>();

        roles.add(roleService.findByName("USER"));

        Cliente cliente = new Cliente(clienteDTO.getCpf(),
                clienteDTO.getNome(),
                clienteDTO.getLogin(),
                clienteDTO.getIdade(),
                encoder.encode(clienteDTO.getSenha()),
                roles);

        salvarClienteCadastrado(cliente);


        return modelMapper.map(cliente, ClienteDTO.class);
    }

    public ClienteDTO atualizaCliente(Long id, ClienteDTO clienteDTO) throws ClienteNotFoundException {

        Cliente cliente = getClienteId(id);

        cliente.setIdade(clienteDTO.getIdade());

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