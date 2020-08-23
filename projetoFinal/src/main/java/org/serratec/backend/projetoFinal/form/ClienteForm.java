package org.serratec.backend.projetoFinal.form;

import java.util.Date;
import java.util.Optional;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.serratec.backend.projetoFinal.model.Cliente;
import org.serratec.backend.projetoFinal.model.Endereco;
import org.serratec.backend.projetoFinal.repository.EnderecoRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class ClienteForm {
	
	private String nomeCompleto;
	
	private String nomeUsuario;
	
	private String email;
	
	private String senha;
	
	private String cpf;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(iso = ISO.DATE)
	private Date dataNascimento ;
	
	private String telefone;

	private Integer codigoEndereco;
	
	public Cliente converte(EnderecoRepository enderecoRepository) {
	Optional<Endereco> endereco = enderecoRepository.findByCodigoEndereco(codigoEndereco);
		Cliente novo = new Cliente(this.nomeCompleto, this.nomeUsuario, this.email, this.senha, this.cpf, this.dataNascimento, this.telefone, endereco.get());
		return novo;
	}
	

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public Integer getCodigoEndereco() {
		return codigoEndereco;
	}


	public void setCodigoEndereco(Integer codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}

	
}
