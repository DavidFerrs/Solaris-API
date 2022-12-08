package com.api.solaris.service;
import com.api.solaris.dto.ModuloDTO;
import com.api.solaris.exception.EntityAlreadyExistsException;
import com.api.solaris.exception.EntityNotFoundException;
import com.api.solaris.model.Modulo;
import com.api.solaris.repository.ModuloRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModuloServiceImpl implements ModuloService {

    @Autowired
    private ModuloRepository moduloRepository;

    @Autowired
    public ModelMapper modelMapper;


    @Override
    public void removerModuloCadastrado(Long id) throws EntityNotFoundException {
        Modulo modulo = getModulo(id);
        moduloRepository.delete(modulo);
    }

    private Modulo getModulo(Long id) throws EntityNotFoundException {
        return moduloRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
    }

    private boolean isModuloCadastrado(Long id) {
        try {
            getModulo(id);
            return true;
        } catch (EntityNotFoundException e) {
            return false;
        }
    }
    private void salvarModulo(Modulo modulo) {
        moduloRepository.save(modulo);
    }
    public ModuloDTO addModulo(ModuloDTO moduloDTO) throws EntityAlreadyExistsException{
        if(isModuloCadastrado(moduloDTO.getId())) {
            throw new EntityAlreadyExistsException();
        }

        Modulo modulo = new Modulo(moduloDTO.getModelo(), moduloDTO.getFabricante(), moduloDTO.getPotencia());
        salvarModulo(modulo);
        return modelMapper.map(modulo, ModuloDTO.class);
    }

    @Override
    public List<ModuloDTO> listarModulos() {
        List<ModuloDTO> modulos = moduloRepository.findAll()
                .stream()
                .map(modulo -> modelMapper.map(modulo, ModuloDTO.class))
                .collect(Collectors.toList());
        return modulos;
    }

    @Override
    public ModuloDTO getModuloDTO(long id) throws EntityNotFoundException {
        Modulo modulo = getModulo(id);
        return modelMapper.map(modulo, ModuloDTO.class);
    }

    @Override
    public ModuloDTO atualizarModulo(long id, ModuloDTO moduloDTO) throws EntityNotFoundException{
        Modulo modulo = getModulo(id);
        modulo.setModelo(moduloDTO.getModelo());
        modulo.setFabricante(modulo.getFabricante());
        modulo.setPotencia(modulo.getPotencia());
        salvarModulo(modulo);

        return modelMapper.map(modulo, ModuloDTO.class);
    }


}
