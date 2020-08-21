package org.serratec.backend.projetoFinal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="PRODUTO")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigoProduto;
	
	@Column(name="NOME_COMPLETO", nullable = false, length = 255)
	private String nome;
	
	@Column(name="DESCRICAO", nullable = false, length = 255)
	private String descricao;
	
	@Column(name="QUANTIDADE_ESTOQUE", nullable = false)
	private Integer quantidadeEstoque;
	
	@Column(name="DATA_PEDIDO")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(iso = ISO.DATE)
	private Date dataFabricacao;
	
	@Column(name="VALOR_UNITARIO", nullable = false)
	private Double valorUnitario;
	
	@Column(name="CODIGO_PEDIDO", nullable = false)
	private Integer codigoPedido;
	
	@Column(name="CODIGO_FUNCIONARIO", nullable = false)
	private Integer codigoFuncionario;
	
	public Integer getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public Date getDataFabricacao() {
		return dataFabricacao;
	}
	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	public Double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public Integer getCodigoPedido() {
		return codigoPedido;
	}
	public void setCodigoPedido(Integer codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	public Integer getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(Integer codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}
	
}
