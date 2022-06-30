package com.spring.api.dtos;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.caelum.stella.bean.validation.CPF;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ColaboradorRequestDto {

	private Long id;
	
	@ApiModelProperty(value = "Nome do colaborador", example = "Machado de Assis")
	@NotBlank(message = "Campo nome obrigatório.")
	@Size(message = "Limite máximo de 64 caracteres.", max = 64)
	private String nome;

	@ApiModelProperty(value = "CPF do colaborador", example = "138.471.630-00")
	@NotBlank(message = "Campo CPF obrigatório.")
	@CPF(message = "CPF inválido.")
	private String cpf;
	
	private List<MantimentoRequestDto> listaMantimentos;

	public String getCpfNumber() {
		return cpf.replaceAll("\\D", "");
	}
}
