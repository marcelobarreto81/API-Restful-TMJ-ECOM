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
@Table(name="ENDERECO")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco-generator")
	@SequenceGenerator(name = "endereco-generator", sequenceName = "end_seq")
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
	
	@OneToMany
	private List<Cliente> cliente;
	
	
//	public List<Cliente> getCliente() {
//		return cliente;
//	}
//	public void setCliente(List<Cliente> cliente) {
//		this.cliente = cliente;
//	}
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
