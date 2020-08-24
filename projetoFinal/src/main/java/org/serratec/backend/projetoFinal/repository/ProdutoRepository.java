package org.serratec.backend.projetoFinal.repository;

import java.util.Optional;

import org.serratec.backend.projetoFinal.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	Optional<Produto> findByCodigoProduto(Integer produto);

}
