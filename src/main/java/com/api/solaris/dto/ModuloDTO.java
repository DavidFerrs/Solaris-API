package com.api.solaris.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModuloDTO {
    private long id;

    private String modelo;
    private String fabricante;
    private Double potencia;

}