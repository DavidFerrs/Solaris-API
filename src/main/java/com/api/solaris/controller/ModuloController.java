package com.api.solaris.controller;

import com.api.solaris.dto.ModuloDTO;
import com.api.solaris.exception.EntityAlreadyExistsException;
import com.api.solaris.exception.EntityNotFoundException;
import com.api.solaris.service.ModuloService;
import com.api.solaris.util.ErroAdministrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ModuloController {
    @Autowired
    ModuloService moduloService;

    @PostMapping(value = "/modulo/")
    public ResponseEntity<?> criarModulo(@RequestBody ModuloDTO moduloDTO) {
        try {
            ModuloDTO modulo = moduloService.addModulo(moduloDTO);
            return new ResponseEntity<ModuloDTO>(modulo, HttpStatus.CREATED);
        } catch (EntityAlreadyExistsException e) {
            return new ResponseEntity<String>("modulo ja cadastrado", HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/modulos")
    public ResponseEntity<?> listarModulos() {
        List<ModuloDTO> modulos = moduloService.listarModulos();
        if (modulos.isEmpty()) {
            return ErroAdministrador.erroSemAdministradoresCadastrados();
        }
        return new ResponseEntity<List<ModuloDTO>>(modulos, HttpStatus.OK);
    }

    @DeleteMapping(value = "/modulo/{id}")
    public ResponseEntity<?> removerModuloCadastrado(@PathVariable("id") long id) {

        try {
            moduloService.removerModuloCadastrado(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<String>("modulo não encontrado", HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/modulo/{id}")
    public ResponseEntity<?> consultarModulo(@PathVariable("id") long id) throws EntityNotFoundException{

        try {
            ModuloDTO modulo = moduloService.getModuloDTO(id);
            return new ResponseEntity<ModuloDTO>(modulo, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<String>("modulo não encontrado", HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "/modulo/{id}")
    public ResponseEntity<?> atualizarModulo(@PathVariable("id") long id, @RequestBody ModuloDTO administradorDTO) throws EntityNotFoundException {

        ModuloDTO modulo = moduloService.atualizarModulo(id, administradorDTO);
        return new ResponseEntity<ModuloDTO>(modulo, HttpStatus.OK);
    }
}
