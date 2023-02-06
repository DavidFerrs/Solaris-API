package com.api.solaris.controller;

import com.api.solaris.dto.InversorDTO;
import com.api.solaris.dto.OrcamentoDTO;
import com.api.solaris.dto.PedidoDTO;
import com.api.solaris.exception.EntityAlreadyExistsException;
import com.api.solaris.exception.EntityNotFoundException;
import com.api.solaris.model.Orcamento;
import com.api.solaris.service.InversorService;
import com.api.solaris.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class InversorController {
    @Autowired
    InversorService inversorService;
    @PostMapping(value = "/inversor/")
    public ResponseEntity<?> criarinversor(@RequestBody InversorDTO InversorDTO) {
        try {
            InversorDTO inversor = inversorService.addInversor(InversorDTO);
            return new ResponseEntity<InversorDTO>(inversor, HttpStatus.CREATED);
        } catch (EntityAlreadyExistsException e) {
            return new ResponseEntity<String>("inversor ja cadastrado", HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/inversores")
    public ResponseEntity<?> listarinversors() {
        List<InversorDTO> inversors = inversorService.listarInversors();
        return new ResponseEntity<List<InversorDTO>>(inversors, HttpStatus.OK);
    }

    @DeleteMapping(value = "/inversor/{id}")
    public ResponseEntity<?> removerinversorCadastrado(@PathVariable("id") long id) {

        try {
            inversorService.removerInversorCadastrado(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<String>("inversor não encontrado", HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/inversor/{id}")
    public ResponseEntity<?> consultarinversor(@PathVariable("id") long id) throws EntityNotFoundException{

        try {
            InversorDTO inversor = inversorService.getInversorDTO(id);
            return new ResponseEntity<InversorDTO>(inversor, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<String>("inversor não encontrado", HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "/inversor/{id}")
    public ResponseEntity<?> atualizarinversor(@PathVariable("id") long id, @RequestBody InversorDTO administradorDTO) throws EntityNotFoundException {

        InversorDTO inversor = inversorService.atualizarInversor(id, administradorDTO);
        return new ResponseEntity<InversorDTO>(inversor, HttpStatus.OK);
    }
}
