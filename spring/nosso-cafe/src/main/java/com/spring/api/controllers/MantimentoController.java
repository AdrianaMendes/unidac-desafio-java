package com.spring.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.dtos.MantimentoRequestDto;
import com.spring.api.dtos.MantimentoResponseDto;
import com.spring.api.services.MantimentoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("mantimento")
@Api(tags = "Mantimentos")
public class MantimentoController {

	@Autowired
	private MantimentoService service;

	@DeleteMapping(path = "delete")
	public ResponseEntity<Void> delete(@RequestParam final Long id) {
		this.service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping(path = "findAll")
	public ResponseEntity<List<MantimentoResponseDto>> findAll() {
		return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
	}

	@PostMapping(path = "save")
	public ResponseEntity<Void> save(@Valid @RequestBody final MantimentoRequestDto request) {
		this.service.save(request);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
