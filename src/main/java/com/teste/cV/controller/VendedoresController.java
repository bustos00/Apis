package com.teste.cV.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.teste.cV.model.Vendedores;
import com.teste.cV.repository.VendedoresRepository;


@RestController
@RequestMapping("/vendedores")
public class VendedoresController {
	
	@Autowired
	private VendedoresRepository repository;

	//Listar vendedores
	
	@GetMapping
	public ResponseEntity<List<Vendedores>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	} 

	//adicionar vendedores
	
	@PostMapping
	public ResponseEntity<Vendedores> post(@Valid @RequestBody Vendedores vendedores) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(vendedores));

	}
	
	// excluir vendedores
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		Optional<Vendedores> post = repository.findById(id);

		if (post.isEmpty())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

		repository.deleteById(id);
	}

}
