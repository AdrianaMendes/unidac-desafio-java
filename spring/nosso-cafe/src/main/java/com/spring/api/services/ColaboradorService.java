package com.spring.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.dtos.ColaboradorRequestDto;
import com.spring.api.dtos.ColaboradorResponseDto;
import com.spring.api.repositories.ColaboradorRepository;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repository;
	
	public void save(final ColaboradorRequestDto request) {
		repository.saveNativeQuery(request.getNome(), request.getCpf());
	}
	
	public List<ColaboradorResponseDto> findAll() {
		return ColaboradorResponseDto.toListDto(repository.findAllNativeQuery());
	}
	
}
