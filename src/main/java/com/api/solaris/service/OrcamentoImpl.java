package com.api.solaris.service;
import com.api.solaris.dto.ClienteDTO;
import com.api.solaris.dto.OrcamentoDTO;
import com.api.solaris.dto.PedidoDTO;
import com.api.solaris.exception.EntityAlreadyExistsException;
import com.api.solaris.exception.EntityNotFoundException;
import com.api.solaris.model.Orcamento;
import com.api.solaris.model.Pedido;
import com.api.solaris.repository.OrcamentoRepository;
import com.api.solaris.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrcamentoImpl implements OrcamentoService{
    @Autowired
    private OrcamentoRepository orcamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public void removerOrcamentoCadastrado(Long id) throws EntityNotFoundException {
        Orcamento orcamento = getOrcamento(id);
        orcamentoRepository.delete(orcamento);
    }

    @Override
    public Orcamento getOrcamento(Long id) throws EntityNotFoundException {
        return orcamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
    }

    private boolean isOrcamentoCadastrado(Long id) {
        try {
            getOrcamento(id);
            return true;
        } catch (EntityNotFoundException e) {
            return false;
        }
    }
    private void salvarOrcamento(Orcamento orcamento) {
        orcamentoRepository.save(orcamento);
    }

    @Override
    public OrcamentoDTO addOrcamento(OrcamentoDTO orcamentoDTO){
//        if(isOrcamentoCadastrado(orcamentoDTO.getId())) {
//            throw new EntityAlreadyExistsException();
//        }

        Orcamento orcamento = new Orcamento(orcamentoDTO.getTipoMedia(), orcamentoDTO.getTaxaDeRetorno(), orcamentoDTO.getMediaConsumo(), orcamentoDTO.getTipoFase(),
                orcamentoDTO.getEconomiaMensal(), orcamentoDTO.getEconomiaAnual(), orcamentoDTO.getPotenciaInversor(), orcamentoDTO.getQtdModulos(), orcamentoDTO.getCusto(), orcamentoDTO.getDataSolicitacao(), orcamentoDTO.getNomeCliente(), orcamentoDTO.isPedidoGerado());

        this.salvarOrcamento(orcamento);
        return modelMapper.map(orcamento, OrcamentoDTO.class);
    }

    @Override
    public List<OrcamentoDTO> listarOrcamentos() {
        List<OrcamentoDTO> orcamentos = orcamentoRepository.findAll()
                .stream()
                .map(orcamento -> modelMapper.map(orcamento, OrcamentoDTO.class))
                .collect(Collectors.toList());
        return orcamentos;
    }

    @Override
    public OrcamentoDTO getOrcamentoDTO(long id) throws EntityNotFoundException {
        Orcamento orcamento = getOrcamento(id);
        return modelMapper.map(orcamento, OrcamentoDTO.class);
    }

    @Override
    public OrcamentoDTO atualizarOrcamento(long id, OrcamentoDTO orcamentoDTO) throws EntityNotFoundException{

        Orcamento orcamento = getOrcamento(id);
        orcamento.setQtdModulos(orcamentoDTO.getQtdModulos());
        orcamento.setMediaConsumo(orcamentoDTO.getMediaConsumo());
        orcamento.setPotenciaInversor(orcamentoDTO.getPotenciaInversor());
        orcamento.setTipoMedia(orcamentoDTO.getTipoMedia());
        orcamento.setTipoFase(orcamentoDTO.getTipoFase());
        orcamento.setTaxaDeRetorno(orcamento.getTaxaDeRetorno());
        orcamento.setEconomiaMensal(orcamentoDTO.getEconomiaMensal());
        orcamento.setEconomiaAnual(orcamentoDTO.getEconomiaAnual());
        orcamento.setCusto(orcamentoDTO.getCusto());
        orcamento.setDataSolicitacao(orcamento.getDataSolicitacao());
        orcamento.setNomeCliente(orcamentoDTO.getNomeCliente());

        salvarOrcamento(orcamento);

        return modelMapper.map(orcamento, OrcamentoDTO.class);
    }

    @Override
    public OrcamentoDTO atualizarPedidoGerado(long id, OrcamentoDTO orcamentoDTO) throws EntityNotFoundException{

        Orcamento orcamento = getOrcamento(id);
        orcamento.setPedidoGerado(orcamentoDTO.isPedidoGerado());

        salvarOrcamento(orcamento);

        return modelMapper.map(orcamento, OrcamentoDTO.class);
    }


    @Override
    public OrcamentoDTO calculaOrcamento(OrcamentoDTO orcamentoDTO){
        double HORAS_DIARIAS = 4.93;
        double POTENCIA_MODULO = 340;
        double preçoKWHparaiba = 0.53644;

        double energia = POTENCIA_MODULO * HORAS_DIARIAS * (1 - 0.20);
        double energiaMes = (energia * 30) / 1000;


        int qtdModulos = (int) (orcamentoDTO.getMediaConsumo() / energiaMes);
        double potInversor = (qtdModulos * POTENCIA_MODULO); // kWp

        double ecoMes = potInversor * preçoKWHparaiba;
        double ecoAno = ecoMes * 12;

        double custo = Math.floor(Math.random() * (25000 - 8000 + 1) + 8000);
        int taxaRetorno = (int)Math.floor(Math.random() * (84 - 23 + 1) + 23);

        Orcamento orcamento = new Orcamento(orcamentoDTO.getTipoMedia(), taxaRetorno, orcamentoDTO.getMediaConsumo(), orcamentoDTO.getTipoFase(),
                ecoMes, ecoAno, (potInversor/ 1000), qtdModulos, custo, orcamentoDTO.getDataSolicitacao(), orcamentoDTO.getNomeCliente(), orcamentoDTO.isPedidoGerado());

        salvarOrcamento(orcamento);

        return modelMapper.map(orcamento, OrcamentoDTO.class);
    }

    private void salvarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public PedidoDTO criarPedido(PedidoDTO pedidoDTO) throws EntityAlreadyExistsException, EntityNotFoundException {

//        this.nomeCliente = nomeCliente;
//        this.dataSolicitacao = dataSolicitacao;
//        this.custoTotal = custoTotal;
//        this.status = status;
//        this.tipoMedia = tipoMedia;
//        this.mediaConsumo = mediaConsumo;
//        this.tipoFase = tipoFase;
//        this.taxaDeRetorno = taxaDeRetorno;
//        this.economiaMensal = economiaMensal;
//        this.economiaAnual = economiaAnual;
//        this.potenciaInversor = potenciaInversor;
//        this.qtdModulos = qtdModulos;
//        this.pedidoGerado = pedidoGerado;

        Pedido pedido = new Pedido(pedidoDTO.getNomeCliente(), pedidoDTO.getDataSolicitacao(),
                pedidoDTO.getCustoTotal(), pedidoDTO.getStatus(),pedidoDTO.getTipoMedia(),pedidoDTO.getMediaConsumo(),
                pedidoDTO.getTipoFase(), pedidoDTO.getTaxaDeRetorno(), pedidoDTO.getEconomiaMensal(), pedidoDTO.getEconomiaAnual(),
                pedidoDTO.getPotenciaInversor(), pedidoDTO.getQtdModulos(), pedidoDTO.getOrcamentoId());
        salvarPedido(pedido);
        return modelMapper.map(pedido, PedidoDTO.class);
    }


    @Override
    public List<PedidoDTO> listarPedidos() {
        List<PedidoDTO> clientes = pedidoRepository.findAll()
                .stream()
                .map(cliente -> modelMapper.map(cliente, PedidoDTO.class))
                .collect(Collectors.toList());
        return clientes;
    }

    @Override
    public PedidoDTO getPedidoDTO(long id) throws EntityNotFoundException {

        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(pedido, PedidoDTO.class);
    }





}
