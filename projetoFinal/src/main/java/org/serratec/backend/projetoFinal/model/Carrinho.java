package org.serratec.backend.projetoFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CARRINHO")
public class Carrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itensPedidos;
	
	@Column(name="CODIGO_PEDIDO", nullable = false)
	private Integer codigoPedido;
	
	@Column(name="CODIGO_PRDUTO", nullable = false)
	private Integer codigoProduto;
	
	public Integer getItensPedidos() {
		return itensPedidos;
	}
	public void setItensPedidos(Integer itensPedidos) {
		this.itensPedidos = itensPedidos;
	}
	public Integer getCodigoPedido() {
		return codigoPedido;
	}
	public void setCodigoPedido(Integer codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	public Integer getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
}
