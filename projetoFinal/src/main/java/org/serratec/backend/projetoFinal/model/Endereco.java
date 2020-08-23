package org.serratec.backend.projetoFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ENDERECO")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigoEndereco;
	
	@Column(name="CEP", nullable = false, length = 10)
	private String cep;
	
	@Column(name="RUA", nullable = false, length = 255)
	private String rua;
	
	@Column(name="NUMERO", length = 10)
	private Integer numero;
	
	@Column(name="COMPLEMENTO", length = 255)
	private String complemento;
	
	@Column(name="BAIRRO", nullable = false, length = 50)
	private String bairro;
	
	@Column(name="CIDADE", nullable = false, length = 50)
	private String cidade;
	
	@Column(name="ESTADO", nullable = false, length = 2)
	private String estado;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_codigo_cliente")
	private Cliente cliente;
	
	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Endereco(String cep, String rua, Integer numero, String complemento, String bairro, String cidade,
			String estado, Cliente cliente) {
		super();
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getCodigoEndereco() {
		return codigoEndereco;
	}
	public void setCodigoEndereco(Integer codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}
	
	
}
