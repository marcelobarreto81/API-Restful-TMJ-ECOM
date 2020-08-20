package org.serratec.backend.projetoFinal.service;

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
}
