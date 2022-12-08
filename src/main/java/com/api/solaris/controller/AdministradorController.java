package com.api.solaris.controller;

import com.api.solaris.dto.AdministradorDTO;
import com.api.solaris.exception.AdministradorAlreadyCreatedException;
import com.api.solaris.exception.AdministradorNotFoundException;
import com.api.solaris.service.AdministradorService;
import com.api.solaris.util.ErroAdministrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AdministradorController {

    @Autowired
    AdministradorService administradorService;

    @PostMapping(value = "/administrador/")
    public ResponseEntity<?> criarAdministrador(@RequestBody AdministradorDTO administradorDTO) {
        try {
            AdministradorDTO administrador = administradorService.criaAdministrador(administradorDTO);
            return new ResponseEntity<AdministradorDTO>(administrador, HttpStatus.CREATED);
        } catch (AdministradorAlreadyCreatedException e) {
            return ErroAdministrador.erroAdministradorJaCadastrado(administradorDTO);
        }
    }

    @GetMapping(value = "/administradores")
    public ResponseEntity<?> listarAdministradores() {
        List<AdministradorDTO> administradores = administradorService.listarAdministradores();
        if (administradores.isEmpty()) {
            return ErroAdministrador.erroSemAdministradoresCadastrados();
        }
        return new ResponseEntity<List<AdministradorDTO>>(administradores, HttpStatus.OK);
    }

    @DeleteMapping(value = "/administrador/{id}")
    public ResponseEntity<?> removerAdministrador(@PathVariable("id") long id) {

        try {
            administradorService.removerAdministradorCadastrado(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (AdministradorNotFoundException e) {
            return ErroAdministrador.erroAdministradorNaoEncontrado(id);
        }
    }

    @GetMapping(value = "/administrador/{id}")
    public ResponseEntity<?> consultarAdministrador(@PathVariable("id") long id) {

        try {
            AdministradorDTO administrador = administradorService.getAdministradorById(id);
            return new ResponseEntity<AdministradorDTO>(administrador, HttpStatus.OK);
        } catch (AdministradorNotFoundException e) {
            return ErroAdministrador.erroAdministradorNaoEncontrado(id);
        }
    }

    @PutMapping(value = "/administrador/{id}")
    public ResponseEntity<?> atualizarAdministrador(@PathVariable("id") long id, @RequestBody AdministradorDTO administradorDTO) {

        try {
            AdministradorDTO administrador = administradorService.atualizaAdministrador(id, administradorDTO);
            return new ResponseEntity<AdministradorDTO>(administrador, HttpStatus.OK);
        } catch (AdministradorNotFoundException e) {
            return ErroAdministrador.erroAdministradorNaoEncontrado(id);
        }
    }

}
