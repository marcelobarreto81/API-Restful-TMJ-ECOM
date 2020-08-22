package org.serratec.backend.projetoFinal.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIA")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigoCategoria;
	
	@Column(name="NOME", nullable = false, length = 25)
	private String nome;
	
	@Column(name="DESCRICAO", nullable = false, length = 255)
	private String descricao;
	
	@OneToMany
	private List<Produto> livros;
	
	public Integer getCodigoCategoria() {
		return codigoCategoria;
	}
	public void setCodigoCategoria(Integer codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
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
	public List<Produto> getLivros() {
		return livros;
	}
	public void setLivros(List<Produto> livros) {
		this.livros = livros;
	}
	
	
}
