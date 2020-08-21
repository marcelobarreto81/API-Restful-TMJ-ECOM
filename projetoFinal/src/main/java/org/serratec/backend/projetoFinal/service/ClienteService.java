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
	
	public Cliente substituir(Integer codigo, Cliente cliente) throws ParametroObrigatorioException, ClienteNotFoundException {
		if(cliente == null) throw new ParametroObrigatorioException("Campo 'Cliente' é obrigatório");
		
		Cliente clienteNoBanco = listarPorCodigo(codigo);
		
		if(cliente.getNomeCompleto() != null) {
			clienteNoBanco.setNomeCompleto(cliente.getNomeCompleto());
		}
		
		if(cliente.getNomeUsuario() != null) {
			clienteNoBanco.setNomeUsuario(cliente.getNomeUsuario());
		}
		
		if(cliente.getCpf() != null) {
			clienteNoBanco.setCpf(cliente.getCpf());
		}
		
		if(cliente.getDataNascimento() != null) {
			clienteNoBanco.setDataNascimento(cliente.getDataNascimento());
		}
		
		if(cliente.getEmail() != null) {
			clienteNoBanco.setEmail(cliente.getEmail());
		}
		
		if(cliente.getSenha() != null) {
			clienteNoBanco.setSenha(cliente.getSenha());
		}
		
		if(cliente.getTelefone() != null) {
			clienteNoBanco.setTelefone(cliente.getTelefone());
		}
		
		return clienteRepository.save(clienteNoBanco);
	}
	
	public void deletar(Integer codigo) throws ClienteNotFoundException{
		Cliente ClienteNoBanco = listarPorCodigo(codigo);
		clienteRepository.delete(ClienteNoBanco);
	}
}

