package org.serratec.backend.projetoFinal.controller;

import java.util.List;

import org.serratec.backend.projetoFinal.exception.ParametroObrigatorioException;
import org.serratec.backend.projetoFinal.exception.PedidoNotFoundException;
import org.serratec.backend.projetoFinal.model.Pedido;
import org.serratec.backend.projetoFinal.service.PedidoService;
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
@RequestMapping("/api/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Pedido pedido) {
		pedidoService.inserir(pedido);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Pedido> listar() {
		return pedidoService.listar();
	}
	
	@GetMapping("/{codigo}")
	public Pedido listarPorCodigo(@PathVariable Integer codigo) throws PedidoNotFoundException {
		return pedidoService.listarPorCodigo(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Void> substituir(@PathVariable Integer codigo, @RequestBody(required = true) Pedido pedido)
			throws PedidoNotFoundException, ParametroObrigatorioException {
		pedidoService.substituir(codigo, pedido);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{codigo}")
	public void deletar(@PathVariable Integer codigo) throws PedidoNotFoundException {
		pedidoService.deletar(codigo);
	}

}
