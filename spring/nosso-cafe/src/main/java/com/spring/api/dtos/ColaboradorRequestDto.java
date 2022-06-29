package com.spring.api.dtos;

import javax.validation.constraints.NotBlank;

import br.com.caelum.stella.bean.validation.CPF;
import lombok.Getter;

@Getter
public class ColaboradorRequestDto {
	@NotBlank(message = "Campo nome obrigatório.")
	private String nome;
	
	@NotBlank(message = "Campo CPF obrigatório.")
	@CPF(message = "CPF inválido.")
	private String cpf;
}
