package com.spring.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.dtos.MantimentoRequestDto;
import com.spring.api.dtos.MantimentoResponseDto;
import com.spring.api.repositories.MantimentoRepository;

@Service
public class MantimentoService {

	@Autowired
	private MantimentoRepository repository;

	public void deleteById(final Long id) {
		repository.deleteByIdNativeQuery(id);
	}

	public List<MantimentoResponseDto> findAll() {
		return MantimentoResponseDto.toListDto(repository.findAllNativeQuery());
	}

	public void save(final MantimentoRequestDto request) {
		repository.saveNativeQuery(request.getDescricao());
	}
}
