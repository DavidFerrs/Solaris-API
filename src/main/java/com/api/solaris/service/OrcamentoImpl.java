package com.api.solaris.service;
import com.api.solaris.dto.CalculoOrcamentoDTO;
import com.api.solaris.dto.OrcamentoDTO;
import com.api.solaris.exception.EntityNotFoundException;
import com.api.solaris.model.Orcamento;
import com.api.solaris.repository.OrcamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrcamentoImpl implements OrcamentoService{
    @Autowired
    private OrcamentoRepository orcamentoRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public void removerOrcamentoCadastrado(Long id) throws EntityNotFoundException {
        Orcamento orcamento = getOrcamento(id);
        orcamentoRepository.delete(orcamento);
    }

    private Orcamento getOrcamento(Long id) throws EntityNotFoundException {
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
//    public OrcamentoDTO addOrcamento(OrcamentoDTO orcamentoDTO) throws EntityAlreadyExistsException {
//        if(isOrcamentoCadastrado(orcamentoDTO.getId())) {
//            throw new EntityAlreadyExistsException();
//        }
//
//        Orcamento orcamento = new Orcamento(orcamentoDTO.getPotenciaInversor(), orcamentoDTO.getTipoFase(), orcamentoDTO.getConsumoCliente());
//        salvarOrcamento(orcamento);
//        return modelMapper.map(orcamento, OrcamentoDTO.class);
//    }

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
        return modelMapper.map(orcamento, OrcamentoDTO.class);
    }


    @Override
    public CalculoOrcamentoDTO calculaOrcamento(OrcamentoDTO orcamentoDTO){
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

        this.salvarOrcamento(orcamento);

        return modelMapper.map(orcamento, CalculoOrcamentoDTO.class);
    }



}
