package org.serratec.backend.projetoFinal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="PRODUTO")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto-generator")
	@SequenceGenerator(name = "produto-generator", sequenceName = "prod_seq")
	private Integer codigoProduto;
	
	@Column(name="NOME", nullable = false, length = 255)
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
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Funcionario funcionario;
	
	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produto(String nome, String descricao, Integer quantidadeEstoque, Date dataFabricacao, Double valorUnitario,
			Categoria categoria, Funcionario funcionario) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.quantidadeEstoque = quantidadeEstoque;
		this.dataFabricacao = dataFabricacao;
		this.valorUnitario = valorUnitario;
		this.categoria = categoria;
		this.funcionario = funcionario;
	}
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
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
}
