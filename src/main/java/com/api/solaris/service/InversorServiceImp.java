package com.api.solaris.service;

import com.api.solaris.dto.InversorDTO;
import com.api.solaris.exception.EntityAlreadyExistsException;
import com.api.solaris.exception.EntityNotFoundException;
import com.api.solaris.model.Inversor;
import com.api.solaris.repository.InversorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InversorServiceImp implements InversorService{

    @Autowired
    private InversorRepository inversorRepository;

    @Autowired
    public ModelMapper modelMapper;


    @Override
    public void removerInversorCadastrado(Long id) throws EntityNotFoundException {
        Inversor inversor = getInversor(id);
        inversorRepository.delete(inversor);
    }

    private Inversor getInversor(Long id) throws EntityNotFoundException {
        return inversorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
    }

    private boolean isInversorCadastrado(Long id) {
        try {
            getInversor(id);
            return true;
        } catch (EntityNotFoundException e) {
            return false;
        }
    }
    private void salvarInversor(Inversor inversor) {
        inversorRepository.save(inversor);
    }

    public InversorDTO addInversor(InversorDTO inversorDTO) throws EntityAlreadyExistsException {
        if(isInversorCadastrado(inversorDTO.getId())) {
            throw new EntityAlreadyExistsException();
        }

        Inversor inversor = new Inversor(inversorDTO.getModelo(), inversorDTO.getFabricante(), inversorDTO.getPotencia());
        salvarInversor(inversor);
        return modelMapper.map(inversor, InversorDTO.class);
    }

    @Override
    public List<InversorDTO> listarInversors() {
        List<InversorDTO> inversors = inversorRepository.findAll()
                .stream()
                .map(inversor -> modelMapper.map(inversor, InversorDTO.class))
                .collect(Collectors.toList());
        return inversors;
    }


    @Override
    public InversorDTO getInversorDTO(long id) throws EntityNotFoundException {
        Inversor inversor = getInversor(id);
        return modelMapper.map(inversor, InversorDTO.class);
    }

    @Override
    public InversorDTO atualizarInversor(long id, InversorDTO inversorDTO) throws EntityNotFoundException{
        Inversor inversor = getInversor(id);
        inversor.setModelo(inversorDTO.getModelo());
        inversor.setFabricante(inversor.getFabricante());
        inversor.setPotencia(inversor.getPotencia());
        salvarInversor(inversor);

        return modelMapper.map(inversor, InversorDTO.class);
    }

}
