package com.api.user.Dto.v1;


import jakarta.validation.constraints.NotBlank;

public class UserDto {

    @NotBlank
    private String name;

    @NotBlank
    private String cpf;

    private Integer cep;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }
}
