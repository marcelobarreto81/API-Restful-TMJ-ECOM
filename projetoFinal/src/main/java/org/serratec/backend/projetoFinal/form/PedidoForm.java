package org.serratec.backend.projetoFinal.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.serratec.backend.projetoFinal.model.Carrinho;
import org.serratec.backend.projetoFinal.model.Cliente;
import org.serratec.backend.projetoFinal.model.Pedido;
import org.serratec.backend.projetoFinal.model.Produto;
import org.serratec.backend.projetoFinal.repository.ClienteRepository;
import org.serratec.backend.projetoFinal.repository.ProdutoRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class PedidoForm {
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(iso = ISO.DATE)
	private Date dataPedido;
	private Double valor = 0.0;
	private Integer codigoCliente;
	private Integer quantidadeProdutos = 0;
	private List<Carrinho> carrinho;
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	
	public PedidoForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PedidoForm(Date dataPedido, Integer codigoCliente, List<Carrinho> carrinho) {
		super();
		this.dataPedido = dataPedido;
		this.codigoCliente = codigoCliente;
		this.carrinho = carrinho;
		;
	}

	public Pedido converte(ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
		Optional<Cliente> cliente = clienteRepository.findByCodigoCliente(codigoCliente);
		for (int i = 0; i < carrinho.size(); i++) {
			Optional<Produto> novo = produtoRepository.findByCodigoProduto(carrinho.get(i).getCodigoProduto());
			listaProdutos.add(novo.get());
			valor = valor + novo.get().getValorUnitario() * carrinho.get(i).getQuantidade();
			quantidadeProdutos += carrinho.get(i).getQuantidade();
		} 
		return new Pedido(dataPedido, valor, cliente.get(), quantidadeProdutos, listaProdutos, carrinho);
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Integer getQuantidadeProdutos() {
		return quantidadeProdutos;
	}

	public void setQuantidadeProdutos(Integer quantidadeProdutos) {
		this.quantidadeProdutos = quantidadeProdutos;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public List<Carrinho> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(List<Carrinho> carrinho) {
		this.carrinho = carrinho;
	}

}
