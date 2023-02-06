//package com.api.solaris.controller;
//
//import com.api.solaris.dto.OrcamentoDTO;
//import com.api.solaris.dto.PedidoDTO;
//import com.api.solaris.exception.EntityAlreadyExistsException;
//import com.api.solaris.exception.EntityNotFoundException;
//import com.api.solaris.model.Orcamento;
//import com.api.solaris.service.OrcamentoService;
//import com.api.solaris.service.PedidoService;
//import com.api.solaris.service.PedidoServiceImp;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//@CrossOrigin
//public class PedidoController {
//    @Autowired
//    PedidoService pedidoService;
//
//    @Autowired
//    OrcamentoService orcamentoService;
//
//    @PostMapping(value = "/pedido/")
//    public ResponseEntity<?> calculaOrcamento(@RequestBody PedidoDTO pedidoDTO) {
//        try {
//            System.out.println("controoelr");
//            PedidoDTO pedido = pedidoService.criarPedido(pedidoDTO);
//            return new ResponseEntity<PedidoDTO>(pedido, HttpStatus.CREATED);
//        } catch (EntityNotFoundException e) {
//            return new ResponseEntity<String>("orcamento não encontrado", HttpStatus.CONFLICT);
//        } catch (EntityAlreadyExistsException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
////    @GetMapping(value = "/pedidos")
////    public ResponseEntity<?> listarOrcamentos() {
////        List<PedidoDTO> pedidos = pedidoService.listarPedidos();
////        return new ResponseEntity<List<PedidoDTO>>(pedidos, HttpStatus.OK);
////    }
//
//
//}
