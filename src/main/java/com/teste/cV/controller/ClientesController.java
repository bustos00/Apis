package com.teste.cV.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.teste.cV.model.Clientes;
import com.teste.cV.repository.ClientesRepository;


@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClientesController {
	
	@Autowired
	private ClientesRepository repository;

	//Listar clientes
	
	@GetMapping
	public ResponseEntity<List<Clientes>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	} 

	//adicionar clientes
	
	@PostMapping
	public ResponseEntity<Clientes> post(@Valid @RequestBody Clientes clientes) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(clientes));

	}
	
	// excluir clientes
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		Optional<Clientes> post = repository.findById(id);

		if (post.isEmpty())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

		repository.deleteById(id);
	}

}
