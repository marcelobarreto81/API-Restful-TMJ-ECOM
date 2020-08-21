package org.serratec.backend.projetoFinal.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetoFinal.exception.EnderecoNotFoundException;
import org.serratec.backend.projetoFinal.exception.ParametroObrigatorioException;
import org.serratec.backend.projetoFinal.model.Endereco;
import org.serratec.backend.projetoFinal.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco inserir(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public List<Endereco> listar(){
		return enderecoRepository.findAll();
	}
	
	public Endereco listarPorCodigo(Integer codigo) throws EnderecoNotFoundException {
		Optional<Endereco> opEndereco = enderecoRepository.findById(codigo);

		if(opEndereco.isPresent()) {
			return opEndereco.get();
		}
		
		throw new EnderecoNotFoundException("Endereco com id " + codigo + " não encontrada");
	}
	
	public Endereco substituir(Integer codigo, Endereco endereco) throws ParametroObrigatorioException, EnderecoNotFoundException {
		if(endereco == null) throw new ParametroObrigatorioException("Campo 'Endereco' é obrigatório");
		
		Endereco enderecoNoBanco = listarPorCodigo(codigo);
		
		if(endereco.getCep() != null) {
			enderecoNoBanco.setCep(endereco.getCep());
		}
		
		if(endereco.getRua() != null) {
			enderecoNoBanco.setRua(endereco.getRua());
		}
		
		if(endereco.getNumero() != null) {
			enderecoNoBanco.setNumero(endereco.getNumero());
		}
		
		if(endereco.getComplemento() != null) {
			enderecoNoBanco.setComplemento(endereco.getComplemento());
		}
		
		if(endereco.getBairro() != null) {
			enderecoNoBanco.setBairro(endereco.getBairro());
		}
		
		if(endereco.getCidade() != null) {
			enderecoNoBanco.setCidade(endereco.getCidade());
		}
		
		if(endereco.getEstado() != null) {
			enderecoNoBanco.setEstado(endereco.getEstado());
		}
		
		return enderecoRepository.save(enderecoNoBanco);
		}
	
		public void deletar(Integer codigo) throws EnderecoNotFoundException{
			Endereco enderecoNoBanco = listarPorCodigo(codigo);
			enderecoRepository.delete(enderecoNoBanco);
		}
}
