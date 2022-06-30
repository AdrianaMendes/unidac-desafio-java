package com.spring.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.dtos.ColaboradorRequestDto;
import com.spring.api.dtos.ColaboradorResponseDto;
import com.spring.api.services.ColaboradorService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("colaborador")
@Api(tags = "Colaboradores")
public class ColaboradorController {

	@Autowired
	private ColaboradorService service;

	@PutMapping(path = "addMantimento")
	public ResponseEntity<Void> addMantimento(@RequestParam final Long colaboradorId, @RequestParam final Long mantimentoId) {
		this.service.addMantimento(colaboradorId, mantimentoId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(path = "delete")
	public ResponseEntity<Void> delete(@RequestParam final Long id) {
		this.service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping(path = "findAll")
	public ResponseEntity<List<ColaboradorResponseDto>> findAll() {
		return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
	}

	@PostMapping(path = "save")
	public ResponseEntity<Void> save(@Valid @RequestBody final ColaboradorRequestDto request) {
		this.service.save(request);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
