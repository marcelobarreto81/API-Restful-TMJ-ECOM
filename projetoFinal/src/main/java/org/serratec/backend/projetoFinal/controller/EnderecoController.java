package org.serratec.backend.projetoFinal.controller;


import java.util.List;

import org.serratec.backend.projetoFinal.exception.EnderecoNotFoundException;
import org.serratec.backend.projetoFinal.exception.ParametroObrigatorioException;
import org.serratec.backend.projetoFinal.model.Endereco;
import org.serratec.backend.projetoFinal.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Endereco endereco) {
		enderecoService.inserir(endereco);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Endereco> listar() {
		return enderecoService.listar();
	}
	
	@GetMapping("/{codigo}")
	public Endereco listarPorCodigo(@PathVariable Integer codigo) throws EnderecoNotFoundException {
	return enderecoService.listarPorCodigo(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Void> substituir(@PathVariable Integer codigo, @RequestBody(required = true) Endereco endereco)
			throws EnderecoNotFoundException, ParametroObrigatorioException {
		enderecoService.substituir(codigo, endereco);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{codigo}")
	public void deletar(@PathVariable Integer codigo) throws EnderecoNotFoundException {
		enderecoService.deletar(codigo);
	}
	
	
}
