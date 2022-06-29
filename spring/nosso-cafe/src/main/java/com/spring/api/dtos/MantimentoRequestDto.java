package com.spring.api.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MantimentoRequestDto {
	@Size(max = 64)
	@NotBlank(message = "Campo descrição obrigatório.")
	@ApiModelProperty(value = "Descrição do item", example = "Pão de forma")
	private String descricao;
}
