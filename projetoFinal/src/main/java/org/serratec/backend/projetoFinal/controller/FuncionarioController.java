package org.serratec.backend.projetoFinal.controller;

import java.util.List;

import org.serratec.backend.projetoFinal.exception.FuncionarioNotFoundException;
import org.serratec.backend.projetoFinal.exception.ParametroObrigatorioException;
import org.serratec.backend.projetoFinal.model.Funcionario;
import org.serratec.backend.projetoFinal.service.FuncionarioService;
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
@RequestMapping("api/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Funcionario funcionario) {
		funcionarioService.inserir(funcionario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Funcionario> listar() {
		return funcionarioService.listar();
	}
	
	@GetMapping("/{codigo}")
	public Funcionario listarPorCodigo(@PathVariable Integer codigo) throws FuncionarioNotFoundException {
		return funcionarioService.listarPorCodigo(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Void> substituir(@PathVariable Integer codigo, @RequestBody(required = true) Funcionario funcionario)
			throws FuncionarioNotFoundException, ParametroObrigatorioException {
		funcionarioService.substituir(codigo, funcionario);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{codigo}")
	public void deletar(@PathVariable Integer codigo) throws FuncionarioNotFoundException {
		funcionarioService.deletar(codigo);
	}
}
