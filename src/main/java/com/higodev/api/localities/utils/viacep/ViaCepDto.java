package com.higodev.api.localities.utils.viacep;

import lombok.Data;

@Data
public class ViaCepDto {
    private String cep = "58000000";
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String unidade;
    private String ibge;
    private String gia;
}
