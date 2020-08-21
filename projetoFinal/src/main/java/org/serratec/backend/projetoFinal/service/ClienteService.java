package org.serratec.backend.projetoFinal.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetoFinal.exception.ClienteNotFoundException;
import org.serratec.backend.projetoFinal.exception.ParametroObrigatorioException;
import org.serratec.backend.projetoFinal.model.Cliente;
import org.serratec.backend.projetoFinal.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente inserir(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	public Cliente listarPorCodigo(Integer codigo) throws ClienteNotFoundException {
		Optional<Cliente> opCliente = clienteRepository.findById(codigo);

		if(opCliente.isPresent()) {
			return opCliente.get();
		}
		
		throw new ClienteNotFoundException("Cliente com id " + codigo + " não encontrada");
	}
	
	public Cliente substituir(Integer codigo, Cliente Cliente) throws ParametroObrigatorioException, ClienteNotFoundException {
		if(Cliente == null) throw new ParametroObrigatorioException("Campo 'Cliente' é obrigatório");
		
		Cliente ClienteNoBanco = listarPorCodigo(codigo);
		
		if(Cliente.getNomeCompleto() != null) {
			ClienteNoBanco.setNomeCompleto(Cliente.getNomeCompleto());
		}
		
		if(Cliente.getNomeUsuario() != null) {
			ClienteNoBanco.setNomeUsuario(Cliente.getNomeUsuario());
		}
		
		if(Cliente.getCpf() != null) {
			ClienteNoBanco.setCpf(Cliente.getCpf());
		}
		
		if(Cliente.getDataNascimento() != null) {
			ClienteNoBanco.setDataNascimento(Cliente.getDataNascimento());
		}
		
		if(Cliente.getEmail() != null) {
			ClienteNoBanco.setEmail(Cliente.getEmail());
		}
		
		if(Cliente.getSenha() != null) {
			ClienteNoBanco.setSenha(Cliente.getSenha());
		}
		
		if(Cliente.getTelefone() != null) {
			ClienteNoBanco.setTelefone(Cliente.getTelefone());
		}
		
		return clienteRepository.save(ClienteNoBanco);
	}
	
	public void deletar(Integer codigo) throws ClienteNotFoundException{
		Cliente ClienteNoBanco = listarPorCodigo(codigo);
		clienteRepository.delete(ClienteNoBanco);
	}
}

