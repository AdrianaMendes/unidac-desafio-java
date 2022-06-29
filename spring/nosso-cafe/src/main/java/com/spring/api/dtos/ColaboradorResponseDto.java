package com.spring.api.dtos;

import java.util.List;

import com.spring.api.entities.ColaboradorEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColaboradorResponseDto {
	private Long id;
	private String nome;
	private String cpf;
	
	public static List<ColaboradorResponseDto> toListDto(final List<ColaboradorEntity> listEntity) {
		return listEntity.stream().map(x -> new ColaboradorResponseDto(x.getId(), x.getNome(), x.getCpf())).toList();
	}
}
