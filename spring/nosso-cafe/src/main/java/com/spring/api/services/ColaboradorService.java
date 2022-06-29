package com.spring.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.spring.api.dtos.ColaboradorRequestDto;
import com.spring.api.dtos.ColaboradorResponseDto;
import com.spring.api.repositories.ColaboradorRepository;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repository;

	public void addMantimento(final Long colaboradorId, final Long mantimentoId) {
		repository.addMantimentoNativeQuery(colaboradorId, mantimentoId);
	}

	public List<ColaboradorResponseDto> findAll() {
		return ColaboradorResponseDto.toListDto(repository.findAllNativeQuery());
	}

	public void save(final ColaboradorRequestDto request) {
		if (this.repository.findByCpfNativeQuery(request.getCpfNumber()).size() != 0) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "CPF registrado.");
		}
		repository.saveNativeQuery(request.getNome(), request.getCpfNumber());
	}

}
