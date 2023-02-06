package com.api.solaris.controller;
import com.api.solaris.dto.CalculoOrcamentoDTO;
import com.api.solaris.dto.OrcamentoDTO;
import com.api.solaris.exception.EntityAlreadyExistsException;
import com.api.solaris.exception.EntityNotFoundException;
import com.api.solaris.service.OrcamentoService;
import com.api.solaris.util.ErroAdministrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class OrcamentoController {
    @Autowired
    OrcamentoService orcamentoService;

//    @PostMapping(value = "/orcamento/")
//    public ResponseEntity<?> criarOrcamento(@RequestBody OrcamentoDTO orcamentoDTO) {
//        try {
//            OrcamentoDTO orcamento = orcamentoService.addOrcamento(orcamentoDTO);
//            return new ResponseEntity<OrcamentoDTO>(orcamento, HttpStatus.CREATED);
//        } catch (EntityAlreadyExistsException e) {
//            return new ResponseEntity<String>("orcamento ja cadastrado", HttpStatus.CONFLICT);
//        }
//    }

    @PostMapping(value = "/orcamento/")
    public ResponseEntity<?> calculaOrcamento(@RequestBody OrcamentoDTO orcamentoDTO) {
        try {
            OrcamentoDTO orcamento = orcamentoService.calculaOrcamento(orcamentoDTO);
            return new ResponseEntity<OrcamentoDTO>(orcamento, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/orcamentos")
    public ResponseEntity<?> listarOrcamentos() {
        List<OrcamentoDTO> orcamentos = orcamentoService.listarOrcamentos();
        return new ResponseEntity<List<OrcamentoDTO>>(orcamentos, HttpStatus.OK);
    }

    @DeleteMapping(value = "/orcamento/{id}")
    public ResponseEntity<?> removerOrcamentoCadastrado(@PathVariable("id") long id) {

        try {
            orcamentoService.removerOrcamentoCadastrado(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<String>("orcamento não encontrado", HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/orcamento/{id}")
    public ResponseEntity<?> consultarOrcamento(@PathVariable("id") long id) throws EntityNotFoundException{

        try {
            OrcamentoDTO orcamento = orcamentoService.getOrcamentoDTO(id);
            return new ResponseEntity<OrcamentoDTO>(orcamento, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<String>("orcamento não encontrado", HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "/orcamento/{id}")
    public ResponseEntity<?> atualizarOrcamento(@PathVariable("id") long id, @RequestBody OrcamentoDTO orcamentoDTO) throws EntityNotFoundException {

        OrcamentoDTO orcamento = orcamentoService.atualizarOrcamento(id, orcamentoDTO);
        return new ResponseEntity<OrcamentoDTO>(orcamento, HttpStatus.OK);
    }


}
