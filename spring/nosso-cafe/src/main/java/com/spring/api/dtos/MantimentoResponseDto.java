package com.spring.api.dtos;

import java.util.List;

import com.spring.api.entities.MantimentoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MantimentoResponseDto {
	private Long id;
	private String descricao;
	
	public static List<MantimentoResponseDto> toListDto(final List<MantimentoEntity> listEntity) {
		return listEntity.stream().map(x -> new MantimentoResponseDto(x.getId(), x.getDescricao())).toList();
	}
}
