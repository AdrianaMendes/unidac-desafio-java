package com.spring.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody final ColaboradorRequestDto request) {
		this.service.save(request);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ColaboradorResponseDto>> findAll() {
		return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
	}
}
