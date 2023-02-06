//package com.api.solaris.service;
//
//import com.api.solaris.dto.ModuloDTO;
//import com.api.solaris.dto.OrcamentoDTO;
//import com.api.solaris.dto.PedidoDTO;
//import com.api.solaris.exception.EntityAlreadyExistsException;
//import com.api.solaris.exception.EntityNotFoundException;
//import com.api.solaris.model.Modulo;
//import com.api.solaris.model.Orcamento;
//import com.api.solaris.model.Pedido;
//import com.api.solaris.repository.OrcamentoRepository;
//import com.api.solaris.repository.PedidoRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class PedidoServiceImp implements PedidoService {
//    @Autowired
//    private PedidoRepository pedidoRepository;
//
//    @Autowired
//    private OrcamentoService orcamentoService;
//
//    @Autowired
//    public ModelMapper modelMapper;
//
//    private void salvarPedido(Pedido pedido) {
//        pedidoRepository.save(pedido);
//    }
//
////    private Orcamento getOrcamento(Long id) throws EntityNotFoundException {
////        return orcamentoRepository.findById(id)
////                .orElseThrow(() -> new EntityNotFoundException());
////    }
//
//    @Override
//    public PedidoDTO criarPedido( PedidoDTO pedidoDTO) throws EntityAlreadyExistsException, EntityNotFoundException {
////        if(isModuloCadastrado(moduloDTO.getId())) {
////            throw new EntityAlreadyExistsException();
////        }
////        System.out.println(pedidoDTO.getOrcamento());
//        Orcamento orcamento = orcamentoService.getOrcamento(pedidoDTO.getOrcamentoId());
////        System.out.println(orcamento.toString());
////
////        Orcamento orcamento = new Orcamento(pedidoDTO.getTipoMedia(), pedidoDTO.getTaxaDeRetorno(), pedidoDTO.getMediaConsumo(), pedidoDTO.getTipoFase(),
////                pedidoDTO.getEconomiaMensal(), pedidoDTO.getEconomiaAnual(), pedidoDTO.getPotenciaInversor(), pedidoDTO.getQtdModulos(), pedidoDTO.getCusto(), pedidoDTO.getDataSolicitacao(), pedidoDTO.getNomeCliente(), pedidoDTO.isPedidoGerado());
//
//
//
//
//
//        Pedido pedido = new Pedido(orcamento,pedidoDTO.getStatus());
//        System.out.println(pedido);
//        salvarPedido(pedido);
//        return modelMapper.map(pedido, PedidoDTO.class);
//    }
//
////    @Override
//    public List<PedidoDTO> listarPedidos() {
//        List<PedidoDTO> pedidos = pedidoRepository.findAll()
//                .stream()
//                .map(pedido -> modelMapper.map(pedido, PedidoDTO.class))
//                .collect(Collectors.toList());
//        return pedidos;
//    }
//
//}
