package org.serratec.backend.projetoFinal.form;

import java.util.Date;
import java.util.Optional;

import org.serratec.backend.projetoFinal.model.Categoria;
import org.serratec.backend.projetoFinal.model.Funcionario;
import org.serratec.backend.projetoFinal.model.Produto;
import org.serratec.backend.projetoFinal.repository.CategoriaRepository;
import org.serratec.backend.projetoFinal.repository.FuncionarioRepository;

public class ProdutoForm {
	
	private String nome;
	private String descricao;
	private Integer quantidadeEstoque;
	private Date dataFabricacao;
	private Double valorUnitario;
	private Integer codigoCategoria;
	private Integer codigoFuncionario;
	
	
	public Produto converte(CategoriaRepository categoriaRepository, FuncionarioRepository funcionarioRepository) {
		Optional<Categoria> categoria = categoriaRepository.findByCodigoCategoria(codigoCategoria);
		Optional<Funcionario> funcionario = funcionarioRepository.findByCodigoFuncionario(codigoFuncionario);
		return new Produto(nome, descricao, quantidadeEstoque, dataFabricacao, valorUnitario, categoria.get(), funcionario.get());
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
	public Integer getCodigoCategoria() {
		return codigoCategoria;
	}
	public void setCodigoCategoria(Integer codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}
	public Integer getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(Integer codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}
}
