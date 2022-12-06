package com.api.solaris.util;

import com.api.solaris.dto.AdministradorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErroAdministrador {

    static final String ADMINISTRADOR_NAO_CASTRADO = "Administrador com id %s não está cadastrado";

    static final String ADMINISTRADORES_NAO_CASTRADOS = "Não há administradores cadastrados";

    static final String ADMINISTRADOR_JA_CADASTRADO = "O administrador com login %s já esta cadastrado";

    public static ResponseEntity<CustomErrorType> erroAdministradorNaoEncontrado(long id) {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(ErroAdministrador.ADMINISTRADOR_NAO_CASTRADO, id)),
                HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<CustomErrorType> erroSemAdministradoresCadastrados() {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(ErroAdministrador.ADMINISTRADORES_NAO_CASTRADOS),
                HttpStatus.NO_CONTENT);
    }

    public static ResponseEntity<?> erroAdministradorJaCadastrado(AdministradorDTO administradorDTO) {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(ErroAdministrador.ADMINISTRADOR_JA_CADASTRADO, administradorDTO.getLogin())), HttpStatus.CONFLICT);
    }

}
