package org.serratec.backend.projetoFinal.controller;

import java.util.List;

import org.serratec.backend.projetoFinal.exception.ClienteNotFoundException;
import org.serratec.backend.projetoFinal.exception.ParametroObrigatorioException;
import org.serratec.backend.projetoFinal.form.ClienteForm;
import org.serratec.backend.projetoFinal.model.Cliente;
import org.serratec.backend.projetoFinal.repository.EnderecoRepository;
import org.serratec.backend.projetoFinal.service.ClienteService;
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
@RequestMapping("api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody ClienteForm cliente) {
		Cliente novo = cliente.converte(enderecoRepository);
		clienteService.inserir(novo);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteService.listar();
	}
	
	@GetMapping("/{codigo}")
	public Cliente listarPorCodigo(@PathVariable Integer codigo) throws ClienteNotFoundException {
		return clienteService.listarPorCodigo(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Void> substituir(@PathVariable Integer codigo, @RequestBody(required = true) Cliente cliente)
			throws ClienteNotFoundException, ParametroObrigatorioException {
		clienteService.substituir(codigo, cliente);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{codigo}")
	public void deletar(@PathVariable Integer codigo) throws ClienteNotFoundException {
		clienteService.deletar(codigo);
	}
	
}
