package org.serratec.backend.projetoFinal.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FUNCIONARIO")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario-generator")
	@SequenceGenerator(name = "funcionario-generator", sequenceName = "fun_seq")
	private Integer codigoFuncionario;
	
	@Column(name="NOME", nullable = false, length = 255)
	private String nome;
	
	@Column(name="CPF", nullable = false, length = 14)
	private String cpf;
	
	@OneToMany
	private List<Produto> produtos;
	
	public Integer getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(Integer codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
//	public List<Produto> getProdutos() {
//		return produtos;
//	}
//	public void setProdutos(List<Produto> produtos) {
//		this.produtos = produtos;
//	}
}
