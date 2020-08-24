package org.serratec.backend.projetoFinal.controller;

import java.util.List;

import org.serratec.backend.projetoFinal.exception.ParametroObrigatorioException;
import org.serratec.backend.projetoFinal.exception.ProdutoExisteException;
import org.serratec.backend.projetoFinal.exception.ProdutoNotFoundException;
import org.serratec.backend.projetoFinal.form.ProdutoForm;
import org.serratec.backend.projetoFinal.model.Produto;
import org.serratec.backend.projetoFinal.repository.CategoriaRepository;
import org.serratec.backend.projetoFinal.repository.FuncionarioRepository;
import org.serratec.backend.projetoFinal.service.ProdutoService;
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
@RequestMapping("/api/produto")
public class produtoController {
	
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody ProdutoForm produtoForm) throws ProdutoExisteException {
		Produto produto = produtoForm.converte(categoriaRepository, funcionarioRepository);
		produtoService.inserir(produto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Produto> listar() {
		return produtoService.listar();
	}
	
	@GetMapping("/{codigo}")
	public Produto listarPorCodigo(@PathVariable Integer codigo) throws ProdutoNotFoundException {
		return produtoService.listarPorCodigo(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Void> substituir(@PathVariable Integer codigo, @RequestBody(required = true) Produto produto)
			throws ProdutoNotFoundException, ParametroObrigatorioException {
		produtoService.substituir(codigo, produto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{codigo}")
	public void deletar(@PathVariable Integer codigo) throws ProdutoNotFoundException {
		produtoService.deletar(codigo);
	}
}











