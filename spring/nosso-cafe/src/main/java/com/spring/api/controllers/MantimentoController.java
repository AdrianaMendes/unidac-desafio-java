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
	
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody final MantimentoRequestDto request) {
		this.service.save(request);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<MantimentoResponseDto>> findAll() {
		return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
	}
}
