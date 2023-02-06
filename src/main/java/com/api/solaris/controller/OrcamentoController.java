package com.api.solaris.controller;
import com.api.solaris.dto.CalculoOrcamentoDTO;
import com.api.solaris.dto.OrcamentoDTO;
import com.api.solaris.dto.PedidoDTO;
import com.api.solaris.exception.EntityAlreadyExistsException;
import com.api.solaris.exception.EntityNotFoundException;
import com.api.solaris.service.OrcamentoService;
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


    @PutMapping(value = "/orcamento/pedidogerado/{id}")
    public ResponseEntity<?> confirmarPedidoGerado(@PathVariable("id") long id, @RequestBody OrcamentoDTO orcamentoDTO) throws EntityNotFoundException {

        OrcamentoDTO orcamento = orcamentoService.confirmarPedidoGerado(id);
        return new ResponseEntity<OrcamentoDTO>(orcamento, HttpStatus.OK);
    }


    // PEDIDOS API // _+_+_+_+_+_+_+_+_+=-=-=-=--=-=-=-=--==-=-=--==--==-=-

    @PostMapping(value = "/pedido/")
    public ResponseEntity<?> calculaOrcamento(@RequestBody PedidoDTO pedidoDTO) {
        try {
            PedidoDTO pedido = orcamentoService.criarPedido(pedidoDTO);
            return new ResponseEntity<PedidoDTO>(pedido, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<String>("orcamento não encontrado", HttpStatus.CONFLICT);
        } catch (EntityAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value = "/pedido/{id}")
    public ResponseEntity<?> consultarPedido(@PathVariable("id") long id) throws EntityNotFoundException{

        try {
            PedidoDTO pedido = orcamentoService.getPedidoDTO(id);
            return new ResponseEntity<PedidoDTO>(pedido, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<String>("pedido não encontrado", HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/pedidos")
    public ResponseEntity<?> listarPedidos() {
        List<PedidoDTO> pedidos = orcamentoService.listarPedidos();
        return new ResponseEntity<List<PedidoDTO>>(pedidos, HttpStatus.OK);
    }

    @PutMapping(value = "/pedido/confirmar/{id}")
    public ResponseEntity<?> atualizarStatusPedidoConfirmar(@PathVariable("id") long id) throws EntityNotFoundException {

        PedidoDTO pedido = orcamentoService.atualizarStatusPedidoConfirmar(id);
        return new ResponseEntity<PedidoDTO>(pedido, HttpStatus.OK);
    }

    @PutMapping(value = "/pedido/cancelar/{id}")
    public ResponseEntity<?> atualizarStatusPedidoCancelar(@PathVariable("id") long id) throws EntityNotFoundException {

        PedidoDTO pedido = orcamentoService.atualizarStatusPedidoCancelar(id);
        return new ResponseEntity<PedidoDTO>(pedido, HttpStatus.OK);
    }


}
