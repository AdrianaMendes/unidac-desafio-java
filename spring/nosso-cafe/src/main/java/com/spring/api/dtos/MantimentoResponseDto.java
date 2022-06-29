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
	public static List<MantimentoResponseDto> toListDto(final List<MantimentoEntity> listEntity) {
		return listEntity.stream().map(x -> new MantimentoResponseDto(x.getId(), x.getDescricao())).toList();
	}

	private Long id;

	private String descricao;
}
