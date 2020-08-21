package org.serratec.backend.projetoFinal.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetoFinal.exception.FuncionarioNotFoundException;
import org.serratec.backend.projetoFinal.exception.ParametroObrigatorioException;
import org.serratec.backend.projetoFinal.model.Funcionario;
import org.serratec.backend.projetoFinal.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario inserir(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public List<Funcionario> listar() {
		return funcionarioRepository.findAll();
	}
	
	public Funcionario listarPorCodigo(Integer codigo) throws FuncionarioNotFoundException {
		Optional<Funcionario> opFuncionario = funcionarioRepository.findById(codigo);

		if(opFuncionario.isPresent()) {
			return opFuncionario.get();
		}
		
		throw new FuncionarioNotFoundException("Funcionário com id " + codigo + " não encontrada");
	}
	
	public Funcionario substituir(Integer codigo, Funcionario funcionario) throws ParametroObrigatorioException, FuncionarioNotFoundException {
		if(funcionario == null) throw new ParametroObrigatorioException("Campo 'Funcionário' é obrigatório");
		
		Funcionario funcionarioNoBanco = listarPorCodigo(codigo);
		
		if(funcionario.getNome() != null) {
			funcionarioNoBanco.setNome(funcionario.getNome());
		}
		
		if(funcionario.getCpf() != null) {
			funcionarioNoBanco.setCpf(funcionario.getCpf());
		}
		
		return funcionarioRepository.save(funcionarioNoBanco);
	}
	
	public void deletar(Integer codigo) throws FuncionarioNotFoundException{
		Funcionario FuncionarioNoBanco = listarPorCodigo(codigo);
		funcionarioRepository.delete(FuncionarioNoBanco);
	}

}
