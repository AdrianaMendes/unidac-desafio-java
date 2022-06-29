package com.spring.api.config;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;

@XmlRootElement(name = "error")
@Data
@AllArgsConstructor
public class ErrorResponse {
	private String message;
}