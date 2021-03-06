package org.serratec.backend.projetoFinal.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="PEDIDO")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido-generator")
	@SequenceGenerator(name = "pedido-generator", sequenceName = "ped_seq")
	private Integer codigoPedido;
	
	@Column(name="DATA_PEDIDO")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(iso = ISO.DATE)
	private Date dataPedido;
	
	@Column(name="VALOR")
	private Double valor;
	
	@Column(name="QTD_ITENS")
	private Integer qtdItens;
	
	@OneToMany
	private List<Carrinho> carrinho;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToMany
	private List<Produto> listaProdutos;

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(Date dataPedido, Double valor, Cliente cliente, Integer qtdItens, List<Produto> listaProdutos, List<Carrinho> carrinho) { 
		super();
		this.dataPedido = dataPedido;
		this.valor = valor;
		this.cliente = cliente;
		this.qtdItens = qtdItens;
		this.listaProdutos = listaProdutos;
		this.carrinho = carrinho;
	}

	public Integer getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Integer codigoPedido) {
		this.codigoPedido = codigoPedido;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getQtdItens() {
		return qtdItens;
	}

	public void setQtdItens(Integer qtdItens) {
		this.qtdItens = qtdItens;
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
