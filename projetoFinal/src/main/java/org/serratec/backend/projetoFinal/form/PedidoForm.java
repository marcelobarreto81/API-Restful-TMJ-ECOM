package org.serratec.backend.projetoFinal.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	private List<Integer> quantidadePorItem;
	private List<Integer> listaCodigoProdutos;
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	
	public PedidoForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PedidoForm(Date dataPedido, Integer codigoCliente, List<Integer> quantidadePorItem,
			List<Integer> listaCodigoProdutos) {
		super();
		this.dataPedido = dataPedido;
		this.codigoCliente = codigoCliente;
		this.quantidadePorItem = quantidadePorItem;
		this.listaCodigoProdutos = listaCodigoProdutos;
	}

	public Pedido converte(ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
		Optional<Cliente> cliente = clienteRepository.findByCodigoCliente(codigoCliente);
		for (int i = 0; i < listaCodigoProdutos.size(); i++) {
			Optional<Produto> novo = produtoRepository.findByCodigoProduto(listaCodigoProdutos.get(i));
			listaProdutos.add(novo.get());
			valor = valor + novo.get().getValorUnitario() * quantidadePorItem.get(i);
			quantidadeProdutos += quantidadePorItem.get(i);
		} 
		return new Pedido(dataPedido, valor, cliente.get(), quantidadeProdutos, listaProdutos);
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

	public List<Integer> getQuantidadePorItem() {
		return quantidadePorItem;
	}

	public void setQuantidadePorItem(List<Integer> quantidadePorItem) {
		this.quantidadePorItem = quantidadePorItem;
	}

	public List<Integer> getListaCodigoProdutos() {
		return listaCodigoProdutos;
	}

	public void setListaCodigoProdutos(List<Integer> listaCodigoProdutos) {
		this.listaCodigoProdutos = listaCodigoProdutos;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

}
