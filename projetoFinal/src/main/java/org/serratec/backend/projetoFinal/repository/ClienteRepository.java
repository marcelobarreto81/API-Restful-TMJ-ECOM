package org.serratec.backend.projetoFinal.repository;

import java.util.Optional;

import org.serratec.backend.projetoFinal.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	Optional<Cliente> findByCodigoCliente(Integer codigoCliente);

}
