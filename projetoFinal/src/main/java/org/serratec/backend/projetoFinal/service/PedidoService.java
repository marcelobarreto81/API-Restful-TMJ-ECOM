package org.serratec.backend.projetoFinal.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetoFinal.exception.EstoqueException;
import org.serratec.backend.projetoFinal.exception.ParametroObrigatorioException;
import org.serratec.backend.projetoFinal.exception.PedidoNotFoundException;
import org.serratec.backend.projetoFinal.model.Carrinho;
import org.serratec.backend.projetoFinal.model.Pedido;
import org.serratec.backend.projetoFinal.model.Produto;
import org.serratec.backend.projetoFinal.repository.CarrinhoRepository;
import org.serratec.backend.projetoFinal.repository.PedidoRepository;
import org.serratec.backend.projetoFinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Pedido inserir(Pedido pedido) throws EstoqueException{
		for (int i = 0; i < pedido.getListaProdutos().size(); i++) {
			Integer getEstoque = pedido.getListaProdutos().get(i).getQuantidadeEstoque();
			Integer getQuantidade = pedido.getCarrinho().get(i).getQuantidade();
			if(getEstoque < getQuantidade) {
				throw new EstoqueException("Estoque insuficiente, só temos "+getEstoque);
			} pedido.getListaProdutos().get(i).setQuantidadeEstoque(getEstoque - getQuantidade);
			carrinhoRepository.save(pedido.getCarrinho().get(i));
		}
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
		List<Carrinho> carrinhoNoBanco = pedidoNoBanco.getCarrinho();
		Double valor = 0.0;
		Integer qtd = 0;
				
		if(pedido.getCodigoPedido() != null) {
			pedidoNoBanco.setCodigoPedido(pedido.getCodigoPedido());
		}
		
		if(pedido.getDataPedido() != null) {
			pedidoNoBanco.setDataPedido(pedido.getDataPedido());
		}
		
		if(pedido.getValor() != null) {
			pedidoNoBanco.setValor(pedido.getValor());
		}
		
		for(int i = 0; i<pedido.getCarrinho().size();i++) {
			if(carrinhoNoBanco.get(i).getCodigoProduto() != pedido.getCarrinho().get(i).getCodigoProduto()) {
				carrinhoNoBanco.get(i).setCodigoProduto(pedido.getCarrinho().get(i).getCodigoProduto());	
			}
			
			if(carrinhoNoBanco.get(i).getQuantidade() != pedido.getCarrinho().get(i).getQuantidade())
				carrinhoNoBanco.get(i).setQuantidade(pedido.getCarrinho().get(i).getQuantidade());
			
			valor = valor + pedidoNoBanco.getListaProdutos().get(i).getValorUnitario() * carrinhoNoBanco.get(i).getQuantidade();
			qtd += pedido.getCarrinho().get(i).getQuantidade();
		}
		
		pedidoNoBanco.setValor(valor);
		pedidoNoBanco.setQtdItens(qtd);
		return pedidoRepository.save(pedidoNoBanco);
	}
	
	public void deletar(Integer codigo) throws PedidoNotFoundException{
		Pedido pedidoNoBanco = listarPorCodigo(codigo);
		for(int i = 0; i<pedidoNoBanco.getListaProdutos().size();i++) {
			Optional<Produto> produto = produtoRepository.findByCodigoProduto(pedidoNoBanco.getCarrinho().get(i).getCodigoProduto());
			produto.get().setQuantidadeEstoque(produto.get().getQuantidadeEstoque() + pedidoNoBanco.getCarrinho().get(i).getQuantidade());
		}
		pedidoRepository.delete(pedidoNoBanco);
	}
}
