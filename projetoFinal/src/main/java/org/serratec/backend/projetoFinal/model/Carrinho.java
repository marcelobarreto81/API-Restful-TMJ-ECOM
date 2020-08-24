package org.serratec.backend.projetoFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CARRINHO")
public class Carrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carrinho-generator")
	@SequenceGenerator(name = "carrinho-generator", sequenceName = "car_seq")
	private Integer id;
	@Column(name="CODIGO_PRODUTO")
	private Integer codigoProduto;
	
	@Column(name="QUANTIDADE")
	private Integer quantidade;
	
	@ManyToOne
	private Pedido pedido;
	
	public Integer getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
