package com.spring.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.spring.api.dtos.ColaboradorRequestDto;
import com.spring.api.dtos.ColaboradorResponseDto;
import com.spring.api.entities.ColaboradorEntity;
import com.spring.api.entities.MantimentoEntity;
import com.spring.api.repositories.ColaboradorRepository;
import com.spring.api.repositories.MantimentoRepository;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repository;

	@Autowired
	private MantimentoRepository mantimentoRepository;

	public void addMantimento(final Long colaboradorId, final Long mantimentoId) {

		final ColaboradorEntity colaborador = this.repository.findByIdNativeQuery(colaboradorId);
		final MantimentoEntity mantimento = this.mantimentoRepository.findByIdNativeQuery(mantimentoId);

		if (colaborador == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Colaborador de id: " + colaboradorId + " não encontrado.");
		}

		if (mantimento == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mantimento de id: " + mantimentoId + " não encontrado.");
		}

		if (mantimento.getColaborador() != null) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"Colaborador " + mantimento.getColaborador().getNome() + " já está levando " + mantimento.getDescricao() + ".");
		}

		this.repository.addMantimentoNativeQuery(colaboradorId, mantimentoId);
	}

	public void deleteById(final Long id) {
		final ColaboradorEntity colaborador = this.repository.findByIdNativeQuery(id);

		if (colaborador == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Colaborador de id: " + id + " não encontrado.");
		}

		this.repository.deleteMantimentoFromColaborador(id);
		this.repository.deleteByIdNativeQuery(id);
	}

	public List<ColaboradorResponseDto> findAll() {
		return ColaboradorResponseDto.toListDto(repository.findAllNativeQuery());
	}
	
	public void update(final ColaboradorRequestDto request) {
		this.repository.updateNativeQuery(request.getId(), request.getNome());
	}

	public void save(final ColaboradorRequestDto request) {
		if (this.repository.findByCpfNativeQuery(request.getCpfNumber()) != null) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "CPF registrado.");
		}
		this.repository.saveNativeQuery(request.getNome(), request.getCpfNumber());
	}
}
