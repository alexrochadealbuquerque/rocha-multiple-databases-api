package com.br.rocha.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.rocha.services.ClienteService;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteResources {

	@Autowired
	private ClienteService service;

	@GetMapping
	public ResponseEntity<List<String>> getAllClientes() {
		List<String> obj = service.getAllClientes();
		return ResponseEntity.ok().body(obj);
	}

}
