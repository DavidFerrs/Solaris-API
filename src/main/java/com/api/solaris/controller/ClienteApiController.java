package com.api.solaris.controller;

import com.api.solaris.dto.ClienteDTO;
import com.api.solaris.exception.cliente.*;
import com.api.solaris.service.ClienteService;
import com.api.solaris.util.ErroCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClienteApiController {

	@Autowired
	ClienteService clienteService;

	@GetMapping(value = "/clientes")
	public ResponseEntity<?> listarClientes() {

		List<ClienteDTO> clientes = clienteService.listarClientes();
		return new ResponseEntity<List<ClienteDTO>>(clientes, HttpStatus.OK);
	}

	@PostMapping(value = "/cliente/")
	public ResponseEntity<?> criarCliente(@RequestBody ClienteDTO clienteDTO) {

		try {
			ClienteDTO cliente = clienteService.criaCliente(clienteDTO);
			return new ResponseEntity<ClienteDTO>(cliente, HttpStatus.CREATED);
		} catch (ClienteAlreadyCreatedException e) {
			return ErroCliente.erroClienteJaCadastrado(clienteDTO);
		}
	}

	@GetMapping(value = "/cliente/{id}")
	public ResponseEntity<?> consultarCliente(@PathVariable("id") Long id) {

		try {
			ClienteDTO cliente = clienteService.getClienteById(id);
			return new ResponseEntity<ClienteDTO>(cliente, HttpStatus.OK);
		} catch (ClienteNotFoundException e) {
			return ErroCliente.erroClienteNaoEnconrtrado(id);
		}
	}

	@PutMapping(value = "/cliente/{id}")
	public ResponseEntity<?> atualizarCliente(@PathVariable("id") Long id, @RequestBody ClienteDTO clienteDTO) {

		try {
			ClienteDTO cliente = clienteService.atualizaCliente(id, clienteDTO);
			return new ResponseEntity<ClienteDTO>(cliente, HttpStatus.OK);
		} catch (ClienteNotFoundException e) {
			return ErroCliente.erroClienteNaoEnconrtrado(id);
		}
	}

	@DeleteMapping(value = "/cliente/{id}")
	public ResponseEntity<?> removerCliente(@PathVariable("id") Long id) {

		try {
			clienteService.removerClienteCadastrado(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ClienteNotFoundException e) {
			return ErroCliente.erroClienteNaoEnconrtrado(id);
		}
	}
}