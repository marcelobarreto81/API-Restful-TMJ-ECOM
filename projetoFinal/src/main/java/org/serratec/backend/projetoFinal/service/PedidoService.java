package org.serratec.backend.projetoFinal.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetoFinal.exception.ParametroObrigatorioException;
import org.serratec.backend.projetoFinal.exception.PedidoNotFoundException;
import org.serratec.backend.projetoFinal.model.Pedido;
import org.serratec.backend.projetoFinal.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido inserir(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public List<Pedido> listar() {
		return pedidoRepository.findAll();
	}
	
	public Pedido listarPorCodigo(Integer codigo) throws PedidoNotFoundException {
		Optional<Pedido> opPedido = pedidoRepository.findById(codigo);

		if(opPedido.isPresent()) {
			return opPedido.get();
		}
		
		throw new PedidoNotFoundException("Pedido com código " + codigo + " não encontrada");
	}
	
	public Pedido substituir(Integer codigo, Pedido pedido) throws ParametroObrigatorioException, PedidoNotFoundException {
		if(pedido == null) throw new ParametroObrigatorioException("Campo 'Pedido' é obrigatório");
		
		Pedido pedidoNoBanco = listarPorCodigo(codigo);
				
		if(pedido.getCodigoPedido() != null) {
			pedidoNoBanco.setCodigoPedido(pedido.getCodigoPedido());
		}
		
		if(pedido.getDataPedido() != null) {
			pedidoNoBanco.setDataPedido(pedido.getDataPedido());
		}
		
		if(pedido.getValor() != null) {
			pedidoNoBanco.setValor(pedido.getValor());
		}
		
		return pedidoRepository.save(pedidoNoBanco);
	}
	
	public void deletar(Integer codigo) throws PedidoNotFoundException{
		Pedido pedidoNoBanco = listarPorCodigo(codigo);
		pedidoRepository.delete(pedidoNoBanco);
	}
}
